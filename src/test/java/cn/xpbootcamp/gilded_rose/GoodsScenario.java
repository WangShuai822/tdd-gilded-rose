package cn.xpbootcamp.gilded_rose;

public class GoodsScenario {
    private static int SELL_IN = 20;
    private static double QUALITY = 30;
    private static double SLOW_RATE = 0.02;
    private static double FAST_RATE = 0.1;

    //商品到期后，价值>0
    public static Goods createCommonGoodsWithSlowRate() {
        Goods goods = new Goods();
        goods.setSellIn(SELL_IN);
        goods.setQuality(QUALITY);
        goods.setRate(SLOW_RATE);
        return goods;
    }
    //商品未到期，价值可变为0
    public static Goods createCommonGoodsWithFastRate() {
        Goods goods = new Goods();
        goods.setSellIn(SELL_IN);
        goods.setQuality(QUALITY);
        goods.setRate(FAST_RATE);
        return goods;
    }

    //商品未到期，时间越久，价值越高
    public static Goods createAgedBrieGoods() {
        Goods agedBrie = new Goods();
        agedBrie.setName("Aged Brie");
        agedBrie.setSellIn(SELL_IN);
        agedBrie.setQuality(QUALITY);
        agedBrie.setRate(SLOW_RATE);
        return agedBrie;
    }

    //没有保质期，质量也不下滑
    public static Goods createSulfurasGoods() {
        Goods goods = new Goods();
        goods.setName("Sulfuras");
        goods.setQuality(QUALITY);
        goods.setSellIn(0);
        return goods;
    }

    //后台门票
    public static Goods createBackstageGoods() {
        Goods goods = new Goods();
        goods.setName("Backstage pass");
        goods.setQuality(QUALITY);
        goods.setSellIn(SELL_IN);
        return goods;
    }
}
