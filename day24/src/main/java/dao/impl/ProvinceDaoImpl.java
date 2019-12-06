package dao.impl;

import dao.ProvinceDao;
import domian.City;
import domian.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        return template.query("select * from province",new BeanPropertyRowMapper<>(Province.class));
    }

    @Override
    public List<City> findAllCity(String province_name) {
        return template.query("select * from City where province_name = ?",new BeanPropertyRowMapper<>(City.class),province_name);
    }
}
