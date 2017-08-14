package br.com.db1.controller;

import br.com.db1.service.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/application")
public class TimeZoneController {

    @Autowired
    private DateTimeService dateTimeService;

    @RequestMapping(value = "/default-time-zone", method = RequestMethod.GET)
    public ResponseEntity<?> getDefaultTimeZone() {
        Clock defaultTimeZone = dateTimeService.getDefaultTimeZone();
        return new ResponseEntity<>(defaultTimeZone, HttpStatus.OK);
    }

    @RequestMapping(value = "/time-zone", method = RequestMethod.GET)
    public ResponseEntity<?> getPlusHours(@RequestParam("timeZone") String timeZone) {
        ZonedDateTime zonedDateTime = dateTimeService.getDateByTimeZone(timeZone);
        return new ResponseEntity<>(zonedDateTime, HttpStatus.OK);
    }

    @RequestMapping(value = "/offset", method = RequestMethod.GET)
    public ResponseEntity<?> getTimeZoneOffset(@RequestParam("day") Integer day,
                                               @RequestParam("month") Integer month,
                                               @RequestParam("year") Integer year,
                                               @RequestParam("hour") Integer hour,
                                               @RequestParam("minute") Integer minute,
                                               @RequestParam("offset") String offset) {
        OffsetDateTime zonedDateTime = dateTimeService.getZoneOffset(day, month, year, hour, minute, offset);
        return new ResponseEntity<>(zonedDateTime, HttpStatus.OK);
    }

}
