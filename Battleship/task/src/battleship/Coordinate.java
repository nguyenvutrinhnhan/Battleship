package battleship;

import java.util.ArrayList;
import java.util.Objects;

import static battleship.Constants.ASCII_CODE;
import static battleship.Constants.SIZE_COL;
import static battleship.Constants.SIZE_ROW;
import static battleship.Constants.SYMBOL_FOG;

public class Coordinate {
    private int rowIndex; // A -> J
    private int colIndex; // 1 -> 10

    @Override
    public String toString() {
        return "[" + rowIndex + "," + colIndex + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return rowIndex == that.rowIndex && colIndex == that.colIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, colIndex);
    }

    public Coordinate(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public Coordinate(char rowIndex, String colIndex) {
        this.rowIndex = convertRowIndexToNumber(rowIndex) - 1;
        this.colIndex = Integer.parseInt(String.valueOf(colIndex)) - 1;
    }

    public static Coordinate[] convertToCoordinates(String[] inputCoordinates) {
        String beginPoint = inputCoordinates[0];
        String endPoint = inputCoordinates[1];
        Coordinate beginCoordinate = convertToCoordinate(beginPoint);
        Coordinate endCoordinate = convertToCoordinate(endPoint);
        return new Coordinate[]{beginCoordinate, endCoordinate};
    }

    // Convert character to number coordinate
    public static Coordinate convertToCoordinate(String inputCoordinate) {
        char begin = inputCoordinate.charAt(0);
        String end = inputCoordinate.substring(1);
        return new Coordinate(begin, end);
    }

    public static int convertRowIndexToNumber(char rowIndex) {
        return (int) rowIndex - ASCII_CODE;
    }

    public static boolean isHorizontal(Coordinate[] coordinates) {
        // Check same row
        Coordinate begin = coordinates[0];
        Coordinate end = coordinates[1];
        return begin.getRowIndex() == end.getRowIndex();
    }

    public static boolean isVertical(Coordinate[] coordinates) {
        // Check same column
        Coordinate begin = coordinates[0];
        Coordinate end = coordinates[1];
        return begin.getColIndex() == end.getColIndex();
    }

    public static boolean checkCoordinateIsIsolate(GameField gameField, Coordinate coordinate) {
        ArrayList<Coordinate> neighborPoints = getNeighborPoints(coordinate);
        for (Coordinate neighborPoint : neighborPoints) {
            String coordinateValue = gameField.getCoordinateValue(neighborPoint);
            if (!SYMBOL_FOG.equals(coordinateValue)) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Coordinate> getNeighborPoints(Coordinate coordinate) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        int rowIndex = coordinate.getRowIndex();
        int colIndex = coordinate.getColIndex();
        int upRowIndex = (rowIndex == 0) ? -1 : rowIndex - 1;
        int downRowIndex = (rowIndex == SIZE_ROW - 1) ? -1 : rowIndex + 1;
        int leftColIndex = (colIndex == 0) ? -1 : colIndex - 1;
        int rightColIndex = (colIndex == SIZE_COL - 1) ? -1 : colIndex + 1;

        if (upRowIndex != -1) {
            coordinates.add(new Coordinate(upRowIndex, colIndex));
        }
        if (downRowIndex != -1) {
            coordinates.add(new Coordinate(downRowIndex, colIndex));
        }
        if (leftColIndex != -1) {
            coordinates.add(new Coordinate(rowIndex, leftColIndex));
        }
        if (rightColIndex != -1) {
            coordinates.add(new Coordinate(rowIndex, rightColIndex));
        }

        return coordinates;
    }

    // ======================================= Getters & Setters =======================================

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }
}
