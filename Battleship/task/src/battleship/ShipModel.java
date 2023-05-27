package battleship;

public enum ShipModel {
    AIRCRAFT("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);
    private final String shipName;
    private final int shipLength;

    ShipModel(String shipName, int shipLength) {
        this.shipName = shipName;
        this.shipLength = shipLength;
    }

    public String getShipName() {
        return shipName;
    }

    public int getShipLength() {
        return shipLength;
    }
}
