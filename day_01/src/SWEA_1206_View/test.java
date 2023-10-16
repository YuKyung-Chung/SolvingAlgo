package SWEA_1206_View;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException{
        File file = new File("src/SWEA_1206_View/input.txt");
        
        Scanner sc = new Scanner(file);
        
        for (int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();
            int[] bld = new int [N];
            int brightRoom = 0;
                        
            for (int i = 0; i < N; i++)
                bld[i] = sc.nextInt();
            
            for (int i = 2; i < N-2; i++)
            {
                int min = 255;

                int[] diff = new int [4];
                diff[0] = bld[i] - bld[i-2];
                diff[1] = bld[i] - bld[i-1];
                diff[2] = bld[i] - bld[i+1];
                diff[3] = bld[i] - bld[i+2];
                
                for (int j = 0; j < 4; j++)
                {
                    if (diff[j] < 1)
                    {
                        min = 0;
                        break;
                    }
                    if (min > diff[j]) min = diff[j];
                }
                //System.out.println("bld : " + bld[i] + " min : " + min);
                brightRoom += min;
            }
            System.out.println("#" + test_case + " " + brightRoom);
        }
        
    }
}