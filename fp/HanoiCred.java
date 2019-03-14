/**
 * Project title: Tower of Hanoi
 * Members: Cabalatungan, Ibacarra, Pagaran
 * Subject: CC12 B & CC13 B
 * Date: March 1, 2019
 * Description: This is a sub part of ToH.java.
 *              For game cred.
 * Status: FINISHED
 */
import java.util.Scanner;
import java.io.*;
public class HanoiCred{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        space(50);
        try{
            File file = new File("ToH_Cred.txt");
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                String line = input.nextLine();
                System.out.println(line);
            }
        }catch(Exception e){

        }
        input.nextLine();
    }
    public static void space(int line){
        for(int i = 0; i!=line; i++){
            System.out.println();
        }
    }
}