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
        goods.updateQuality(15);
        assertTrue(goods.getQuality() > originQuality && goods.getQuality() <= 50);
    }

    @Test
    public void should_keep_quality_when_goods_is_sulfuras() {
        Goods goods = GoodsScenario.createSulfurasGoods();
        double originQuality = goods.getQuality();
        goods.updateQuality(15);
        assertTrue(originQuality == goods.getQuality());
    }

    @Test
    public void should_increase_quality_when_goods_is_backstage_pass() {
        Goods goods = GoodsScenario.createBackstageGoods();
        double originQuality = goods.getQuality();
        goods.updateQuality(14);
        assertTrue(goods.getQuality() == 50 || goods.getQuality() == originQuality + 8);

        goods.updateQuality(17);
        assertTrue(goods.getQuality() == 50 || goods.getQuality() == originQuality + 16);

        goods.updateQuality(21);
        assertTrue(goods.getQuality() == 0.0);

    }

}