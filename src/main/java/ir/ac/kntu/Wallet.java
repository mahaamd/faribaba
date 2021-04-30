package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Wallet {

    private double charge;

    public Wallet(double charge) {
        this.charge = charge;
    }

    public void decreaseCharge(double charge) {
        this.charge -= charge;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge += charge;
    }

    public void showCredit() {
        System.out.println(this.charge);
    }

    public void increaseCharge(User user, Scanner input) {
        System.out.println("Want to charge your Wallet?(yes,no)");
        if (input.nextLine().equals("yes")) {
            double mony = Double.parseDouble(input.nextLine());
            setCharge(mony);
        }
    }

    @Override
    public String toString() {
        return "charge = " + charge;
    }

    public boolean checkBuyingTicketPossibility(double charge) {
        return charge <= this.charge;
    }


}
