import java.util.Scanner;
public class Person {
    //add attributes
    String name;
    String surname;
    String email;

    //constructor
    public Person(){
        //Get name as an input from user
        System.out.println("Please enter the personal details below :");
        Scanner user_input = new Scanner(System.in);
        System.out.println("Name : ");
        name = user_input.next();

        //Get surname as an input from user
        System.out.println("Surname : ");
        surname = user_input.next();

        //Get e-mail as an input from user
        System.out.println("E-mail : ");
        email = user_input.next();


    }



}
