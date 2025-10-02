package pr4.ex3;

import java.util.Scanner;

public class Shop {
    private Client client;
    private Cart cart;
    private Product[] products;
    private Scanner sc;

    public Shop(){
        this.sc = new Scanner(System.in);
        this.cart = new Cart();
        initializeProducts();
    }

    private void initializeProducts(){
        products = new Product[8];
        products[0] = new Product(1, "Смартфон", 29999.99, CatalogProducts.ELECTRONICS, 10);
        products[1] = new Product(2, "Ноутбук", 89999.99, CatalogProducts.ELECTRONICS, 5);
        products[2] = new Product(3, "Наушники", 4999.99, CatalogProducts.ELECTRONICS, 15);
        products[3] = new Product(4, "Java учебник", 1999.99, CatalogProducts.BOOKS, 20);
        products[4] = new Product(5, "Война и мир", 899.99, CatalogProducts.BOOKS, 8);
        products[5] = new Product(6, "Футболка", 1499.99, CatalogProducts.CLOTHING, 25);
        products[6] = new Product(7, "Джинсы", 3999.99, CatalogProducts.CLOTHING, 12);
        products[7] = new Product(8, "Чайник", 1999.99, CatalogProducts.HOME, 18);
    }

    public void start(){
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В НАШ МАГАЗИН");
        client = new Client("Имя", "пароль");
        while(!client.isLogout()){
            if (!client.isLoggedIn()){
                authorization();
            }
            if (client.isLoggedIn()){
                showMenu();
            }
        }
    }

    private void authorization(){
        System.out.println("Войдите в аккаунт");
        System.out.print("Логин: ");
        String login = sc.nextLine();
        System.out.print("Пароль: ");
        String password = sc.nextLine();

        if (client.LoggedIn(login, password)){
            System.out.println("Совершён успешный вход в систему\nДобро пожаловать, " + client.getLogin());
        }else {
            System.out.println("Ошибка: Неправильный логин или пароль! Повторите попытку!");
        }
    }

    private void showMenu(){
        while (!client.isLogout()){
            System.out.println("Меню магазина");
            System.out.println("1. Просмотр каталогов товаров");
            System.out.println("2. Просмотр корзины");
            System.out.println("3. Покупка товаров в корзине");
            System.out.println("4. Выйти из системы");
            System.out.print("Выберите действие(введите пункт меню): ");

            String choice = sc.nextLine();

            switch (choice){
                case "1":
                    showCatalogsProducts();
                    break;
                case "2":
                    cart.displayCart();
                    break;
                case "3":
                    purchaseProducts();
                    break;
                case "4":
                    cart.clear();
                    client.logout();
                    System.out.println("Вы вышли из системы");
                    break;
                default:
                    System.out.println("Неверный выбор! Введите число от 1 до 4.");
            }
        }
    }

    private void showCatalogsProducts(){
        while(true){
            System.out.println("КАТАЛОГИ ТОВАРОВ");
            CatalogProducts[] catalogs = CatalogProducts.values();
            for (int i = 0; i < catalogs.length; i++){
                System.out.println((i+1) + ". " + catalogs[i].getCatalogName());
            }
            System.out.println((catalogs.length + 1)+". Выйти в главное меню");
            System.out.print("Выберите категорию: ");

            int choice = getIntInput();
            if (choice >= 1 && choice <= catalogs.length){
                showProductsInCatalog(catalogs[choice-1]);
            } else if (choice == catalogs.length + 1) {
                return;
            } else{
                System.out.println("Неверный выбор! Повторите попытку");
            }
        }
    }

    private void showProductsInCatalog(CatalogProducts catalog){
        int count = 0;
        for (Product product : products){
            if (product.getCatalog() == catalog && product.getAmount() > 0){
                count++;
            }
        }

        if (count == 0){
            System.out.println("В этой категории нет товаров.");
            return;
        }

        Product[] catalogProducts = new Product[count];
        int index = 0;
        for (Product product : products){
            if(product.getCatalog() == catalog && product.getAmount() > 0){
                catalogProducts[index] = product;
                index++;
            }
        }

        while (true){
            System.out.println(catalog.getCatalogName().toUpperCase());

            for (int i = 0; i < catalogProducts.length; i++){
                System.out.println((i+1) + ". " + catalogProducts[i]);
            }
            System.out.println((catalogProducts.length + 1) + ". Вернуться к катеориям");
            System.out.print("Выберите пункт: ");

            int choice = getIntInput();
            if (choice >= 1 && choice <= catalogProducts.length) {
                Product selectedProduct = catalogProducts[choice - 1];
                addToCart(selectedProduct);
            } else if (choice == catalogProducts.length + 1) {
                return;
            } else {
                System.out.println("Неверный выбор!");
            }
        }
    }
    private void addToCart(Product product){
        while (true){
            System.out.println("\nВыбран товар: " + product.getName());
            System.out.println("Цена: " + product.getPrice() + " руб.");
            System.out.println("В наличии: " + product.getAmount() + " шт.");
            System.out.print("Введите количество: ");

            int quantity = getIntInput();

            if (quantity >= 0 && product.getAmount() >= quantity){
                cart.addProduct(product, quantity);
                return;
            }else{
                System.out.println("Неверное количество. Повторите попытку!");
            }
        }
    }

    private void purchaseProducts(){
        if (cart.isEmpty()){
            System.out.println("Корзина пуста!");
            return;
        }
        cart.displayCart();
        System.out.print("Подтвердить покупку? (1 - Да, 2 - Нет): ");

        String input = sc.nextLine();
        if (input.equals("1")){
            for (int i = 0; i < cart.getProductsCount(); i++){
                Product product = cart.getProduct(i);
                int quantity = cart.getQuantity(i);
                product.setAmount(product.getAmount()-quantity);
            }
            System.out.println("Покупка завершена успешно!");
            double total = calculateTotal();
            System.out.println("Сумма покупки: " + total + "руб.");
            cart.clear();
        }else{
            System.out.println("Покупка отменена.");
        }
    }

    private double calculateTotal(){
        double total = 0;
        for (int i = 0; i < cart.getProductsCount(); i++){
            Product product = cart.getProduct(i);
            total += product.getPrice() * cart.getQuantity(i);
        }
        return total;
    }

    private int getIntInput(){
        while(true){
            String input = sc.nextLine();
            try{
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Неправильное число! Повторите попытку: ");
            }
        }
    }

    public static void main(String[] args){
        Shop shop = new Shop();
        shop.start();
    }
}
