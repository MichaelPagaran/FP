/**
 * Project title: Tower of Hanoi
 * Members: Cabalatungan, Ibacarra, Pagaran
 * Subject: CC12 B & CC13 B
 * Date: February 8, 2019
 * Description: This is a sub part of ToH.java 
 *              Used for the tutorial/Auto-solve part.
 * Status: FINISHED
 */
import java.util.Scanner;
import java.util.Stack;
public class SampleHanoi {
    public static int N;
            //Stack creation
    public static Stack<Integer>[] rod = new Stack[4];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        rod[1] = new Stack<Integer>();rod[2] = new Stack<Integer>();rod[3] = new Stack<Integer>();
        space(50);
        System.out.println("*Move the disks from rod1 to rod3. The player \nmay use rod2 as he/she pleases as long as no\ndisk will be placed on top of a smaller disk.\n");
        System.out.println("*You may move the disk by picking the number\nof the rod you want to pop or push in the\nactual game");
        space(1);
        System.out.println("Press Enter to continue...");
        input.nextLine();
        System.out.print("AUTO-SOLVE / TUTORIAL\nNumber of disks: ");

        int num = input.nextInt();      //disks
        System.out.println();
        N = num;
        toh(num); //the whole operation
        double totalMoves = Math.pow(2, num) - 1;       //auto calculate the total moves

        System.out.println();
        System.out.println("Lowest possible score: " + Math.round(totalMoves) + "\nLower score = better\n");

        space(2);
    }
    public static void toh(int disk) {         //push disk to stacks
        for(int d = disk; d>0; d--){ 
            rod[1].push(d);
        }
        display();
        move(disk, 1, 2, 3);
    }
    public static void move(int n, int a, int b, int c) {       //recursion
        if (n > 0) {
            move(n - 1, a, c, b);
            int d = rod[a].pop();
            rod[c].push(d);
            display();
            move(n - 1, b, a, c);
        }
    }
    public static void display() {                       //show progress
        Scanner s = new Scanner(System.in);
        System.out.println("  Rod1    Rod2    Rod3\n");
        for (int i = N - 1; i >= 0; i--) {
            String disk1 = " ", disk2 = " ", disk3 = " ";        //space instead of "0"
            try {
                if(rod[1].get(i)>0){
                    disk1 = String.valueOf(rod[1].get(i));     //conversion from integer to string
                }
            } catch (Exception e) {
            }
            try {
                if(rod[2].get(i)>0){
                    disk2 = String.valueOf(rod[2].get(i));
                }
            } catch (Exception e) {
            }
            try {
                if(rod[3].get(i)>0){
                    disk3 = String.valueOf(rod[3].get(i));
                }
            } catch (Exception e) {
            }
            System.out.println("    " + disk1 + "      " + disk2 + "       " + disk3);
        }
        s.nextLine();
    }
    public static void space(int line){
        for(int i = 0; i!=line; i++){
            System.out.println();
        }
    }
}