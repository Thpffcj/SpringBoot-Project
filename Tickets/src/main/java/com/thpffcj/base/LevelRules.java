package com.thpffcj.base;

/**
 * Created by Thpffcj on 2018/3/3.
 */
public enum LevelRules {

    LEVEL1(1, 100, 1.0),
    LEVEL2(2, 200, 0.9);

    private int level;
    private double grade;
    private double discount;

    LevelRules(int level, double grade, double discount) {
        this.level = level;
        this.grade = grade;
        this.discount = discount;
    }

    public int getLevel() {
        return level;
    }

    public double getGrade() {
        return grade;
    }

    public double getDiscount() {
        return discount;
    }

    /**
     * 根据等级寻找升级所需积分
     * @param level
     * @return
     */
    public static double getGradeByLevel(int level) {
        for (LevelRules state : values()) {
            if (state.getLevel() == level) {
                return state.getGrade();
            }
        }
        return 1.0;
    }

    /**
     * 根据等级确定折扣
     * @param level
     * @return
     */
    public static double getDiscountByLevel(int level) {
        for (LevelRules state : values()) {
            if (state.getLevel() == level) {
                return state.getDiscount();
            }
        }
        return 1.0;
    }
}
