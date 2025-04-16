package designPatterns.creational.builder;

public class Car {
    private final int numberPlate;
    private final int numberOfWheels;
    private final String color;

    private Car(Builder builder) {
        this.numberPlate = builder.numberPlate;
        this.numberOfWheels = builder.numberOfWheels;
        this.color = builder.color;
    }

    public int getNumberPlate() {
        return numberPlate;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Color: ").append(this.color);
        sb.append(" Number Plate: ").append(this.numberPlate);
        sb.append(" Number of Wheels: ").append(this.numberOfWheels);
        return sb.toString();
    }

    public static class Builder {
        private int numberPlate;
        private int numberOfWheels;
        private String color;

        public Builder setNumberPlate(int numberPlate) {
            this.numberPlate = numberPlate;
            return this;
        }

        public Builder setNumberOfWheels(int numberOfWheels) {
            this.numberOfWheels = numberOfWheels;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
