package openjanela.model.entities.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Sherif
 */
@Embeddable
public class CountryHolidaysPK implements Serializable {

    private String countryid;
    private int month;
    private int day;

    //************************************************************************
    // CONSTRUCTORS
    //************************************************************************

    /**
     * Default Constructor
     */
    public CountryHolidaysPK() {
    }

    /**
     * Country Holiday Constructor
     *
     * @param countryid, Country Identification Id
     * @param month,     Month
     * @param day,       Day
     */
    public CountryHolidaysPK(String countryid, int month, int day) {
        this.countryid = countryid;
        this.month = month;
        this.day = day;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    @Column(name = "countryid")
    public String getCountryid() {
        return countryid;
    }

    public void setCountryid(String countryid) {
        this.countryid = countryid;
    }

    @Column(name = "month_")
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Column(name = "day_")
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

}
