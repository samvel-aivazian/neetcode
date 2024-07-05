package org.samvelaivazian.factorymethod;

import org.samvelaivazian.factorymethod.factory.BikeFactory;
import org.samvelaivazian.factorymethod.factory.CarFactory;
import org.samvelaivazian.factorymethod.factory.TruckFactory;
import org.samvelaivazian.factorymethod.factory.VehicleFactory;
import org.samvelaivazian.factorymethod.model.Bike;
import org.samvelaivazian.factorymethod.model.Car;
import org.samvelaivazian.factorymethod.model.Truck;
import org.samvelaivazian.factorymethod.model.Vehicle;

/**
 * This class contains test cases for the VehicleFactory interface and its implementations.
 * Each test case verifies the functionality of specific methods in the VehicleFactory interface.
 * <p>
 * Note: To enable assertions, you need to add the VM argument `-ea` when running the tests.
 * </p>
 */
public final class FactoryMethodTest {

    /**
     * Main method to run all the test cases.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        testBikeFactory();
        testCarFactory();
        testTruckFactory();
        testVehicleFactory();

        System.out.println("All tests passed!");
    }

    /**
     * Tests the BikeFactory to ensure it creates a Bike object.
     */
    private static void testBikeFactory() {
        final VehicleFactory bikeFactory = new BikeFactory();
        final Vehicle bike = bikeFactory.createVehicle();

        assert bike.getType().equals("Bike") : "Created vehicle type should be Bike";
        assert bike instanceof Bike : "Created vehicle should be instance of Bike";
    }

    /**
     * Tests the CarFactory to ensure it creates a Car object.
     */
    private static void testCarFactory() {
        final VehicleFactory carFactory = new CarFactory();
        final Vehicle car = carFactory.createVehicle();

        assert car.getType().equals("Car") : "Created vehicle type should be Car";
        assert car instanceof Car : "Created vehicle should be instance of Car";
    }

    /**
     * Tests the TruckFactory to ensure it creates a Truck object.
     */
    private static void testTruckFactory() {
        final VehicleFactory truckFactory = new TruckFactory();
        final Vehicle truck = truckFactory.createVehicle();

        assert truck.getType().equals("Truck") : "Created vehicle type should be Truck";
        assert truck instanceof Truck : "Created vehicle should be instance of Truck";
    }

    /**
     * Tests the VehicleFactory interface by creating a test-specific anonymous class.
     */
    private static void testVehicleFactory() {
        final VehicleFactory vehicleFactory = new VehicleFactory() {

            @Override
            public Vehicle createVehicle() {
                return new Bike(); // Using Bike as an example
            }

        };
        final Vehicle vehicle = vehicleFactory.createVehicle();

        assert vehicle.getType().equals("Bike") : "Created vehicle type should be Bike";
        assert vehicle instanceof Bike : "Created vehicle should be instance of Bike";
    }

}
