package PrincetonImplementations;
import edu.princeton.cs.algs4.In;

import static PrincetonImplementations.dataFiles.*;

public class ReadFileTest {
    public static void main(String[] args){
        // Changing implementation to follow Scanner standard instead : https://www.w3schools.com/java/java_files_read.asp
        System.out.println("File Name: " + tinyGraph);

        In in = new In(tinyGraph);
        int i = 0;

        while (!in.isEmpty()) {
            i += 1;
            String nextLine = in.readLine();
            System.out.print("Line " + i + " is: ");
            System.out.println(nextLine);
            System.out.print("After splitting on delimiter, the first word is: ");
            String[] splitLine = nextLine.split(" ");
            System.out.println(splitLine[0]);
        }
    }
}
