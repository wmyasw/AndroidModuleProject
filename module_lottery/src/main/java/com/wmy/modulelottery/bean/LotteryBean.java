package com.wmy.modulelottery.bean;

import java.io.Serializable;


/**
 * @author wmy
 * @Description: 彩票类
 * @FileName: LotteryBean
 * @Date 2018/5/30/030 16:08
 */
public class LotteryBean implements Serializable {

    /**
     * series :
     * area : 全国彩
     * issuer : 体彩
     * times :
     * high : false
     * code : dlt
     * hots : false
     * notes : 每周一、三、六的20:30开奖
     * descr : 超级大乐透
     */

    private String series;
    private String area;
    private String issuer;
    private String times;
    private String high;
    private String code;
    private String hots;
    private String notes;
    private String descr;
    /**
     * expect : 2018061
     * timestamp : 1527599900
     * time : 2018-05-29 21:18:20
     * name : 双色球
     * openCode : 09,10,11,12,18,23+07
     */

    private String expect;
    private int timestamp;
    private String time;
    private String name;
    private String openCode;


    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHots() {
        return hots;
    }

    public void setHots(String hots) {
        this.hots = hots;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }
}
