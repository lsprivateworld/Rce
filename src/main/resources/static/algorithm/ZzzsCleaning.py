# -*- coding: utf-8 -*-
"""
Created on Sat Oct 26 15:52:20 2019

@author: Administrator
"""

# =============================================================================
# import....
import logging
from flask import request, current_app
import flask_restful
from flask_restful import Resource, reqparse
import numpy as np
import pandas as pd
import time
import utils
import json
# 自定义模块
from errors import my_abort, generate_response, ResponseCode
# 自定义错误
flask_restful.abort = my_abort
root_logger = logging.getLogger('root')
logger = logging.getLogger('main')
# =============================================================================

# =============================================================================
# 模型import
from all_code.Cleaning import function
# =============================================================================

class ZzzsCleaning(Resource):
    def __init__(self):
        self.parser = reqparse.RequestParser(bundle_errors=True)
        # 根据参数需求增删
        self.parser.add_argument('dataPath', type=str, required=True, help="需要数据文件绝对路径")
        self.parser.add_argument('savePath', type=str, required=True, help="需要数据文件绝对路径")
    
    def get(self):
        currentTimeStr = utils.nowTimeText4China()
        print('=== 数据预处理开始, 中国时间: %s' % currentTimeStr)

        computeDurationStart = time.time()
        httpStatusCode = 200
        queryParams = self.parser.parse_args()
        # 获取参数，根据参数需求增删
        dataPath = queryParams.get('dataPath')
        savePath = queryParams.get('savePath')

        logger.info('=== 数据预处理请求 ==> GET ?\ndataPath=%s\nsavePath=%s' % (dataPath, savePath))
        res = function(dataPath, savePath)
        
        if res['resp_code'] == ResponseCode.WRONG_PARAM:
            httpStatusCode = 400
        computeDuration = time.time() - computeDurationStart
        logger.info('=== 数据预处理 ==> 耗时( %.3f 秒 )' % computeDuration)
        return res, httpStatusCode, {"Content-Type": "application/json; charset=utf-8"}

    def post(self):
        return {"message": "post, DjdpFeature!"}
    
class NpEncoder(json.JSONEncoder): #继承json.JSONEncoder
    def default(self, obj):
        if isinstance(obj, np.integer):
            return int(obj)
        elif isinstance(obj, np.floating):
            return float(obj)
        elif isinstance(obj, np.float):
            return float(obj)
        elif isinstance(obj, np.ndarray):
            return obj.tolist()
        elif isinstance(obj, pd.Timestamp):
            return obj.strftime('%Y-%m-%d %H:%M:%S')
        elif isinstance(obj, datetime):
            return obj.strftime('%Y-%m-%d %H:%M:%S')
        elif isinstance(obj, date):
            return obj.strftime('%Y-%m-%d')
        elif isinstance(obj,np.datetime64):
            return np.datetime_as_string(obj)
        else:
            return super(NpEncoder, self).default(obj)