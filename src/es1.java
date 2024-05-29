import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class es1 {
    public static void main(String[] args) {

        Product product1 = new Product(1, "SuperBook", "Books", 600.00);
        Product product2 = new Product(2, "BasicBook", "Books", 15.00);
        Product product3 = new Product(3, "ExpensiveBook", "Books", 150.00);
        Product product4 = new Product(4, "Candy", "Food", 5.00);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        List<Product> filteredProducts = getExpensiveBooks(productList);
        filteredProducts.forEach(System.out::println);
    }

    public static List<Product> getExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(product -> "Books".equals(product.getCategory()) && product.getPrice() > 100)
                .collect(Collectors.toList());
    }
}

