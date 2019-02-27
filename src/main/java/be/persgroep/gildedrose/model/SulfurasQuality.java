package be.persgroep.gildedrose.model;

public class SulfurasQuality extends Quality {

    /*
    "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    however "Sulfuras" is a
legendary item and as such its Quality is 80 and it never alters.
     */
    @Override
    public void calculateForItem(Item item) {
        item.getQuality().setValue(80);
    }
}
