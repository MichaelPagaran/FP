/**
 * Project title: Tower of Hanoi
 * Members: Cabalatungan, Ibacarra, Pagaran
 * Subject: CC12 B & CC13 B
 * Date: February 22, 2019
 * Description: This is a sub part of ToH.java.
 *              For score.
 * Status: FINISHED
 */
import java.io.*;
import java.util.*;
public class ScoreHanoi{
    public static void main(String[] args){
        space(50);
        try{
            File file = new File("ToH_Scores.txt");
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                String line = input.nextLine();
                System.out.println(line);
            }
        }catch(Exception e){

        }
        Scanner s = new Scanner(System.in);
        s.nextLine();
        space(50);
    }
    public static void space(int line){
        for(int i = 0; i!=line; i++){
            System.out.println();
        }
    }
}