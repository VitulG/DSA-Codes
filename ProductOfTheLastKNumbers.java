import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private final List<Integer> products;

    public ProductOfNumbers() {
        this.products = new ArrayList<>();
        this.products.add(1);
    }

    public void add(int num) {
        if(num == 0) {
            this.products.clear();
            this.products.add(1);
        }else {
            this.products.add(this.products.get(this.products.size()-1) * num);
        }
    }

    public int getProduct(int k) {
        if(k >= products.size()) {
            return 0;
        }

        return this.products.get(this.products.size()-1) / this.products.get(this.products.size() - 1 - k);
    }
}

public class ProductOfTheLastKNumbers {

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2));
    }

}
