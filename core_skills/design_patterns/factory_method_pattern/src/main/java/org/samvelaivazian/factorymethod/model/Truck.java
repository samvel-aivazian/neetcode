package org.samvelaivazian.factorymethod.model;

/**
 * Class representing a Truck.
 */
public final class Truck implements Vehicle {

    /**
     * Gets the type of the vehicle.
     *
     * @return the vehicle type as "Truck"
     */
    @Override
    public String getType() {
        return "Truck";
    }

}
