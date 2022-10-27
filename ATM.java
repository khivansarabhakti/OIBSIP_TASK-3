// NAME:Khivansara Bhakti Rakesh
// JAVA PROGRAMMING
// TASK:TASK_3


package ATMINTERFACE;
import java.util.*;
public class ATM {
    public static void main(String args[]){
        System.out.println("WELCOME TO ATM!!!");
        System.out.println("\nSelect any one option!");
        System.out.println(" 1.REGISTER \n 2.EXIT");
        System.out.println("Enter your option :");
        Scanner sc=new Scanner(System.in);
        int ch;
        ch=sc.nextInt();
        if (ch==1){
            ATMFUNC ATM=new ATMFUNC();
            ATM.register();
            while(ch==1){
                System.out.println("\nSelect any one option!");
                System.out.println(" 1.LOGIN \n 2.EXIT");
                System.out.println("Enter your option :");
                int bank =sc.nextInt();
                if (bank==1){
                    if(ATM.login()){
                        boolean isFin=false;
                        while(!isFin){
                            System.out.println("\nSelect any option : ");
                            System.out.println("1.DEPOSIT\n2.WITHDRAW\n3.TRANSFER\n4.TRANSACTION HISTORY\n5.CHECK BALANCE\n6.EXIT");
                            System.out.println("Enter your choice :");
                            int c=sc.nextInt();
                            switch(c){
                            	case 1 : ATM.deposit();
                                    break;
                                case 2 : ATM.withdraw();
                                    break;
                                case 3 : ATM.transfer();
                                    break;
                                case 4 : ATM.transHistory();
                                    break;
                                case 5 : ATM.checkBal();
                                    break;
                                case 6 : isFin=true;
                                    break;
                                    
                                default: System.out.println("Invalid choice!");
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
        else {
            System.out.print("Please Collect Your Card \n");
            System.exit(0);
        }
    }

    
}
