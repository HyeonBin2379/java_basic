package bookproject;

public class Book {

    private String isbn;
    private String title;
    private int price;
    private String author;
    private String description;
    private String category;
    private String publishDate;

    public Book(String[] data) {
        this.isbn = data[0];
        this.title = data[1];
        this.price = Integer.parseInt(data[2]);
        this.author = data[3];
        this.description = data[4];
        this.category = data[5];
        this.publishDate = data[6];
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPublishDate() {
        return publishDate;
    }
}
