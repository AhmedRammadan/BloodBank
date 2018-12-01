package bloodbank.com;

public class choose {
    private String to , from ;
    private int image;

    public choose() {
    }

    public choose(String to, String from, int image) {
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
