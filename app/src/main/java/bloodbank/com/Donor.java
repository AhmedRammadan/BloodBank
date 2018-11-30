package bloodbank.com;

public class Donor {
    private String  name ,
            phoneNumber , availableDay,fromTime , toTime,sat, mon, tue, wed, thu,fri,sun,availableTime ;
    /**
     * @checkDay =0 isEmpty || =1 isNo'tEmpty
     * @checkTime =0 isEmpty || =1 isNo'tEmpty
     */
    private int checkDay ,checkTime ;

    public Donor() {
    }

    public Donor( int checkDay ,int checkTime,String name, String phoneNumber,String availableDay, String availableTime) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.availableTime = availableTime;
        this.availableDay = availableDay;
        this.checkDay = checkDay;
        this.checkTime = checkTime;
    }
    ///
    public Donor( int checkDay ,int checkTime, String name, String phoneNumber, String fromTime, String toTime
                  ,String sat, String mon, String tue, String wed, String thu, String fri, String sun) {
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
        this.checkDay = checkDay;
        this.checkTime = checkTime;
    }
    public Donor( int checkDay ,int checkTime, String name, String phoneNumber,String availableTime, String sat, String mon, String tue, String wed, String thu, String fri, String sun) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.availableTime = availableTime;
        this.sat = sat;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sun = sun;
        this.checkDay = checkDay;
        this.checkTime = checkTime;
    }
    ///
    public Donor(int checkDay ,int checkTime, String name, String phoneNumber,String availableDay, String fromTime,String toTime) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.checkTime = checkTime;
        this.checkDay = checkDay;
        this.availableDay = availableDay;
    }
    public int getCheckDay() {
        return checkDay;
    }

    public int getCheckTime() {
        return checkTime;
    }

    public String getAvailableDay() {
        return availableDay;
    }

    public String getName() {
        return name;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
