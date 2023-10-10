package com.aj.mvc1.repositry;

import com.aj.mvc1.model.Holiday;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HolidayReposirty {

    private final JdbcTemplate jdbcTemplate;

    public HolidayReposirty(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Holiday> findAllHoliday(){
        String sql = "SELECT * FROM HOLIDAYS";
        BeanPropertyRowMapper<Holiday> rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
      return   jdbcTemplate.query(sql,rowMapper);
    }

}
