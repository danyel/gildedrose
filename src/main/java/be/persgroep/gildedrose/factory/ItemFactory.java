package be.persgroep.gildedrose.factory;

import be.persgroep.gildedrose.model.AgedBrieQuality;
import be.persgroep.gildedrose.model.BackstagePassQuality;
import be.persgroep.gildedrose.model.ConjuredQuality;
import be.persgroep.gildedrose.model.Item;
import be.persgroep.gildedrose.model.Quality;
import be.persgroep.gildedrose.model.SulfurasQuality;

public class ItemFactory {
    public Item createItemFor(String name, int sellIn, int quality) {
        Item itemFor = createItemFor(name, sellIn);
        itemFor.getQuality().setValue(quality);
        return itemFor;
    }
    public Item createItemFor(String name, int sellIn) {
        Item item = new Item(name);

        if (item.isAgedBrie()) {
            item.setQuality(new AgedBrieQuality());
        } else if (item.isSulfuras()) {
            item.setQuality(new SulfurasQuality());
        } else if (item.isConjured()) {
            item.setQuality(new ConjuredQuality());
        } else if (item.isBackstagePasses()) {
            item.setQuality(new BackstagePassQuality());
        } else {
            item.setQuality(new Quality());
        }
        item.setSellIn(sellIn);

        return item;
    }
}
