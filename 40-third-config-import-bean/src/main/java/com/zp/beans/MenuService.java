package com.zp.beans;

import lombok.Data;

@Data
public class MenuService {
    private String name;
    public MenuService() {
        System.out.println("menuService construction init");
    }
}
