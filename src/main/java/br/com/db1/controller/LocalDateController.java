package br.com.db1.controller;


import br.com.db1.model.DateObject;
import br.com.db1.service.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/application")
public class LocalDateController {


    @Autowired
    private DateTimeService dateTimeService;

    @RequestMapping(value = "/date-now", method = RequestMethod.GET)
    public ResponseEntity<?> getNow() {
        return new ResponseEntity<>(LocalDate.now(), HttpStatus.OK);
    }

    @RequestMapping(value = "/year-month-day", method = RequestMethod.GET)
    public ResponseEntity<?> getYearMonthDay() {
        DateObject dateObject = dateTimeService.dateObjectActual();
        return new ResponseEntity<>(dateObject, HttpStatus.OK);
    }

    @RequestMapping(value = "/birth-day", method = RequestMethod.GET)
    public ResponseEntity<?> birthDay(@RequestParam("day") Integer day,
                                      @RequestParam("month") Integer month,
                                      @RequestParam("year") Integer year) {
        LocalDate dateBirth = dateTimeService.getBirth(day, month, year);
        return new ResponseEntity<>(dateBirth, HttpStatus.OK);
    }

    @RequestMapping(value = "/between-now-date", method = RequestMethod.GET)
    public ResponseEntity<?> betweenNowDate(@RequestParam("day") Integer day,
                                      @RequestParam("month") Integer month,
                                      @RequestParam("year") Integer year) {
        Period period = dateTimeService.getBetweenDate(day, month, year);
        return new ResponseEntity<>(period, HttpStatus.OK);
    }

    @RequestMapping(value = "/next-week", method = RequestMethod.GET)
    public ResponseEntity<?> getNextWeek() {
        LocalDate nextWeek = dateTimeService.getNextWeek();
        return new ResponseEntity<>(nextWeek, HttpStatus.OK);
    }

    @RequestMapping(value = "/next-year", method = RequestMethod.GET)
    public ResponseEntity<?> getNextYear() {
        LocalDate nextYear = dateTimeService.getNextYear();
        return new ResponseEntity<>(nextYear, HttpStatus.OK);
    }

    @RequestMapping(value = "/previous-year", method = RequestMethod.GET)
    public ResponseEntity<?> getPreviousYear() {
        LocalDate previousYear = dateTimeService.getPreviousYear();
        return new ResponseEntity<>(previousYear, HttpStatus.OK);
    }

    @RequestMapping(value = "/date-time-to-string", method = RequestMethod.GET)
    public ResponseEntity<?> getDateTimeNowToString() {
        String dateTimeString = dateTimeService.dateTimeNowToString();
        return new ResponseEntity<>(dateTimeString, HttpStatus.OK);
    }
}
