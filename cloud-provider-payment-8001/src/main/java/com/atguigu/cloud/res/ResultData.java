package com.atguigu.cloud.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResultData<T> {

    /**
     * response code
     */
    private Integer code;

    /**
     * responseメッセージ
     */
    private String message;

    /**
     * responseデータ
     */
    private T data;

    private long timestamp;

    public static<T> ResultData<T> Success(){
        return new ResultData<>(200,"Success",null,System.currentTimeMillis());
    }

    public static<T> ResultData<T> Success(T data){
        return new ResultData<>(200,"Success",data,System.currentTimeMillis());
    }

    public static<T> ResultData<T> Error(Integer code,String message,T data){
        return new ResultData<>(code,message,data,System.currentTimeMillis());
    }
}
