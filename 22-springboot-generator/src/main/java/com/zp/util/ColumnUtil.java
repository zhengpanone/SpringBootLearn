package com.zp.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/07/20 13:37.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
public class ColumnUtil {
    private static final char SEPARATOR = '_';

    /**
     * 获取配置信息
     * @return
     */
    public static PropertiesConfiguration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转换mysql数据类型为java数据类型
     *
     * @param type
     * @return
     */
    public static String colToJava(String type) {
        Configuration config = getConfig();
        return config.getString(type, "unknowType");
    }

    /**
     * 驼峰命名法
     *
     * @param s
     * @return
     */
    public static String toCameCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == SEPARATOR) {
                upperCase = true;

            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCameCase(s);
//        return s.substring(0, 1).toUpperCase() + s.substring(1);

        return StringUtils.capitalize(s);
    }
}
