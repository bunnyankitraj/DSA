package org.example;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class CarFleet {
    public int carFleet(int target, int[] pos, int[] speed) {
        Map<Integer,Integer> mp = new TreeMap<>();
        for(int i=0;i<pos.length;i++){
            mp.put(pos[i],speed[i]);
        }

        Stack<Float> s = new Stack();
        int count =0;

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            Float timeToReach = (float) ((target - entry.getKey()) / entry.getValue());
            if(s.isEmpty()){
                s.push(timeToReach);
                continue;
            }
            Float x = s.peek();
            if(timeToReach>x){
                while(!s.isEmpty()){
                    s.pop();
                }
                s.push(timeToReach);
                count++;
            }
            else{
                s.push(timeToReach);
            }
        }
        if(!s.isEmpty()){
            count++;
        }
        return count;
    }
}
