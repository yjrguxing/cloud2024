package com.atguigu.cloud.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@AllArgsConstructor
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

    public ResultData(){
        this.timestamp = System.currentTimeMillis();
    }

    public static<T> ResultData<T> success(){
        return new ResultData<>(200,"success",null,System.currentTimeMillis());
    }

    public static<T> ResultData<T> success(T data){
        return new ResultData<>(200,"success",data,System.currentTimeMillis());
    }

    public static<T> ResultData<T> error(Integer code,String message,T data){
        return new ResultData<>(code,message,data,System.currentTimeMillis());
    }
}
