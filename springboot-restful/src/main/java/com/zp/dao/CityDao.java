package com.zp.dao;

import com.zp.pojo.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityDao {
    List<City> findAllCity();

    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long city);

}
