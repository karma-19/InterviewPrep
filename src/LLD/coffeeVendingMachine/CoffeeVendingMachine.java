package LLD.coffeeVendingMachine;

import LLD.coffeeVendingMachine.coffee.Coffee;
import LLD.coffeeVendingMachine.states.DispenseState;
import LLD.coffeeVendingMachine.states.IdleState;
import LLD.coffeeVendingMachine.states.ReadyState;
import LLD.coffeeVendingMachine.states.ReturnChangeState;

public class CoffeeVendingMachine {
    public static CoffeeVendingMachine instance;
    private Inventory inventory;
    private IdleState idleState;
    private ReadyState readyState;
    private DispenseState dispenseState;
    private ReturnChangeState returnChangeState;
    private Coffee product;

    private CoffeeVendingMachine() {
        idleState = new IdleState();
        readyState = new ReadyState();
        dispenseState = new DispenseState();
        returnChangeState = new ReturnChangeState();
        product = null;
    }

    public static CoffeeVendingMachine getInstance() {
        if(instance == null) {
            synchronized (CoffeeVendingMachine.class) {
                if(instance == null) {
                    instance = new CoffeeVendingMachine();
                }
            }
        }
        return instance;
    }

    public void addCoffee(Coffee coffee) {
        inventory.addCoffee(coffee);
    }

    public String getCoffeeDetails() {
        return inventory.getCoffeeIntegerMap().toString();
    }

    public void selectProduct(String name, double payment) {
        if(product != null) {
            System.out.println("Product is already selected. Please wait for the transaction to finish.");
            return;
        }
        Coffee coffee = inventory.getCoffee(name);
        idleState.selectProduct(coffee);
    }
}
