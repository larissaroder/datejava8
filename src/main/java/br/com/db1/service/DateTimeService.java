package br.com.db1.service;

import br.com.db1.model.DateObject;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.WEEKS;
import static java.time.temporal.ChronoUnit.YEARS;

@Service
public class DateTimeService {

    private static final int AMOUNT = 1;
    public static final String DATE_AFTER_NOW = "A data informada nãopode ser maior que a data atual";

    public DateObject dateObjectActual() {
        LocalDate now = LocalDate.now();
        return new DateObject(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
    }

    public LocalDate getBirth(Integer day, Integer month, Integer year) {
        return LocalDate.of(year, month, day);
    }

    public LocalTime sumHours(Integer hour) {
        return LocalTime.now().plusHours(hour);
    }

    public LocalDate getNextWeek() {
        return LocalDate.now().plus(AMOUNT, WEEKS);
    }

    public LocalDate getNextYear() {
        return LocalDate.now().plus(AMOUNT, YEARS);
    }

    public LocalDate getPreviousYear() {
        return LocalDate.now().minus(AMOUNT, WEEKS);
    }

    public Clock getDefaultTimeZone() {
        return Clock.systemDefaultZone();
    }

    public ZonedDateTime getDateByTimeZone(String timeZone) {
        ZoneId zone = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        return ZonedDateTime.of(localtDateAndTime, zone);

    }

    public Period getBetweenDate(Integer day, Integer month, Integer year) {

        LocalDate dateBefore = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Preconditions.checkArgument(dateBefore.isAfter(now), DATE_AFTER_NOW);
        return Period.between(now, dateBefore);
    }

    public OffsetDateTime getZoneOffset(Integer day, Integer month, Integer year, Integer hour, Integer minute, String offSet) {
        LocalDateTime datetime = LocalDateTime.of(year, month, day, hour, minute);
        ZoneOffset offsetZone = ZoneOffset.of(offSet);
        return OffsetDateTime.of(datetime, offsetZone);
    }

    public String dateTimeNowToString() {
        LocalDateTime arrivalDate = LocalDateTime.now();
        String pattern = "dd/MM/yyyy HH:mm";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        return arrivalDate.format(format);
    }
}
