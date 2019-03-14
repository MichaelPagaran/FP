/**
 * Project title: Tower of Hanoi
 * Members: Cabalatungan, Ibacarra, Pagaran
 * Subject: CC12 B & CC13 B
 * Date: February 21, 2019
 * Description: This java program is devided into 3 sub parts:
 *              - SampleHanoi.java for the auto-solve
 *              - ManualHanoi.java for the manual gameplay
 *              - ScoreHanoi.java to display scores
 *              - HanoiCred.java for game cred
 * Status: FINISHED
 */
import java.io.*;
import java.util.Scanner;
public class ToH{
public static Scanner asdads;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int gameMode = 0;
        while(gameMode!=5){
            System.out.println(":::: TOWER OF HANOI ::::");
            System.out.println("Choose game mode\n 1: Tutorial\n 2: Start game\n 3: Scores\n 4: Game credits\n 5: Exit");
            System.out.println();
            gameMode = input.nextInt();
            switch(gameMode){
                case 1: SampleHanoi.main(new String[0]);
                break;

                case 2: ManualHanoi.main(new String[0]);
                break;

                case 3: ScoreHanoi.main(new String[0]);
                break;

                case 4: HanoiCred.main(new String[0]);
                break;

                case 5: System.out.println("Closed");
                break;

                default:
                break;
            }
        }
    }
}