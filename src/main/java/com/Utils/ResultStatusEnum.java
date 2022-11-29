package com.Utils;

/**
 * 自定义请求状态码
 */
public enum ResultStatusEnum {
    /**
     * 0：失败
     * 1：成功
     */
    SUCCESS(1, "成功"),
    LOGOUT_SUCCESS(1, "注销成功"),
    register_SUCCESS(1, "注册成功"),
    DELETE_SUCCESS(1, "删除成功"),
    UPDATE_SUCCESS(1, "更改成功"),
    SELECT_SUCCESS(1, "查询成功"),
    Login_SUCCESS(1,"登陆成功"),
    Login_ERROR(0,"登陆失败"),
    ERROR(0, "异常失败"),
    SAVE_ERROR(0, "增加失败"),
    DELETE_ERROR(0, "删除失败"),
    UPDATE_ERROR(0, "更改失败"),
    SELECT_ERROR(0, "查询失败");

    /**
     * 返回码
     */
    private int status;

    /**
     * 返回结果描述
     */
    private String msg;

    ResultStatusEnum() {
    }

    ResultStatusEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}