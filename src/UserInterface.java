import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {

    public static void outInternet(OrderManager orderManager){
        HashMap<String, Order> list = orderManager.getInternetOrders();
        int i = 1;
        for (String key: list.keySet()){
            System.out.println(i++ + " заказ (" + key + ") : " + list.get(key).toString());
        }
    }

    public static void outOffline(OrderManager orderManager){
        for (int i = 0; i < orderManager.tableCount; i++){
            if (orderManager.getOrder(i) != null)
                System.out.println("Стол " + (i) + ": " + orderManager.getOrder(i).toString());
        }
    }

    public static void adder(OrderManager orderManager, boolean flag) {
        Scanner enter = new Scanner(System.in);
        if (!flag) {
            System.out.println("Стол?");
            int table = enter.nextInt();
            System.out.println("Напиток/Блюдо (1/2)");
            int choose = enter.nextInt();
            int temp = enter.nextInt();
            enter.nextLine();
            String temp1 = enter.nextLine();
            String temp2 = enter.nextLine();
            switch (choose) {
                case 1:
                    orderManager.addDrink(new Drink(temp, temp1, temp2), table);
                    break;
                case 2:
                    orderManager.addDish(new Dish(temp, temp1, temp2), table);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Адрес?");
            String address = enter.nextLine();
            System.out.println("Напиток/Блюдо (1/2)");
            int choose = enter.nextInt();
            int temp = enter.nextInt();
            enter.nextLine();
            String temp1 = enter.nextLine();
            String temp2 = enter.nextLine();
            switch (choose) {
                case 1:
                    orderManager.addItem(address, new Drink(temp, temp1, temp2));
                    break;
                case 2:
                    orderManager.addItem(address, new Dish(temp, temp1, temp2));
                    break;
                default:
                    break;
            }
        }
    }

    public static void remover(OrderManager orderManager, boolean flag){
        Scanner enter = new Scanner(System.in);
        if (!flag){
            System.out.println("Стол?");
            int table = enter.nextInt();
            orderManager.removeOrder(table);
            } else {
            System.out.println("Адрес?");
            enter.nextLine();
            String address = enter.nextLine();
            orderManager.removeOrder(address);
        }
    }


    public static void main(String[] args) {
        System.out.print("Введите кол-во столов в вашем ресторане: ");
        Scanner enter = new Scanner(System.in);
        int count = enter.nextInt();
        int x, temp, choose, table;
        String temp1, temp2, address;
        OrderManager orderManager = new OrderManager(count);
        while (true){
            System.out.println("\n1. Создать offline заказ на столик (новый).\n2. Создать online заказ на адрес (новый)\n3. Показать все offline заказы\n4. Показать все online заказы\n5. Добавить позицию к заказу\n6. Удалить заказ\n7. Выход");
            System.out.print("Вы ввели ");
            x = enter.nextInt();
            switch (x){
                case 1:
                    System.out.println("Стол?");
                    table = enter.nextInt();
                    System.out.println("Напиток/Блюдо (1/2)");
                    choose = enter.nextInt();
                    temp = enter.nextInt();
                    enter.nextLine();
                    temp1 = enter.nextLine();
                    temp2 = enter.nextLine();
                    switch (choose){
                        case 1:
                            RestaurantOrder ro = new RestaurantOrder(20);
                            ro.add(new Drink(temp, temp1, temp2));
                            orderManager.add(ro, table);
                            break;
                        case 2:
                            RestaurantOrder rd = new RestaurantOrder(20);
                            rd.add(new Dish(temp, temp1, temp2));
                            orderManager.add(rd, table);
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Введите адрес");
                    enter.nextLine();
                    address = enter.nextLine();
                    System.out.println("Напиток/Блюдо (1/2)");
                    choose = enter.nextInt();
                    temp = enter.nextInt();
                    enter.nextLine();
                    temp1 = enter.nextLine();
                    temp2 = enter.nextLine();
                    switch (choose){
                        case 1:
                            RestaurantOrder ro = new RestaurantOrder(20);
                            ro.add(new Drink(temp, temp1, temp2));
                            orderManager.add(address, ro);
                            break;
                        case 2:
                            RestaurantOrder rd = new RestaurantOrder(20);
                            rd.add(new Dish(temp, temp1, temp2));
                            orderManager.add(address, rd);
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    outOffline(orderManager);
                    break;
                case 4:
                    outInternet(orderManager);
                    break;
                case 5:
                    System.out.println("Offline/Online (1/2)");
                    choose = enter.nextInt();
                    switch (choose){
                        case 1:
                            outOffline(orderManager);
                            adder(orderManager, false);
                            break;
                        case 2:
                            outInternet(orderManager);
                            adder(orderManager, true);
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Offline/Online (1/2)");
                    choose = enter.nextInt();
                    switch (choose){
                        case 1:
                            outOffline(orderManager);
                            remover(orderManager, false);
                            break;
                        case 2:
                            outInternet(orderManager);
                            remover(orderManager, true);
                            break;
                    }
                    break;
                case 7:
                    return;
                default:
                    break;
            }
        }
    }
}
