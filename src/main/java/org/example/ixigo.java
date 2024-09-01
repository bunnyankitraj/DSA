package org.example;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;

public class ixigo {


    public static void main(String[] args) {
        checkTimeEpoch(24);
    }

    private static void convertEpochToTIme(long epochSecond) {

        // Convert epoch second to Instant
        Instant instant = Instant.ofEpochSecond(epochSecond);

        // Print the instance in ISO-8601 format which by default is in UTC.
        System.out.println("UTC DateTime: " + instant);

        // Optionally, convert Instant to OffsetDateTime with UTC offset
        OffsetDateTime utcDateTime = instant.atOffset(ZoneOffset.UTC);
        System.out.println("UTC DateTime with Offset: " + utcDateTime);
    }

    private static void checkTimeEpoch(int i) {
        long epoch =
                OffsetTime.now()
                        .atDate(OffsetDateTime.now().toLocalDate())
                        .plusHours(i)
                        .toInstant()
                        .getEpochSecond();

        System.out.println(epoch);
        convertEpochToTIme(epoch);

    }
}
