package edu.forty.bits.designing.splitwise.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String userId;
    String name;
    String email;
    String mobileNumber;
}
