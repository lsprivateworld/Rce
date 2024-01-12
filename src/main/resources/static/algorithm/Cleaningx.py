# -*- coding: utf-8 -*-
"""
Created on Sat Oct 26 15:58:20 2019

@author: Administrator
"""


# =============================================================================
'''
以下为该程序需要使用的扩展包，若没有，请使用pip install 文件名 自行下载：
'''
import pandas as pd
import numpy as np
from  sklearn.preprocessing import MinMaxScaler,StandardScaler
from  sklearn.decomposition import PCA
from functools import wraps
from sklearn.cluster import  KMeans
################################################
# =============================================================================

# =============================================================================
# import ......
import logging
import flask_restful
# 自定义模块
from errors import my_abort, generate_response, ResponseCode
# 自定义错误
flask_restful.abort = my_abort

root_logger = logging.getLogger('root')
logger = logging.getLogger('main')
# =============================================================================


def function(dataPath, savePath):
    datas = [[]]
    #pklPath = current_app.config['PKL_PATH'] #建议把pklPath作为函数参数传入

    try: # 简单搞一个粗放型的错误控制，TODO建议predict_*子函数通过抛出自定义异常控制错误代码
        value_qs = function_qs(dataPath, savePath)
        if value_qs['resp_code'] != 0:
            return value_qs
        datas =value_qs['datas']
        return generate_response(datas)
    except Exception as e:
        return generate_response(datas=datas, code=ResponseCode.ERROR, appendmessage='{0}'.format(str(e)))


def function_qs(dataPath, savePath):
    res = {}

    logger.info('------------------')
    logger.info('数据预处理开始')
    logger.info('------------------')
    try:
        #model= joblib.load(path_model)
        y_pred = dataProcess(dataPath, savePath)
        logger.info('数据预处理完成')
        #......       
        return generate_response(y_pred)
    except Exception as e:
        #TODO，优化建议：以后这里可以不要返回res结构，最好和以前一样，而是通过抛出自定义异常来反馈给调用者分类的错误信息
        logger.error('数据预处理失败，请检查文件名是否正确')
        res = generate_response(code=ResponseCode.WRONG_PARAM, appendmessage='{0}'.format(str(e)))
    return res

def dataProcess(dataPath, savePath):
    # 数据路径
    path = dataPath
    # 原始数据处理
    DP = Preprocessing()  # 调用数据处理包
    DP.load_csv(path)  # 处理好的数据集
    data=DP.Fillnan()
    data1=DP.OutlierDetection(data)
    data1.to_csv(savePath,  encoding="utf-8-sig",index=False)
    return {'路径':savePath}
    



def catch_exception(orignal_func):
    '''
    检测是否载入数据
    '''
    @wraps(orignal_func)
    def warpper(*args,**kwargs):
        try:
            u=orignal_func(*args,**kwargs)
            return u
        except Exception :
            print('1.路径是否有问题，分隔符请用/或者\\\;\n'
                  '2.检查文件读取方式是否正确，csv文件请用load_csv,xlsx文件请用load_excel\n'
                  '3.请检查文件后缀是否为存在文件格式后缀，例如xxxx.csv  ')
    return warpper
class Preprocessing:

    def __init__(self):
        self.data=None
    @catch_exception
    def load_csv(self,path):
        '''
        读取csv文件
        :param path : 路径
        return ：DataFrame
        '''
        self.data=pd.read_csv(path, index_col=0, encoding='utf-8')
        return self.data

    @catch_exception
    def load_excel(self,path,sheet_name=0):
        '''
        读取 excel 文件
        :param path： 路径
        :param sheet_name : 表格名称
        return：DataFrame
        '''
        self.data=pd.read_excel(path,sheet_name=sheet_name)
        return self.data
    def Fillnan(self,way=0):
        '''
        用于缺失值的填充，默认零填充，可以使用 均值、中位数填充，并可以自行扩展
        :param way： 填充方式
        ：return：DataFrame
        '''
        # print('未填充缺失值：',self.data.isnull().sum())
        # x = data.iloc[:, :-1]
        # y = data.iloc[:, -1]
        if way =='mean':
            for column in list(self.data.columns[self.data.isnull().sum() > 0]):
                mean_val = self.data[column].mean()
                self.data[column].fillna(mean_val, inplace=True)
        elif way == 'median':
            for column in list(self.data.columns[self.data.isnull().sum() > 0]):
                median_val = self.data[column].median()
                self.data[column].fillna(median_val, inplace=True)
        else:
            self.data.fillna(way,inplace=True)

        print('已填充缺失值：', self.data.isnull().sum())
        return self.data

    def OutlierDetection(self, data,method='std'):
        '''
        异常值检测,并选择填充方式
        :param： data：dataframe| 需要检测的数据
        method：str | 选择方法，std,box，默认是std
        :return：DataFrame
        '''
        data=data.reset_index(drop=True)
        if method == 'std':
            # 异常值检测之标准差法
            for i in list(data.columns):
                xbar = np.mean(data.loc[:, i])
                xstd = np.std(data.loc[:, i], ddof=1)
                for j in range(len(data.index)):
                    if data.loc[j, i] > xbar + 3 * xstd or data.loc[j, i] < xbar - 3 * xstd:
                        data.loc[j, i] = xbar  # 替换为均值
        elif method == 'box':
            # 异常值检测之箱线图法
            for i in list(data.columns):
                Q1 = data[i].quantile(q=0.25)
                Q3 = data[i].quantile(q=0.75)
                xbar = np.mean(data.loc[:, i])
                IQR = Q3 - Q1
                for j in range(len(data.index)):
                    if data.loc[j, i] > Q3 + 1.5 * IQR or data.loc[j, i] < Q1 - 1.5 * IQR:
                        data.loc[j, i] = xbar  # 替换为均值
        return data
    def Dimension_reduction(self,n):
        '''
        PCA降维，输入n为降低的维数
        ：return ： np.array
        '''
        # print(type(self.data))
        model=PCA(n_components=n)
        self.data=model.fit_transform(self.data)
        # print(type(self.data))
        return self.data
    def Normalization(self,pro_data,method='ss'):
        '''
        一种为归一化法,为mms，默认一种为标准化,方法为ss
        ：return： 返回规约的数据   DataFrame
        '''
        x = pro_data.iloc[:, :-1]
        label=pro_data.reset_index(drop=True).loc[:,'标签']
        if method =='mms':
            # 归一化
            mms=MinMaxScaler()
            name_list=[]
            data=[]
            name_list.append(['归一化'+i for i in x.columns])
            for i in list(x.columns):
                data.append(mms.fit_transform(x[i].values.reshape(-1,1)).flatten().tolist())

            N_data=pd.DataFrame(data).T
            N_data.columns=name_list

        elif method =='ss':
            # 标准化
            mms = StandardScaler()
            name_list = []
            data = []
            name_list.append(['标准化' + i for i in x.columns])
            for i in list(x.columns):
                data.append(mms.fit_transform(x[i].values.reshape(-1, 1)).flatten().tolist())

            N_data = pd.DataFrame(data).T
            N_data.columns = name_list
            N_data.loc[:,'标签']=label
        return N_data

