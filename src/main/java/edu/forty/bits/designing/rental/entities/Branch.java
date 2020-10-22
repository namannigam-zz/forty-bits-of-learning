package edu.forty.bits.designing.rental.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class Branch {
    String branchId; // name
    List<Vehicle> vehicles;
}