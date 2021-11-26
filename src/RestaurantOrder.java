import java.util.Arrays;
import java.util.Objects;

public class RestaurantOrder implements Order {

    protected int size;
    protected Item[] items;

    public RestaurantOrder(int size) {
        this.size = size;
        items=new Item[size];
    }

    @Override
    public void add(Item item) {
        for (int i = 0; i < size; i++)
        {
            if (items[i] == null)
            {
                items[i] = item;
                break;
            }
        }
    }

    public boolean remove(String itemName) {
        for (int i = 0; i < size; i++) {
            if (items[i] == null)
                continue;
            if (Objects.equals(items[i].getName(), itemName)) {
                items[i] = null;
                for (int j = i; j < size - 1; j++) {
                    items[j] = items[j + 1];
                }
                size -= 1;
                return true;
            }
        }
        return false;
    }


    @Override
    public Item[] getItems() {
        return items;
    }

    @Override
    public double getTotalCost() {
        double cost = 0;
        for(int i = 0; i < size; i++){
            if (items[i] == null)
                continue;
            cost += items[i].getCost();
        }
        return cost;
    }

    @Override
    public int getItemscount(String itemName) {
        int count = 0;
        for(int i = 0; i < size; i++){
            if (items[i] == null)
                continue;
            if (Objects.equals(items[i].getName(), itemName))
                count++;
        }
        return count;
    }

    public int getCount(){
        int count = 0;
        for(int i = 0; i < size; i++){
            if (items[i] == null)
                continue;
            else
                count++;
        }
        return count;
    }

    @Override
    public Item[] getItemsSort() {
        Item temp;
        for(int j = 1; j < size - 1; j++){
            for(int i = 0; i < size - (j + 1); i++){
                if (items[i].getCost() > items[i + 1].getCost()){
                    temp = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = temp;
                }
            }
        }
        return items;
    }

    public Item[] getItemsSortReverse(){
        Item temp;
        for(int j = 1; j < size - 1; j++){
            for(int i = 0; i < size - (j + 1); i++){
                if (items[i].getCost() < items[i + 1].getCost()){
                    temp = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = temp;
                }
            }
        }
        return items;
    }

    public Item[] getItemsNoRepeat(){
        Item[] noRepeat = new Item[size];
        noRepeat = items;
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if (Objects.equals(noRepeat[i].getName(), noRepeat[j].getName()))
                    noRepeat[j] = null;
            }
        }
        return noRepeat;
    }

    @Override
    public String toString() {
        return "RestaurantOrder{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
