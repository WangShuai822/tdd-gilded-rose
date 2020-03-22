package cn.xpbootcamp.gilded_rose;

import lombok.*;
import lombok.extern.java.Log;

@Data
@Log
public class Goods {
    private String name;
    private int sellIn;
    private double quality;
    private double rate; //保质期内，每天价值递减率

    public void updateQuality(int days) {
        double currentQuality = getCurrentQuality(days);
        if (currentQuality < 0) {
            currentQuality = 0;
        }
        if (currentQuality > 50) {
            currentQuality = 50;
        }
        log.info("update quality: " + currentQuality);
        this.setQuality(currentQuality);
    }

    private double getCurrentQuality(int days) {
        double currentQuality;

        if (name != null && name.equals("Aged Brie")) {
            currentQuality = quality * (1 + rate * days);
        }else if(name != null && name.equals("Backstage pass")){
            currentQuality = getBackstageQuality(days);
        } else {
            currentQuality = getCommonGoodsQuality(days);
        }

        log.info("current quality is :" + currentQuality);
        return currentQuality;
    }

    private double getBackstageQuality(int days) {
        double currentQuality = 0.0;
        int beforeShow = sellIn - days;
        if (beforeShow > 5 && beforeShow < 10) {
            currentQuality = quality + (days - 10) * 2;
        }
        if (beforeShow > 0 && beforeShow <= 5) {
            currentQuality = quality + 8 + beforeShow * 3;
        }
        return currentQuality;
    }

    private double getCommonGoodsQuality(int days) {
        double currentQuality = 0.0;
        //保质期内
        if (days <= sellIn) {
            currentQuality = quality * (1 - rate * days);
        }

        //超过保质期，质量双倍下降
        if (days > sellIn) {
            //到保质期时的价值
            double qualityInSellIn = quality * (1 - rate * sellIn);
            if (qualityInSellIn > 0) {
                currentQuality = qualityInSellIn - quality * rate * (days - sellIn) * 2;
            }
        }
        return currentQuality;
    }
}
