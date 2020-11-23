import java.util.*;
public class nextpermutatiton
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int data[] = new int[n];
        for(int i = 0;i<n;i++)
        data[i] = sc.nextInt();
        
        data = nextPermutation(data);
        System.out.println(Arrays.toString(data));



        
    }

    static int[] swap (int data[],int i ,int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data [j] = temp;
        return data;
   }
    static int[] rev(int []data,int left,int right)
    {
        while(left<right)
        {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp; 
        }
        
        return data;
    }
  static int [] nextPermutation(int[] data)
    {
        int l = data.length;
        if(l>1)
        {
            int  last = l-2;
            while(last>=0)
            {
                if(data[last]<data[last+1])
                    break;
                last--;
            }
            if(last<0)
                Arrays.sort(data);
          else if(last>=0)
            {
                int next = l-1;
                for(int i = l-1;i>last;i--)
                {
                    if(data[i]>data[last])
                    {
                        next = i;
                        break;
                    }
                }
                
                data = swap(data,next,last);
                data = rev(data,last+1,l-1);            
                    
            }
            
        }
        return data;
        
    }
    
}
