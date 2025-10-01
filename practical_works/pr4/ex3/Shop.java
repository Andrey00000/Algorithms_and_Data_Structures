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

    public void authorization(){
        System.out.print("Войдите в аккаунт%nЛогин: ");
        String login = sc.nextLine();
        System.out.print("Пароль: ");
        String password = sc.nextLine();

        if (client.LoggedIn(login, password)){
            System.out.println("Совершён успешный вход в систему");
        }else {
            System.out.println("Ошибка: Неправильный логин или пароль!%nПовторите попытку!");
        }
    }

    public void showMenu(){
        System.out.println("Меню магазина");
        System.out.println("1. Просмотр каталогов товаров");
        System.out.println("2. Просмотр корзины");
        System.out.println("3. Покупка товаров в корзине");
        System.out.println("4. Выйти из системы");
        System.out.print("Выберите действие(введите пункт меню: ");

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
