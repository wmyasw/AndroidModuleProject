package com.wmy.caipiaomodule;

import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        System.out.println(year + "年" + month + "月" + day + "号," + weekDays[w]);
    }
}