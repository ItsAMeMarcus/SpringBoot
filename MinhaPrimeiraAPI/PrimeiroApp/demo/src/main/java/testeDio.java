import java.io.IOException;
import java.util.Scanner;

public class testeDio {

	  public static void main(String[] args) throws IOException {
		  double h = 0;
		  Scanner sc = new Scanner(System.in);
		  double n = sc.nextDouble();
		
		  for (int i = 1; i <= n; i++) {
			  double x = i;
			  h = h + 1/x * 1.0;
		  }
		  sc.close();
		  int intH = (int) Math.round(h);
		  System.out.println(intH);
	  }

}
