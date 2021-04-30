package ir.ac.kntu;

public enum Seat {

    ECONOMYCLASS(300),
    FIRSTCLASS(450),
    BUSINESSCLASS(600);
//    DOMESTIC(100),
//    INTERNATIONAL(200);

    private final int price;

    Seat(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
