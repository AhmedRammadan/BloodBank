package bloodbank.com.items;

public class card_WhichYouCanDonate {
    private String to , from ;
    private int image;

    public card_WhichYouCanDonate() {
    }

    public card_WhichYouCanDonate(String to, String from, int image) {
        this.to = to;
        this.from = from;
        this.image = image;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public int getImage() {
        return image;
    }
}
