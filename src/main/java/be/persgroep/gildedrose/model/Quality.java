package be.persgroep.gildedrose.model;

import lombok.Data;

@Data
public class Quality {
    public static final int MAX_QUALITY = 50;
    public static final int QUALITY_STEP = 1;
    public static final int DEFAULT_QUALITY_DROP = 1;
    private int value;

    public void calculateForItem(Item item) {
        item.setQuality(item.getQuality());
    }

    protected int getSellInRate(Item item) {
        return item.getSellIn() < 0 ? getDropRate() * 2 : DEFAULT_QUALITY_DROP;
    }

    protected int getDropRate() {
        return QUALITY_STEP;
    }
}
