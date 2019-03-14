/**
 * Project title: Tower of Hanoi
 * Members: Cabalatungan, Ibacarra, Pagaran
 * Subject: CC12 B & CC13 B
 * Date: February 25, 2019
 * Description: This is a sub part of ToH.java.
 *              Used for manual gameplay.
 * Status: FINISHED
 */
import java.util.Stack;
import java.util.Scanner;
import java.io.*;
public class ManualHanoi{ 
    public static int N; 
    public static Stack<Integer>[] rod = new Stack[4];
    public static String PlayerName;
    public static int Score;
    public static Scanner input = new Scanner(System.in);
    public static int gameMode;
    public static void main(String[] args){
        rod[1] = new Stack<Integer>();
        rod[2] = new Stack<Integer>();
        rod[3] = new Stack<Integer>();
        Scanner fileInput = new Scanner(System.in);
        System.out.print("Disks: ");
        int disks = input.nextInt();
        space(3);
        N = disks;
        gameMode = 1;
        while(gameMode<3){
            switch(gameMode){
                case 1: gameStart(disks);
                break;
                case 2: 
                System.out.println("Player name: ");
                PlayerName = fileInput.nextLine();
                saveScore(PlayerName,Score,N);
                gameMode = 3;
                break;
                case 3: 
                break;
                default: System.out.println("gokk");
                break;
            }
            space(50);
        }
    }
    public static boolean gameWon(){
        try{
            int count = 0;
            int disks = N;
            for(int i = 0; i<disks; i++){
                if(rod[3].get(i)>0){
                    count++;
                }
            }
            if(count==N){
                return true;
            }
        }
        catch(Exception e){
        }
        return false;
    }
    public static void gameStart(int disk){ 
        Scanner input = new Scanner(System.in);
        int movesMade = 0;
        setDisks(disk);
        space(50);
        display();
        space(1);
        while(gameWon() == false){
            System.out.println("Move from what rod?");
            System.out.println("Select rod number:..");
            int rodFrom = input.nextInt();
            space(1);

            while(rodFrom>3||rodFrom<0){
                space(50);
                display();
                System.out.println("ERROR! ROD["+ rodFrom +"] DOES NOT EXIST\nSELECT ANOTHER ROD");
                System.out.println("\nMove from what rod?");
                System.out.println("Select rod number:..");
                rodFrom = input.nextInt();
                space(1);
            }
            while(rod[rodFrom].isEmpty()){
                space(50);
                display();
                System.out.println("ERROR! ROD EMPTY\nSELECT ANOTHER ROD");
                System.out.println("\nMove from what rod?");
                System.out.println("Select rod number:..");
                rodFrom = input.nextInt();
                space(1);
            }

            int activeDisk = rod[rodFrom].peek(); 
            space(50);
            display();
            space(1);
            System.out.println("Move from rod["+ rodFrom +"] to where?");
            System.out.println("Select rod number:..");
            int rodTo = input.nextInt(); 
            space(1);
            while(rodTo>3||rodTo<0){ 
                space(50);
                display();
                System.out.println("ERROR! ROD["+ rodTo +"] DOES NOT EXIST\nSELECT ANOTHER ROD");
                System.out.println("\nMove to what rod?");
                System.out.println("Select rod number:..");
                rodTo = input.nextInt();
                space(1);
            }
            try{ 
                while(activeDisk > rod[rodTo].peek()){
                    space(50);
                    display();
                    System.out.println("ERROR! DISK SHOULD NOT BE ON TOP OF A SMALLER DISK\nRESELECT YOUR DESTINATION");
                    System.out.println("\nMove from rod[" + rodFrom + "] to where?");
                    System.out.println("Select rod number:..");
                    rodTo = input.nextInt();
                    space(1);
                }
            }catch(Exception e){
            }
            rod[rodFrom].pop();
            rod[rodTo].push(activeDisk);
            space(50);
            display();
            movesMade++;
            space(1);
            System.out.println("Current score: "+movesMade);
        }
        space(50);
        display();
        System.out.println("Game won yey! Score:"+movesMade);
        Score = movesMade;
        double perfectScore = Math.pow(2, disk)-1;
        if(movesMade == Math.round(perfectScore)){
            System.out.println("Perfect Score!");
        }
        //clear rod 3
        for(int i = disk-1; i>=0; i--){
            rod[3].pop();
        }
        System.out.println("1:Retry\n2:Exit");
        gameMode = input.nextInt();
    }
    public static void setDisks(int disk){
        for(int d = disk; d>0; d--){
            rod[1].push(d); 
        }
    }
    public static void display() {                       
        System.out.println("  Rod1    Rod2    Rod3\n");
        for (int i = N - 1; i >= 0; i--) {
            String disk1 = " ", disk2 = " ", disk3 = " "; 
            try {
                if(rod[1].get(i)==0){
                    disk1 = " ";
                }
                else{
                    disk1 = String.valueOf(rod[1].get(i));
                }     
            } catch (Exception e) {
            }
            try {
                if(rod[2].get(i)==0){
                    disk2 = " ";
                }
                else{
                    disk2 = String.valueOf(rod[2].get(i));
                }        
            } catch (Exception e) {
            }
            try {
                if(rod[3].get(i)==0){
                    disk3 = " ";
                }
                else{
                    disk3 = String.valueOf(rod[3].get(i));
                }
            } catch (Exception e) {
            }
            System.out.println("    " + disk1 + "      " + disk2 + "       " + disk3);
        }
    }
    public static void space(int line){
        for(int i = 0; i!=line; i++){
            System.out.println();
        }
    }
    public static void saveScore(String name, int score, int disks){
        try{
        FileWriter scoreFile = new FileWriter("ToH_Scores.txt",true);
        PrintWriter scorePrinter = new PrintWriter(scoreFile);
        scorePrinter.println("Player: "+name);
        scorePrinter.println("Score: "+score);
        scorePrinter.println("Disks: "+disks);
        scorePrinter.println();
        scorePrinter.close();
        }catch(Exception e){
        }
        System.out.println("Score saved!");

    }
}