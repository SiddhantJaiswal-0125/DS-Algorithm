import java.util.*;
public class FindAllFourSumNumbers 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int k = sc.nextInt();
        for(int  i =0;i<n;i++)
             a[i] = sc.nextInt();
        ArrayList<ArrayList<Integer> >  al = solve(a,k);
       System.out.println(al);
    
    }
    static  ArrayList<ArrayList<Integer>> solve(int A[], int X)
    {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        Arrays.sort(A);
        int n = A.length;
       
        int l =0, r=0;
        for (int i = 0; i < n - 3; i++)  
        { 
            for (int j = i + 1; j < n - 2; j++)  
            { 
                // Initialize two variables as indexes of the first and last  
                // elements in the remaining elements 
                l = j + 1; 
                r = n - 1; 
  
                // To find the remaining two elements, move the index  
                // variables (l & r) toward each other. 
                while (l < r)  
                { 
                    if (A[i] + A[j] + A[l] + A[r] == X)  
                    { 
                        ArrayList <Integer> tr = new ArrayList<>();
                        tr.add(A[i]);
                        tr.add(A[j]);
                        tr.add(A[l]);

                        tr.add(A[r]);
                        al.add(tr);

                        l++; 
                        r--; 
                    }  
                    else if (A[i] + A[j] + A[l] + A[r] < X) 
                        l++; 
                    else // A[i] + A[j] + A[l] + A[r] > X 
                        r--; 
                } // end of while 
            } // end of inner for loop 
        } // end of outer for loop 
        
        



        return al;
    }
    
}
