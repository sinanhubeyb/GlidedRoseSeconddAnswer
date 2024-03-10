package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item: items){
            updateItemsQuality(item);
        }
    }

    private void updateItemsQuality(Item item) {
        if (isOtherItem(item)){
            decreaseTheQuality(item);
        } else if (isAgedBrie(item)) {
            increaseTheQuality(item);
        } else if (isBackStagePass(item)) {
            updateBackStagePassQuality(item);
        }

        if (!isSulfuras(item)){
            decreaseSellIn(item);
        }

        if (hasExpired(item)){
            if (isOtherItem(item) || isConjuredManaCakeItem(item)){
                decreaseTheQuality(item);
            } else if (isAgedBrie(item)) {
                increaseTheQuality(item);
            } else if (isBackStagePass(item)) {
                item.quality = 0;
            }
        }
    }

    private boolean isOtherItem(Item item){
        return !isAgedBrie(item) && !isBackStagePass(item) && !isSulfuras(item) && !isConjuredManaCakeItem(item);
    }

    private boolean isConjuredManaCakeItem(Item item) {
        return item.name.equals("Conjured Mana Cake");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackStagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private void decreaseTheQuality(Item item) {
        if (item.quality > 0) {
            int decreaseBy = isConjuredManaCakeItem(item) ? 2 : 1;
            item.quality = Math.max(0, item.quality - decreaseBy);
        }
    }
        private void increaseTheQuality(Item item){
            if (item.quality<50){
                item.quality = Math.min(50, item.quality+1);
            }
    }

    private void updateBackStagePassQuality(Item item){
        if (item.quality<50){
            int increaseBy = 1;
            if (item.sellIn <=10){
                increaseBy=2;
            }
            if (item.sellIn<=5){
                increaseBy = 3;
            }
            item.quality = Math.min(50, item.quality+increaseBy);
        }
    }

    private void decreaseSellIn(Item item){
        item.sellIn--;
    }

    private boolean hasExpired(Item item){
        return item.sellIn<0;
    }

}
