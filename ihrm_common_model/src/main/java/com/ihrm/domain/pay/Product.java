package com.ihrm.domain.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product  implements Serializable {
    private static final long serialVersionUID = -9084332496284489553L;
    @Id
    private String id;

    private String name;

    private String price;

}