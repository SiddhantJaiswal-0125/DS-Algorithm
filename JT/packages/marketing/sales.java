package marketing;
import General.Employee;

public class sales  extends Employee {
    int basicamount ;
    double res ;
   public sales(String name, int ba)
    {
        super(name);
        basicamount = ba;
        res = this.earnings(basicamount);
    }

    public double tallowance()
    {

        return res * 0.05;

    }
    public double totalEarning()
    {
        return res + (res*0.05);

    }

}
