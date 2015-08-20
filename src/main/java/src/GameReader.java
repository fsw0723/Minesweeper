package src;

import java.util.Scanner;

public class GameReader {
    public String readBoardSetting(){
        System.out.println("Board setup [size, number of mines]: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public String selectField(){
        System.out.println("Please select field [ x, y, Action]");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
