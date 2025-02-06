package skyshop.src.main.skyshop;

public class App {
    public static void main(String[] args) {
        ProductBasket products = new ProductBasket();
        products.setProductInBasket(new Product("apple", 300));
        products.setProductInBasket(new Product("orange", 250));
        products.setProductInBasket(new Product("pineapple", 240));
        products.setProductInBasket(new Product("watermelon", 400));
        products.setProductInBasket(new Product("mango", 360));
//        products.getAllCost();
        products.printAllBasket();
//        products.setProductInBasket(new Product("apples", 300));
//        products.printAllBasket();
        products.getBasketCleaner();
        products.printAll();


    }
}
