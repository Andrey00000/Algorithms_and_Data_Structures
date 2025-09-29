package pr4.ex3;

public enum CatalogProducts {
    ELECTRONICS("Электроника"),
    BOOKS("Книги"),
    CLOTHING("Одежда"),
    HOME("Товары для дома");

    private final String catalogName;

    CatalogProducts(String catalogName){
        this.catalogName = catalogName;
    }

    public String getCatalogName() {
        return catalogName;
    }

}
