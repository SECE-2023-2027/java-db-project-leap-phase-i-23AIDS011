/*public class Control {
    public static void main(String[] args) {
        int age = 15;
        if (age > 18) {
            System.out.println("Eligible to vote");
        }
        else{
            System.out.println("Not eligible to vote");
        }
    }
}*/

/*import java.util.Scanner;

public class Control {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the age:");
        int age=sc.nextInt();
        if (age > 18) {
            System.out.println("Eligible to vote");
        }
        else{
            System.out.println("Not eligible to vote");
        }
    }
}
 */
/*
import java.util.Scanner;

public class Control {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the mark:");
        int mark=sc.nextInt();
        if ((mark > 80)&&(mark<=100)) {
            System.out.println("S Grade");
        }
        else if ((mark > 50)&&(mark<=80)) {
            System.out.println("E Grade");
        }
        else if ((mark > 30)&&(mark<=50)) {
            System.out.println("C Grade");
        }
        else{
            System.out.println("Fail");
        }
    }
}
*/

import java.util.Scanner;

public class Control {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the age:");
        int age=sc.nextInt();
        if (age > 18) {
            System.out.println("Eligible to vote");
            if(age>50){
                System.out.println("Eligible to get pension");
            }
            else{
                System.out.println("Not eligible yo get pension");
            }
        }
        else{
            System.out.println("Not eligible to vote");
        }
    }
}