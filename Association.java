import java.util.Arrays;

class FoodBrand {
    public  static  void main(String[] args) {
        Dominos d = new Dominos();
        d.placeOrder();
    }
}

class Dominos extends FoodBrand {
    Feedback feedback = new Feedback();
    SalesReport salesReport = new SalesReport();
    Delivery delivery = new Delivery();

    public void placeOrder() {
        System.out.println("Placing your order...");
        FoodItem[] foodItems = {
                new FoodItem("Veg Pizza", 200),
                new FoodItem("Coke", 20)
        };

        Table tableNo = new Table(10);
        boolean status = false;
        Payment payment = new Payment();
        float totalCost = payment.calculateTotalCost(foodItems);
        status = payment.completePayment(foodItems, tableNo, status, totalCost);

        if (status) {
            Order order = new Order(foodItems, tableNo, payment);
            order.showOrderDetails();
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Payment failed");
        }
    }
}

class FoodItem {
    String foodName;
    float foodPrice;

    FoodItem(String foodName, float foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
    public String toString() {
        return foodName;
    }
}

class Order {
    FoodItem[] foodItems;
    Table table;
    Payment payment;

    Order(FoodItem[] foodItems, Table table, Payment payment) {
        this.foodItems = foodItems;
        this.table = table;
        this.payment = payment;
    }
    void showOrderDetails() {
        System.out.println("Food Items: " + Arrays.toString(foodItems));
        System.out.println("Table No: " + table.tableNo);
        System.out.println("Total Cost: " + payment.totalCost);
    }
}

class Payment {
    float totalCost;

    public boolean completePayment(FoodItem[] foodItems, Table tableNo, boolean status, float totalCost) {
        System.out.println("Processing payment...");
        return true;
    }
    public float calculateTotalCost(FoodItem[] foodItems) {
        float cost = 0;
        for(var foodItem:foodItems) {
            cost += foodItem.foodPrice;
        }
        totalCost = cost;
        return cost;
    }
}

class Table {
    int tableNo;

    Table(int tableNo) {
        this.tableNo = tableNo;
    }
}

class Feedback {
}

class SalesReport {
}

class Delivery {
}
