package edu.forty.bits.designing.rental.request;

import edu.forty.bits.designing.rental.entities.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddVehicleRequest {
    int quantity;
    VehicleType vehicleType;
}
