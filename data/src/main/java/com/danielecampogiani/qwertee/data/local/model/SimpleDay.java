package com.danielecampogiani.qwertee.data.local.model;

public class SimpleDay {


    private final int day;
    private final int month;
    private final int year;

    public SimpleDay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isBefore(SimpleDay other) {

        if (this.year < other.year) {
            return true;
        } else {
            if (this.year == other.year && this.month < other.month) {
                return true;
            } else if (this.year == other.year && this.month == other.month) {
                return this.day < other.day;
            }
        }

        return false;

    }

    public boolean isAfter(SimpleDay other) {

        if (this.year > other.year) {
            return true;
        } else {
            if (this.year == other.year && this.month > other.month) {
                return true;
            } else if (this.year == other.year && this.month == other.month) {
                return this.day > other.day;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SimpleDay simpleDay = (SimpleDay) o;

        if (day != simpleDay.day)
            return false;
        if (month != simpleDay.month)
            return false;
        if (year != simpleDay.year)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "SimpleDay{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
