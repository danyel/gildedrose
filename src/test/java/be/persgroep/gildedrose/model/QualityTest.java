package be.persgroep.gildedrose.model;

import be.persgroep.gildedrose.GildedRose;
import be.persgroep.gildedrose.factory.ItemFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.*;

public class QualityTest {
    private static final String DEFAULT = "Default";
    private GildedRose gildedRose = new GildedRose();
    private ItemFactory itemFactory = new ItemFactory();
    private List<Item> items = new LinkedList<>();

    @Before
    public void setUp() {
        items.add(itemFactory.createItemFor(DEFAULT, 0, 10));
        items.add(itemFactory.createItemFor(DEFAULT, 3, 14));
        items.add(itemFactory.createItemFor(DEFAULT, 7, 16));
    }

    @Test
    public void calculateQuality() {
        gildedRose.updateQualityForItems(items);
        assertThat(items.get(0).getQuality().getValue()).isEqualTo(10);
        assertThat(items.get(1).getQuality().getValue()).isEqualTo(14);
        assertThat(items.get(2).getQuality().getValue()).isEqualTo(16);
    }
}