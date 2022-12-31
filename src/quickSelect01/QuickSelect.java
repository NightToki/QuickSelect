package quickSelect01;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class QuickSelect {
	public static int[] call(int n) {
		Random rand = new Random(); 
	
		int[] a = new int[n];
		for(int i = 0; i <n;i++) {
			a[i] = rand.nextInt(200)-100;
		}
		return a;
		
	}

	public static int partition(int []a,int start, int end) {
		int pivot = a[end];
		while(start < end ) {
			while(a[start]<pivot) {
				start++;
			}
			while(a[end]>pivot) {
				end--;
			}
			if(start<end) {
				int temp = a[end];
		        a[end] = a[start];
		        a[start] = temp;
			}
		}
        return start;
		
		
	}
	

	
	public static int quickSelect(int []a,int k,int start, int end ) {
		
		int partition = partition(a,start,end);
		  if (partition == k - 1) {
			 // System.out.println(partition);
			  return a[partition];
	            }
		  
		  else if (partition < k - 1)
	            return quickSelect(a, k,partition + 1, end);
		  else
	            return quickSelect(a, k, start, partition - 1);		
	}
	
	public static int quickSelect2(int []a,int start, int end,int s ) {
        int k = a.length-s+1;
        int partition = partition(a,start,end);
          if (partition == k-1) {
        	  	k = a.length;
                return a[partition];
          }
          else if (partition < k - 1)
                return quickSelect2(a,partition + 1, end,s);
          else
                return quickSelect2(a,start, partition - 1,s);
    }
	public static int[] maxS(int[] a, int s, int[]store) { // try to get the index and put that into x insttead of the direct number
        /*
         * ideas to test 
         * use the quick select to find the number of the greatest S integers so 
         * for ex if s = 3 in the array  [4 2 0 10 1 6] it would return 4 10 6 or 0 3 5
         * 
         * for loop it?.
         * then throw it into a new array of a[0],a[3],a[5]
         */
		int x = 0;
		int y = 0;
	
		int[] a2 = new int[s];
		
		int s2 = s;
		for(int i = 0; i<s2;i++) {
			 x = quickSelect2(a,0,a.length-1,s);
		//	System.out.println("This is the what ever largest number: "+x);
		//	System.out.println("this is i: "+i);
			s--;
			for(int j = 0;j<a.length;j++) {
				if(store[j]==x) {
					a2[i] = store[j];
					//System.out.println("this is y: "+y);
					//System.out.println("this is store of y: "+store[y]);
					//y = j;
					//a2[y]=store[j];
				}//return index and sort the index 
				
			}
			
		}
	//	System.out.println(Arrays.toString(a2));


        //int[] a2 = Arrays.copyOfRange(a, a.length -s, a.length);
        return a2;
        // print out anything after the pivot index call quick select once 
    }
	
	
	public static void main(String[] args) {
		System.out.println("partA");
		Scanner userInt = new Scanner(System.in);
		boolean loop = true;
		boolean loop2 = true;

		int n = 0;
		while(loop == true){
			System.out.println("Enter a valid positive integer: ");
			 n = userInt.nextInt();
			if(n<0) {
				System.out.println("Not valid positive integer");
				loop=true;
			}
			else {
				loop =false;
			}
		}
		int[] a; 
		int []store;
		a = call(n);
		store= a.clone();		
		 System.out.println(Arrays.toString(a));
		int k = 0;

		while(loop2 == true){
			System.out.println("Enter a valid positive integer from 1 to "+n+": ");
			 k = userInt.nextInt();
			if(k<0&&k>n) {
				System.out.println("Not valid positive integer");
				loop2=true;
			}
			else {
				loop2 =false;
			}
		}
		
		int length = a.length;
		int b = quickSelect(a,k,0,length-1);
		System.out.println(b);
		//System.out.println(Arrays.toString(a));
		

		System.out.println("partB");

		//System.out.println(Arrays.toString(a));
		int s = 0;
		boolean loop3 = true;
		while(loop3  == true){
			System.out.println("Enter a valid positive integer: ");
			 s = userInt.nextInt();
			if(s<0) {
				System.out.println("Not valid positive integer");
				loop3=true;
			}
			else {
				loop3 =false;
			}
		}
		int[] c = maxS(a,s,store);
		//System.out.println(c);
		System.out.println(Arrays.toString(c));

		

		
	}
	
}
