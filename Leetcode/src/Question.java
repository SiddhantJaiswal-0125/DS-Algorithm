import java.io.BufferedReader;
import java.io.InputStreamReader;

class Question3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Cost Price :");
        int cp = Integer.parseInt(br.readLine());
        System.out.println("Enter the Selling Price :");
        int sp = Integer.parseInt(br.readLine());
        if (cp > sp) {
            //Loss
            int loss = cp - sp;
            double losspercent = ((double) loss / (double) cp) * 100;
            System.out.println("Loss Percent is -" + losspercent + "%");

        } else if (cp < sp) {
            //Profit
            int profit = sp - cp;
            double profitpercent = ((double) profit / (double) cp) * 100;
            System.out.println("Loss Percent is " + profitpercent + "%");
        } else {
            //NO PROFIT AND LOSS
            System.out.println("There is No Loss and No Profit");
        }
    }
}

