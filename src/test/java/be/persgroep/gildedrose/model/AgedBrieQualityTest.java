package be.persgroep.gildedrose.model;

import be.persgroep.gildedrose.GildedRose;
import be.persgroep.gildedrose.factory.ItemFactory;
import org.assertj.core.api.Java6Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AgedBrieQualityTest {
    private static final String AGED_BRIE = "Aged Brie";
    private GildedRose gildedRose = new GildedRose();
    private ItemFactory itemFactory = new ItemFactory();
    private List<Item> items = new LinkedList<>();

    @Before
    public void setUp() {
        items.add(itemFactory.createItemFor(AGED_BRIE, -5, 10));
        items.add(itemFactory.createItemFor(AGED_BRIE, 0, 10));
        items.add(itemFactory.createItemFor(AGED_BRIE, 3, 11));
        items.add(itemFactory.createItemFor(AGED_BRIE, 7, 12));
        items.add(itemFactory.createItemFor(AGED_BRIE, 11, 14));
    }

    @Test
    public void calculateQuality() {
        gildedRose.updateQualityForItems(items);
        List<Integer> values = items.stream().map(item -> item.getQuality().getValue())
                .collect(Collectors.toList());
        Java6Assertions.assertThat(values).contains(12, 12, 11, 13, 15);
    }
}