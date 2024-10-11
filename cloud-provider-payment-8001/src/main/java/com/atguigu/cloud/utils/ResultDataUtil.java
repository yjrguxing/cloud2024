package com.atguigu.cloud.utils;

import com.atguigu.cloud.res.HttpStatus;
import com.atguigu.cloud.res.ResultData;

public class ResultDataUtil {

    public static <T> ResultData<T> createResultData(HttpStatus httpStatus) {
        return createResultData(httpStatus, httpStatus.getReasonPhrase(), null);
    }

    public static <T> ResultData<T> createResultData(HttpStatus httpStatus, String msg) {
        return createResultData(httpStatus, msg, null);
    }

    public static <T> ResultData<T> createResultData(HttpStatus httpStatus, T data) {
        return createResultData(httpStatus, httpStatus.getReasonPhrase(), data);
    }

    public static <T> ResultData<T> createResultData(HttpStatus httpStatus, String msg, T data) {
        return new ResultData<>(httpStatus.value(), msg, data, System.currentTimeMillis());
    }
}
