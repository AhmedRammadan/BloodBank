package bloodbank.com;

public class Item_Recy {
    private String name , date ,days;

    public Item_Recy(String name, String date, String days) {
        this.name = name;
        this.date = date;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getDays() {
        return days;
    }


}
