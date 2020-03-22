package cn.xpbootcamp.gilded_rose;

public class GoodsScenario {

    //商品到期后，价值>0
    public static Goods createCommonGood() {
        Goods goods = new Goods();
        goods.setSellIn(20);
        goods.setQuality(40);
        goods.setRate(0.02);
        return goods;
    }
}
