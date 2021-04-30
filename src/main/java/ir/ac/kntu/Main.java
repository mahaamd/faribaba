package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Travel t = new Travel();
        User mohammad = new User("091131240206", "Mohammad Amiri", "2051216316", "mamal160018", "A12345678");
        mohammad.setWallet(new Wallet(0));
//        mohammad.buyTicket(new Scanner(System.in));
//        System.exit(0);

        ArrayList<User> users = new ArrayList<>();
//        User mohammad = new User("091131240206","Mohammad Amiri","2051216316","mamal160018","A12345678");
        //ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        DateTime dateTime = new DateTime("12:16", 5, 1399, 12);
        Ticket ticket = new Ticket(dateTime, "babol", "tehran", "international");
        ticket.setSeat(Seat.ECONOMYCLASS);
        Travel.getTickets().put(0,ticket);
        //tickets.add(ticket);
        mohammad.setTickets(ticket);
        users.add(mohammad);
        Scanner input = new Scanner(System.in);

        startingMenu(users, input);
    }

    public static void startingMenu(ArrayList<User> users, Scanner input) {
        int condition;
        System.out.println("1: Sign in\n" + "2: Login\n" + "3:Define Ticket\n" + "4: Exit");
        condition = Integer.parseInt(input.nextLine());
        switch (condition) {
            case 1:
                addUser(users, input);
                startingMenu(users, input);
                break;
            case 2:
                User user1 = userValidation(users, input);
                if (user1 != null) {
                    loginMenu(user1, users, input);
                } else {
                    System.out.println("Invalid User");
                }
                startingMenu(users, input);
                break;
            case 3:
                Travel.ticketDefinition(input);
                startingMenu(users, input);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("choose number between 1 to 4");
                startingMenu(users, input);
        }
    }

    public static void loginMenu(User user, ArrayList<User> users, Scanner input) {
        System.out.println("1: Show user Info\n2: Buy New Ticket\n3: Show ExistingTicket\n" +
                "4: Show Credit Status\n5: Exit Login Page");
        int choose = Integer.parseInt(input.nextLine());
        switch (choose) {
            case 1:
                System.out.println(user);
                loginMenu(user, users, input);
                break;
            case 2:
                user.buyTicket(input);
                loginMenu(user, users, input);
                break;
            case 3:
                System.out.println(user.getTickets());
                loginMenu(user, users, input);
                break;
            case 4:
                user.getWallet().showCredit();
                user.getWallet().increaseCharge(user, input);
                loginMenu(user, users, input);
            case 5:
                startingMenu(users, input);
                break;
            default:
                System.out.println("Oops! Try Again");
                loginMenu(user, users, input);
        }
    }


    public static void addUser(ArrayList<User> users, Scanner input) {
        System.out.println("Enter Phone Number");
        String phoneNumber = input.nextLine();
        System.out.println("Enter Full Name");
        String fullName = input.nextLine();
        System.out.println("Enter National Code");
        String nationalCode = input.nextLine();
        System.out.println("Enter User Name");
        String userName = input.nextLine();
        System.out.println("Enter Password");
        String password = input.nextLine();
        User user = new User(phoneNumber, fullName, nationalCode, userName, password);
        user.setWallet(new Wallet(0));
        users.add(user);
    }

    public static User userValidation(ArrayList<User> users, Scanner input) {
        System.out.println("Enter User Name");
        String username = input.nextLine();
        System.out.println("Enter Password");
        String password = input.nextLine();

        for (User user : users) {
            if (user.getPassword().matches(password) && user.getUserName().matches(username)) {
                return user;
            }
        }
        return null;
    }

//    public static void showUserInfoAfterLogin(User user) {
//        System.out.println(user);
//    }
}