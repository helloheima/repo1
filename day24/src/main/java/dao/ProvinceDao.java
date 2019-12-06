package dao;

import domian.City;
import domian.Province;

import java.util.List;

public interface ProvinceDao {

    List<Province> findAll();
    List<City> findAllCity(String province_name);
}
