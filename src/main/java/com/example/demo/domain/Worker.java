package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    private Integer id;
    private String workerid;
    private String worker;
    private String sex;
    private String age;
    private String type;
    private String entrydate;
    private String post;
    private String title;
    private String status;
    private String phonenumber;
    private String introduction;
    private String note;
    private int age1;

}
