package be.persgroep.gildedrose.model;

import be.persgroep.gildedrose.GildedRose;
import be.persgroep.gildedrose.factory.ItemFactory;
import org.assertj.core.api.Java6Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.*;

public class BackstagePassQualityTest {
    private static final String BACKSTAGE_PASSES = "Backstage passes";
    private GildedRose gildedRose = new GildedRose();
    private ItemFactory itemFactory = new ItemFactory();
    private List<Item> items = new LinkedList<>();

    @Before
    public void setUp() {
        items.add(itemFactory.createItemFor(BACKSTAGE_PASSES, 0, 10));
        items.add(itemFactory.createItemFor(BACKSTAGE_PASSES, 3, 14));
        items.add(itemFactory.createItemFor(BACKSTAGE_PASSES, 7, 16));
    }

    @Test
    public void calculateQuality() {
        gildedRose.updateQualityForItems(items);
        assertThat(items.get(0).getQuality().getValue()).isEqualTo(0);
        assertThat(items.get(1).getQuality().getValue()).isEqualTo(17);
        assertThat(items.get(2).getQuality().getValue()).isEqualTo(18);
    }
}