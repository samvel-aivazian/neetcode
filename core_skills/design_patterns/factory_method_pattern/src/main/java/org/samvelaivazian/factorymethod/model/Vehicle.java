package org.samvelaivazian.factorymethod.model;

/**
 * Interface representing a generic vehicle.
 * Classes implementing this interface should provide the type of the vehicle.
 */
public interface Vehicle {

    /**
     * Gets the type of the vehicle.
     *
     * @return the vehicle type as a String
     */
    String getType();

}
