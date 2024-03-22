public class Ticket {
    //add attributes
    int row;
    int seat;
    double price;
    Person person;

    //constructor
    public Ticket(int r, int s, double pr, Person p){
        row = r;
        seat = s;
        price = pr;
        person = p;

    }
    //Create print method
    public void print(){
        System.out.println("-----Ticket Information-----\nName :"+ person.name +" "+ person.surname + "\tE-mail :" + person.email +"\tRow :"+ row +"\tSeat No: "+ seat +"\tTicket Price:"+ price);


    }

}
