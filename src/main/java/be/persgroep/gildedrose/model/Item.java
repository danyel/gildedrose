package be.persgroep.gildedrose.model;

import lombok.Data;

@Data
public class Item {
    private final String name;
    private int sellIn = 1;
    private Quality quality = new Quality();

    public boolean isSulfuras() {
        return "Sulfuras".equals(name);
    }

    public boolean isBackstagePasses() {
        return "Backstage passes".equals(name);
    }

    public boolean isAgedBrie() {
        return "Aged Brie".equals(name);
    }

    public boolean isConjured() {
        return "Conjured".equals(name);
    }
}
