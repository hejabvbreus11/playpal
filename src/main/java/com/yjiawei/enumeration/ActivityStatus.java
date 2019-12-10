package com.yjiawei.enumeration;

public enum ActivityStatus {
    Recruit("活动招募中"),
    Inactive("活动已失效"),
    Active("活动进行中");
    private String message;

    private ActivityStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
