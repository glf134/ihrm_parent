package com.ihrm.domain.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "flow")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flow implements Serializable {
    private static final long serialVersionUID = -9084352495284489553L;
    @Id
    private String id;

    private String flowNum;

    private String orderNum;

    private String productId;

    private String paidAmount;

    private Integer paidMethod;

    private Integer buyCounts;

    private Date createTime;

}