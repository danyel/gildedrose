package be.persgroep.gildedrose.model;

import be.persgroep.gildedrose.GildedRose;
import be.persgroep.gildedrose.factory.ItemFactory;
import org.assertj.core.api.Java6Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SulfurasQualityTest {
    private static final String SULFURAS = "Sulfuras";
    private GildedRose gildedRose = new GildedRose();
    private ItemFactory itemFactory = new ItemFactory();
    private List<Item> items = new LinkedList<>();

    @Before
    public void setUp() {
        items.add(itemFactory.createItemFor(SULFURAS, 0));
        items.add(itemFactory.createItemFor(SULFURAS, 3));
        items.add(itemFactory.createItemFor(SULFURAS, 7));
        items.add(itemFactory.createItemFor(SULFURAS, 11));
    }

    @Test
    public void calculateQuality() {
        gildedRose.updateQualityForItems(items);
        List<Integer> values = items.stream().map(item -> item.getQuality().getValue())
                .collect(Collectors.toList());
        Java6Assertions.assertThat(values).contains(80, 80, 80, 80);
    }
}