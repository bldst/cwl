package com.Utils;

import java.util.List;

/**
 * 统一返回的消息体结构
 */
public class ResultMsg {
    /**
     * 状态,成功：1，失败：0
     */
    private int status;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public ResultMsg() {
    }

    /**
     * 构造函数
     * @param status 状态值
     * @param msg 描述
     */
    public ResultMsg(int status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = null;
    }

    /**
     * 构造函数
     * @param status 状态值
     * @param msg 描述
     * @param data 返回数据
     */
    public ResultMsg(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造函数
     * @param resultStatus 状态枚举
     */
    public ResultMsg(ResultStatusEnum resultStatus) {
        this.status = resultStatus.getStatus();
        this.msg = resultStatus.getMsg();
        this.data = null;
    }

    /**
     * 构造函数
     * @param resultStatus 状态枚举
     * @param data 返回对象
     */
    public ResultMsg(ResultStatusEnum resultStatus, Object data) {
        this.status = resultStatus.getStatus();
        this.msg = resultStatus.getMsg();
        this.data = data;
    }

    /**
     * 构造函数
     * @param resultStatus 状态枚举
     * @param str 追加的描述
     */
    public ResultMsg(ResultStatusEnum resultStatus, String str) {
        this.status = resultStatus.getStatus();
        this.msg = resultStatus.getMsg() + "：[" + str +"]";
    }

    /**
     * 静态构造函数（成功）
     * @param data 返回对象
     * @return
     */
    public static ResultMsg ok(Object data) {
        //查询集合为空的统一提示处理
        if(data instanceof List){
            List list = (List)data;

        }
        return new ResultMsg(ResultStatusEnum.SUCCESS, data);
    }

    /**
     * 静态构造函数（成功）
     * @param ok 成功状态枚举
     * @param data 返回对象
     * @return
     */
    public static ResultMsg ok(ResultStatusEnum ok, Object data) {
        //查询集合为空的统一提示处理
        if(data instanceof List){
            List list = (List)data;

        }
        return new ResultMsg(ok, data);
    }

    /**
     * 静态构造函数（成功）
     * @return
     */
    public static ResultMsg ok() {
        return new ResultMsg(ResultStatusEnum.SUCCESS);
    }

    /**
     * 静态构造函数（成功）
     * @param ok 成功状态枚举
     * @return
     */
    public static ResultMsg ok(ResultStatusEnum ok) {
        return new ResultMsg(ok);
    }

    /**
     * 静态构造函数（失败）
     * @param error 错误状态枚举
     * @return
     */
    public static ResultMsg error(ResultStatusEnum error) {
        return new ResultMsg(error);
    }

    /**
     * 静态构造函数（失败）
     * @param error 错误状态枚举
     * @param str 错误描述
     * @return
     */
    public static ResultMsg error(ResultStatusEnum error, String str) {
        return new ResultMsg(error,str);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
