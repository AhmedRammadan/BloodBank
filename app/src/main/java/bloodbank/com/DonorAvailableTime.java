package bloodbank.com;

public class DonorAvailableTime {
    private String id , name ,
            phoneNumber , fromTime , toTime,sat, mon, tue, wed, thu,fri,sun;

    public DonorAvailableTime(String id , String name, String phoneNumber, String fromTime,
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
        this.id = id;
    }

}

