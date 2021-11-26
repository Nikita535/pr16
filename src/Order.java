public interface Order{
    public void add(Item item);
    public Item[] getItems();
    public double getTotalCost();
    public int getItemscount(String itemName);
    public Item[] getItemsSort();
}
