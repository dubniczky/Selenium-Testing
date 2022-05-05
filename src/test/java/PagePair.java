public class PagePair {
    public String url;
    public String text;
    public Boolean contain;

    PagePair(String url, String text) {
        this.url = url;
        this.text = text;
        this.contain = true;
    }

    PagePair(String url, String text, Boolean contain) {
        this.url = url;
        this.text = text;
        this.contain = contain;
    }
}
