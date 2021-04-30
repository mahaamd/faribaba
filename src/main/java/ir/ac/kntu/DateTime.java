package ir.ac.kntu;

import java.util.Objects;
import java.util.PrimitiveIterator;

public class DateTime {
    private String time;

    private int day;

    private int year;

    private int month;

    public DateTime() {

    }

    public DateTime(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DateTime(String time, int day, int year, int month) {
        this.time = time;
        this.day = day;
        this.year = year;
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DateTime)) {
            return false;
        }
        DateTime dateTime = (DateTime) o;
        return getDay() == dateTime.getDay() && getYear() == dateTime.getYear() && getMonth() == dateTime.getMonth();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getDay(), getYear(), getMonth());
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getTime() {
        return time;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
