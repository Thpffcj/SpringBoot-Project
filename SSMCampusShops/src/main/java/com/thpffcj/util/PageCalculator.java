package com.thpffcj.util;

/**
 * Created by Thpffcj on 2017/12/31.
 */
public class PageCalculator {

    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
