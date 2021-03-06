package com.thpffcj.base;

/**
 * Created by Thpffcj on 2018/3/3.
 */
public enum LevelRules {

    LEVEL0(0, Integer.MIN_VALUE, 1.0),
    LEVEL1(1, 1000, 0.9),
    LEVEL2(2, 2000, 0.8),
    LEVEL4(3, 3000, 0.7),
    LEVEL5(4, 4000, 0.6);

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
     * 根据等级寻找升级所需金额
     *
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
     *
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
