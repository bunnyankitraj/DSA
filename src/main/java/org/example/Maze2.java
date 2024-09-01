//package org.example;
//
//import java.util.*;
//
//import java.util.*;
//
//public class Maze2 {
//    static class Point {
//        int x, y;
//        Point(int x, int y) { this.x = x; this.y = y; }
//        public boolean equals(Object o) { return o instanceof Point && x == ((Point)o).x && y == ((Point)o).y; }
//        public int hashCode() { return Objects.hash(x, y); }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int M = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//
//        char[][] maze = new char[N][M];
//        Point start = null, end = null;
//        Map<Character, List<Point>> teleporters = new HashMap<>();
//
//        // Reading the maze input
//        for (int i = 0; i < N; i++) {
//            String line = scanner.nextLine();
//            for (int j = 0; j < M; j++) {
//                maze[i][j] = line.charAt(j);
//                if (maze[i][j] == 'S') start = new Point(i, j);
//                else if (maze[i][j] == 'E') end = new Point(i, j);
//                else if (Character.isUpperCase(maze[i][j]))
//                    teleporters.computeIfAbsent(maze[i][j], k -> new ArrayList<>()).add(new Point(i, j));
//            }
//        }
//
//        char[][] result = bfs(maze, start, end, teleporters);
//        for (char[] row : result) System.out.println(row);
//    }
//
////    private static char[][] bfs(char[][] maze, Point start, Point end, Map<Character, List<Point>> teleporters) {
////        Queue<Point> queue = new LinkedList<>();
////        Map<Point, Point> prev = new HashMap<>();
////        boolean[][] visited = new boolean[maze.length][maze[0].length];
////        queue.add(start);
////        visited[start.x][start.y] = true;
////
////        while (!queue.isEmpty()) {
////            Point curr = queue.poll();
////            if (curr.equals(end)) return markPath(maze, start, end, prev);
////            for (int[] dir : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
////                int x = curr.x + dir[0], y = curr.y + dir[1];
////                if (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] != '1' && !visited[x][y]) {
////                    queue.add(new Point(x, y));
////                    visited[x][y] = true;
////                    prev.put(new Point(x, y), curr);
////                }
////            }
////            if (Character.isUpperCase(maze[curr.x][curr.y]))
////                for (Point tp : teleporters.get(maze[curr.x][curr.y]))
////                    if (!visited[tp.x][tp.y]) {
////                        queue.add(tp);
////                        visited[tp.x][tp.y] = true;
////                        prev.put(tp, curr);
////                    }
////        }
////        return maze; // return original maze if no path is found
////    }
//
//    private static char[][] markPath(char[][] maze, Point start, Point end, Map<Point, Point> prev) {
//        for (Point at = end; !at.equals(start); at = prev.get(at))
//            if (!prev.get(at).equals(start)) maze[prev.get(at).x][prev.get(at).y] = 'X';
//        return maze;
//    }
//}
//
//
//
