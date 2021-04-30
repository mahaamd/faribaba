package ir.ac.kntu;

import java.util.*;

public class Travel {
    private final double price = 320;

    private DateTime travelTime;

    private String origin;

    private String destination;

    private Seat seat;

    private String flightType;

    private ArrayList<Plane> airPlanes;

    private static Map<Integer, Ticket> tickets;


    public Travel() {
        tickets = new HashMap<>();
    }

    public static Map<Integer, Ticket> getTickets() {
        return tickets;
    }

    public ArrayList<Plane> getAirPlanes() {
        return airPlanes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Travel)) {
            return false;
        }
        Travel travel = (Travel) o;
        return Objects.equals(travelTime, travel.travelTime) && Objects.equals(origin, travel.origin) && Objects.equals(destination, travel.destination) && seat == travel.seat && Objects.equals(flightType, travel.flightType) && Objects.equals(getAirPlanes(), travel.getAirPlanes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, travelTime, origin, destination, seat, flightType, getAirPlanes());
    }

    public static void ticketDefinition(Scanner input) {

        System.out.println("Ticket number: ");
        int ticketNumber = Integer.parseInt(input.nextLine());
        DateTime dateTime = new DateTime();
        System.out.println("Day, month, year");
        dateTime.setDay(Integer.parseInt(input.nextLine()));
        dateTime.setMonth(Integer.parseInt(input.nextLine()));
        dateTime.setYear(Integer.parseInt(input.nextLine()));

        System.out.println("Enter Flight Time");
        dateTime.setTime(input.nextLine());

        System.out.println("Enter Fly City");
        String origin = input.nextLine().toLowerCase(Locale.ROOT);
        System.out.println("Enter Destination");
        String destination = input.nextLine().toLowerCase(Locale.ROOT);

        System.out.println("seat : Economy or First or Business Class");
        String seat = input.nextLine().toUpperCase() + "CLASS";

        System.out.println("choose Your Flight Type Domestic or international");
        String flightType = input.nextLine().toUpperCase(Locale.ROOT);

        Ticket ticket = new Ticket(dateTime, origin, destination, flightType, Seat.valueOf(seat));
        ticket.setPlane(new Plane((int) ((Math.random() + 3) * 100), (int) (Math.random() * 100000)));
        tickets.put(ticketNumber, ticket);
    }

}
