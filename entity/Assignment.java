package entity;

public class Assignment {
    private Gland gland;
    private int quantity;

    public Assignment(Gland gland, int quantity) {
        this.gland = gland;
        this.quantity = quantity;
    }

    public Gland getGland() {
        return gland;
    }

    public void setGland(Gland gland) {
        this.gland = gland;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "buses=" + gland +
                ", quantity=" + quantity +
                '}';
    }
}
