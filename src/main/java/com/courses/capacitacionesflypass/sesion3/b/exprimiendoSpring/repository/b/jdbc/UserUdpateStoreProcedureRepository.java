package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.repository.b.jdbc;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Map;

@Repository
public class UserUdpateStoreProcedureRepository {

    private final SimpleJdbcCall jdbcCall;

    public UserUdpateStoreProcedureRepository(DataSource dataSource) {
        this.jdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("UpdateUserEmail")
                .declareParameters(
                        new SqlParameter("userId", Types.INTEGER),
                        new SqlParameter("newEmail", Types.VARCHAR),
                        new SqlOutParameter("success", Types.BOOLEAN)
                );
    }

    public boolean updateUserEmail(Long userId, String newEmail) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("newEmail", newEmail);

        Map<String, Object> result = jdbcCall.execute(params);
        return (Boolean) result.get("success");
    }
}
