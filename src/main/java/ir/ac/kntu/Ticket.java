package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Ticket {

    private Plane plane;

    private double price = 300;

    private DateTime travelTime;

    private String origin;

    private String destination;

    private Seat seat;

    private String flightType;


    public Ticket(DateTime travelTime, String origin, String destination, String flightType, Seat seat) {
        this.travelTime = travelTime;
        this.origin = origin;
        this.destination = destination;
        this.flightType = flightType;
        this.seat = seat;
    }

    public Ticket(DateTime travelTime, String origin, String destination, String flightType) {
        this.travelTime = travelTime;
        this.origin = origin;
        this.destination = destination;
        this.flightType = flightType;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setPrice(double price) {
        this.price += price;
    }

    public void setTravelTime(DateTime travelTime) {
        this.travelTime = travelTime;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public double getPrice() {
        return price;
    }

    public Plane getPlane() {
        return plane;
    }

    public DateTime getTravelTime() {
        return travelTime;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Seat getSeat() {
        return seat;
    }

    public String getFlightType() {
        return flightType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                ", travelTime=" + travelTime.getTime() +
                ", travel Date=" + travelTime.getYear() + "/" + travelTime.getMonth() + "/"
                + travelTime.getDay() +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", seat=" + seat +
                '}';
    }

    public static ArrayList<Ticket> searchDesiredTicketExistence(DateTime dateTime, String flightType, String flyCity, String dest) {
        boolean condition = false;

        ArrayList<Ticket> desiredTickets = new ArrayList<>();
        for (Ticket t : Travel.getTickets().values()) {
            if (t.getTravelTime().equals(dateTime) && t.getFlightType().equals(flightType)
                    && t.getOrigin().equals(flyCity) && t.getDestination().equals(dest)) {
                desiredTickets.add(t);
                condition = true;
            }
        }

        if (condition) {
            return desiredTickets;
        }
        return null;
    }
}
