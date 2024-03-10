package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.sellIn -= 1;
            if (item.quality > 0) {
                if (item.name.equals("Aged Brie")) {
                    if (item.quality < 50) {
                        item.quality += 1;
                    }
                } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality < 48 && item.sellIn < 6) {
                        item.quality += 3;
                    } else if (item.quality < 49 && item.sellIn < 11) {
                        item.quality += 2;
                    } else {
                        item.quality += 1;
                    }
                } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    if (item.name.equals("Conjured Mana Cake") && item.quality > 1) {
                        item.quality -= 2;
                    } else {
                        item.quality -= 1;
                    }
                }
                else {
                    item.sellIn += 1;
                }
            }
        }
    }
}
