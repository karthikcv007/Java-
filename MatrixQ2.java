import java.util.Scanner;
public class MatrixQ2
{
    String x;
    int A[][];
    int r,c;
    //String[] a;
    public void set1(String[] a,int r,int c)
    {
        int k=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                //A[i][j]=Integer.parseInt(a[i]);
                System.out.print(a[k+2]+" ");
                k++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        MatrixQ2 q=new MatrixQ2();
        int r=Integer.parseInt(args[0]);
        int c=Integer.parseInt(args[1]);
        q.set1(args,r,c);
    }
}

