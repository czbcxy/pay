package com.example.apipay.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class ApiResult<T> {

    private Integer code;
    private String msg;
    private T data;

    public static ApiResult success(Object data) {
        return new ApiResult().setCode(HttpStatus.OK.value()).setData(data);
    }

    public static ApiResult fail(String msg) {
        return new ApiResult().setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).setMsg("请求错误: " + msg);
    }

}
