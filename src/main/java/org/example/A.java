package org.example;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class A {

    public static void main(String[] args) {
        String s1 = "24";
        String s2 = new String("24");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

//        WeakReference<>
//        SoftReference
//        long l = 1234567890;
//        System.out.println(l);

//        int y,x=1,total=0;
//        while (x<=5){
//            y= x+x;
//            total+= y;
//            ++x;
//        }
//        System.out.println(total);




//        int a =1,b=2,c,d;
//        c=++b;
//        d=a++;
//        c++;
//
//        System.out.println(a);





    }
}
