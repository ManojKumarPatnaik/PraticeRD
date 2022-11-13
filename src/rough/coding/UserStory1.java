package rough.coding;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserStory1 {
    static int[] result = new int[9];

    static int counter = 0;

    public static  int jumpSearch(int []A,int t){
        int bock = (int) Math.sqrt(A.length);
return -1;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        long val=Long.MIN_VALUE;
        System.out.println(val-1);
        File file = new File("C:\\Users\\Manojkumar_Uriti\\IdeaProjects\\" +
                "Dummy\\src\\userStory1.txt");
        List<String> stringList = Files.lines(file.toPath()).toList();
        FileInputStream fileInputStream =new FileInputStream(file);
//        var s=new Scanner()
       var br = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.equalsIgnoreCase("quit")) {
                break;
            }
            System.out.println("Line entered : " + line.length());
        }
        conversationMethod(stringList);
        System.out.println("Account Number in an Array format : " + Arrays.toString(result));
    }

    private static void conversationMethod(List<String> lines) {

        String firstHeader, secondHeader, thirdHeader;
        for (int j = 0; j < 24; j += 3) {
            firstHeader = lines.get(0).substring(j, j + 3);
            secondHeader = lines.get(1).substring(j, j + 3);
            thirdHeader = lines.get(2).substring(j, j + 3);
            patternMatching(firstHeader, secondHeader, thirdHeader);
        }
        firstHeader = lines.get(0).substring(24);
        secondHeader = lines.get(1).substring(24);
        thirdHeader = lines.get(2).substring(24);
        patternMatching(firstHeader, secondHeader, thirdHeader);
    }

    private static void patternMatching(String firstHeader, String secondHeader, String thirdHeader) {
        if (firstHeader.equals("   ") && secondHeader.equals("  |") && thirdHeader.equals("  |")) {
            result[counter] = 1;
        } else if (firstHeader.equals(" _ ") && secondHeader.equals(" _|") && thirdHeader.equals("|_ ")) {
            result[counter] = 2;
        } else if (firstHeader.equals(" _ ") && secondHeader.equals(" _|") && thirdHeader.equals(" _|")) {
            result[counter] = 3;
        } else if (firstHeader.equals("   ") && secondHeader.equals("|_|") && thirdHeader.equals("  |")) {
            result[counter] = 4;
        } else if (firstHeader.equals(" _ ") && secondHeader.equals("|_ ") && thirdHeader.equals(" _|")) {
            result[counter] = 5;
        } else if (firstHeader.equals(" _ ") && secondHeader.equals("|_ ") && thirdHeader.equals("|_|")) {
            result[counter] = 6;
        } else if (firstHeader.equals(" _ ") && secondHeader.equals("  |") && thirdHeader.equals("  |")) {
            result[counter] = 7;
        } else if (firstHeader.equals(" _ ") && secondHeader.equals("|_|") && thirdHeader.equals("|_|")) {
            result[counter] = 8;
        } else if (firstHeader.equals(" _") && secondHeader.equals("|_|") && thirdHeader.equals(" _|")) {
            result[counter] = 9;
        } else if (firstHeader.equals(" _ ") && secondHeader.equals(" | |") && thirdHeader.equals("|_|")) {
            result[counter] = 0;
        } else {
            throw new IllegalArgumentException("Invalid characters ");
        }
        counter++;
    }
}
