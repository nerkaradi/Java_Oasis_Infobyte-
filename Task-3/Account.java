import java.util.*;
import java.text.DecimalFormat;

public class Account {
    private int UserId;
    private int PIN;
    private int transfer_amount;
    private String recipient_name;
    private int recipient_account_number;
    private double balance= 750;
    private ArrayList<String> history= new ArrayList<String>();   

    Scanner input= new Scanner(System.in);
    DecimalFormat moneyFormat= new DecimalFormat("'$'###,##0.00");

    public int setUserId(int UserId){
        this.UserId= UserId;
        return UserId;
    }

    public int getUserId(){
        return UserId;
    }

    public int setPIN(int PIN){
        this.PIN= PIN;
        return PIN;
    }

    public int getPIN(){
        return PIN;
    }

    public double getBalance(){
        return balance;
    }

    public double calcWithdraw(double amount){

        balance= balance - amount;
        return balance;
        
    }

    public double calcDeposit(double amount){

        balance= balance + amount;
        return balance;

    }

    public void getWithdrawInput(){

        System.out.println("\nEnter the amount you want to withdraw: ");
        double amount= input.nextDouble();

        if((balance-amount)>=0){

            calcWithdraw(amount);
            System.out.println("\nAmount " + moneyFormat.format(amount) + " withdrawn successfully!!");
            System.out.println("\nNew Updated Balance: " + moneyFormat.format(balance));
            update(amount, "Withdraw", "Self");

        }

        else{
            System.out.println("\nInsufficient Balance");
            System.out.println("\nYour Account Balance: " + moneyFormat.format(balance));
        }

    }

    public void getDepositInput(){

        System.out.println("\nYour Account Balance: " + moneyFormat.format(balance));
        System.out.println("\nEnter the amount you want to deposit: ");
        double amount= input.nextDouble();

        if((balance+amount)>=0){

            calcDeposit(amount);
            System.out.println("\nAmount " + moneyFormat.format(amount) + " deposited successfully!!");
            System.out.println("\nNew Updated Balance: " + moneyFormat.format(balance));
            update(amount, "Deposit", "Self");

        }
        
    }

    public void transfer(){

        String recipient_first_name;
        String recipient_last_name;

        System.out.println("\nEnter the first name of recipient: ");
        recipient_first_name= input.next();

        System.out.println("\nEnter the last name of recipient: ");
        recipient_last_name= input.next();

        System.out.println("\nEnter the account number of recipient: ");
        recipient_account_number= input.nextInt();

        System.out.println("\nEnter the amount to be transfer: ");
        transfer_amount= input.nextInt();

        if(transfer_amount < balance){

            balance = balance - transfer_amount;
            recipient_name= recipient_first_name + " " + recipient_last_name;
            System.out.println("\nAmount " + moneyFormat.format(transfer_amount) + " transferred successfully!!");
            System.out.println("\nTransaction Details:");
            System.out.println("\nName of Recipient: " + recipient_name + "\nRecipient Account Number: " + recipient_account_number + "\nTransfered Amount: " + moneyFormat.format(transfer_amount));
            System.out.println("\nNew Updated Balance: " + moneyFormat.format(balance));
            update(transfer_amount, "Transfer", recipient_name);

        }
        
        else{
            System.out.println("\nInsufficient Balance to transfer the amount!!");
            System.out.println("\nYour Account Balance: " + moneyFormat.format(balance));
        }

    }

    public void update(double amount, String type , String name){

        history.add(type);
        history.add(Double.toString(amount));
        history.add(name);

    }

    public void transc_history(){
        
        if(history.size()==0){
            System.out.println("\nTransaction History: \n");
            System.out.println("No Transactions done!!\n");
        }

        else{
            System.out.println("\nTransaction History: \n");
            for(int i=0; i<history.size();){
                System.out.print(history.get(i) + " \t");
                i++;
                System.out.print(history.get(i) + " \t");
                i++;
                System.out.print(history.get(i) + "\n");
                i++;
            }
        }

    }
}
