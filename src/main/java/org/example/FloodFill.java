package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}

class FloodFill {

//    private void dfs(int[][] vis,int[][] grid,int r,int c,int color){
//        Queue<Pairs> queue = new LinkedList<>();
//        vis[r][c]=color;
//        Pairs pairs = new Pairs(r,c);
//        queue.add(pairs);
//        int n = grid.length;
//        int m = grid[0].length;
//
//        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        while(!queue.isEmpty()){
//            Pairs pairs1 = queue.remove();
//            int row = pairs1.start;
//            int col = pairs1.end;
//            vis[row][col]=color;
//
//            for(int i = 0 ;i<dirs.length;i++){
//                int[] dir = dirs[i];
//                int newRow = row + dir[0];
//                int newCol = col + dir[1];
//
//                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m){
//                    if(grid[newRow][newCol]==color && vis[newRow][newCol]==0){
//                        Pairs pairs2 = new Pairs(newRow,newCol);
//                        queue.add(pairs2);
//                        vis[newRow][newCol] = color;
//                    }
//                }
//            }
//
//        }
//    }

    public static void main(String[] args) {
        String s1 = "H";
        String s2 = "Hi";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        Map<Person, String> personMap = new HashMap<>();
        Person p1 = new Person("John", 30);
        Person p2 = new Person("John", 30);

        personMap.put(p1, "Engineer");

        System.out.println(personMap.get(p2)); // Should print "Engineer" if equals and hashCode are overridden correctly
        System.out.println(personMap.get(p1));

    }
}