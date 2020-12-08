package com.apple.developer.entity;

import java.io.Serializable;

/**
 * 如何取出使用---待定
 */

@SuppressWarnings("all")
public class Config implements Serializable {
    private int conId;
    private String conType;
    private String conKey;
    private String conPage;
    private String conCreateTime;

    /**
     * 构造方法
     * <p>
     * 存入时只需要conType、conKey、conPage
     * <p>
     * 取出时需要conId、conType、conKey、conPage、conCreateTime
     */

    public Config() {
    }

    public Config(String conType, String conKey, String conPage) {
        this.conType = conType;
        this.conKey = conKey;
        this.conPage = conPage;
    }

    public Config(String conType, String conKey, String conPage, String conCreateTime) {
        this.conType = conType;
        this.conKey = conKey;
        this.conPage = conPage;
        this.conCreateTime = conCreateTime;
    }

    /**
     * getter&setter方法
     *
     * @return
     */

    public int getconId() {
        return conId;
    }

    public void setconId(int conId) {
        this.conId = conId;
    }

    public String getconType() {
        return conType;
    }

    public void setconType(String conType) {
        this.conType = conType;
    }

    public String getconKey() {
        return conKey;
    }

    public void setconKey(String conKey) {
        this.conKey = conKey;
    }

    public String getconPage() {
        return conPage;
    }

    public void setconPage(String conPage) {
        this.conPage = conPage;
    }

    public String getconCreateTime() {
        return conCreateTime;
    }

    public void setconCreateTime(String conCreateTime) {
        this.conCreateTime = conCreateTime;
    }

    /**
     * override toString()方法
     */

    @Override
    public String toString() {
        return "Config{" +
                "conId=" + conId +
                ", conType='" + conType + '\'' +
                ", conKey='" + conKey + '\'' +
                ", conPage='" + conPage + '\'' +
                ", conCreateTime='" + conCreateTime + '\'' +
                '}';
    }
}
