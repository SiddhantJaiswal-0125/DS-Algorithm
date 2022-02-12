class pas
{
	public static void main(String args[])
	{
		int n = 5;
		pascal(n);	



	}
	static void pascal(int n )
	{
		
	int mat [][] = new int [n][n];
	mat[0][0]  = 1;
	for(int i =1;i<n;i++)
	{
		for(int j = 0;j<=i;j++)
		{
			if(j==0)
			mat[i][j] = mat[i-1][j];
			else if(j==i)
			mat[i][j] = mat[i-1][j-1];
			else
			mat[i][j] = mat[i-1][j-1]+ mat[i-1][j];
				
		}
	}


	for(int i =0;i<n;i++)
	{
		for(int j = 0;j<=i;j++)
		System.out.print(mat[i][j]+"  ");
 
		System.out.println();
	}
			
		
	}

	
 			




	

}