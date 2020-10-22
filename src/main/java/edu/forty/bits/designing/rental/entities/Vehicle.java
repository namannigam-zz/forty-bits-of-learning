package edu.forty.bits.designing.rental.entities;

import lombok.Getter;

@Getter
public class Vehicle {
    VehicleType vehicleType;
    Rate rate;

    enum VehicleType {
        CAR, BIKE
    }

    @Getter
    class Rate {
        int pricePerHour;
    }
}