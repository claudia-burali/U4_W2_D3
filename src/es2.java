import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class es2 {
    public static void main(String[] args) {
        // Creazione di alcuni prodotti
        Product product1 = new Product(1, "Laptop", "Electronics", 1200.00);
        Product product2 = new Product(2, "Pacifier", "Baby", 12.00);
        Product product3 = new Product(3, "SoftToy", "Baby", 30.00);
        Product product4 = new Product(4, "Crib", "Baby", 300.00);
        Product product5 = new Product(5, "Book", "Books", 20.00);

        Customer customer1 = new Customer(1, "Mario Rossi", 2);
        Customer customer2 = new Customer(2, "Maria Rossi", 3);

        List<Product> productList1 = new ArrayList<>();
        productList1.add(product1);
        productList1.add(product3);

        List<Product> productList2 = new ArrayList<>();
        productList2.add(product2);
        productList2.add(product4);

        List<Product> productList3 = new ArrayList<>();
        productList3.add(product5);

        Order order1 = new Order(1, "Shipped", LocalDate.now(), LocalDate.now().plusDays(3), productList1, customer1);
        Order order2 = new Order(2, "Processing", LocalDate.now(), LocalDate.now().plusDays(5), productList2, customer2);
        Order order3 = new Order(3, "Delivered", LocalDate.now(), LocalDate.now().minusDays(1), productList3, customer1);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        List<Order> ordersWithBabyProducts = getOrdersWithBabyProducts(orderList);

        System.out.println("Orders with Baby products:");
        ordersWithBabyProducts.forEach(System.out::println);
    }

    public static List<Order> getOrdersWithBabyProducts(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> "Baby".equals(product.getCategory())))
                .collect(Collectors.toList());
    }
}
