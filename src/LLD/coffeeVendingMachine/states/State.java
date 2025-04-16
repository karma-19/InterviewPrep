package LLD.coffeeVendingMachine.states;

import LLD.coffeeVendingMachine.coffee.Coffee;

public interface State {
    void selectProduct(Coffee coffee);
    void makePayment();
    void dispense();
    void returnChange();
}
