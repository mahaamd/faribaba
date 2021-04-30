package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class User {

    private String phoneNumber;

    private String fullName;

    private String nationalCode;

    private String userName;

    private String password;

    private ArrayList<Ticket> tickets;

    private Wallet wallet;

    @Override
    public String toString() {
        return fullName + "{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
//        tickets = new ArrayList<>();
    }

    public User(String phoneNumber, String fullName, String nationalCode, String userName, String password) {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.nationalCode = nationalCode;
        this.userName = userName;
        this.password = password;
        tickets = new ArrayList<>();
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTickets(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void showFoundedTicketsAndBuyIfPossible(ArrayList<Ticket> desiredTicket, double seatPrice, Scanner input) {
        try {
            for (int i = 0; i < desiredTicket.size(); i++) {
                desiredTicket.get(i).setPrice(seatPrice);
                System.out.println(i + ":");
                System.out.println(desiredTicket.get(i));
            }
        } catch (NullPointerException N) {
            System.out.println("No Matched Tickets !");
            return;
        }
        System.out.println("Which one Do You Want :");
        int choose = Integer.parseInt(input.nextLine());
        if (getWallet().checkBuyingTicketPossibility(desiredTicket.get(choose).getPrice())) {
            getWallet().decreaseCharge(desiredTicket.get(choose).getPrice());
            setTickets(desiredTicket.get(choose));
        } else {
            System.out.println("Your Wallet Charge Is Not Adequate Please Increase your Charge From Back Menu");
        }
    }

    public void buyTicket(Scanner input) {
        ArrayList<Ticket> desiredTicket;
        double seatPrice = 0;
        System.out.println("Enter Your Flight Date( Day / Month / Year)");
        DateTime dateTime = new DateTime(Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()));

        System.out.println("Enter Flight Type(Domestic, International");
        String flightType = input.nextLine().toUpperCase(Locale.ROOT);
        String seatType;
        if (flightType.equals("INTERNATIONAL")) {
            System.out.println("seat : Economy or First or Business Class");
            seatType = input.nextLine() + "Class";
            seatPrice = Seat.valueOf(seatType.toUpperCase(Locale.ROOT)).getPrice();
        }
        System.out.println("Enter Fly City");
        String origin = input.nextLine().toLowerCase(Locale.ROOT);
        System.out.println("Enter Destination");
        String destination = input.nextLine().toLowerCase(Locale.ROOT);
        //Ticket ticket = new Ticket();
        //System.out.println(Travel.getTickets());

        desiredTicket = Ticket.searchDesiredTicketExistence(dateTime, flightType, origin, destination);

        showFoundedTicketsAndBuyIfPossible(desiredTicket, seatPrice, input);
    }
}
