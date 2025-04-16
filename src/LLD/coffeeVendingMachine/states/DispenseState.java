package LLD.coffeeVendingMachine.states;

import LLD.coffeeVendingMachine.coffee.Coffee;

public class DispenseState implements State{

    private State state;
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void selectProduct(Coffee coffee) {
        System.out.println("Please select product first.");
    }

    @Override
    public void makePayment() {

    }

    @Override
    public void dispense() {

    }

    @Override
    public void returnChange() {

    }
}
