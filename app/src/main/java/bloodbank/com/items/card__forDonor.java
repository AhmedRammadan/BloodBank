package bloodbank.com.items;

public class card__forDonor {
    private String title , description;

    public card__forDonor() {
    }

    public card__forDonor(String title, String description) {
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
