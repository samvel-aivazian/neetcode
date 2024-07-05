package org.samvelaivazian.factorymethod.model;

/**
 * Class representing a Bike.
 */
public final class Bike implements Vehicle {

    /**
     * Gets the type of the vehicle.
     *
     * @return the vehicle type as "Bike"
     */
    @Override
    public String getType() {
        return "Bike";
    }

}
