package main.java.model;

public enum ProductCategory {
    FOOD("FOOD"),
    GADGETS("GADGETS"),
    SOFT_DRINKS("SOFT_DRINKS"),
    ALCOHOL("ALCOHOL"),
    CHEMISTRY("CHEMISTRY"),
    BUILDING_MATERIALS("BUILDING_MATERIALS"),
    MACHINERY("MACHINERY"),
    OTHER("OTHER");


    public String category;

    ProductCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}


