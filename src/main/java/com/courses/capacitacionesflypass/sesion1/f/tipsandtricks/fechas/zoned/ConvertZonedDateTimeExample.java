package com.courses.capacitacionesflypass.sesion1.f.tipsandtricks.fechas.zoned;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ConvertZonedDateTimeExample {

    public static void main(String[] args) {


        ZonedDateTime currentDateTime = ZonedDateTime.now();
        System.out.println("Fecha y hora actual: " + currentDateTime);

        ZonedDateTime tokyoDateTime = currentDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("Fecha y hora en Tokio: " + tokyoDateTime);

        ZonedDateTime newYorkDateTime = currentDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Fecha y hora en Nueva York: " + newYorkDateTime);
    }
}
