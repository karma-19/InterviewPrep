package LLD.coffeeVendingMachine.coffee;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    Map<String, Double> recipe = new HashMap<>();

    public void addIngrediant(String ingrediant, Double quantity) {
        recipe.put(ingrediant, quantity);
    }

    public Map<String, Double> getRecipe() {
        return recipe;
    }
}
