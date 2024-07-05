package org.samvelaivazian.factorymethod.factory;

import org.samvelaivazian.factorymethod.model.Vehicle;

/**
 * Abstract factory class for creating vehicles.
 * Subclasses should implement the createVehicle method to instantiate specific types of vehicles.
 */
public abstract class VehicleFactory {

    /**
     * Creates a vehicle. Subclasses must implement this method to create specific vehicle types.
     *
     * @return the created vehicle
     */
    public abstract Vehicle createVehicle();

}
