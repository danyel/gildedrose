package be.persgroep.gildedrose;

import be.persgroep.gildedrose.model.Item;

import java.util.List;

public class GildedRose {
    public void updateQualityForItems(List<Item> items) {
        items.forEach(item -> {
            this.updateQualityForItem(item);
            this.updateSellInForItem(item);
        });
    }

    public void updateQualityForItem(Item item) {
        item.getQuality().calculateForItem(item);
    }

    private void updateSellInForItem(Item item) {
        item.setSellIn(item.getSellIn() - (item.isSulfuras() ? 0 : 1));
    }
}
