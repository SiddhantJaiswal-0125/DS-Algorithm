
import java.util.*;
public class BeforeanExam
{

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int d = sc.nextInt();
	int sumTime = sc.nextInt();
	int min[] = new int[d];
	int max[] = new int[d];
	for(int i =0;i<d;i++)
	{
		min[i] = sc.nextInt();
		max[i] = sc.nextInt();
	}


	int time[] = new int[d];
	boolean all = false;


	for(int i =0;i<d;i++)
	{
		if(sumTime>=min[i])
		{
			sumTime -= min[i];
			time[i] = min[i];

		}
		else
		{
			all = true;
			break;
		}
			
	}
	

		for(int i =0;i<d;i++)
		{
			

				if(sumTime>= max[i]- min[i])
				{
					time[i] = max[i];
					sumTime -= max[i] - min[i];
				}
				else
				{
					time[i] += sumTime;
					sumTime = 0;


				}


			


		}


	



	if(sumTime>0 || all)
	{
		System.out.println("NO");
	}
	else
	{

		System.out.println("YES");

		for(int i : time)
			System.out.print(i+" ");

		System.out.println();


	}







}


}