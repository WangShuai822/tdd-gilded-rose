package cn.xpbootcamp.gilded_rose;

import lombok.*;
import lombok.extern.java.Log;

@Data
@Log
public class Goods {
    private String name;
    private double sellIn;
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
        double currentQuality = 0.0;

        if (name != null && name.equals("Aged Brie")) {
            currentQuality = quality * (1 + rate * days);
        } else {
            currentQuality = getCommonGoodsQuality(days);
        }

        log.info("current quality is :" + currentQuality);
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
            double qualityInSellIn = quality * (1 - this.getRate() * sellIn);
            if (qualityInSellIn > 0) {
                currentQuality = qualityInSellIn - quality * this.getRate() * (days - sellIn) * 2;
            }
        }
        return currentQuality;
    }
}
