import java.util.Scanner;

public class FloodFill
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mat[][] = new int[n][m];
        for(int i =0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

//        System.out.println("ENTER SOURCE");
        int _sR = sc.nextInt();
        int _sC = sc.nextInt();
//        System.out.println("Enter Colour");
        int _color = sc.nextInt();

      new FloodFill().floodFill(mat,_sR,_sC, _color);
      for(int i =0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(mat[i][j]);
            System.out.println();
        }

    }


    public    int[][] floodFill(int[][] im, int sr, int sc, int newColor)
    {
        int iniColor = im[sr][sc];
//        System.out.println("INITIAL COLOR "+iniColor);
//        System.out.println("FINAL COLOR "+newColor);


        int r = im.length;
        int c = im[0].length;
        boolean isvisited[][] = new boolean [r][c];
        bfs(im,sr,sc,newColor,iniColor, r,c,isvisited);


        return im;
    }
    void bfs(int [][] im, int sr, int sc, int newColor , int prevColor, int r, int c, boolean isvis[][])
    {
        if(sr>=r || sc>=c || sc<0 || sr<0)
            return;

        if(im[sr][sc] != prevColor)
            return;

//        if(im[sr][sc] == prevColor)

            if(!isvis[sr][sc]) {

                isvis[sr][sc] = true;
                im[sr][sc] = newColor;
                bfs(im, sr + 1, sc, newColor, prevColor, r, c,isvis);
                bfs(im, sr - 1, sc, newColor, prevColor, r, c,isvis);
                bfs(im, sr, sc + 1, newColor, prevColor, r, c,isvis);
                bfs(im, sr, sc - 1, newColor, prevColor, r, c,isvis);
            }
        isvis[sr][sc] = true;

        return  ;

    }

}
