import java.util.HashMap;

public class OrderManager {
    protected RestaurantOrder[] orders;
    protected int tableCount;
    protected HashMap<String, Order> pairs = new HashMap();

    public OrderManager(int tableCount) {
        this.tableCount = tableCount;
        orders = new RestaurantOrder[tableCount];
    }


    public void add(String address, Order order) {
        try {
            if (pairs.containsKey(address))
                throw new OrderAlreadyAddedException("This address has already been added");
            pairs.put(address, order);
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }

    }

    public void add(RestaurantOrder order, int tableNumber) {
        try {
            if (tableNumber > tableCount) {
                throw new Exception("There are no more tables");
            }
            if (orders[tableNumber] != null)
                throw new OrderAlreadyAddedException("This table has already been added");
            orders[tableNumber] = order;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public RestaurantOrder getOrder(int tableNumber) {
        try {
            if (tableNumber > tableCount) {
                throw new Exception();
            }
            return orders[tableNumber];
        } catch (Exception e) {
            System.out.println("There are no more tables");
            return null;
        }
    }

    public Order getOrder(String address) {
        return pairs.get(address);
    }

    public void addItem(String address, Item item) {
        try {
            if (!pairs.containsKey(address))
                throw new Exception();
            pairs.get(address).add(item);
        } catch (Exception e) {
            System.out.println("There is no that address");
        }
    }

    public HashMap<String, Order> getInternetOrders() {
        return pairs;
    }

    public int getInternetCount() {
        return pairs.size();
    }

    public int getInternetDefiniteCount(String itemName) {
        int count = 0;
        for (String key : pairs.keySet()) {
            count += pairs.get(key).getItemscount(itemName);
        }
        return count;
    }

    public void addDish(Dish dish, int tableNumber) {

        try {
            if (tableNumber > tableCount) {
                throw new Exception();
            }
            orders[tableNumber].add(dish);
        } catch (Exception e) {
            System.out.println("There are no more tables");
        }

    }

    public void addDrink(Drink drink, int tableNumber) {
        try {
            if (tableNumber > tableCount) {
                throw new Exception();
            }
            orders[tableNumber].add(drink);
        } catch (Exception e) {
            System.out.println("There are no more tables");
        }
    }

    public void removeOrder(int tableNumber) {
        try {
            if (tableNumber > tableCount) {
                throw new Exception();
            }

            orders[tableNumber] = null;
        } catch (Exception e) {
            System.out.println("There are no more tables");
        }
    }

    public void removeOrder(String address) {
        try {
            if (!pairs.containsKey(address))
                throw new Exception();
            pairs.remove(address);
        } catch (Exception e) {
            System.out.println("There is no that address");
        }
    }

    public RestaurantOrder[] getOrders() {
        return orders;
    }

    public double ordersCostSummary() {
        double totalCost = 0;
        for (int i = 0; i < orders.length; i++) {
            totalCost += orders[i].getTotalCost();
        }
        return totalCost;
    }

}