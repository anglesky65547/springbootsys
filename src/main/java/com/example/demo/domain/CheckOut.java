package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckOut {
    private Integer id;
    private String customername;
    private String type;
    private String reason;
    private String checkoutdata;
    private String applicationdata;
    private String auditMind;
    private String auditdata;
    private String worker;
    private String auditstatus;
    private String note;
}
