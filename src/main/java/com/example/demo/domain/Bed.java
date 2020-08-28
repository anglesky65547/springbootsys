package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bed {
    private Integer bedid;
    private String customername;
    private String startdate;
    private String enddate;
    private String info;
}
