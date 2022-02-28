import java.io.BufferedReader;
import java.io.InputStreamReader;

class Question1 {
     public static void main(String[] args) throws  Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Enter Length of Rectangle :");
         int l = Integer.parseInt(br.readLine());
         System.out.println("Enter Breadth of Rectangle :");
         int b = Integer.parseInt(br.readLine());
         System.out.println("Enter 1  to get the Area ");
         System.out.println("Enter 2  to get the Perimeter ");
         System.out.println("Enter 3 for to get the Diagonal ");
         int choice = Integer.parseInt(br.readLine());


         if(choice ==1 )
         {
             //Area
             int area = l * b;
             System.out.println("Area is : "+area);

         }
         else if(choice == 2)
         {
             //Perimeter
             int perimeter = 2 *(l+b);
             System.out.println("Perimeter is "+perimeter);

         }
         else if(choice == 3) {
             //Diagonal
             double diagonal  = Math.pow((l*l) + (b*b),0.5);
             System.out.println("Diagonal is "+diagonal);
         }

         }


     }

