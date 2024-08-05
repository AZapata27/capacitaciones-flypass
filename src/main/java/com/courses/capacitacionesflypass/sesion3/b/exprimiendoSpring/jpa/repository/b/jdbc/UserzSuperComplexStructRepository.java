package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.b.jdbc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.SqlValue;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;


/*
-- Tipo de usuario para dirección
CREATE TYPE AddressType AS OBJECT (
        street VARCHAR2(100),
city VARCHAR2(100),
postalCode VARCHAR2(10)
);

        -- Tipo de usuario para usuario con múltiples direcciones
CREATE TYPE AddressListType AS TABLE OF AddressType;

CREATE TYPE UserType AS OBJECT (
        id NUMBER,
        username VARCHAR2(50),
email VARCHAR2(100),
addresses AddressListType
);

        -- Procedimiento almacenado que acepta un UserType
CREATE PROCEDURE InsertUserWithAddresses(user IN UserType) IS
BEGIN
    -- Lógica para insertar el usuario y sus direcciones en la base de datos
    -- ...
END;
*/





@Repository
public class UserzSuperComplexStructRepository {

    private final SimpleJdbcCall jdbcCall;

    public UserzSuperComplexStructRepository(DataSource dataSource) {
        this.jdbcCall = new SimpleJdbcCall(dataSource)
            .withProcedureName("InsertUserWithAddresses")
            .declareParameters(
                new SqlParameter("user", Types.STRUCT, "UserType")
            );
    }

    public void insertUserWithAddresses(User user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user", new SqlValue() {
            @Override
            public void setValue(PreparedStatement ps, int parameterIndex) throws SQLException {
                Connection conn = ps.getConnection();

                // Crear el ARRAY de direcciones
                Array addressArray = conn.createArrayOf(
                        "AddressType", user.getAddresses().stream()
                                .map(address -> {
                                    try {
                                        return conn.createStruct("AddressType", new Object[]{
                                                address.getStreet(),
                                                address.getCity(),
                                                address.getPostalCode()
                                        });
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                }).toArray()
                );

                // Crear el STRUCT de usuario
                Struct userStruct = conn.createStruct("UserType", new Object[]{
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        addressArray
                });

                ps.setObject(parameterIndex, userStruct);
            }

            @Override
            public void cleanup() {
                // Aquí puedes liberar recursos si es necesario
            }
        });

        jdbcCall.execute(params);
    }

}


@Getter
@Setter
class Address {
    private String street;
    private String city;
    private String postalCode;

    // Getters y Setters
}

@Getter
@Setter
class User {
    private Long id;
    private String username;
    private String email;
    private List<Address> addresses;
}

