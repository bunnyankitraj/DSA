package org.example;

public class numberOfSeniorCitizen {

    public static int countSeniors(String[] details) {
        int cnt = 0;
        for(String s: details){
            String no = s.substring(0,10);
            String gender =  s.substring(10,11);
            String age = s.substring(11,13);
            String seat = s.substring(13,15);
            System.out.println(no);
            System.out.println(gender);
            System.out.println(seat);
            if(Integer.parseInt(age)>60){
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(countSeniors(details));
    }
}
