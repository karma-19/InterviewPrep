package LLD.coffeeVendingMachine;

import LLD.coffeeVendingMachine.coffee.Coffee;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Coffee, Integer> coffeeIntegerMap = new HashMap<>();

    public Map<Coffee, Integer> getCoffeeIntegerMap() {
        return coffeeIntegerMap;
    }

    public void addCoffee(Coffee coffee) {
        coffeeIntegerMap.put(coffee, coffeeIntegerMap.getOrDefault(coffee, 0) + 1);
    }

    public boolean isAvailable(String name) {
        for(Map.Entry<Coffee, Integer> e : coffeeIntegerMap.entrySet()) {
            if(e.getKey().getName().equals(name)) {
                return e.getValue() > 0;
            }
        }
        return false;
    }

    public Coffee getCoffee(String name) {
        if(isAvailable(name)) {
            for(Map.Entry<Coffee, Integer> e : coffeeIntegerMap.entrySet()) {
                if(e.getKey().getName().equals(name)) {
                    return e.getKey();
                }
            }
        }
        return null;
    }
}
