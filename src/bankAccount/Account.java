package bankAccount;

public class Account {

    public static int deposit(int accountAmount, int amountToAdd) {
        return accountAmount += amountToAdd;
    }

    public static int withDraw(int accountAmount, int withdrawAmount) {
        return accountAmount -= withdrawAmount;
    }

    public static String transferOtherUser(Users sendingUser, Users receivingUser, int transferAmount) {
        if (transferAmount > sendingUser.amountAccount1) {
            return "Sender is poor lol :)";
        } else {
            transferAmount -= transferAmount * 2 / 100;
            sendingUser.amountAccount1 -= transferAmount;
            receivingUser.amountAccount1 += transferAmount;
            return "";
        }
    }

    public static String transferToOwnAccount(Users u1, int transferAmount) {
        if (transferAmount > u1.amountAccount1) {
            return "You need more money dude";
        }else {
            transferAmount -= transferAmount / 100;
            u1.amountAccount1-=transferAmount;
            u1.amountAccount2+=transferAmount;
            return "";
        }
    }
}












