package org.samvelaivazian.factorymethod.factory;

import org.samvelaivazian.factorymethod.model.Truck;
import org.samvelaivazian.factorymethod.model.Vehicle;

/**
 * Factory class for creating Truck objects.
 */
public final class TruckFactory extends VehicleFactory {

    /**
     * Creates a new Truck object.
     *
     * @return a new Truck object
     */
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }

}
