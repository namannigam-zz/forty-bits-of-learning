package edu.forty.bits.designing.rental.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class City {
    String cityId; //name
    List<Branch> branchList;
}
