/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastrucass1_3;

/************************************************************** 
Purpose/Description: < Write a program in Java to implement a recursive search 
* function (b.1) Implement a sub-linear running time complexity function in Java
*  (b.2) What is the running time complexity of your exponentiation function? >
Author’s Panther ID: <>
Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
**************************************************************/

public class DataStrucAss1_3 {
    
   // A is sorted in increasing(non-decreasing order)
   // Part (a)
    
        public static int terSearch(int A[], int l, int r, int x) 
        {
            int d1, d2;
            if (l > r) 
              {
                return -1;
              } 
            else if (l == r) 
              {
                if (A[l] == x) 
                {
                    return l;
                } 
                else 
                {
                    return -1;
                }
              } 
            else 
              {
                // l < r
                int div3 = (r - l) / 3;
                d1 = l + div3;
                d2 = d1 + div3;
                if (A[d1] == x) 
                  {
                    return d1;
                  } 
                else if (A[d2] == x) 
                  {
                    return d2;
                  } 
                else if (x < A[d1]) 
                  {
                    return terSearch(A, l, d1 - 1, x);
                  } 
                else if (x > A[d1] && x < A[d2]) 
                  {
                    return terSearch(A, d1 + 1, d2 - 1, x);
                  } 
                else 
                  {
                    return terSearch(A, d2 + 1, r, x);
                  }
              }

        }

        // Part (b.1)
        public static long exponentiation(long x, int n) 
        {
            // The exponent i.e n >= 0
            // Assuming multiplication of two long data types takes O(1) time,
            // time complexity of the algorithm is O(log(n))

            if (n == 0) {
                return 1;
            } else if (n == 1) {
                return x;
            } else {
                long Expo = exponentiation(x, n / 2);
                if (n % 2 == 0) {
                    return Expo * Expo;
                } else {
                    return Expo * Expo * x;
                }
            }
        }

        public static void PrintForA(int abc, int efg, int[] hij) {
            int size = hij.length;
            if (efg == -1) 
              {
                System.out.print("The number " + abc + " does not exist in the array ");
                System.out.print("{");
                for (int i = 0; i < size - 1; i++) 
                {
                    System.out.print(hij[i] + ",");
                }
                System.out.print(hij[size - 1]);
                System.out.println("}");
              } 
            else 
              {
                System.out.print("The number " + abc + " exist at position " + efg + " in Array ");
                System.out.print("{");
                for (int i = 0; i < size - 1; i++) 
                {
                    System.out.print(hij[i] + ",");
                }
                System.out.print(hij[size - 1]);
                System.out.println("}");
              }
        }

        public static void main(String[] args) {
            
            // Some Sample test cases for (a)
            
            int a[] = new int[]{1, 25, 43, 74, 55, 67, 95, 4511};
            int b[] = new int[]{1, 9};
            int c[] = new int[]{19};
            int d[] = new int[]{4, 5, 6, 8, 9, 10, 12, 13, 15, 18};

            // Search for a few numbers in the above test cases
            PrintForA(1, terSearch(a, 0, 7, 1), a);
            PrintForA(14, terSearch(a, 0, 7, 14), a);
            System.out.println();
            PrintForA(1, terSearch(b, 0, 1, 1), b);
            PrintForA(-1, terSearch(b, 0, 1, -1), b);
            System.out.println();
            PrintForA(1, terSearch(c, 0, 0, 1), c);
            PrintForA(19, terSearch(c, 0, 0, 3), c);
            System.out.println();
            PrintForA(8, terSearch(d, 0, 9, 8), d);
            PrintForA(1, terSearch(d, 0, 9, 1), d);
            System.out.println();
            
            // Some Sample test cases for (b.1)
            System.out.println("2 raised to the power of 63 is " + exponentiation(2, 63));
            System.out.println("3 raised to the power of 4 is " + exponentiation(3, 4));
            System.out.println("4 raised to the power of 31 is " + exponentiation(4, 31));
            
        }

}