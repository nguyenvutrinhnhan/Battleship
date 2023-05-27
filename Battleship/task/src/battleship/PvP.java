package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PvP {
    Scanner scanner = new Scanner(System.in);

    // Player 1
    // public List<Ship> Player1_SHIPS = new ArrayList<>(Arrays.asList(new Aircraft("F3", "F7"), new Battleship("A1", "D1"), new Submarine("B9", "D9"), new Cruiser("J8", "J10"), new Destroyer("I2", "J2")));
    public List<Ship> Player1_SHIPS = new ArrayList<>(Arrays.asList(new Destroyer("I2", "J2")));
    public List<String> Player1_mockShooting = new ArrayList<>(Arrays.asList("F3", "F4", "F5", "F6", "F7", "A1", "B1", "C1", "D1", "B9", "C9", "D9", "J8", "J9", "J10", "I2"));
    // Player player1 = new Player("Player 1", Player1_SHIPS, Player1_mockShooting);
    Player player1 = new Player("Player 1");

    // Player 2
    // public List<Ship> Player2_SHIPS = new ArrayList<>(Arrays.asList(new Aircraft("H2", "H6"), new Battleship("F3", "F6"), new Submarine("D4", "D6"), new Cruiser("F8", "H8"), new Destroyer("C8", "D8")));
    public List<Ship> Player2_SHIPS = new ArrayList<>(Arrays.asList(new Destroyer("C8", "D8")));
    public List<String> Player2_mockShooting = new ArrayList<>(Arrays.asList("H2", "H3", "H4", "H5", "H6", "F3", "F4", "F5", "F6", "D4", "D5", "D6", "F8", "G8", "H8", "C8"));
    // Player player2 = new Player("Player 2", Player2_SHIPS, Player2_mockShooting);
    Player player2 = new Player("Player 2");

    Player currentTurnPlayer = player1;
    Player lastTurnPlayer;

    public PvP() {
        this.setCurrentTurnPlayer(player1);
    }

    public void startGame() {
        this.buildShip(player1);
        this.pressEnterToSwitchTurn();
        this.buildShip(player2);
        while (player1.hasShips() && player2.hasShips()) {
            this.fireShips();
        }
    }

    public void buildShip(Player player) {
        player.getPlayerField().setupField();
        System.out.println(player.getPlayerName() + ", place your ships on the game field\n");
        player.getPlayerField().displayField(false);
        // player.mockPlaceShips();
        player.placeShips(scanner);
    }

    // TODO: implement real shoot

    public void fireShips() {
        this.pressEnterToSwitchTurn();
        Player currentPlayer = this.getCurrentTurnPlayer();
        Player lastPlayer = this.getLastTurnPlayer();
        this.displayBothFields();
        System.out.println("\n" + currentPlayer.getPlayerName() + ", it's your turn:");
        lastPlayer.beFired(scanner);
    }

    public void mockFireShips() {
        Player currentPlayer = this.getCurrentTurnPlayer();
        Player lastPlayer = this.getLastTurnPlayer();
        this.displayBothFields();
        System.out.println("\n" + currentPlayer.getPlayerName() + ", it's your turn:");
        lastPlayer.beFired(scanner);
        this.mockPressEnterToSwitchTurn();
    }

    public void displayBothFields() {
        this.getLastTurnPlayer().getPlayerField().displayField(true);
        System.out.println("---------------------");
        this.getCurrentTurnPlayer().getPlayerField().displayField(false);
    }

    public void pressEnterToSwitchTurn() {
        System.out.print("\nPress Enter and pass the move to another player\n");
        scanner.nextLine();
        setCurrentTurnPlayer(getCurrentTurnPlayer().equals(player1) ? player2 : player1);
        setLastTurnPlayer(getCurrentTurnPlayer().equals(player1) ? player2 : player1);
    }

    public void mockPressEnterToSwitchTurn() {
        System.out.print("\nMOCK Press Enter and pass the move to another player\n");
        setCurrentTurnPlayer(getCurrentTurnPlayer().equals(player1) ? player2 : player1);
        setLastTurnPlayer(getCurrentTurnPlayer().equals(player1) ? player2 : player1);
    }

    public Player getCurrentTurnPlayer() {
        return currentTurnPlayer;
    }

    public Player getLastTurnPlayer() {
        return lastTurnPlayer;
    }

    public void setCurrentTurnPlayer(Player currentTurnPlayer) {
        this.currentTurnPlayer = currentTurnPlayer;
    }

    public void setLastTurnPlayer(Player lastTurnPlayer) {
        this.lastTurnPlayer = lastTurnPlayer;
    }
}
