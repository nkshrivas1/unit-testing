package com.example.unittesting.questions;

public class Main {
    public static void main(String[] args) {
//        *
//        * *
//        * * *
//        * * * *
//        * * * * *
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
//               *
//              * *
//            * * *
//          * * * *
//        * * * * *
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
//     *
//    * *
//   * * *
//  * * * *
// * * * * *
//* * * * * *
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
//        1 2 3 4 5 6
//         2 3 4 5 6
//          3 4 5 6
//           4 5 6
//            5 6
//             6
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j <= 6; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        int i,j,k;
        for(i=6;i>=1;i--){
            for(j=i;j<6;j++)
                System.out.print(" ");
            for(k=1;k<=(2*i-1);k++){
                if(k==1 || i==6 || k== (2*i -1)){
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println("");
        }

//        ***********
//         *       *
//          *     *
//           *   *
//            * *
//             *
    }
//                    *
//                   * *
//                  *   *
//                 *     *
//                *       *
//               ***********
//    i-> 1->n
//    j-> i<n space
//    k->2*i-1
//    k==1 i==n k== 2*i -1
//     print *
//    else print space


}
