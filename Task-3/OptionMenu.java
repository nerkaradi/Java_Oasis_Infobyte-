import java.util.*;
import java.io.IOException;
import java.text.DecimalFormat;

public class OptionMenu extends Account{
    Scanner menuInput= new Scanner(System.in);
    DecimalFormat moneyFormat= new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> record= new HashMap<Integer, Integer>();

    public void loginpage() throws IOException{
        int k;
        int c;

        do{
            k=1;
            c=1;
            try{
                record.put(1234, 5678);
                record.put(5678, 1234);
                
                System.out.println("\nWelcome to the ATM !!");
                System.out.println("\nEnter your User Id: ");
                setUserId(menuInput.nextInt());

                System.out.println("\nEnter your PIN: ");
                setPIN(menuInput.nextInt());
            }
            catch (Exception e){
                System.out.println("\nBad Input");
                k=2;
            }

            int id= getUserId();
            int pin= getPIN();

            if(record.containsKey(id) && record.get(id)== pin){
                homepage();
                k=2;
            }
            
            else{
                if(c>3){
                    System.out.print("\nToo many attempts, Session expired.\nPlzz Try Again Later!!");
                }

                else{
                    System.out.println("Invalid Credentials");
                    c++;
                }
            }

        } while(k==1);
    }

    public void homepage(){
        System.out.println("\nSeb   lect option from below: \n");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Funds");
        System.out.println("3. Deposit Funds");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit/Logout");
        System.out.println("\nEnter Choice: ");
        int selection= menuInput.nextInt();

        switch (selection){

            case 1:
            System.out.println("\nCurrent Account Balance: " + moneyFormat.format(getBalance()));
            homepage();
            break;

            case 2:
            getWithdrawInput();
            homepage();
            break;

            case 3:
            getDepositInput();
            homepage();
            break;

            case 4:
            transfer();
            homepage();
            break;

            case 5:
            transc_history();
            homepage();
            break;

            case 6:
            System.out.println("\nThank You for using our services, Have a Nice Day!\n");
            break;

            default:
            System.out.print("\nInvalid Choice, Plzz Try Again!");
            homepage();
            break;
        }
    }

}