package battleship;

import java.util.List;

public class Ship {
    private ShipModel shipModel;
    private ShipCoordinate shipCoordinate;
    private List<Coordinate> shipStrength;
    private boolean isDestroyed;

    public Ship(ShipModel shipModel) {
        this.shipModel = shipModel;
    }

    public Ship(ShipModel shipModel, String beginCoordinate, String endCoordinate) {
        this.shipModel = shipModel;
        this.shipCoordinate = ShipCoordinate.convertToShipCoordinate(beginCoordinate, endCoordinate);
    }

    public boolean checkCoordinateOnShip(Coordinate coordinate) {
        return shipStrength.contains(coordinate);
    }

    public ShipModel getShipModel() {
        return shipModel;
    }

    public ShipCoordinate getShipCoordinate() {
        return shipCoordinate;
    }

    public void setShipCoordinate(ShipCoordinate shipCoordinate) {
        this.shipCoordinate = shipCoordinate;
    }

    public List<Coordinate> getShipStrength() {
        return shipStrength;
    }

    public void setShipStrength(ShipCoordinate shipCoordinate) {
        this.shipStrength = ShipCoordinate.getRangeShipCoordinates(shipCoordinate);
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}

class Aircraft extends Ship {

    public Aircraft() {
        super(ShipModel.AIRCRAFT);
    }

    public Aircraft(String beginCoordinate, String endCoordinate) {
        super(ShipModel.AIRCRAFT, beginCoordinate, endCoordinate);
    }
}

class Battleship extends Ship {

    public Battleship() {
        super(ShipModel.BATTLESHIP);
    }

    public Battleship(String beginCoordinate, String endCoordinate) {
        super(ShipModel.BATTLESHIP, beginCoordinate, endCoordinate);
    }
}

class Submarine extends Ship {

    public Submarine() {
        super(ShipModel.SUBMARINE);
    }

    public Submarine(String beginCoordinate, String endCoordinate) {
        super(ShipModel.SUBMARINE, beginCoordinate, endCoordinate);
    }
}

class Cruiser extends Ship {

    public Cruiser() {
        super(ShipModel.CRUISER);
    }

    public Cruiser(String beginCoordinate, String endCoordinate) {
        super(ShipModel.CRUISER, beginCoordinate, endCoordinate);
    }
}

class Destroyer extends Ship {

    public Destroyer() {
        super(ShipModel.DESTROYER);
    }

    public Destroyer(String beginCoordinate, String endCoordinate) {
        super(ShipModel.DESTROYER, beginCoordinate, endCoordinate);
    }
}
