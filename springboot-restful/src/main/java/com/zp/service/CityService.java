package com.zp.service;

import com.zp.pojo.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityService {
    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市ID,查询城市信息
     *
     * @param id
     * @return
     */
    City findCityById(Long id);

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    Long updateCity(City city);

    /**
     * 根据城市ID删除城市信息
     *
     * @param city
     * @return
     */
    Long deleteCity(Long city);

}
