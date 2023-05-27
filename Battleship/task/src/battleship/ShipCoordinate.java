package battleship;

import java.util.ArrayList;

import static battleship.Coordinate.checkCoordinateIsIsolate;
import static battleship.Coordinate.isHorizontal;
import static battleship.Coordinate.isVertical;

public class ShipCoordinate {
    private boolean isHorizontalShip;
    private Coordinate beginCoordinate;
    private Coordinate endCoordinate;
    private int commonIndex;
    private int beginIndex;
    private int endIndex;

    public ShipCoordinate(Coordinate[] coordinates) {
        this.beginCoordinate = coordinates[0];
        this.endCoordinate = coordinates[1];
        this.isHorizontalShip = beginCoordinate.getRowIndex() == endCoordinate.getRowIndex();
        this.commonIndex = this.isHorizontalShip ? beginCoordinate.getRowIndex() : beginCoordinate.getColIndex();
        if (this.isHorizontalShip) {
            if (beginCoordinate.getColIndex() < endCoordinate.getColIndex()) {
                this.beginIndex = beginCoordinate.getColIndex();
                this.endIndex = endCoordinate.getColIndex();
            } else {
                this.beginIndex = endCoordinate.getColIndex();
                this.endIndex = beginCoordinate.getColIndex();
            }
        } else {
            if (beginCoordinate.getRowIndex() < endCoordinate.getRowIndex()) {
                this.beginIndex = beginCoordinate.getRowIndex();
                this.endIndex = endCoordinate.getRowIndex();
            } else {
                this.beginIndex = endCoordinate.getRowIndex();
                this.endIndex = beginCoordinate.getRowIndex();
            }

        }
    }

    public static ShipCoordinate convertToShipCoordinate(String beginCoordinate, String endCoordinate) {
        Coordinate[] coordinates = Coordinate.convertToCoordinates(new String[]{beginCoordinate,endCoordinate });
        return new ShipCoordinate(coordinates);
    }

    public static boolean checkShipIsHorizontalOrVertical(Coordinate[] coordinates) {
        return isHorizontal(coordinates) || isVertical(coordinates);
    }

    public static boolean checkShipHasValidLength(Coordinate[] coordinates, int shipCell) {
        Coordinate begin = coordinates[0];
        Coordinate end = coordinates[1];

        if (isHorizontal(coordinates)) {
            return Math.abs(begin.getColIndex() - end.getColIndex()) + 1 == shipCell;
        }

        if (isVertical(coordinates)) {
            return Math.abs(begin.getRowIndex() - end.getRowIndex()) + 1 == shipCell;
        }

        return false;
    }

    public static boolean checkShipIsFarFromAnotherOne(GameField gameField, Coordinate[] coordinates) {
        ShipCoordinate shipCoordinate = new ShipCoordinate(coordinates);
        ArrayList<Coordinate> rangeShipCoordinates = getRangeShipCoordinates(shipCoordinate);
        for (Coordinate coordinate : rangeShipCoordinates) {
            if (!checkCoordinateIsIsolate(gameField, coordinate)) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Coordinate> getRangeShipCoordinates(ShipCoordinate shipCoordinate) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        if (shipCoordinate.isHorizontalShip()) {
            int rowIndex = shipCoordinate.getCommonIndex();
            for (int colIndex = shipCoordinate.getBeginIndex(); colIndex <= shipCoordinate.getEndIndex(); colIndex++) {
                coordinates.add(new Coordinate(rowIndex, colIndex));
            }
        } else {
            int colIndex = shipCoordinate.getCommonIndex();
            for (int rowIndex = shipCoordinate.getBeginIndex(); rowIndex <= shipCoordinate.getEndIndex(); rowIndex++) {
                coordinates.add(new Coordinate(rowIndex, colIndex));
            }
        }
        return coordinates;
    }

    // ======================================= Getters & Setters =======================================

    public boolean isHorizontalShip() {
        return isHorizontalShip;
    }

    public void setHorizontalShip(boolean horizontalShip) {
        isHorizontalShip = horizontalShip;
    }

    public int getCommonIndex() {
        return commonIndex;
    }

    public void setCommonIndex(int commonIndex) {
        this.commonIndex = commonIndex;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
