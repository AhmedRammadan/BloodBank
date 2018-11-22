package bloodbank.com;

public class Donor {
    private String name , phoneNumber , availableTime ;


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


}
