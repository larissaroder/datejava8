package br.com.db1.controller;


import br.com.db1.service.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/application")
public class LocalTimeController {


    @Autowired
    private DateTimeService dateTimeService;

    @RequestMapping(value = "/time-now", method = RequestMethod.GET)
    public ResponseEntity<?> getNow() {
        return new ResponseEntity<>(LocalTime.now(), HttpStatus.OK);
    }

    @RequestMapping(value = "/plus-hour", method = RequestMethod.GET)
    public ResponseEntity<?> getPlusHours(@RequestParam("hour") Integer hour) {
        LocalTime localTime = dateTimeService.sumHours(hour);
        return new ResponseEntity<>(localTime, HttpStatus.OK);
    }
}
