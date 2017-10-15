package openjanela.model.entities.admin;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Sherif
 */
@Embeddable
public class CountryWeekendsPK implements Serializable {

    private String country;
    private int day1;
    private int day2;

    //************************************************************************
    // CONSTRUCTORS
    //************************************************************************

    public CountryWeekendsPK() {}

    public CountryWeekendsPK(String country, int day1, int day2) {
        this.country = country;
        this.day1 = day1;
        this.day2 = day2;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "day1")
    public int getDay1() {
        return day1;
    }

    public void setDay1(int day1) {
        this.day1 = day1;
    }

    @Column(name = "day2")
    public int getDay2() {
        return day2;
    }

    public void setDay2(int day2) {
        this.day2 = day2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (country != null ? country.hashCode() : 0);
        hash += day1;
        hash += day2;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields
        // are not set
        if (!(object instanceof CountryWeekendsPK)) {
            return false;
        }
        CountryWeekendsPK other = (CountryWeekendsPK) object;
        if ((this.country == null && other.country != null) || (this.country != null && !this.country.equals(other.country))) {
            return false;
        }
        if (this.day1 != other.day1) {
            return false;
        }
        if (this.day2 != other.day2) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Openjanela_PersistenceObjects.CountryWeekendsPK[ country=" + country + ", day1=" + day1 + ", day2=" + day2
                + " ]";
    }

}
