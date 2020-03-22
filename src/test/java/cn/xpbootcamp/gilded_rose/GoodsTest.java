package cn.xpbootcamp.gilded_rose;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Log
class GoodsTest {

    private void should_get_correct_quality(Goods goods) {
        assertTrue(goods.getQuality() >= 0 && goods.getQuality() <= 50);
    }

    @Test
    public void when_goods_in_sellIn_and_slow_rate() {
        Goods goods = GoodsScenario.createCommonGoodsWithSlowRate();
        goods.updateQuality(10);
        should_get_correct_quality(goods);
    }
    @Test
    public void when_goods_in_sellIn_and_fast_rate() {
        Goods goods = GoodsScenario.createCommonGoodsWithFastRate();
        goods.updateQuality(15);
        should_get_correct_quality(goods);
    }

    @Test
    public void when_goods_out_sellIn() {
        Goods goods = GoodsScenario.createCommonGoodsWithSlowRate();
        goods.updateQuality(60);
        should_get_correct_quality(goods);
    }

    @Test
    public void should_increase_quality_when_goods_is_aged_brie() {
        Goods goods = GoodsScenario.createAgedBrieGoods();
        double originQuality = goods.getQuality();
        goods.updateQuality(10);
        assertTrue(goods.getQuality() > originQuality);
    }

}