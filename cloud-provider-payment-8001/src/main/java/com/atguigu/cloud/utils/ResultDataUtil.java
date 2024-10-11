package com.atguigu.cloud.utils;

import com.atguigu.cloud.res.HttpStatus;
import com.atguigu.cloud.res.ResultData;

public class ResultDataUtil {

    public static <T> ResultData<T> createResultData(HttpStatus httpStatus) {
        return new ResultData<>(httpStatus.value(), httpStatus.getReasonPhrase(), null, System.currentTimeMillis());
    }

    public static <T> ResultData<T> createResultData(HttpStatus httpStatus, String msg) {
        return new ResultData<>(httpStatus.value(), msg, null, System.currentTimeMillis());
    }

    public static <T> ResultData<T> createResultData(HttpStatus httpStatus, T data) {
        return new ResultData<>(httpStatus.value(), httpStatus.getReasonPhrase(), data, System.currentTimeMillis());
    }

    public static <T> ResultData<T> createResultData(HttpStatus httpStatus, String msg,T data) {
        return new ResultData<>(httpStatus.value(), msg, data, System.currentTimeMillis());
    }
}
