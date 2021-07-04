package com.grantcs.usermanagementsystem.domain;

import lombok.Data;

@Data
public class Salary {
    private String userId;
    private String yearMonth;
    private Integer salary;
}
