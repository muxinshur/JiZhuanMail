package com.mail.interfaces;

import com.mail.interfaces.constant.HTTPStatusConstants;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Result implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int statusCode;

    private final String message;

    private final Object data;

    public static boolean isSuccess(Result result) {
        return Objects.equals(result.getStatusCode(), HTTPStatusConstants.SUCCESS);
    }

    public static boolean isError(Result result) {
        return Objects.equals(result.getStatusCode(), HTTPStatusConstants.ERROR);
    }

    public static Result success(String message, Object data) {
        return new Result(HTTPStatusConstants.SUCCESS, message, data);
    }

    public static Result success(String message) {
        return Result.success(message, null);
    }

    public static Result success(Object data) {
        return Result.success("操作成功", data);
    }

    public static Result success() {
        return Result.success("操作成功", null);
    }

    public static Result error(String message, Object data) {
        return new Result(HTTPStatusConstants.ERROR, message, null);
    }

    public static Result error(String message) {
        return Result.error(message, null);
    }

    public static Result error(Object data) {
        return Result.error("操作失败", data);
    }

    public static Result error() {
        return Result.error("操作失败", null);
    }

    public Result(int statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
