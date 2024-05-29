import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class es3 {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Bike", "Boys", 500.00);
        Product product2 = new Product(2, "ActionFigure", "Boys", 50.00);
        Product product3 = new Product(3, "LegoSet", "Boys", 130.00);
        Product product4 = new Product(4, "Crib", "Baby", 300.00);
        Product product5 = new Product(5, "Book", "Books", 20.00);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

        List<Product> discountedBoysProducts = getDiscountedBoysProducts(productList);

        System.out.println("Discounted Boys Products:");
        discountedBoysProducts.forEach(System.out::println);
    }

    public static List<Product> getDiscountedBoysProducts(List<Product> products) {
        return products.stream()
                .filter(product -> "Boys".equals(product.getCategory()))
                .map(product -> new Product(product.getId(), product.getName(), product.getCategory(), product.getPrice() * 0.9))
                .collect(Collectors.toList());
    }
}
