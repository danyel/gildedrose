package be.persgroep.gildedrose.model;

import static java.lang.Math.min;

public class AgedBrieQuality extends Quality {
    /*
    "Aged Brie" actually increases in Quality the older it gets
     */
    @Override
    public void calculateForItem(Item item) {
        item.getQuality().setValue(min(item.getQuality().getValue() + QUALITY_STEP, MAX_QUALITY));
    }
}
