package be.persgroep.gildedrose.model;

import static java.lang.Math.min;

public class BackstagePassQuality extends Quality {
    /*
    - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	Quality drops to 0 after the concert
     */
    @Override
    public void calculateForItem(Item item) {
        item.getQuality().setValue(getSellInRate(item));
    }

    @Override
    protected int getSellInRate(Item item) {
        return item.getSellIn() > 0 ? min(item.getQuality().getValue() + calculateDropRate(item), MAX_QUALITY) : item.getSellIn();
    }

    private int calculateDropRate(Item item) {
        if (isFiveDaysOrLess(item)) {
            return getDropRate() + 2;
        } else if (isLessThenTenDays(item)) {
            return getDropRate() + 1;
        }
        return getDropRate();
    }

    private boolean isFiveDaysOrLess(Item item) {
        return item.getSellIn() <= 5;
    }

    private boolean isLessThenTenDays(Item item) {
        return item.getSellIn() <= 10;
    }
}
