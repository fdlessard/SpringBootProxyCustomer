package io.fdlessard.codebites.customer.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private Long id;
    private String lastName;
    private String firstName;
    private String company;
    private Long addressId;
    private Long productId;
}
