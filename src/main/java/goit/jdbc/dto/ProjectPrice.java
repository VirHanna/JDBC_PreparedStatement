package goit.jdbc.dto;

public class ProjectPrice {
    private int id;
    private long price;

    public ProjectPrice(int id, long price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
