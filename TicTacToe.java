//Name: Mohammed Nadim Mahmud
//N19764218 mnm376
package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private static Scanner scanner = new Scanner( System.in );
    public static void main(String[] args) {
        char[] board = createBoard();
        boolean gameOver = false;
        char letter = 'O';
        displayBoard(board);
        while(!gameOver){
            letter = switchLetter(letter);
            System.out.println("You are: " + letter + ". Please pick where you want to place (e.g. A1): ");
            String rowCol = scanner.nextLine();
            board = placeLetter(board, letter, rowCol);
            displayBoard(board);
            gameOver = checkIfGame(board, letter);
        }  
    }
    
    public static char switchLetter(char letter){
        char newLetter = 'Z';
        if (letter == 'X'){
            newLetter = 'O';
        }
        if (letter == 'O'){
            newLetter = 'X';
        }
        return newLetter;
    }
    
    public static char[] createBoard() {
        char[] charArray = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}; 
        return charArray;
    }
    
    public static int rowColToIndex(String input){
        int index;
        String rowCol = input;
        while (!rowCol.equals("A1") && !rowCol.equals("A2") && !rowCol.equals("A3") && !rowCol.equals("B1") && !rowCol.equals("B2") && !rowCol.equals("B3") && !rowCol.equals("C1") && !rowCol.equals("C2") &&!rowCol.equals("C3")){
                System.out.println("Not a valid input, please pick a new position: ");
                rowCol = scanner.nextLine();
                System.out.println(rowCol);
        }
        switch(rowCol){
            case "A1": index = 0;
                break;
            case "A2": index = 1;
                break;
            case "A3": index = 2;
                break;
            case "B1": index = 3;
                break;
            case "B2": index = 4;
                break;
            case "B3": index = 5;
                break;
            case "C1": index = 6;
                break;
            case "C2": index = 7;
                break;
            case "C3": index = 8;
                break;    
            default:
                index = 0; //will never run
                break;
        }
        return index;
    }
    
    public static boolean checkIfGame(char[] board, char letter){
        boolean trueOrFalse = false;
        if ((board[0] == letter) && (board[4] == letter) && (board[8] == letter)){
            System.out.println("\nGame!\n" + letter + " Wins!");
            trueOrFalse = true;
        }
        else if ((board[6] == letter) && (board[4] == letter) && (board[2] == letter)){
            System.out.println("\nGame!\n" + letter + " Wins!");
            trueOrFalse = true;
        }
        else if ((board[0] == letter) && (board[3] == letter) && (board[6] == letter)){
            System.out.println("\nGame!\n" + letter + " Wins!");
            trueOrFalse = true;
        }
        else if ((board[1] == letter) && (board[4] == letter) && (board[2] == letter)){
            System.out.println("\nGame!\n" + letter + " Wins!");
            trueOrFalse = true;
        }
        else if ((board[2] == letter) && (board[5] == letter) && (board[8] == letter)){
            System.out.println("\nGame!\n" + letter + " Wins!");
            trueOrFalse = true;
        }
        else if ((board[0] == letter) && (board[1] == letter) && (board[2] == letter)){
            System.out.println("\nGame!\n" + letter + " Wins!");
            trueOrFalse = true;
        }
        else if ((board[3] == letter) && (board[4] == letter) && (board[5] == letter)){
            System.out.println("\nGame!\n" + letter + " Wins!");
            trueOrFalse = true;
        }
        else if ((board[6] == letter) && (board[7] == letter) && (board[8] == letter)){
            System.out.println("\nGame!\n" + letter + " Wins!");
            trueOrFalse = true;
        }
        else if (checkIfFull(board)){
            System.out.println("It's a tie!");
            displayBoard(board);
            trueOrFalse = true;
        }
        return trueOrFalse;
    }
    
    public static boolean checkIfFull(char[] board){
        boolean full = true;
        for (int i = 0; i < 8; i++){
            if (board[i] == ' '){
                full = false;
            }
        }
        return full;
    }
    
 
    public static char[] placeLetter(char[] board, char letter,  String rowCol){
        int index = rowColToIndex(rowCol);
        while (board[index] != ' '){
            index = rowColToIndex("D1"); 
        }
        board[index] = letter;
        return board; 
    }
    
    public static void displayBoard(char[] board){
        System.out.println("  1 2 3 ");
        System.out.println("A " + board[0] + " " + board[1] + " " + board[2]);
        System.out.println("B " + board[3] + " " + board[4] + " " + board[5]);
        System.out.println("C " + board[6] + " " + board[7] + " " + board[8]);
    }
}

