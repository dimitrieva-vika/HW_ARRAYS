package ru.netology.stats;

public class StatsService {

    // 1. Сумма всех продаж
    public long sum(long[] sales) {
        long total = 0;
        for (long sale : sales) {
            total = total + sale;
        }
        return total;
    }

    // 2. Средняя сумма продаж в месяц
    public double average(long[] sales) {
        double total = sum(sales);
        return total / sales.length;
    }

    // 3. Номер месяца с пиком продаж (максимум) - последний
    public int maxSalesMonth(long[] sales) {
        int maxMonth = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) {
                maxMonth = i;
            }
        }
        return maxMonth + 1;
    }

    // 4. Номер месяца с минимумом продаж (последний)
    public int minSalesMonth(long[] sales) {
        int minMonth = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) {
                minMonth = i;
            }
        }
        return minMonth + 1;
    }

    // 5. Количество месяцев с продажами ниже среднего
    public int monthsBelowAverage(long[] sales) {
        double avg = average(sales);
        int count = 0;
        for (long sale : sales) {
            if (sale < avg) {
                count++;
            }
        }
        return count;
    }

    // 6. Количество месяцев с продажами выше среднего
    public int monthsAboveAverage(long[] sales) {
        double avg = average(sales);
        int count = 0;
        for (long sale : sales) {
            if (sale > avg) {
                count++;
            }
        }
        return count;
    }
}