import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        /*Checking chkAcct1 = new Checking("Tom Wilson", "123456789", 1500);
        Savings savAcct1 = new Savings("Rich Lowe", "123456780", 2500);

        savAcct1.compound();
        savAcct1.showInfo();
        System.out.println("*************************");
        chkAcct1.showInfo();*/

        List<Account> accounts = new LinkedList<Account>();




        // Read a CSV file then create new accounts based on that data
        String file = "/Users/RaulM/Downloads/NewBankAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String SSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            // System.out.println(name + " " + SSN + " " + accountType + " $" + initDeposit);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, SSN, initDeposit));
            }
            else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, SSN, initDeposit));
            }
            else {
                System.out.println("Error Reading account type");
            }

        }

        // To display a single item from the array index
        // accounts.get(5).showInfo();

        for (Account acc : accounts) {
            System.out.println("\n**************************");
            acc.showInfo();
        }

        accounts.get((int) Math.random() * accounts.size());

    }
}
