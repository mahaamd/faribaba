package ir.ac.kntu;

import java.util.ArrayList;

public class Plane {

    private final int capacity;

    private final int id;

    ArrayList<User> users;

    public Plane(int capacity, int id) {
        this.capacity = capacity;
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Plane" + id + " capacity == " + capacity;
    }
}
