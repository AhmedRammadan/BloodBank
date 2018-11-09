package bloodbank.com;

public class Item_Recy {
    private String name , date ,Number;

    public Item_Recy(String name, String date, String number) {
        this.name = name;
        this.date = date;
        Number = number;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getNumber() {
        return Number;
    }
}
