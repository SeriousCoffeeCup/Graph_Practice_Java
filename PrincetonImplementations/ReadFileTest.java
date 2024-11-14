package PrincetonImplementations;
import edu.princeton.cs.algs4.In;
import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

import static PrincetonImplementations.dataFiles.*;

public class ReadFileTest {
    public static void main(String[] args){
        // Changing implementation to follow Scanner standard instead : https://www.w3schools.com/java/java_files_read.asp
        System.out.println("File Name: " + tinyGraph);
        In in = new In(tinyGraph);


//        Failed attempts to convert to real inReader
//        File in = new File("z:/Other computers/My Computer (1)/repos/Java/Java61B/lectureCode/Graphs/PrincetonImplementations/tinyG.txt");
//        Scanner inReader = new Scanner(in); // why error...


//        Debug Attempt 1:
//        https://stackoverflow.com/questions/11553042/the-system-cannot-find-the-file-specified-in-java
//
//        File file = new File(".");
//        for(String fileNames : file.list()) System.out.println(fileNames);

//        Debug Attempt 2:
//        System.out.println(new File("PrincetonImplementations/tinyG.txt").getAbsolutePath());



//        Scanner inReader = new Scanner(tinyGraph);

        int i = 0;

        while (!in.isEmpty()) {
//        while(inReader.hasNextLine()){
            i += 1;
            String nextLine = in.readLine();
//            String nextLine = inReader.nextLine();
            System.out.print("Line " + i + " is: ");
            System.out.println(nextLine);
            System.out.print("After splitting on delimiter, the first word is: ");
            String[] splitLine = nextLine.split(" ");
            System.out.println(splitLine[0]);
        }
    }
}
