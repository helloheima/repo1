package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domian.Province;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import service.ProvinceService;
import util.JedisUtil;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public String findAll() {

        Jedis jedis = JedisUtil.getJedis();
        String province = jedis.get("province");

        if (province == null){
            List<Province> list = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province);
        }
        jedis.close();
        return province;
    }

    @Override
    public String findAllCity(String province_name) {

        return null;
    }

}
