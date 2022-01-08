import java.util.Scanner;

 class MaximiseIslands
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test =  sc.nextInt();
        while(test -->0)
        {
            int n  = sc.nextInt();
            int m = sc.nextInt();
            char c1[][] = new char[n][m];
            char c2[][] = new char[n][m];
            String inp[] = new String[n];

            for(int  i =0;i<n;i++)
                inp[i] = sc.next();





            if(m%2==0 || n%2==0)
            {
                long count1 = 0l;
                long coun2 = 0l;
                //check with both
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++)
                    {

                        if(i%2==0){
                            if(j%2==0)
                            {

                                c1[i][j] = '*';
                                c2[i][j] = '.';
                            }
                            else
                            {
                                c1[i][j] = '.';
                                c2[i][j] = '*';
                            }


                        }
                        else
                        {
                            if(j%2==0)
                            {

                                c1[i][j] = '.';
                                c2[i][j] = '*';
                            }
                            else
                            {
                                c1[i][j] = '*';
                                c2[i][j] = '.';
                            }


                    }
                }


                }

                for (int i = 0; i < n; i++)
                {
                    for (int j = 0; j < m; j++)
                    {
                        char c = inp[i].charAt(j);

                        if(c!=c1[i][j])
                            count1++;

                        if(c!=c2[i][j])
                            coun2++;
                    }
                }

                System.out.println(Math.min(coun2,count1));

                }




            else
            {

                long count  =0l;

                //m is odd and n both are odd
                char desired [][] = new char[n][m];


                for (int i = 0; i < n; i++)
                {
                    for (int j = 0; j < m; j++)
                    {

                        if(i%2==0) {

                            if(j%2==0)
                            {

                               desired[i][j] = '*';
                            if(inp[i].charAt(j)!=desired[i][j])
                                count++;
                            }
                            else
                            {
                                desired[i][j] = '.';
                                if(inp[i].charAt(j)!=desired[i][j])
                                    count++;

                            }


                        }
                        else
                        {
                            if(j%2==0)
                            {

                                desired[i][j] = '.';
                                if(inp[i].charAt(j)!=desired[i][j])
                                    count++;
                            }
                            else
                            {
                                desired[i][j] = '*';
                                if(inp[i].charAt(j)!=desired[i][j])
                                    count++;
                            }
                        }



                    }

            }
                System.out.println(count);



        }



        }
    }


}
