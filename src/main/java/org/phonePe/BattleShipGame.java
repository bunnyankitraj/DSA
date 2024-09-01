package org.phonePe;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BattleShipGame {
    private static final char EMPTY = 'X';
    private static final Map<String, Character> shipIdentifiers = new HashMap<>();
    private static int N;
    private static char[][] battlefield;
    private static Set<String> playerAShips = new HashSet<>();
    private static Set<String> playerBShips = new HashSet<>();
    private static Set<String> firedCoordinates = new HashSet<>();

    static {
        shipIdentifiers.put("A", 'A');
        shipIdentifiers.put("B", 'B');
    }

    public static void initGame(int n) {
        N = n;
        battlefield = new char[N][N];
        for (char[] row : battlefield) {
            Arrays.fill(row, EMPTY);
        }
    }

    public static void addShip(String id, int size, int xPosA, int yPosA, int xPosB, int yPosB) {
        char shipIdA = shipIdentifiers.get("A");
        char shipIdB = shipIdentifiers.get("B");

        addShipToPlayer(id, size, xPosA, yPosA, shipIdA, playerAShips);
        addShipToPlayer(id, size, xPosB, yPosB, shipIdB, playerBShips);
    }

    private static void addShipToPlayer(String id, int size, int x, int y, char ownerId, Set<String> playerShips) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int newX = (x + i) % N;
                int newY = (y + j) % N;
                battlefield[newX][newY] = ownerId;
                playerShips.add(newX + "," + newY);
            }
        }
    }

    public static void viewBattleField() {
        System.out.println("(" + N + ", " + N + ")");
        for (char[] row : battlefield) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println("(0, 0)");
    }

    public static void startGame() {
        boolean isGameOver = false;
        boolean playerATurn = true;
        Random rand = new Random();

        while (!isGameOver) {
            String player = playerATurn ? "PlayerA" : "PlayerB";
            int x = rand.nextInt(N);
            int y = rand.nextInt(N);
            while (firedCoordinates.contains(x + "," + y)) {
                x = rand.nextInt(N);
                y = rand.nextInt(N);
            }
            firedCoordinates.add(x + "," + y);
            String hitResult = fireMissile(playerATurn, x, y);

            System.out.println(player + "'s turn: Missile fired at (" + x + ", " + y + ") : " + hitResult);
            System.out.println("Ships Remaining - PlayerA:" + playerAShips.size() / (N * N) + ", PlayerB:" + playerBShips.size() / (N * N));

            if (playerAShips.isEmpty() || playerBShips.isEmpty()) {
                isGameOver = true;
                System.out.println("GameOver. " + (playerAShips.isEmpty() ? "PlayerB" : "PlayerA") + " wins.");
            } else {
                playerATurn = !playerATurn;
            }
        }
    }

    private static String fireMissile(boolean playerATurn, int x, int y) {
        char cell = battlefield[x][y];
        if (cell == EMPTY) {
            return "Miss";
        }

        if ((playerATurn && cell == 'B') || (!playerATurn && cell == 'A')) {
            battlefield[x][y] = EMPTY;
            if (playerATurn) {
                playerBShips.remove(x + "," + y);
            } else {
                playerAShips.remove(x + "," + y);
            }
            return "Hit";
        }
        return "Miss";
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initGame(6);
        addShip("SH1", 2, 1, 5, 4, 4);
        viewBattleField();
        startGame();
    }

}
