package org.samvelaivazian.factorymethod.factory;

import org.samvelaivazian.factorymethod.model.Car;
import org.samvelaivazian.factorymethod.model.Vehicle;

/**
 * Factory class for creating Car objects.
 */
public final class CarFactory extends VehicleFactory {

    /**
     * Creates a new Car object.
     *
     * @return a new Car object
     */
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

}
