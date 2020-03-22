package cn.xpbootcamp.gilded_rose;

public class GoodsScenario {

    //商品到期后，价值>0
    public static Goods createCommonGoodsWithSlowRate() {
        Goods goods = new Goods();
        goods.setSellIn(20);
        goods.setQuality(40);
        goods.setRate(0.02);
        return goods;
    }
    //商品未到期，价值可变为0
    public static Goods createCommonGoodsWithFastRate() {
        Goods goods = new Goods();
        goods.setSellIn(20);
        goods.setQuality(40);
        goods.setRate(0.1);
        return goods;
    }

    //商品未到期，时间越久，价值越高
    public static Goods createAgedBrieGoods() {
        Goods agedBrie = new Goods();
        agedBrie.setName("Aged Brie");
        agedBrie.setSellIn(20);
        agedBrie.setQuality(40);
        agedBrie.setRate(0.02);
        return agedBrie;
    }
}
