public class Pattern {
    public static void main(String[] args) {
        pattern17(5);

    }

    //    1.  *****
    //        *****
    //        *****
    //        *****
    //        *****
    static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //        2.  *
    //            **
    //            ***
    //            ****
    //            *****
    static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //        3.  *****
    //            ****
    //            ***
    //            **
    //            *

    static void pattern3(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //        4.  1
    //            1 2
    //            1 2 3
    //            1 2 3 4
    //            1 2 3 4 5
    static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    //        5.  *
    //            **
    //            ***
    //            ****
    //            *****
    //            ****
    //            ***
    //            **
    //            *
    static void pattern5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //            6.       *
    //                    **
    //                   ***
    //                  ****
    //                 *****
    static void pattern6(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j <= n; j++) {
                if (j < i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }

    //            7.   *****
    //                  ****
    //                   ***
    //                    **
    //                     *
    static void pattern7(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //            8.      *
    //                   ***
    //                  *****
    //                 *******
    //                *********

    static void pattern8(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j <= n; j++) {
                if (j < i) System.out.print(" ");
                else System.out.print("*");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    //            9.  *********
    //                 *******
    //                  *****
    //                   ***
    //                    *
    static void pattern9(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) System.out.print(" ");
                else System.out.print("*");
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
//            10.      *
//                    * *
//                   * * *
//                  * * * *
//                 * * * * *

    static void pattern10(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= n; j++) {
                if (j < i) System.out.print(" ");
                else System.out.print("* ");
            }
            System.out.println();
        }
    }

//            11.  * * * * *
//                  * * * *
//                   * * *
//                    * *
//                     *

    static void pattern11(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) System.out.print(" ");
                else System.out.print("* ");
            }
            System.out.println();
        }
    }
//            12.  * * * * *
//                  * * * *
//                   * * *
//                    * *
//                     *
//                     *
//                    * *
//                   * * *
//                  * * * *
//                 * * * * *

    static void pattern12(int n){
        pattern11(n);
        pattern10(n);
    }
//            13.      *
//                    * *
//                   *   *
//                  *     *
//                 *********

    static void pattern13(int n){
        for(int i=n;i>1;i--){
            for(int j=0;j<n;j++){
                if(j==i-1) System.out.print("*");
                else System.out.print(" ");
            }
            for(int j=0;j<n-i;j++){
                if(j==n-i-1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=0;i<(2*n-1);i++){
            System.out.print("*");
        }
    }
//            14.  *********
//                  *     *
//                   *   *
//                    * *
//                     *

    static void pattern14(int n){
        for(int i=0;i<(2*n-1);i++){
            System.out.print("*");
        }
        System.out.println();
        for(int i=n;i>1;i--){
            for(int j=0;j<n-1;j++){
                if(j==n-i) System.out.print(" *");
                else System.out.print(" ");
            }
            for(int j=2;j<n;j++){
                if(j==i-1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
//            15.      *
//                    * *
//                   *   *
//                  *     *
//                 *       *
//                  *     *
//                   *   *
//                    * *
//                     *
//

    public static void pattern15(int n){
        for(int i=n;i>0;i--){
            for(int j=0;j<n;j++){
                if(j==i-1) System.out.print("*");
                else System.out.print(" ");
            }
            for(int j=0;j<n-i;j++){
                if(j==n-i-1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=n;i>1;i--){
            for(int j=0;j<n-1;j++){
                if(j==n-i) System.out.print(" *");
                else System.out.print(" ");
            }
            for(int j=2;j<n;j++){
                if(j==i-1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
//
//            16.           1
//                        1   1
//                      1   2   1
//                    1   3   3   1
//                  1   4   6   4   1


//            17.      1
//                    212
//                   32123
//                  4321234
//                   32123
//                    212
//                     1

    public static void pattern17(int n){
        for (int i = 1; i < 2*n; i++) {
            for (int space = 0; space < (i>n?i-n:n-i); space++) {
                System.out.print(" ");
            }
            int condition = i > n ? 2 * n - i : i;
            for (int j = condition; j >0 ; j--) {
                System.out.print(j);
            }
            for(int j = 2; j<= condition; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

//            18.   **********
//                  ****  ****
//                  ***    ***
//                  **      **
//                  *        *
//                  *        *
//                  **      **
//                  ***    ***
//                  ****  ****
//                  **********
//
//
//            19.    *        *
//            **      **
//            ***    ***
//            ****  ****
//            **********
//            ****  ****
//            ***    ***
//            **      **
//            *        *
//
//
//            20.    ****
//            *  *
//            *  *
//            *  *
//            ****
//
//            21.    1
//            2  3
//            4  5  6
//            7  8  9  10
//            11 12 13 14 15
//
//            22.    1
//            0 1
//            1 0 1
//            0 1 0 1
//            1 0 1 0 1
//
//            23.        *      *
//            *   *  *   *
//            *      *      *
//
//            24.    *        *
//            **      **
//            * *    * *
//            *  *  *  *
//            *   **   *
//            *   **   *
//            *  *  *  *
//            * *    * *
//            **      **
//            *        *
//
//            25.       *****
//            *   *
//            *   *
//            *   *
//            *****
//
//            26.   1 1 1 1 1 1
//            2 2 2 2 2
//            3 3 3 3
//            4 4 4
//            5 5
//            6
//
//            27.   1 2 3 4  17 18 19 20
//            5 6 7  14 15 16
//            8 9  12 13
//            10 11
//
//            28.      *
//            * *
//            * * *
//            * * * *
//            * * * * *
//            * * * *
//            * * *
//            * *
//            *
//
//            29.
//            *        *
//            **      **
//            ***    ***
//            ****  ****
//            **********
//            ****  ****
//            ***    ***
//            **      **
//            *        *
//
//            30.         1
//            2 1 2
//            3 2 1 2 3
//            4 3 2 1 2 3 4
//            5 4 3 2 1 2 3 4 5
//
//
//            31.      4 4 4 4 4 4 4
//            4 3 3 3 3 3 4
//            4 3 2 2 2 3 4
//            4 3 2 1 2 3 4
//            4 3 2 2 2 3 4
//            4 3 3 3 3 3 4
//            4 4 4 4 4 4 4
//
//            32.    E
//    D E
//    C D E
//    B C D E
//    A B C D E
//
//33.    a
//    B c
//    D e F
//    g H i J
//    k L m N o
//
//34.    E D C B A
//    D C B A
//    C B A
//    B A
//    A
//
//35.    1      1
//        12    21
//        123  321
//        12344321
}
