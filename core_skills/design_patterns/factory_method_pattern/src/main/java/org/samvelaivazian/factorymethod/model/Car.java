package org.samvelaivazian.factorymethod.model;

/**
 * Class representing a Car.
 */
public final class Car implements Vehicle {

    /**
     * Gets the type of the vehicle.
     *
     * @return the vehicle type as "Car"
     */
    @Override
    public String getType() {
        return "Car";
    }

}
