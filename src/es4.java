import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class es4 {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Laptop", "Electronics", 1200.00);
        Product product2 = new Product(2, "Pacifier", "Baby", 12.00);
        Product product3 = new Product(3, "ActionFigure", "Boys", 50.00);
        Product product4 = new Product(4, "LegoSet", "Boys", 130.00);
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

        Order order1 = new Order(1, "Shipped", LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 18), productList1, customer1);
        Order order2 = new Order(2, "Processing", LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 15), productList2, customer1);
        Order order3 = new Order(3, "Delivered", LocalDate.of(2021, 1, 25), LocalDate.of(2021, 1, 30), productList3, customer2);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        List<Product> productsOrderedByTier2Customers = getProductsOrderedByTier2Customers(orderList);

        System.out.println("Products ordered by Tier 2 customers between 01-Feb-2021 and 01-Apr-2021:");
        productsOrderedByTier2Customers.forEach(System.out::println);
    }

    public static List<Product> getProductsOrderedByTier2Customers(List<Order> orders) {
        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);

        return orders.stream()
                .filter(order -> order.getOrderDate().isAfter(startDate.minusDays(1)) && order.getOrderDate().isBefore(endDate.plusDays(1)))
                .filter(order -> order.getCustomer().getTier() == 2)
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());
    }
}
