package LLD.coffeeVendingMachine.coffee;

import java.util.Objects;

public class Coffee {
    String name;
    double price;
    Recipe recipe;

    Coffee(String name, double price, Recipe recipe) {
        this.name = name;
        this.price = price;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Double.compare(price, coffee.price) == 0 && Objects.equals(name, coffee.name) && Objects.equals(recipe, coffee.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getRecipe());
    }
}
