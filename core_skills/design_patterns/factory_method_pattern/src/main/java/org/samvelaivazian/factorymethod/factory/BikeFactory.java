package org.samvelaivazian.factorymethod.factory;

import org.samvelaivazian.factorymethod.model.Bike;
import org.samvelaivazian.factorymethod.model.Vehicle;

/**
 * Factory class for creating Bike objects.
 */
public final class BikeFactory extends VehicleFactory {

    /**
     * Creates a new Bike object.
     *
     * @return a new Bike object
     */
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }

}
