package pr4.ex3;

public class Cart {
    private Product[] products;
    private int productsCount;
    private int[] quantities;

    public Cart(){
        this.products = new Product[50];
        this.quantities = new int[50];
        this.productsCount = 0;
    }

    public void addProduct(Product product, int quantity){
        for (int i = 0; i < productsCount; i++){
            if (products[i].getId() == product.getId()){
                quantities[i] += quantity;
                System.out.println("Товар успешно добавлен в корзину:" + product.getName());
                return;
            }
        }

        if (productsCount < quantities.length){
            products[productsCount] = product;
            quantities[productsCount] = quantity;
            productsCount++;
            System.out.println("Товар успешно добавлен в корзину:" + product.getName());
        }else{
            System.out.println("Корзина переполнена!");
        }
    }

    public void displayCart(){
        if(productsCount == 0){
            System.out.println("Коризина пуста!");
            return;
        }

        System.out.println("Корзина:");
        double totalPrice = 0;
        for(int i = 0; i < productsCount; i++){
            double productPrice = products[i].getPrice();
            double productTotalPrice = productPrice * quantities[i];
            System.out.printf("%d) %s Цена: %.2f x %d = %.2f руб.", i+1, products[i].getName(), productPrice, quantities[i], productTotalPrice);
            totalPrice += productTotalPrice;
        }
        System.out.println("Итого: " + totalPrice + "руб.");
    }

    public boolean isEmpty() {
        return productsCount == 0;
    }

    public void clear() {
        productsCount = 0;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public Product getProduct(int index) {
        return products[index];
    }

    public int getQuantity(int index) {
        return quantities[index];
    }
}
