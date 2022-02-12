package General;

//package General;
public class Employee
{
    protected  int empid;
    private String ename ;
    static int id = 0;

   public  Employee( String name )
    {
        id++;
        empid = id;
        ename = name;




    }
    public String getEmployName()
    {
        return  ename;
    }
    public int getEmployId()
    {
        return  empid;
    }

    public double earnings(int basic)
    {
        double   res =  (double) (basic + (0.8 * basic) + ((0.15) * basic));

        return res;

    }


}