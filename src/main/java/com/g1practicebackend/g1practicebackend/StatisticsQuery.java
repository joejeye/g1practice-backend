package com.g1practicebackend.g1practicebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StatisticsQuery {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String tableName = "test_history";

    /* Count the number of attempts for a given question No. */
    public int countAttempts(int questionNo) {
        String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE question_no=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, questionNo);
    }

    public int countCorrectAttempts(int questionNo) {
        String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE question_no=? AND is_correct=true";
        return jdbcTemplate.queryForObject(sql, Integer.class, questionNo);
    }
}
