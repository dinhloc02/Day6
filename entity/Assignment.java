package entity;

public class Assignment {
    private Buses buses;
    private int quantity;

    public Buses getBuses() {
        return buses;
    }

    public void setBuses(Buses buses) {
        this.buses = buses;
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
                "buses=" + buses +
                ", quantity=" + quantity +
                '}';
    }
}
