package newprojectc.example.shoesapp_duked.popular;

public class Popular_items {
    private String title;
    private int picURl;
    private  String review;
    private double score;

    private double price;

    public Popular_items(String title, int picURl, String review, double score, double price) {
        this.title = title;
        this.picURl = picURl;
        this.review = review;
        this.score = score;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPicURl() {
        return picURl;
    }

    public void setPicURl(int picURl) {
        this.picURl = picURl;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
