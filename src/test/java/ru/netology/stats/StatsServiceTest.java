package ru.netology.stats;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    private final long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

    @Test
    void testSum() {
        StatsService service = new StatsService();
        long expected = 180;
        long actual = service.sum(sales);
        assertEquals(expected, actual);
    }

    @Test
    void testAverage() {
        StatsService service = new StatsService();
        double expected = 180.0 / 12;  // = 15.0? НЕТ! 180/12 = 15.0
        // По условию: 8+15+13+15+17+20+19+20+7+14+14+18 = 180? Давайте пересчитаем:
        // 8+15=23, +13=36, +15=51, +17=68, +20=88, +19=107, +20=127, +7=134, +14=148, +14=162, +18=180.
        // 180 / 12 = 15.0
        // Значит, среднее = 15.0, а не 14.166!
        assertEquals(15.0, service.average(sales), 0.001);
    }

    @Test
    void testMaxSalesMonth() {
        StatsService service = new StatsService();
        // Максимум 20 — последний месяц с 20 — это 8-й месяц (индекс 7)
        assertEquals(8, service.maxSalesMonth(sales));
    }

    @Test
    void testMinSalesMonth() {
        StatsService service = new StatsService();
        // Минимум 7 — это 9-й месяц (индекс 8)
        assertEquals(9, service.minSalesMonth(sales));
    }

    @Test
    void testMonthsBelowAverage() {
        StatsService service = new StatsService();
        // Среднее = 15.0
        // Ниже среднего: 8, 13, 7, 14, 14 → 5 месяцев
        assertEquals(5, service.monthsBelowAverage(sales));
    }

    @Test
    void testMonthsAboveAverage() {
        StatsService service = new StatsService();
        // Выше среднего (строго >15): 17,20,19,20,18 → 5? Нет, посчитаем:
        // 8(<15), 15(=15), 13(<15), 15(=15), 17(>15), 20(>15), 19(>15), 20(>15), 7(<15), 14(<15), 14(<15), 18(>15)
        // >15: 17,20,19,20,18 = 5 месяцев
        // Но в условии сказано "количество месяцев, в которых продажи были выше среднего" — строго выше.
        // Если строго выше — то 5. Если выше или равно — то 7.
        // По условию: "выше среднего" — значит строго больше.
        assertEquals(5, service.monthsAboveAverage(sales));
    }
}