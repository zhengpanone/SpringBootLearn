package com.zp.beans;

import lombok.Data;

@Data
public class DepartmentService {
    private String name;
    public DepartmentService() {
        System.out.println("department construction init");
    }
}
