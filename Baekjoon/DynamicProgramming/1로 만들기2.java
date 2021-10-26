import java.util.*;
import java.io.*; 

public class Main {

	public static void main(String[] args) throws IOException{ 
		Scanner sc = new Scanner(System.in); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt(); 
		int[][] d = new int[n+1][2]; 
		

		for(int i=2; i<=n; i++) {
			if(i%3 == 0 && i%2 == 0 ) {
				if(d[i/3][0] < d[i/2][0]) {
					d[i][0] = d[i/3][0]+1;
					d[i][1] = i/3;
				}
				else {
					d[i][0] = d[i/2][0]+1;
					d[i][1] = i/2;
				}
			}
			else if(i%3 == 0) {
				d[i][0] = d[i/3][0]+1;
				d[i][1] =  i/3; 
			}
			else if(i%2 == 0) {
				d[i][0] = d[i/2][0]+1;
				d[i][1] =  i/2; 
			}
			else {
				d[i][0] = d[i-1][0]+1;
				d[i][1] = i-1; 
			}
			if(d[i][0]>d[i-1][0]+1) {
				d[i][0] = d[i-1][0]+1;
				d[i][1] = i-1; 
			}
		}
		
		int x = n; 
		int cnt = -1;

		while(x!=0) {
			cnt++; 
        	bw.write(x+" "); 
        	x = d[x][1]; 
        }
		System.out.println(cnt);
		bw.flush();
		bw.close();
        
    }
}