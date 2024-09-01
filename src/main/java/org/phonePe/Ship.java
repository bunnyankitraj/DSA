package org.phonePe;
import java.util.*;

class Ship {
    private String name;
    private int size;
    private int x, y;
    private Set<String> coordinates;

    public Ship(String name, int size, int x, int y) {
        this.name = name;
        this.size = size;
        this.x = x;
        this.y = y;
        this.coordinates = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                coordinates.add((x + i) + "," + (y + j));
            }
        }
    }

    public Set<String> getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }
}

class Player {
    private String name;
    private List<Ship> ships;

    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public String getName() {
        return name;
    }

    public List<Ship> getShips() {
        return ships;
    }
}

class BattleShip {
    private int N;
    private char[][] battleField;
    private Player playerA;
    private Player playerB;
    private boolean gameStarted;

    public BattleShip() {
        this.gameStarted = false;
    }

    public void initGame(int N) {
        this.N = N;
        this.battleField = new char[N][N];
        for (char[] row : battleField) {
            Arrays.fill(row, '.');
        }
        int half = N / 2;
        playerA = new Player("Player A");
        playerB = new Player("Player B");
        gameStarted = false;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void addShip(String id, int size, int xa, int ya, int xb, int yb) {
        if (gameStarted) {
            System.out.println("Game already started");
            return;
        }

        Ship shipA = new Ship(id, size, xa, ya);
        Ship shipB = new Ship(id, size, xb, yb);

        playerA.addShip(shipA);
        playerB.addShip(shipB);

        for (String coord : shipA.getCoordinates()) {
            String[] parts = coord.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            battleField[x][y] = 'A';
        }

        for (String coord : shipB.getCoordinates()) {
            String[] parts = coord.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            battleField[x][y] = 'B';
        }
    }

    public void startGame() {
        if (!gameStarted) {
            gameStarted = true;
            System.out.println("Game started!");
        } else {
            System.out.println("Game already started!");
        }
    }

    public void fireMissile(Player attacker, Player opponent) {
        if (!gameStarted) {
            System.out.println("Game has not started yet.");
            return;
        }

        Random rand = new Random();
        int x = rand.nextInt(N);
        int y = rand.nextInt(N);

        System.out.print(attacker.getName() + " fires missile at (" + x + "," + y + "). ");

        boolean hit = false;
        for (Ship ship : opponent.getShips()) {
            for (String coord : ship.getCoordinates()) {
                String[] parts = coord.split(",");
                int shipX = Integer.parseInt(parts[0]);
                int shipY = Integer.parseInt(parts[1]);
                if (shipX == x && shipY == y) {
                    hit = true;
                    System.out.println("Hit! " + opponent.getName() + "'s ship with id " + ship.getName() + " destroyed.");
                    break;
                }
            }
            if (hit) {
                break;
            }
        }

        if (!hit) {
            System.out.println("Miss!");
        }
    }

    public void viewBattleField() {
        System.out.println("BattleField :");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(battleField[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BattleShip game = new BattleShip();
        game.initGame(10);

//        game.viewBattleField();

        game.addShip("SH1", 2, 1, 1, 4, 4);
        game.addShip("SH2", 3, 3, 3, 7, 7);

//        game.viewBattleField();

        game.startGame();

        Player playerA = game.getPlayerA();
        Player playerB = game.getPlayerB();

        game.fireMissile(playerA, playerB);
        game.fireMissile(playerB, playerA);

        game.viewBattleField();
    }
}
