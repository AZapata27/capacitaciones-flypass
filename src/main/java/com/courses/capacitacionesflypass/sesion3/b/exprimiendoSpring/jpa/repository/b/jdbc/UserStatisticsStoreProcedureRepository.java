package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.b.jdbc;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Map;

@Repository
public class UserStatisticsStoreProcedureRepository {

    /*  CREATE PROCEDURE GetUserStatistics(OUT activeUsers INT, OUT postsPerUser DOUBLE)
    BEGIN
    SELECT COUNT(*) INTO activeUsers FROM users WHERE active = TRUE;
    SELECT COUNT(*) / COUNT(DISTINCT user_id) INTO postsPerUser FROM posts;
    END;
    */

    private final SimpleJdbcCall jdbcCall;

    public UserStatisticsStoreProcedureRepository(DataSource dataSource) {
        this.jdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("GetUserStatistics")
                .declareParameters(
                        new SqlOutParameter("activeUsers", Types.INTEGER),
                        new SqlOutParameter("postsPerUser", Types.DOUBLE)
                );
    }

    public Map<String, Object> getUserStatistics() {
        return jdbcCall.execute(new MapSqlParameterSource());
    }
}
