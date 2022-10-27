// NAME:Khivansara Bhakti Rakesh
// JAVA PROGRAMMING
// TASK:TASK_3


package ATMINTERFACE;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ATMFUNC {
    DateTimeFormatter DTF=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    LocalDateTime now =LocalDateTime.now();
    float balance=0f;
    int trans=0;
    String transHistory="";
    String password;
    String act_no;
    String name;
    String userID;
    Scanner sc=new Scanner(System.in);

    public void register(){
        System.out.println("\nEnter Your Username  :");
        this.userID=sc.nextLine();
        System.out.println("Enter your Password  :");
        this.password=sc.nextLine();
        System.out.println("Enter your Account Number  :");
        this.act_no=sc.nextLine();
        System.out.println("Registration completed Successfully!");
        System.out.println("Please login to your account.");
    }


    public boolean login(){
        boolean isLogin=false;
        while(!isLogin){
            System.out.println("\nEnter Username : ");
            String usr=sc.nextLine();
            if (usr.equals(userID)){
                System.out.println("Enter Password : ");
                String pd=sc.nextLine();
                while(!isLogin){
                    if(pd.equals(password)){
                        System.out.println("Logged-in Successfully!!");
                        isLogin=true;
                    }
                    else{
                        System.out.println("Invalid login!!");
                        break;
                    }
                }
            }
            else{
                System.out.println("Username not found!!");
            }
        }
        return isLogin;
    }


    public void deposit(){
        System.out.println("\nEnter amount to deposit : ");
        float damount=sc.nextFloat();
        try{
            if(damount<=100000f){
                balance+=damount;
                trans+=1;
                System.out.println("Successfully deposited Rs. "+damount+" at "+DTF.format(now));
                String s="Rs "+damount+" deposited at "+DTF.format(now)+" .\n";
                transHistory=transHistory.concat(s);
            }
            else{
                System.out.println("Sorry!Can't deposit more than one lakh");
            }
        }
        catch(Exception e){
        }
    }


    public void withdraw(){
        System.out.println("\nEnter amount to withdraw : ");
        float wamount=sc.nextFloat();
        try{
            if (wamount<=balance){
                balance-=wamount;
                trans+=1;
                System.out.println("Successfully withdrawn Rs. "+wamount+" at "+DTF.format(now));
                String s="Rs "+wamount+" withdrawn at "+DTF.format(now)+" .\n";
                transHistory=transHistory.concat(s);
            }
            else{
                System.out.println("Sorry!Can't withdraw.Insufficient amount to withdraw..");
            }
        }
        catch(Exception e){
        }
    }



    public void transfer(){
        Scanner in=new Scanner(System.in);
        System.out.println("\nEnter the username you want to transfer to : ");
        String uname=in.nextLine();
        System.out.println("Enter the amount to transfer");
        float tamount=sc.nextFloat();
        try{
            if (tamount<=balance){
                balance-=tamount;
                trans+=1;
                System.out.println("Successfully transferred Rs. "+tamount+" at "+DTF.format(now));
                String s="Rs "+tamount+" transferred to "+uname+" account at "+DTF.format(now)+" .\n";
                transHistory=transHistory.concat(s);
            }
            else{
                System.out.println("Sorry!Can't transfer.Insufficient amount to transfer..");
            }
        }
        catch(Exception e){
        }
    }



    public void transHistory(){
        if(trans==0){
            System.out.println("\nNo Transactions!!");
        }
        else{
            System.out.println("\n"+transHistory);
        }
    }


    public void checkBal(){
        System.out.println("\nBalance amount is : "+balance);
    }

}
    

