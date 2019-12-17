
import java.time.DayOfWeek;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author ariel schafman
 * @version 2020a
 * @see java.lang.Object
 */

public class Date extends java.util.Date {
    private int _day;
    private int _month;
    private int _year;
    private boolean before;

    /**
     * build a date with dd/mm/yyyy format and if given an invalid date return 1/1/2000
     */
    Date(int day, int month, int year) {//Constructor

        this._day = day;
        this._month = month;
        this._year = year;
        if ((_month == 2 && _day > 28 && _year % 4 == 0 && (_year % 100 != 0 || _year % 400 == 0)) || _day > 31 || _day <= 0 || _month <= 0 || _month > 12
                || _month == 4 && _day > 30 || _month == 6 && _day > 30 || _month == 9 && _day > 30
                || _month == 11 && _day > 30) {//to remove any invalid dates
            this._day = 1;
            this._month = 1;
            this._year = 2000;
        }
    }

    /**
     * get the day
     *
     * @return a given date day
     */
    public int getDay() {
        return _day;
    }

    /**
     * get the month
     *
     * @return a given date month
     */
    public int getMonth() {
        return _month;
    }

    /**
     * get the year
     *
     * @return a given date year
     */
    public int getYear() {
        return _year;
    }

    /**
     * set the day
     *
     * @param dayToSet the value to be set
     * @return change the date day to a given number if the given number is valid
     */
    public void setDay(int dayToSet) {
        if ((_month == 2 && dayToSet > 28 && (_year % 4 == 0 && (_year % 100 != 0 || _year % 400 == 0))) || dayToSet > 31 || dayToSet <= 0
                || _month <= 0 || _month > 12 || _month == 4 && dayToSet > 30 || _month == 6 && dayToSet > 30
                || _month == 9 && dayToSet > 30 || _month == 11 && dayToSet > 30) {//to remove any invalid dates
        } else {
            this._day = dayToSet;
        }
    }

    /**
     * set the month
     *
     * @param monthToSet the value to be set
     * @return change the date month to a given number if the given number is valid
     */
    public void setMonth(int monthToSet) {
        if ((monthToSet == 2 && _day > 28 && (_year % 4 == 0 && (_year % 100 != 0 || _year % 400 == 0))) || _day > 31 || _day <= 0
                || monthToSet <= 0 || monthToSet > 12 || monthToSet == 4 && _day > 30 || monthToSet == 6 && _day > 30
                || monthToSet == 9 && _day > 30 || monthToSet == 11 && _day > 30) {//to remove any invalid dates
        } else {
            this._month = monthToSet;
        }
    }

    /**
     * set the year
     *
     * @param yearToSet the value to be set
     */
    public void setYear(int yearToSet) {
        if ((_month == 2 && _day > 28 && (yearToSet % 4 == 0 && (yearToSet % 100 != 0 || yearToSet % 400 == 0))) || _day > 31 || _day <= 0
                || _month <= 0 || _month > 12 || _month == 4 && _day > 30 || _month == 6 && _day > 30
                || _month == 9 && _day > 30 || _month == 11 && _day > 30) {//to remove any invalid dates
        } else {
            this._year = yearToSet;
        }
    }

    /**
     * return the date in dd/mm/yyyy format
     *
     * @return the date in dd/mm/yyyy format
     */
    public String toString() {
        if (this._day < 10 && this._month < 10) {//to add 0 to the days if needed
            return ("0" + this._day + "/" + "0" + this._month + "/" + this._year);
        } else if (this._day < 10) {// to add 0 to months if needed
            return ("0" + this._day + "/" + this._month + "/" + this._year);
        }
        if (this._month < 10) {//to add 0 to days and months if needed
            return (this._day + "/" + "0" + this._month + "/" + this._year);

        }
        return (this._day + "/" + this._month + "/" + this._year);
    }

    /**
     * Compare two dates and tell if they are equals
     *
     * @return day if two dates are the same
     */

    public boolean equals(Date other) {
        if (this._day == other._day && this._month == other._month && this._year == other._year) {
            return true;
        } else return false;

    }

    /**
     * checks if this date comes before a given date
     *
     * @return true if this date comes before the other date
     */

    public boolean before(Date other) {
        if (this._year == other._year && this._month == other._month && this._day == other._day) {//to remove if they are equals
            return false;
        }
        if ((this._year == other._year && this._month == other._month && this._day > other._day)
                || (this._year == other._year && this._month > other._month) || (this._year > other._year)) {//check if this date is before the given date
            before = true;
            return false;
        } else {
            before = false;
            return true;
        }
    }

    /**
     * checks if this date comes after a given date
     *
     * @return tell if this date is after a given date
     */

    public boolean after(Date other) {
        if (this._year == other._year && this._month == other._month && this._day == other._day) {//to remove if they are equals
            return false;
        } else {
            if ((this._year == other._year && this._month == other._month && this._day > other._day)
                    || (this._year == other._year && this._month > other._month) || (this._year > other._year)) {//check if this date is after the given date
                before = false;
            } else {
                before = true;
            }
        }
        if (!before) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * return the next day date of a given date
     *
     * @return the next day date of a given date
     */

    public Date tomorrow() {
        int day = _day;
        int month = _month;
        int year = _year;
        boolean a;//this boolean are to check if it's the end of the month
        boolean b;
        boolean c;
        boolean d;
        boolean e;

        if (_month == 2 && _year % 4 == 0 && (_year % 100 != 0 || _year % 400 == 0) && _day == 29) {//if this year is a leap year
            day = 1;
            month = 3;
            a = false;
        } else {
            a = true;
        }
        if (_month == 2 && _year % 4 != 0 && _day == 28) {//if not a leap year
            day = 1;
            month = 3;
            e = false;
        } else {
            e = true;
        }
        if ((_month == 4 || _month == 6 || _month == 9 || _month == 11) && _day == 30) {//for any 30 day long month
            day = 1;
            month++;
            b = false;
        } else {
            b = true;
        }
        if ((_month == 1 || _month == 3 || _month == 5 || _month == 7 || _month == 8 || _month == 10) && day == 31) {//for any 31 long days month
            day = 1;
            month++;
            c = false;
        } else {
            c = true;
        }
        if (_month == 12 && _day == 31) {//for the end of the year
            day = 1;
            month = 1;
            year++;
            d = false;
        } else {
            d = true;
        }
        if (a && b && c && d && e) {
            day++;
        } else {
        }
        Date date1 = new Date(day, month, year);
        return date1;
    }

    /**
     * tell the difference between any two given dates in days
     *
     * @return tell the difference between any two given dates in days
     */
    public long difference(Date other) {//tell the difference between two dates in days
        LocalDate dateBefore = LocalDate.of(this._year, this._month, this._day);
        LocalDate dateAfter = LocalDate.of(other._year, other._month, other._day);
        long noOfDaysBetween = Math.abs(ChronoUnit.DAYS.between(dateBefore, dateAfter));
        return noOfDaysBetween;

    }

    /**
     * tell what day of the week is any given date 0 is Saturday 1 is Sunday 2 is Monday etc.
     *
     * @return what day of the week is any given date 0 is Saturday 1 is Sunday 2 is Monday etc.
     */

    public int dayInWeek() {
        DayOfWeek day = DayOfWeek.from(LocalDate.of(this._year, this._month, this._day));
        if (day == DayOfWeek.SUNDAY)
            return 1;
        else if (day == DayOfWeek.MONDAY)
            return 2;
        else if (day == DayOfWeek.TUESDAY)
            return 3;
        else if (day == DayOfWeek.WEDNESDAY)
            return 4;
        else if (day == DayOfWeek.THURSDAY)
            return 5;
        else if (day == DayOfWeek.FRIDAY)
            return 6;
        else return 0;


    }

    /**
     * Copy Constructor
     * copy this date to a given date
     */

    public Date(Date other) {
        this._day = other._day;
        this._month = other._month;
        this._year = other._year;

    }
}