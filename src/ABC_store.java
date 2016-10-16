import javax.swing.*;

/**
 * Assignment #2
 * Written by: Kevyn Bele-Binda 260577325 & Jamie Alexander 260706596
 * For CCCS300 - Programming techniques 1
 *
 * This program acts like a sales person, welcomes customers each month
 * and sells merchandise to one customer at a time, respecting the monthly commission
 * limit of $15,000, until you reach the end of year or earning goal of $100,000 for the year;
 * and sends you for a vacation in Honolulu if you achieve the goal, otherwise
 * encourages you to enjoy in Montreal.
 * If the user clicks on cancel it automatically stops the program.
 */


public class ABC_store {
    public static double commissionEarnings(double transactionAmount) {
        double earnings = 0.0;
        if (transactionAmount <= 10000) {
            earnings = transactionAmount * 0.1;
        } else if (transactionAmount > 10000 && transactionAmount <= 30000) {
            earnings = 10000*0.1 + (transactionAmount-10000)*0.15;
        }
        else if (transactionAmount > 30000) {
            earnings = 10000*0.1 + (transactionAmount-10000)*0.15 +  (transactionAmount-30000)*0.2;
        }

        return earnings;

    }

    public static double displayMenu(int month) {
        String monthString;
        double transactionAmount;
        double monthlyEarning=0;
        double totalEarnings = 0;
        int userAnswer=0;
        int isThereACustomer=0;
        if (totalEarnings<100000) {
            switch (month) {
                case 1:  monthString = "January";
                    break;
                case 2:  monthString = "February";
                    break;
                case 3:  monthString = "March";
                    break;
                case 4:  monthString = "April";
                    break;
                case 5:  monthString = "May";
                    break;
                case 6:  monthString = "June";
                    break;
                case 7:  monthString = "July";
                    break;
                case 8:  monthString = "August";
                    break;
                case 9:  monthString = "September";
                    break;
                case 10: monthString = "October";
                    break;
                case 11: monthString = "November";
                    break;
                case 12: monthString = "December";
                    break;
                default: monthString = "Invalid month";
                    break;
            }
            System.out.println("Welcome to " + monthString);
            do {
                isThereACustomer = JOptionPane.showConfirmDialog(null, "Do we have a customer?");
                switch (isThereACustomer) {
                    case 0:
                        System.out.println("Welcome to ABC store!");
                        transactionAmount = Math.random() * 50000.0;
                        transactionAmount = (double) Math.round(transactionAmount * 100) / 100;
                        userAnswer = JOptionPane.showConfirmDialog(null, "Those items cost $" + transactionAmount + ". Do you buy ?");
                        if (userAnswer == 0) {
                            System.out.println("Thanks for transaction amount $" + transactionAmount);
                            monthlyEarning += commissionEarnings(transactionAmount);
                            totalEarnings += monthlyEarning;
                        }
                        else if (userAnswer == 1) {
                            System.out.println("OK. See you next time.");
                        }
                        else {
                            System.exit(1);
                        }
                        break;


                    case 1:
                        monthlyEarning=(double) Math.round(monthlyEarning * 100) / 100;
                        System.out.println("Your commission pay for this month is $" + monthlyEarning);
                        break;
                    case 2:
                        System.exit(1);
                        break;
                }

            }while (monthlyEarning<15000 && isThereACustomer!=1);
            if (monthlyEarning>=15000) {
                monthlyEarning = (double) Math.round(monthlyEarning * 100) / 100;
                System.out.println("Your commission pay for this month is $" + monthlyEarning);
            }
        }
        else {
            System.out.println("\nYour earnings for this year = $"+totalEarnings);
            System.out.println("\nWelcome to Honolulu! Enjoy the rest of this year!");
            return monthlyEarning;
        }
        return monthlyEarning;
    }

    public static void main(String[] args) {
        double monthlyEarning=0;
        double totalEarnings = 0;
        System.out.println("Welcome to ABC store management application presented by Kevyn Bele-Binda and Jamie Alexander");

        for (int month=1; month<=12; month++) {
            totalEarnings += monthlyEarning;
            if(totalEarnings>=100000) {
                System.out.println("\nYour earnings for this year = $"+totalEarnings);
                System.out.println("\nWelcome to Honolulu! Enjoy the rest of this year!");
                break;
            }
            monthlyEarning=0;
            if (monthlyEarning>=15000) {
                monthlyEarning=displayMenu(month);
                monthlyEarning=(double) Math.round(monthlyEarning * 100) / 100;
                System.out.println("Your commission pay for this month is $" + monthlyEarning);

            }
            else {
                monthlyEarning=displayMenu(month);
            }
            if(month>=12 && totalEarnings<100000) {
                totalEarnings += monthlyEarning;
                System.out.println("\nYou earned $" + totalEarnings + " this year, enjoy yourself in Montreal!");
            }
        }
        System.out.print("This program is now over. Thank you for using it!");
    }
}
