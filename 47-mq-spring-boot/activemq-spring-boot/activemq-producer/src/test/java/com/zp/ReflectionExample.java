package com.zp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author : zhengpanone
 * Date : 2024/10/28 22:23
 * Version : v1.0.0
 * Description:
 */
public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // 获取Person类的Class对象
            Class<?> personClass = Class.forName("Person");
            Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            Object personObject = constructor.newInstance("Alice", 123);
            System.out.println(personObject);

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
