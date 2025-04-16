package designPatterns.creational.builder;

public class Client {
    public static void main(String[] args) {
        Car car = new Car.Builder().setColor("White").setNumberOfWheels(4).setNumberPlate(3000).build();
        System.out.println(car.toString());
    }

}
