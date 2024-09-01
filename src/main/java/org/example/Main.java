package org.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Simulate the call to `priceLockViewContent.getTncText()`
//        String tncTextInput = "If the price drops <svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M13.3331 12.4493L13.3331 6.04163C13.3331 5.69645 13.6129 5.41663 13.9581 5.41663C14.3032 5.41663 14.5831 5.69645 14.5831 6.04163L14.5831 13.9582C14.5831 14.3034 14.3032 14.5832 13.9581 14.5832L6.04151 14.5833C5.69633 14.5833 5.41651 14.3035 5.4165 13.9583C5.4165 13.6131 5.69632 13.3333 6.0415 13.3333L12.4492 13.3332L5.59956 6.48362C5.35549 6.23955 5.35548 5.84382 5.59956 5.59974C5.84364 5.35566 6.23937 5.35566 6.48344 5.59974L13.3331 12.4493Z\" fill=\"#1D7D3D\"/></svg> you'll pay the <span style=\"color:#238C46\"><b>lower price</b></span> || \n If the price increases <svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M12.4492 6.66675L6.0415 6.66675C5.69633 6.66675 5.4165 6.38693 5.4165 6.04175C5.4165 5.69657 5.69633 5.41675 6.0415 5.41675L13.9581 5.41675C14.3032 5.41675 14.5831 5.69656 14.5831 6.04174L14.5832 13.9583C14.5832 14.3035 14.3034 14.5833 13.9582 14.5833C13.613 14.5833 13.3332 14.3035 13.3332 13.9583L13.3331 7.55062L6.4835 14.4002C6.23942 14.6443 5.8437 14.6443 5.59962 14.4002C5.35554 14.1562 5.35554 13.7604 5.59961 13.5164L12.4492 6.66675Z\" fill=\"#DC3532\"/></svg> per traveller";
//
//        // Process the tncTextInput
//        List<String> tncText = Arrays.stream(tncTextInput.split("\\|\\|"))
//                .map(String::trim)
//                .collect(Collectors.toList());
//
//        // Print the processed list to confirm it's working as expected
//        tncText.forEach(System.out::println);
        System.out.println(getDaysVsHoursLogic(24));
//        System.out.println(getTimezoneAbbreviation("Asia/Kolkata"));
    }

    private static CharSequence getDaysVsHoursLogic(Integer priceLockExpiry) {
        if (priceLockExpiry < 24) {
            return priceLockExpiry + " hour" + (priceLockExpiry == 1 ? "" : "s");
        }

        int days = priceLockExpiry / 24;
        int hours = priceLockExpiry % 24;

        String daysString = days + " day" + (days == 1 ? "" : "s");
        String hoursString = hours + " hour" + (hours == 1 ? "" : "s");

        return hours == 0 ? daysString : daysString + " " + hoursString;
    }

//    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        Stack<Integer> st = new Stack<>();
//        ans.add(-1);
//        st.push(A.get(0));
//        for(int i =1;i<A.size();i++){
//            while(!st.isEmpty() && st.peek()>A.get(i) ){
//                st.pop();
//            }
//            if(st.isEmpty()){
//                ans.add(-1);
//            }
//            else{
//                ans.add(st.peek());
//            }
//            st.push(A.get(i));
//        }
//        return ans;
//    }

    public static String getTimezoneAbbreviation(String timezoneId) {
        try {
            ZoneId zoneId = ZoneId.of(timezoneId);
            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("zzz", Locale.ENGLISH);
            return zonedDateTime.format(formatter);
        } catch (Exception e) {
            System.out.println("Timezone abbreviation conversion failed");
            return null;
        }
    }

//    public static CharSequence getDaysVsHoursLogic(Integer priceLockExpiry) {
//        if (priceLockExpiry < 24) {
//            return priceLockExpiry + " hour" + (priceLockExpiry == 1 ? "" : "s");
//        }
//
//        int days = priceLockExpiry / 24;
//        int hours = priceLockExpiry % 24;
//
//        String daysString = days + " day" + (days == 1 ? "" : "s");
//        String hoursString = hours + " hour" + (hours == 1 ? "" : "s");
//
//        return hours == 0 ? daysString : daysString + " " + hoursString;
//    }
}
