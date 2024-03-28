import java.util.Scanner;

public class UserInterface {
    public static void main(String args[])
    {   
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the room(in m)");
        double length = sc.nextDouble();
        if(length<=0){
            System.out.println("Invalid length");
            return;
        }
        System.out.println("Enter the breadth of the room(in m)");
        double breadth = sc.nextDouble();
        if(breadth<=0){
            System.out.println("Invalid breadth");
            return;
        }
        System.out.println("Enter the plant area of a single plant(in cm2)");
        double area = sc.nextDouble();
        if(area<=0){
            System.out.println("Invalid plant area");
            return;
        }
        
        area = area/10000;
        
        int totalplant = (int) Math.round(length*breadth/area);
        if(totalplant % 10 != 0){
            totalplant=totalplant-totalplant%10;
        }
        double totaloxygen = totalplant*0.9;
        System.out.println("Total number of plants is " + totalplant);
        System.out.printf("Total oxygen production is %.2f litres" , totaloxygen);
    
    }

}
