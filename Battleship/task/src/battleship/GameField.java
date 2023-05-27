package battleship;

import java.util.Scanner;

import static battleship.Constants.ASCII_CODE;
import static battleship.Constants.SYMBOL_FOG;
import static battleship.Constants.SYMBOL_PLACED;
import static battleship.Constants.SYMBOL_SPACE;

public class GameField {
    private int sizeRow;
    private int sizeCol;
    private String[][] field;

    public GameField(int sizeRow, int sizeCol) {
        this.setSizeRow(sizeRow);
        this.setSizeCol(sizeCol);
        this.field = new String[sizeRow][sizeCol];
    }

    public void setupField() {
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeCol; j++) {
                field[i][j] = SYMBOL_FOG;
            }
        }
    }

    public void displayField(boolean isCovered) {
        printRowHeader();
        for (int i = 0; i < sizeRow; i++) {
            printColHeader(i);
            for (int j = 0; j < sizeCol; j++) {
                System.out.print(SYMBOL_SPACE + (isCovered ? SYMBOL_FOG : field[i][j]));
            }
        }
        System.out.println();
    }

    public void displayShot(Coordinate coordinate) {
        System.out.println();
        printRowHeader();
        for (int i = 0; i < sizeRow; i++) {
            printColHeader(i);
            for (int j = 0; j < sizeCol; j++) {
                if (field[i][j].equals(SYMBOL_PLACED)) {
                    System.out.print(SYMBOL_SPACE + SYMBOL_FOG);
                } else {
                    System.out.print(SYMBOL_SPACE + field[i][j]);
                }
            }
        }
        System.out.println("\n");
    }

    public void startShooting(Scanner scanner) {
        // System.out.println("The game starts!");
        // System.out.println("Take a shot!");
        // while (SHIPS.size() > 0) {
        //     Coordinate coordinate = inputAndReturnValidCoordinate(scanner);
        //     boolean isHit = checkShooting(coordinate);
        //     if (isHit) {
        //         boolean isDestroyedShip = processShipStrengthAndCheckDestroyedShip(coordinate);
        //         if (SHIPS.size() > 0) {
        //             System.out.println(isDestroyedShip ? "You sank a ship! Specify a new target:" : "You hit a ship! Try again:");
        //         } else {
        //             System.out.println(isDestroyedShip ? "You sank the last ship. You won. Congratulations!" : "You hit a ship! Try again:");
        //         }
        //     } else {
        //         System.out.println("You missed. Try again:");
        //     }
        // }
    }

    // Print 1st row header: 1 -> 10
    public void printRowHeader() {
        StringBuilder colHeader = new StringBuilder(SYMBOL_SPACE);
        for (int i = 1; i <= sizeRow; i++) {
            colHeader.append(SYMBOL_SPACE + i);
        }
        System.out.print(colHeader);
    }

    // Print 1st col header: A -> J
    public void printColHeader(int rowIndex) {
        System.out.print("\n" + (char) (ASCII_CODE + rowIndex + 1));
    }

    // ======================================= Getters & Setters =======================================

    public int getSizeRow() {
        return sizeRow;
    }

    public void setSizeRow(int sizeRow) {
        this.sizeRow = sizeRow;
    }

    public int getSizeCol() {
        return sizeCol;
    }

    public void setSizeCol(int sizeCol) {
        this.sizeCol = sizeCol;
    }

    public String getCoordinateValue(Coordinate coordinate) {
        return field[coordinate.getRowIndex()][coordinate.getColIndex()];
    }

    public void setCoordinateValue(Coordinate coordinate, String content) {
        field[coordinate.getRowIndex()][coordinate.getColIndex()] = content;
    }

    public void setCoordinateValue(int rowIndex, int colIndex, String content) {
        field[rowIndex][colIndex] = content;
    }
}
