package bookproject;

import java.util.List;

public class Book extends Item{

    private String author;
    private String description;
    private String category;
    private String releaseDate;

    public Book(String bookId, String name, int unitPrice) {
        super(bookId, name, unitPrice);
    }

    public Book(String[] data) { // 빌더패턴 적용 필요
        super(data[0], data[1], Integer.parseInt(data[2]));
        this.author = data[3];
        this.description = data[4];
        this.category = data[5];
        this.releaseDate = data[6];
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        List<String> fields = List.of(
                this.getBookId(), this.getName(), Integer.toString(this.getUnitPrice()),
                author, description, category, releaseDate
        );
        return String.join(" | ", fields);
    }
}
