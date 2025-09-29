package pr4.ex3;

public class Product {
    private int id;
    private String name;
    private CatalogProducts catalog;
    private double price;
    private int amount;

    public Product(int id, String name, double price, CatalogProducts catalog, int amount){
        this.id = id;
        this.name = name;
        this.price = price;
        this.catalog = catalog;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public CatalogProducts getCatalog() {
        return catalog;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return id + ". " + name + " - " + price + " руб. (В наличии: " + amount + ")";
    }
}
