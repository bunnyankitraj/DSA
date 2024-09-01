//package org.example;
//
//import java.util.*;
//
//
//public class MazeSolver {
//    static class Point {
//        int x, y;
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Point point = (Point) o;
//            return x == point.x && y == point.y;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int N = scanner.nextInt();
//        int M = scanner.nextInt();
//        scanner.nextLine(); // consume the remaining newline
//
//        char[][] maze = new char[N][M];
//        Point start = null, end = null;
//        Map<Character, List<Point>> teleporters = new HashMap<>();
//
//        // Read the maze and locate the start, end, and teleporters
//        for (int i = 0; i < N; i++) {
//            String line = scanner.nextLine();
//            for (int j = 0; j < M; j++) {
//                maze[i][j] = line.charAt(j);
//                if (maze[i][j] == 'S') {
//                    start = new Point(i, j);
//                } else if (maze[i][j] == 'E') {
//                    end = new Point(i, j);
//                } else if (Character.isUpperCase(maze[i][j])) {
//                    teleporters.putIfAbsent(maze[i][j], new ArrayList<>());
//                    teleporters.get(maze[i][j]).add(new Point(i, j));
//                }
//            }
//        }
//
//        if (start == null || end == null) {
//            System.out.println("Invalid maze input. No start or end point found.");
//            return;
//        }
//
//        char[][] result = bfs(maze, start, end, teleporters);
//
//        // Print the result
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(result[i][j]);
//            }
//            System.out.println();
//        }
//    }
//
//    private static char[][] bfs(char[][] maze, Point start, Point end, Map<Character, List<Point>> teleporters) {
//        int N = maze.length;
//        int M = maze[0].length;
//        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//        boolean[][] visited = new boolean[N][M];
//        Queue<Point> queue = new LinkedList<>();
//        Map<Point, Point> prev = new HashMap<>();
//
//        queue.add(start);
//        visited[start.x][start.y] = true;
//
//        while (!queue.isEmpty()) {
//            Point current = queue.poll();
//
//            // Check if we've reached the end
//            if (current.equals(end)) {
//                return markPath(maze, start, end, prev);
//            }
//
//            // Explore neighbors
//            for (int[] dir : directions) {
//                int newX = current.x + dir[0];
//                int newY = current.y + dir[1];
//                if (isValidMove(newX, newY, maze, visited)) {
//                    Point neighbor = new Point(newX, newY);
//                    queue.add(neighbor);
//                    visited[newX][newY] = true;
//                    prev.put(neighbor, current);
//                }
//            }
//
//            // Check for teleportation
//            char currentChar = maze[current.x][current.y];
//            if (Character.isUpperCase(currentChar)) {
//                List<Point> teleporterPoints = teleporters.get(currentChar);
//                if (teleporterPoints != null) {
//                    for (Point p : teleporterPoints) {
//                        if (!visited[p.x][p.y] && !p.equals(current)) {
//                            queue.add(p);
//                            visited[p.x][p.y] = true;
//                            prev.put(p, current);
//                        }
//                    }
//                }
//            }
//        }
//
//        return maze; // Return original maze if no path is found
//    }
//
//    private static boolean isValidMove(int x, int y, char[][] maze, boolean[][] visited) {
//        int N = maze.length;
//        int M = maze[0].length;
//        return x >= 0 && x < N && y >= 0 && y < M && maze[x][y] != '1' && !visited[x][y];
//    }
//
//    private static char[][] markPath(char[][] maze, Point start, Point end, Map<Point, Point> prev) {
//        Point current = end;
//        while (!current.equals(start)) {
//            Point next = prev.get(current);
//            if (!next.equals(start)) {
//                maze[next.x][next.y] = 'X';
//            }
//            current = next;
//        }
//        return maze;
//    }
//}
//
///*
//6 6
//S 1 0 0 0 0
//0 1 0 A 0 E
//0 1 0 1 0 1
//0 A 0 0 0 0
//0 1 0 1 0 1
//0 0 0 0 0 1
//
//
//6 6
//S10000
//010A0E
//010101
//0A0000
//010101
//000001
//
//
//S 1 0 0 0 0
//X 1 0 X X E
//X 1 0 1 0 1
//X X 0 0 0 0
//0 1 0 1 0 1
//0 0 0 0 0 1
//
//
// */
//
