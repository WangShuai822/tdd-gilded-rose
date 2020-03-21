package cn.xpbootcamp.gilded_rose;

import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Log
class GoodsTest {

    @BeforeAll
    public static void init() {
        log.info("init.....");
    }

    @Test
    public void getSellIn() {
        Goods commonGood = new Goods();
        int sellIn = commonGood.getSellIn();
        assertTrue(sellIn >= 0 && sellIn <= 50);
    }
}