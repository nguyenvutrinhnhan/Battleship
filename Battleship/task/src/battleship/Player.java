package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static battleship.Constants.SIZE_COL;
import static battleship.Constants.SIZE_ROW;
import static battleship.Constants.SYMBOL_HIT;
import static battleship.Constants.SYMBOL_MISSED;
import static battleship.Constants.SYMBOL_PLACED;
import static battleship.Coordinate.convertToCoordinate;
import static battleship.Coordinate.convertToCoordinates;
import static battleship.ShipCoordinate.checkShipHasValidLength;
import static battleship.ShipCoordinate.checkShipIsFarFromAnotherOne;
import static battleship.ShipCoordinate.checkShipIsHorizontalOrVertical;

public class Player {
    private String playerName;
    private List<Ship> playerShips;
    private List<String> mockShootingCoordinate;
    private boolean hasShips = true;
    private GameField playerField;

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerShips = new ArrayList<>(Arrays.asList(new Aircraft(), new Battleship(), new Submarine(), new Cruiser(), new Destroyer()));
        // this.playerShips = new ArrayList<>(Arrays.asList(new Aircraft("A1", "A5"), new Battleship("C1", "C4"), new Submarine("E1", "E3"), new Cruiser("G1", "G3"), new Destroyer("I1", "I2")));
        this.playerField = new GameField(SIZE_ROW, SIZE_COL);
    }

    public Player(String playerName, List<Ship> playerShips, List<String> mockShootingCoordinate) {
        this.playerName = playerName;
        this.playerShips = playerShips;
        this.mockShootingCoordinate = mockShootingCoordinate;
        this.playerField = new GameField(SIZE_ROW, SIZE_COL);
    }

    // ============================================ BUILD SHIPS ============================================
    public void placeShips(Scanner scanner) {
        for (Ship ship : playerShips) {
            System.out.println("\nEnter the coordinates of the " + ship.getShipModel().getShipName() + " (" + ship.getShipModel().getShipLength() + " cells):");
            ShipCoordinate shipCoordinate = inputAndReturnValidShipCoordinate(scanner, ship);
            buildShip(ship, shipCoordinate);
            playerField.displayField(false);
        }
    }

    public void mockPlaceShips() {
        for (Ship ship : playerShips) {
            buildShip(ship, ship.getShipCoordinate());
            playerField.displayField(false);
        }
    }

    public void buildShip(Ship ship, ShipCoordinate shipCoordinate) {

        if (shipCoordinate.isHorizontalShip()) {
            int rowIndex = shipCoordinate.getCommonIndex();
            for (int i = shipCoordinate.getBeginIndex(); i <= shipCoordinate.getEndIndex(); i++) {
                playerField.setCoordinateValue(rowIndex, i, SYMBOL_PLACED);
            }
        } else {
            int colIndex = shipCoordinate.getCommonIndex();
            for (int i = shipCoordinate.getBeginIndex(); i <= shipCoordinate.getEndIndex(); i++) {
                playerField.setCoordinateValue(i, colIndex, SYMBOL_PLACED);
            }
        }

        ship.setShipStrength(shipCoordinate);
    }

    public ShipCoordinate inputAndReturnValidShipCoordinate(Scanner scanner, Ship ship) {
        boolean isValid;
        Coordinate[] coordinates;
        do {
            String[] inputCoordinates = scanner.nextLine().split("\\s+");
            coordinates = convertToCoordinates(inputCoordinates);
            isValid = checkCoordinates(coordinates, ship);
        } while (!isValid);

        return new ShipCoordinate(coordinates);
    }

    public boolean checkCoordinates(Coordinate[] coordinates, Ship ship) {

        if (!checkShipIsHorizontalOrVertical(coordinates)) {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }

        if (!checkShipHasValidLength(coordinates, ship.getShipModel().getShipLength())) {
            System.out.println("Error! Wrong length of the " + ship.getShipModel().getShipName() + "! Try again:");
            return false;
        }

        if (!checkShipIsFarFromAnotherOne(this.getPlayerField(), coordinates)) {
            System.out.println("Error! You placed it too close to another one. Try again:");
            return false;
        }

        return true;
    }

    // ============================================ SHOOT SHIPS ============================================

    public void beFired(Scanner scanner) {
        // Coordinate coordinate = mockShootingCoordinate.size() == 0 ? inputAndReturnValidCoordinate(scanner) : mockReturnValidCoordinate();
        Coordinate coordinate = inputAndReturnValidCoordinate(scanner);
        boolean isHit = checkShooting(coordinate);
        if (isHit) {
            boolean isDestroyedShip = processShipStrengthAndCheckDestroyedShip(playerShips, coordinate);
            if (playerShips.size() > 0) {
                System.out.println(isDestroyedShip ? "You sank a ship!" : "You hit a ship!");
            } else {
                System.out.println(isDestroyedShip ? "You sank the last ship. You won. Congratulations!" : "You hit a ship!");
                this.setHasShips(false);
            }
        } else {
            System.out.println("You missed!");
        }
    }

    public Coordinate inputAndReturnValidCoordinate(Scanner scanner) {
        boolean isValid;
        Coordinate coordinate;
        do {
            String inputCoordinate = scanner.nextLine();
            coordinate = convertToCoordinate(inputCoordinate);
            isValid = checkCoordinate(coordinate);
            if (!isValid) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        } while (!isValid);
        return coordinate;
    }

    public Coordinate mockReturnValidCoordinate() {
        String inputCoordinate = mockShootingCoordinate.remove(0);
        return convertToCoordinate(inputCoordinate);
    }

    public boolean checkCoordinate(Coordinate coordinate) {
        if (coordinate.getRowIndex() >= playerField.getSizeRow()) {
            return false;
        }
        if (coordinate.getColIndex() >= playerField.getSizeCol()) {
            return false;
        }
        return true;
    }

    public boolean checkShooting(Coordinate coordinate) {
        String fieldValue = playerField.getCoordinateValue(coordinate);
        boolean isHit = fieldValue.equals(SYMBOL_PLACED) || fieldValue.equals(SYMBOL_HIT);
        playerField.setCoordinateValue(coordinate, isHit ? SYMBOL_HIT : SYMBOL_MISSED);
        // displayShot(coordinate);
        return isHit;
    }

    public boolean processShipStrengthAndCheckDestroyedShip(List<Ship> playerShips, Coordinate coordinate) {
        boolean isHitShip;
        boolean isLastHit = false;
        for (Ship ship : playerShips) {
            isHitShip = ship.checkCoordinateOnShip(coordinate);
            if (isHitShip) {
                ship.getShipStrength().remove(coordinate);
                if (ship.getShipStrength().size() == 0) {
                    isLastHit = true;
                    playerShips.remove(ship);
                }
                break;
            }
        }
        return isLastHit;
    }

    // ======================================= Getters & Setters =======================================
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<Ship> getPlayerShips() {
        return playerShips;
    }

    public void setPlayerShips(List<Ship> playerShips) {
        this.playerShips = playerShips;
    }

    public boolean hasShips() {
        return hasShips;
    }

    public void setHasShips(boolean hasShips) {
        this.hasShips = hasShips;
    }

    public GameField getPlayerField() {
        return playerField;
    }

    public void setPlayerField(GameField playerField) {
        this.playerField = playerField;
    }

    public List<String> getMockShootingCoordinate() {
        return mockShootingCoordinate;
    }

    public void setMockShootingCoordinate(List<String> mockShootingCoordinate) {
        this.mockShootingCoordinate = mockShootingCoordinate;
    }
}
