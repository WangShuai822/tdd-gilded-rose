package cn.xpbootcamp.gilded_rose;

public class GoodsScenario {
    private static double SELL_IN = 20;
    private static double QUALITY = 40;
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
}
