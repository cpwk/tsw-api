package com.mdtech.tsw.api.banner;

public enum BannerType {
    HOME(1), PRODUCT(2), SERVICE(3), CASE(4), COOPERATION(5), ARTICLE(6), BLOG(7), ABOUT(8);

    private int val;

    private BannerType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

}
