package cn.xpbootcamp.gilded_rose;

import lombok.*;

@Data
public class Goods {
    private String name;
    private double sellIn;
    private double quality;
    private double rate; //保质期内，每天价值递减率


    public void updateQuality(int days) {
        double currentQuality = getCurrentQuality(days) >= 0 ? getCurrentQuality(days) : 0;
        this.setQuality(currentQuality);
    }

    private double getCurrentQuality(int days) {
        double currentQuality = 0.0;
        //保质期内
        if (days <= sellIn) {
            currentQuality = quality * (1 - this.getRate() * days);
        }

        //超过保质期，质量双倍下降
        if (days > sellIn) {
            //到保质期时的价值
            double qualityInSellIn = quality * (1 - this.getRate() * sellIn);
            currentQuality = qualityInSellIn - quality * this.getRate() * (days - sellIn) * 2;
        }
        return currentQuality;
    }
}
