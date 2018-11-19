package bloodbank.com;

public class Donor {
    private String name ,
            phoneNumber , availableTime , fromTime , toTime,sat, mon, tue, wed, thu,fri,sun;

    public Donor(String name, String phoneNumber, String fromTime,
                 String toTime, String sat, String mon, String tue, String wed, String thu, String fri, String sun) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.sat = sat;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sun = sun;
    }

    public Donor(String name, String phoneNumber, String availableTime) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.availableTime = availableTime;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public String getSat() {
        return sat;
    }

    public String getMon() {
        return mon;
    }

    public String getTue() {
        return tue;
    }

    public String getWed() {
        return wed;
    }

    public String getThu() {
        return thu;
    }

    public String getFri() {
        return fri;
    }

    public String getSun() {
        return sun;
    }

}
