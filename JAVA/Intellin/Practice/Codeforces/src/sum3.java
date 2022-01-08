import java.util.*;

public class sum3
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ar[] = new int[n];

        for(int i = 0; i < n; i++)
            ar[i] = sc.nextInt();
        List<List<Integer>> res = new sum3().threeSum(ar);
        System.out.println(res);


    }


    public List<List<Integer>> threeSum(int[] nums1) {
        List<List<Integer>> res = new ArrayList<>();

        HashSet<pair> hs = new HashSet<>();

        Arrays.sort(nums1);


        int size = nums1.length;


        for(int i  =0 ;i<size-2;i++)
        {
            for(int j = i+1;j<size-1;j++)
            {

                int sum = nums1[i]+nums1[j];
                int key ;
                if(sum>0)
                    key = -1* sum;
                else
                    key = Math.abs(sum);

                int ind = binarySearch(nums1,j+1, size-1,key);
                if(ind!=-1)
                {

                    int a[] = new int[3];
                    a[0] = nums1[i];
                    a[1] = nums1[j];
                    a[2] = nums1[ind];
                    Arrays.sort(a);
                    pair p = new pair(a[0], a[1], a[2]);
                    if(hs.contains(p) ==  false)
                    {
                        hs.add(p);
                        List<Integer> ar = new ArrayList<Integer>();
                        ar.add(a[0]);
                        ar.add(a[1]);
                        ar.add(a[2]);
                        res.add(ar);
                    }



                }



            }
        }

        return res;

    }

        int binarySearch(int arr[], int l, int r, int x)
        {
            if (r >= l) {
                int mid = l + (r - l) / 2;


                if (arr[mid] == x)
                    return mid;

                if (arr[mid] > x)
                    return binarySearch(arr, l, mid - 1, x);


                return binarySearch(arr, mid + 1, r, x);
            }

            return -1;
        }



    static class pair{
        int a, b, c;


        pair(int x, int y, int z)
        {
            a = x;
            b = y;
            c = z;

        }
        @Override
        public int hashCode()
        {
            int prime = 31;
            int result = 1;
            result = prime * result +  a;
            result = prime * result + b;
            result = prime * result + c;
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if(this ==  obj)
                return true;
            if(obj == null)
                return false;
            if(getClass() != obj.getClass())
                return false;

            pair other = (pair) obj;
            if(a != other.a)
                return false;
            if(b != other.b)
                return false;
            if(c != other.c)
                return false;
            return true;
        }



    }
}
