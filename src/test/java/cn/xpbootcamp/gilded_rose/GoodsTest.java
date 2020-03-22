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
    public void when_goods_in_sellIn() {
        Goods goods = GoodsScenario.createCommonGood();
        goods.updateQuality(10);
        should_get_correct_quality(goods);
    }

    @Test
    public void when_goods_out_sellIn() {
        Goods goods = GoodsScenario.createCommonGood();
        goods.updateQuality(60);
        should_get_correct_quality(goods);
    }


}