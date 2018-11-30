package bloodbank.com;

public class item_forDonor {
    private String title , description;

    public item_forDonor() {
    }

    public item_forDonor( String title, String description) {
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
