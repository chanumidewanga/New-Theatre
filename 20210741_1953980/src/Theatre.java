import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Theatre{

    //buy ticket method
    public static void buyTicket(ArrayList<Ticket> tarray) {

        //create Person class object
        Person person1 = new Person();

        boolean invalid = false;

        int selected_row;
        int selected_seat;

        do {
            selected_row = 0;
            selected_seat = 0;

            try {
                // Get row no and seat no from user
                System.out.println("\nEnter the row number and seat number to make the booking.");
                Scanner user_input = new Scanner(System.in);
                //Get row number from user
                System.out.println("Row number : ");
                selected_row = user_input.nextInt();

                //Check the row number is valid
                if (selected_row > 0 && selected_row <= 3) {
                    //Get seat number from user
                    System.out.println("Seat number : ");
                    selected_seat = user_input.nextInt();

                    if (selected_row == 1) {
                        //Validate user input for seat number
                        if (selected_seat > 12 || selected_seat <= 0) {
                            System.out.println("Invalid seat number. Please try again.");
                            invalid = true;

                        } else {
                            //check availability of the seat and print the availability
                            invalid =true;
                            if (row1[selected_seat - 1] == 1) {
                                System.out.println("Seat is unavailable. Please try another booking. ");
                            } else {
                                //update the row information array as the seat is occupied
                                row1[selected_seat - 1] = 1;
                                //print the booking successful message
                                System.out.println("Seat is available. Your booking for row " + selected_row + " seat " + selected_seat + " is successful." );
                                break;
                            }
                        }
                    } else if (selected_row == 2) {

                        //Validate user input for seat number
                        if (selected_seat > 16 || selected_seat <= 0) {
                            System.out.println("Invalid seat number. Please try again.");
                            invalid = true;
                        } else {
                            //check availability of the seat and print the availability
                            invalid = true;
                            if (row2[selected_seat - 1] == 1) {
                                System.out.println("Seat is unavailable. Please try another booking.");
                            } else {
                                //update the row information array as the seat is occupied
                                row2[selected_seat - 1] = 1;
                                //print the booking successful message
                                System.out.println("Seat is available. Your booking for row " + selected_row + " seat " + selected_seat + " is successful.");
                                break;
                            }
                        }

                    } else if (selected_row == 3) {

                        //Validate user input for seat number
                        if (selected_seat > 20 || selected_seat <= 0) {
                            System.out.println("Invalid seat number. Please try again.");
                            invalid = true;
                        } else {
                            //check availability of the seat and print the availability
                            invalid = true;
                            if (row3[selected_seat - 1] == 1) {
                                System.out.println("Seat is unavailable. Please try another booking.");
                            } else {
                                //update the row information array as the seat is occupied
                                row3[selected_seat - 1] = 1;
                                //print the booking successful message
                                System.out.println("Seat is available. Your booking for row " + selected_row + " seat " + selected_seat + " is successful.");
                                break;
                            }
                        }
                    }
                } else
                    System.out.println("Invalid row number. Please try again.");
                invalid = true;

            //Error handling for mismatched input types
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");

            }
        }while (invalid == true);

        //Get the ticket price
        Scanner user_input = new Scanner(System.in);
        System.out.println("\nInsert the ticket price: ");
        double ticketPrice = user_input.nextDouble();

        //create Ticket class object
        Ticket ticket1 = new Ticket(selected_row, selected_seat, ticketPrice, person1);

        // add Ticket to the Array List
        tarray.add(ticket1);

    }


    //print seating area method
    public static void printSeatingArea(){
        //Print heading
        System.out.println("    ***********\n    *  STAGE  *\n    ***********");

        // print row 1 array using a for loop
        System.out.print("    ");
        for (int i=0; i<row1.length; i++){
           if(i==6){
               System.out.print(" ");
           }

           if(row1[i]==0){
                System.out.print("O");
           }

           else{
                System.out.print("X");
           }

        }
        System.out.print("\n");

        // print row 2 array using a for loop
        System.out.print("  ");
        for (int i=0; i<row2.length; i++){

            if(i==8){
                System.out.print(" ");
            }

            if(row2[i]==0){
                System.out.print("O");
            }

            else{
                System.out.print("X");
            }
        }
        System.out.print("\n");

        // print row 3 array using a for loop
        for (int i=0; i<row3.length; i++){
            if(i==10){
                System.out.print(" ");
            }

            if(row3[i]==0){
                System.out.print("O");
            }

            else{
                System.out.print("X");
            }

        }
        System.out.print("\n");
    }


    //Cancel ticket method
    public static void cancelTicket(ArrayList<Ticket> tarray){

        boolean invalid = false;

        do{
            try{
                //Get row number from user
                Scanner user_input = new Scanner(System.in);
                System.out.println("Please insert the row number: ");
                int selected_row = user_input.nextInt();

                //Get seat number from user
                System.out.println("Please insert the seat number: ");
                int selected_seat = user_input.nextInt();

                if (selected_row==1){
                    //Validate seat number
                    if (selected_seat>12 || selected_seat<=0){
                        System.out.println("Invalid seat number.");
                        invalid = true;
                    }
                    else{
                        invalid=false;
                        //Check the availability of the seat
                        if(row1[selected_seat-1] ==0){
                            System.out.println("Seat is not booked. So you can't cancel.");
                        }
                        else{
                            //Update the row information array as the seat is available again
                            row1[selected_seat-1] =0;
                            System.out.println("Seat booking has been cancelled.");

                            //remove the ticket from ticket array
                            for (int i = 0; i < tarray.size(); i++) {
                                if(tarray.get(i).row == selected_row && tarray.get(i).seat == selected_seat ){
                                    tarray.remove(i);
                                    System.out.println("Ticket has been removed.");

                                }
                            }


                        }
                    }
                }

                else if (selected_row==2){

                    //Validate seat number
                    if (selected_seat>16 || selected_seat<=0){
                        System.out.println("Invalid seat number.");
                        invalid = true;
                    }
                    else{
                        //Check the availability of the seat
                        invalid=false;
                        if(row2[selected_seat-1] ==0){
                            System.out.println("Seat is not booked. So you can't cancel.");
                        }
                        else{
                            //Update the row information array as the seat is available again
                            row2[selected_seat-1] =0;
                            System.out.println("Seat booking has been cancelled.");

                            //remove the ticket from ticket array
                            for (int i = 0; i < tarray.size(); i++) {
                                if(tarray.get(i).row == selected_row && tarray.get(i).seat == selected_seat ){
                                    tarray.remove(i);
                                    System.out.println("Ticket has been removed.");

                                }
                            }

                        }
                    }

                }

                else if (selected_row==3){

                    //Validate seat number
                    if (selected_seat>20 || selected_seat<=0){
                        System.out.println("Invalid seat number.");
                        invalid = true;
                    }
                    else{
                        //Check the availability of the seat
                        invalid=false;
                        if(row3[selected_seat-1] ==0){
                            System.out.println("Seat is not booked. So you can't cancel.");
                        }
                        else{
                            //Update the row information array as the seat is available again
                            row3[selected_seat-1] =0;
                            System.out.println("Seat booking has been cancelled.");

                            //remove the ticket from ticket array
                            for (int i = 0; i < tarray.size(); i++) {
                                if(tarray.get(i).row == selected_row && tarray.get(i).seat == selected_seat ){
                                    tarray.remove(i);
                                    System.out.println("Ticket has been removed.");

                                }
                            }
                        }
                    }
                }

                else{
                    System.out.println("Invalid row number.");
                    invalid = true;
                }
            }

            catch (InputMismatchException e) {
                
                System.out.println("Invalid input. Please try again.");
            }

        }
        while(invalid==true);
    }

    //List available seats method
    public static void showAvailable(){

        //Show available seats in row 1
        System.out.print("\nSeats available in row 1 : ");

        for(int i=0; i<row1.length;i++){
            if (row1[i]!=1){
                System.out.print((i+1) +", ");
            }
        }

        //Show available seats in row 2
        System.out.print("\nSeats available in row 2 : ");

        for(int i=0; i<row2.length;i++){
            if (row2[i]!=1){
                System.out.print((i+1) +", ");
            }
        }

        //Show available seats in row 3
        System.out.print("\nSeats available in row 3 : ");

        for(int i=0; i<row3.length;i++){
            if (row3[i]!=1){
                System.out.print((i+1) +", ");
            }
        }
        System.out.println(" ");
    }

    //Save to file method
    public static void save(){
        try{
            //write to a file
            FileWriter myWriter = new FileWriter("Row_Information.txt");

            //print row 1 array information
            for (int i=0; i<row1.length; i++){

                myWriter.write(row1[i] + "");
                }
            myWriter.write( "\n");

            //print row 2 array information
            for (int i=0; i<row2.length; i++){

                myWriter.write(row2[i] + "");
            }
            myWriter.write( "\n");

            //print row 3 array information
            for (int i=0; i<row3.length; i++){

                myWriter.write(row3[i] + "");
            }

            myWriter.close();
            System.out.println("\nFile saved successfully.");
            }

        catch(IOException e){
            System.out.println("\nCouldn't save file.");
        }
    }

    //Load from file method
    public static void load(){
        try{
            //Read from the file
            File file = new File("Row_Information.txt");
            Scanner file_reader = new Scanner(file);

            int lineNo = 1;

            while (file_reader.hasNextLine()) {
                String text = file_reader.nextLine();
                System.out.println(text);

                if(lineNo==1){
                    //restore row1
                    //split the text from the file and store in a new array
                    String [] row1_data = text.split("");

                    for (int i = 0; i < row1.length; i++) {
                        //convert string to integer and store in row 1 array
                        row1[i] = Integer.parseInt(row1_data[i]);
                    }

                }
                else if(lineNo==2){
                    //restore row2
                    //split the text from the file and store in a new array
                    String [] row2_data = text.split("");

                    for (int i = 0; i < row2.length; i++) {
                        //convert string to integer and store in row 2 array
                        row2[i] = Integer.parseInt(row2_data[i]);
                    }

                }
                else if(lineNo==3){
                    //restore row3
                    //split the text from the file and store in a new array
                    String [] row3_data = text.split("");

                    for (int i = 0; i < row3.length; i++) {
                        //convert string to integer and store in row 3 array
                        row3[i] = Integer.parseInt(row3_data[i]);
                    }

                }

                lineNo++;
            }
            System.out.println("\nFile loaded successfully.");

        }
        catch(IOException e){
            System.out.print("\nError while loading the file.");
        }
    }

    //Print ticket information and total price method
    public static void show_ticket_info(ArrayList<Ticket> tarray){

        //print all ticket information
        double total = 0;
        for (int i = 0; i < tarray.size() ; i++) {
            tarray.get(i).print();
            //calculate total ticket price
            total = total + tarray.get(i).price;
        }

        //print the total ticket price
        System.out.println("Total:" + total);
    }

    // Sort tickets by price  method
    public static void sortTickets(ArrayList<Ticket> tarray){
        //uses Bubblesort for sorting algorithm
        int bottom = tarray.size()-2;
        Ticket temp;
        boolean exchanged = true;

        while (exchanged){
            exchanged= false;

            for (int i = 0; i<= bottom; i++){
                if (tarray.get(i).price > tarray.get(i+1).price){
                  temp = tarray.get(i);
                  tarray.set(i,tarray.get(i+1));
                  tarray.set(i+1,temp);

                    exchanged = true;

                }
            }
            bottom--;
        }

        //print ticket information in ascending order of the ticket price
        for (int i = 0; i <tarray.size(); i++) {
            System.out.println("Price : " + tarray.get(i).price + "\tRow : " + tarray.get(i).row + "\tSeat : " + tarray.get(i).seat + " Name : " + tarray.get(i).person.name + " " + tarray.get(i).person.surname + " Email : " + tarray.get(i).person.email);
        }
    }

    // Quit method
    public static void quit(){
        System.out.println("You are now quitting the program");
    }

    //Adding arrays for each row
    public static int[] row1 = new int[12];
    public static int[] row2 = new int[16];
    public static int[] row3 = new int[20];

    //main method
    public static void main(String[] args){

        //create an arraylist to store ticket information
        ArrayList<Ticket> ticketarray = new ArrayList<Ticket>();


        //Display welcome message
        System.out.println("Welcome to the New Theatre!");

        //Set all seats as available
        Arrays.fill(row1, 0);
        Arrays.fill(row2, 0);
        Arrays.fill(row3, 0);

        int selected_op=99;
        do{
            //Display menu
            System.out.println("--------------------------------------------------");
            System.out.println("1) Buy a ticket\n2) Print seating area\n3) Cancel ticket\n4) List available seats\n5) Save to file\n6) Load from file\n7) Print ticket information and total price\n8) Sort tickets by price\n0) Quit");
            System.out.println("--------------------------------------------------");
            //Get user input for the menu
            Scanner user_input = new Scanner(System.in);
            System.out.println("Please insert an option from the menu: ");

            selected_op = user_input.nextInt();

            switch (selected_op){
                case 1:
                    //Buy a ticket
                    buyTicket(ticketarray);
                    break;

                case 2:
                    //Print seating area
                    printSeatingArea();
                    break;

                case 3:
                    //Cancel ticket
                    cancelTicket(ticketarray);
                    break;

                case 4:
                    //List available seats
                    showAvailable();
                    break;

                case 5:
                    //Save to file
                    save();
                    break;

                case 6:
                    //Load from file
                    load();
                    break;

                case 7:
                    //Print ticket information and total price
                    show_ticket_info(ticketarray);
                    break;

                case 8:
                    //Sort tickets by price
                    sortTickets(ticketarray);
                    break;

                case 0:
                    //Quit
                    quit();
                    break;
                default:
            }
        }while(selected_op!=0);
    }
}
