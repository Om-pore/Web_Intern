import java.util.Scanner;

interface InnerATM {    
    boolean Withdraw(float amt);
    void Deposit(float amt);
    float Checkbalance();
}

public class ATM implements InnerATM{


    private float Balance = 0;

    public ATM(float Balance){
        this.Balance = Balance;
    }

    @Override
    public boolean Withdraw(float amt) {
        if(amt <= Balance){
            Balance -= amt; 
            return true;  
        }
        return false;
        
    }

    @Override
    public void Deposit(float amt) {
        Balance += amt;
    }

    @Override
    public float Checkbalance() {
        return Balance;
    }
}

class User_Bank extends ATM{
    static float balance = 0;

    public User_Bank(float Balance) {
        super(Balance);
    }

    
    public static void main(String[] args) {
        User_Bank ub = new User_Bank(5000);
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("------------Start-------------");
            
            System.out.println("1. Check Balance.");
            System.out.println("2. Deposite.");
            System.out.println("3. Withdraw.");
            System.out.println("4. Exit.");

            System.out.println("Enter the choice (1-4) :");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is : Rs. "+ub.Checkbalance());
                    break;

                case 2:
                    System.out.println("Enter the amount to deposit :");
                    float depositAmt = sc.nextFloat();
                    ub.Deposit(depositAmt);
                    System.out.println("Deposit Successfully. Your balance : Rs. "+ub.Checkbalance());
                    break;

                case 3:
                    System.out.println("Enter the amount to withdraw :");
                    float withdrawAmt = sc.nextFloat();
                    if(ub.Withdraw(withdrawAmt)){
                        System.out.println("Withdrawal Successfully. Your balance : Rs. "+ub.Checkbalance());
                    }
                    else{
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you!");
                    sc.close();
                    break;
            
                default:
                    System.out.println("Invalid choice. Please enter valid choice!");
                    break;
            }
            System.out.println("------------End-------------");

        }


    }

} 
