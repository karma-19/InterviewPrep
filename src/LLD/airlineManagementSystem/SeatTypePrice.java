package src.LLD.airlineManagementSystem;

public enum SeatTypePrice {
    ECONOMY(500),
    PRIMIUM(1000),
    LUXURY(1500);

    private int price;

    SeatTypePrice(int price) {
        this.price = price;
    }

    int getPrice() {
        return this.price;
    }
}
