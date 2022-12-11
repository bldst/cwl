package com.Utils;

/**
 * 角色类型枚举
 * @author developer
 * @since 2022/6/2
 */
public enum RoleTypeEnum {
    /**
     * 管理员
     */
    ADMIN(1, "admin"),
    /**
     * 普通用户
     */
    USER(2, "user");

    /**
     * 号码
     */
    private int number;

    /**
     * 名称
     */
    private String name;

    RoleTypeEnum() {
    }

    RoleTypeEnum(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNameByNumber(int number) {
        for (RoleTypeEnum type : values()) {
            if (number == type.getNumber()) {
                return type.getName();
            }
        }
        return null;
    }
}
