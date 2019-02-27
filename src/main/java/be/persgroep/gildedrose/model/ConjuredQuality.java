package be.persgroep.gildedrose.model;

public class ConjuredQuality extends Quality {
    /*
    "Conjured" items degrade in Quality twice as fast as normal items
     */
    @Override
    public void calculateForItem(Item item) {
        item.getQuality().setValue(item.getQuality().getValue() - getSellInRate(item));
    }

    @Override
    protected int getSellInRate(Item item) {
        return item.getQuality().getValue() - getDropRate() > 0 ? getDropRate() : item.getQuality().getValue();
    }

    @Override
    protected int getDropRate() {
        return super.getDropRate() * 2;
    }
}
