import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
        System.out.println(items.size());
}

    public GildedRose(ArrayList<Item> items)
    {
        this.items = items;

    }

    static boolean isSulfuras(Item item){
        return item.getName().toLowerCase().contains("sulfuras");
    }

    static boolean isBackstagePass(Item item){
        return item.getName().toLowerCase().contains("backstage");
    }
    
    static boolean isBrie(Item item){
        return item.getName().toLowerCase().contains("brie");
    }

    static boolean isConjured(Item item){
        return item.getName().toLowerCase().contains("conjured");
    }

	
    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
            
            if ((!isBrie(item)) && !isBackstagePass(item)) 
            {
                if (item.getQuality() > 0)
                {
                    if (!isSulfuras(item))
                    {
                        item.setQuality(item.getQuality() - 1);

                        if(isConjured(item) && item.getQuality() >= 1){
                            item.setQuality(item.getQuality() -1);
                        }
                    }

                }
            }
            else
            {
                if (item.getQuality() < 50)
                {
                    item.setQuality(item.getQuality() + 1);

                    if (isBackstagePass(item))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(item))
            {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0)
            {
                if (!isBrie(item))
                {
                    if (!isBackstagePass(item))
                    {
                        if (item.getQuality() > 0)
                        {
                            if (!isSulfuras(item))
                            {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                }
                else
                {
                    if (item.getQuality() < 50)
                    {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }

}