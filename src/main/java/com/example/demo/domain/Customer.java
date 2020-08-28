package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer customerid;
    private String name;
    private String age;
    private String sex;
    private String idnumber;
    private Integer roomid;
    private String floatid;
    private String filesid;
    private String oldmantype;
    private String checkindata;
    private String servicematurity;
    private String phonenumber;
    private Float height;
    private String maritalstatus;
    private Float weight;
    private String bloodtype;
    private String image;
    private String worker;
    private String note;
}
