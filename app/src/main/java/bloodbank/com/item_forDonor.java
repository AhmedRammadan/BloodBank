package bloodbank.com;

public class item_forDonor {
    private int image;
    private String title , description;

    public item_forDonor() {
    }

    public item_forDonor(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
