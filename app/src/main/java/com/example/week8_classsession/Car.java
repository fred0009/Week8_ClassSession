package com.example.week8_classsession;

public class Car {


    static class CarEngine { // Inner class
        public void startEngine() {
            System.out.println("Engine started");
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        CarEngine carEngine = new CarEngine();

        car.startCar(carEngine);

        car.startCar(new CarEngine() { // Anonymous class - It extends the carEngine class
            @Override
            public void startEngine() {  // This subclass override the superclass method
                System.out.println("Engine 2 started");
            }
        });
    }

    void startCar(CarEngine engine) { // Delegation
        engine.startEngine();
    }

}
