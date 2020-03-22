package cn.xpbootcamp.gilded_rose;

public class GoodsScenario {

    //商品到期后，价值>0
    public static Goods createCommonGoodWithSlowRate() {
        Goods goods = new Goods();
        goods.setSellIn(20);
        goods.setQuality(40);
        goods.setRate(0.02);
        return goods;
    }
    //商品未到期，价值可变为0
    public static Goods createCommonGoodWithFastRate() {
        Goods goods = new Goods();
        goods.setSellIn(20);
        goods.setQuality(40);
        goods.setRate(0.1);
        return goods;
    }
}
