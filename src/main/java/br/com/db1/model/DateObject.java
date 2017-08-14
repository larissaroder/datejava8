package br.com.db1.model;

import java.io.Serializable;

public class DateObject implements Serializable {

    Integer year;
    Integer month;
    Integer day;

    protected DateObject() {
        // To serializable
    }

    public DateObject(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }
}
