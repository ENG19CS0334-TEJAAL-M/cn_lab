import java.util.*;
class crc {
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		int n;
		System.out.println("Enter the size of the data:");
		n = scan.nextInt();
		int data[] = new int[n];

		System.out.println("Enter the data, bit by bit:");
		for(int i=0 ; i < n ; i++) {
			System.out.println("Enter bit number " + (n-i) + ":");
			data[i] = scan.nextInt();
		}
		
		System.out.println("Enter the size of the divisor:");
		n = scan.nextInt();
		int divisor[] = new int[n];
		System.out.println("Enter the divisor, bit by bit:");
		for(int i=0 ; i < n ; i++) {
			System.out.println("Enter bit number " + (n-i) + ":");
			divisor[i] = scan.nextInt();
		}
		// Divide the inputted data by the inputted divisor
		// Store the remainder that is returned by the method
		int remainder[] = divide(data, divisor);
		for(int i=0 ; i < remainder.length-1 ; i++) {
			System.out.print(remainder[i]);
		}
		System.out.println("\nThe CRC code generated is:");
		for(int i=0 ; i < data.length ; i++) {
			System.out.print(data[i]);
		}
		for(int i=0 ; i < remainder.length-1 ; i++) {
			System.out.print(remainder[i]);
		}
		System.out.println();
	}
	static int[] divide(int old_data[], int divisor[]) {
		int remainder[] , i;
		int data[] = new int[old_data.length + divisor.length];
		System.arraycopy(old_data, 0, data, 0, old_data.length);
	
		remainder = new int[divisor.length];

		System.arraycopy(data, 0, remainder, 0, divisor.length);
		for(i=0 ; i < old_data.length ; i++) {
			System.out.println((i+1) + ".) First data bit is : "
							+ remainder[0]);
			System.out.print("Remainder : ");
			if(remainder[0] == 1) {
				for(int j=1 ; j < divisor.length ; j++) {
					remainder[j-1] = exor(remainder[j], divisor[j]);
					System.out.print(remainder[j-1]);
				}
			}
			else {
				
				for(int j=1 ; j < divisor.length ; j++) {
					remainder[j-1] = exor(remainder[j], 0);
					System.out.print(remainder[j-1]);
				}
			}
				//carry bit
			remainder[divisor.length-1] = data[i+divisor.length];
			System.out.println(remainder[divisor.length-1]);
		}
		return remainder;
	}
	static int exor(int a, int b) {
		
		if(a == b) {
			return 0;
		}
		return 1;
	}

}
