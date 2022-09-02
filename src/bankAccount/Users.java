package bankAccount;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Users {

    String name;
    String password;
    String dateOfBirth;
    String marriageStatus;
    String relativeName;
    String relativeAge;
    String isTransferedSuceesfully;
    int accountNumber = randomNumberCreator();
    int amountAccount1;
    int accountNumber2 = randomNumberCreator();
    int amountAccount2;

    public Users(String name, String password, String dateOfBirth, String marriageStatus, int amountAccount1, int amountAccount2) {
        this.name = name;
        this.password = password;
        this.dateOfBirth = checkAge(dateOfBirth);
        CheckMariageStatus(marriageStatus);
        this.amountAccount1 = amountAccount1;
        this.amountAccount2 = amountAccount2;
    }


    public String CheckMariageStatus(String marriageStatus) {
        Scanner scanner = new Scanner(System.in);
        if (marriageStatus.toLowerCase().equals("married")) {
            System.out.print("Do you want to add add your relative?: ");
            String cevap = scanner.nextLine();
            if (cevap.toUpperCase().equals("YES")) {
                System.out.print("What is your relative name?: ");
                String name = scanner.nextLine();
                System.out.print("Relative's date of birth: ");
                String dateOfBirth = scanner.nextLine();

                AddRelative addRelative = new AddRelative(name, dateOfBirth);
                relativeName = name;
                relativeAge = dateOfBirth;

                LocalDate date = LocalDate.now();
                DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
                String text = date.format(formatters);
                LocalDate today = LocalDate.parse(text, formatters);
                int num = today.compareTo(LocalDate.parse(dateOfBirth, formatters));

                if (num==0) {
                    this.relativeName = "Relative should be more then 18 years old";
                    this.relativeAge = "Relative should be more then 18 years old";
                    this.marriageStatus= "Relative should be more then 18 years old";
                    return "Relative should be more then 18 years old";
                } else {
                    this.marriageStatus = "Transaction done successfully";
                }
            }
        } else {
            this.marriageStatus = "";
        }
        return "";
    }

    public static String checkAge(String myDOB) {

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String text = date.format(formatters);
        LocalDate today = LocalDate.parse(text, formatters);

        LocalDate myAge = LocalDate.parse(myDOB, formatters);

        int num = today.compareTo(LocalDate.parse(myDOB, formatters));

        String result = "";

        if (num > 18) {

            result = "You can get a credit card";

        } else if (num < 18) {

            result = "You should be at least 18 years old to get a credit card.";

        } else if (num == 18) {

            if (today.getMonthValue() > myAge.getMonthValue()) {

                result = "You can get a credit card";

            } else if (today.getMonthValue() < myAge.getMonthValue()) {

                result = "You should be at least 18 years old to get a credit card.";

            } else if (today.getMonthValue() == myAge.getMonthValue()) {

                if (today.getDayOfMonth() > myAge.getDayOfMonth()) {

                    result = "You can get a credit card";

                } else {

                    result = "You should be at least 18 years old to get a credit card.";
                }
            }
        }
        return result;
    }

    public int randomNumberCreator() {
        return (int) (Math.random() * ((99999999 - 10000000) + 10000000));
    }

    public void transfer(Users u1, Users u2) {
        Scanner scan = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        System.out.print("Do you want to transfer between your accounts or different user: ");
        if (scan.nextLine().equals("own")) {
            System.out.print("Enter amount of money you want to enter: ");
            System.out.println(Account.transferToOwnAccount(u1, scanInt.nextInt()));
        } else {
            System.out.print("Enter amount of money you want to enter: ");
            System.out.println(Account.transferOtherUser(u1, u2, scanInt.nextInt()));
        }
    }

    @Override
    public String toString() {
        return "\nname=" + name +
                "\npassword= " + password +
                "\ndateOfBirth= " + dateOfBirth +
                "\nmarriageStatus= " + marriageStatus +
                "\nrelativeName= " + relativeName +
                "\nrelativeAge= " + relativeAge +
                "\naccountNumber= " + accountNumber +
                "\namountAccount1= " + amountAccount1 +
                "\naccountNumber2= " + accountNumber2 +
                "\namountAccount2= " + amountAccount2 + "\n";
    }

}
