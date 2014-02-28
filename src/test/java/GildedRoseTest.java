import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}

    @Test
    public void testSulfurasQualitydoesNeverChange(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Sulfuras, Hand of Ragnaros", -1, 80));


        GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(80, items.get(0).getQuality());
        Assert.assertEquals(80, items.get(0).getQuality());

    }


    @Test
    public void testBrieIncreasesInQualityBy1IfTheSellByDateHasNotExpired(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Aged Brie", 2, 0));

         GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(1, items.get(0).getQuality());

    }

    @Test
    public void testBrieIncreasesInQualityBy2IfTheSellByDateHasExpired(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Aged Brie", 0, 0));

         GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();


        Assert.assertEquals(2, items.get(0).getQuality());
    }

    @Test
    public void testBrieDoesNotIncreaseInQualityIfTheQualityIsAlreadyAt50(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Aged Brie", 0, 50));

         GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();


        Assert.assertEquals(50, items.get(0).getQuality());
    }

    @Test
    public void qualityOfAnyItemCanNeverBeNegative(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Elixir of the Mongoose", 0, 0));

         GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(0, items.get(0).getQuality());
    }

    @Test
    public void onceTheSellByDateHasPassedQualityDegradesQuiteAsFast(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Elixir of the Mongoose", 0, 4));
         GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(2, items.get(0).getQuality());

    }

    @Test
    public void qualityOfAnyItemDegradesBy1IfTheSellByDateHasNotExpired(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Elixir of the Mongoose", 2, 4));
         GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(3, items.get(0).getQuality());
    }

    @Test
    public void sellByDateOfAnyItemDecreasesBy1(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Elixir of the Mongoose", 2, 4));
         GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(1, items.get(0).getSellIn());

    }

    @Test
    public void sellByDateOfAnyItemCanBeNegativeExceptForSulfuras(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Elixir of the Mongoose", 0, 4));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

         GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(-1, items.get(0).getSellIn());
        Assert.assertEquals(0, items.get(1).getSellIn());

    }

    @Test
    public void backstagePassesIncreaseBy1WhenSellByDateIsMoreThan10(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));

         GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(21, items.get(0).getQuality());

    }

    @Test
    public void backstagePassesIncreaseBy2WhenSellByDateIsBetween10And6(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20));

        GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();
        Assert.assertEquals(22, items.get(0).getQuality());
        Assert.assertEquals(22, items.get(1).getQuality());


    }

    @Test
    public void backstagePassesIncreaseBy3WhenSellByDateIsBetween5And1(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20));

        GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();
        
        Assert.assertEquals(23, items.get(0).getQuality());
        Assert.assertEquals(23, items.get(1).getQuality());

    }

    @Test
    public void backstagePassIncrementsBy1IfQualityIs49AndSellByDateIsBetween10And6(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));

        GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(50, items.get(0).getQuality());

    }

    @Test
    public void backstagePassIncrementsBy1IfQualityIs48AndSellByDateIsBetween5And1(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48));

        GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(50, items.get(0).getQuality());

    }

    @Test
    public void backstagePassesFallToZeroWhenSellByDateIs0OrLess(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20));

        GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();
        
        Assert.assertEquals(0, items.get(0).getQuality());
        Assert.assertEquals(0, items.get(1).getQuality());

    }

    @Test
    public void conjuredItemsDecreaseInQualityBy2WhenSellByDateHasNotExpired(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Conjured Mana Cake", 3, 6));

        GildedRose gildedRose = new GildedRose(items);
        GildedRose.updateQuality();

        Assert.assertEquals(4, items.get(0).getQuality());


    }







}
