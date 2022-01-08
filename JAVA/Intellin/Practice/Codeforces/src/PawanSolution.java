import java.util.Scanner;

public class PawanSolution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input[] = new int[10];
        for(int i  = 0;i<10;i++)
            input[i] = sc.nextInt();
        int out[] =  new PawanSolution().hash_and_store(input);
        for(int i:out)
            System.out.print(i+"\t");

    }
    public int[] hash_and_store(int input1[])
    {
        Integer out[] = new Integer[10];
        for(int i =0;i<10;i++)
            out[i] = null;



        out[input1[0]%10] = input1[0];
        for(int i =1;i<10;i++)
        {

            int k = lastdigit(input1[i]);
            if(out[k]==null)
            {
                out[k] = input1[i];
            }
            else
            {
                //rehash

                rehash(input1[i],k, out, input1[i]);




            }


        }


        int a[] = new int[10];
        for(int i =0;i<10;i++)
            a[i] = out[i];
        return a;
    }



    void rehash(int removednum, int j , Integer[] out, int realNum)
    {
        if(out[j]==null) {
            out[j] = realNum;
        return;
        }
        else
            {

                int last = lastdigit(removednum);
                int changed =  removelast(removednum); //steps to be taken
                if(last%2==0)
                {
                    //even

                    moveBackward(last, out, realNum, changed, changed);





                }
                else
                {
                    //odd


//                    moveforward();
                    moveForward(last, out, realNum, changed, changed);
                }






            }

    }

    void moveBackward(int currentLocation , Integer ar[], int realNum, int steps, int changedNum)
    {

        if(steps>currentLocation)
        {
            steps-=  currentLocation;
            currentLocation = 10;
            moveBackward(currentLocation, ar, realNum, steps,changedNum);
        }
        else
        {
            currentLocation-=steps;
            if(ar[currentLocation]==null)
            {
                //add it
                ar[currentLocation] = realNum;
                return;
            }
            else
            {
                 rehash(changedNum,currentLocation, ar, realNum);
                 return;
            }
        }


    }

    void moveForward(int currentLocation , Integer ar[], int realNum, int steps, int changedNum)
    {


        currentLocation = (currentLocation+ steps)%10;

        if(ar[currentLocation]==null)
            {
                //add it
                ar[currentLocation] = realNum;
                return;
            }
            else
            {
                rehash(changedNum,currentLocation, ar, realNum);
                return;
            }



    }





    int lastdigit(int a)
    {
        return a%10;
    }

    int removelast(int a)
    {
        return a/10;
    }

}
