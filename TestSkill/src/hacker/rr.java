package hacker;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class rr {

    public static void main(String[] args) throws IOException {

      int n = (int)Math.pow(2,31);

      Scanner sc = new Scanner(System.in);
      BigInteger b = sc.nextBigInteger();

      Date l = new Date(2021, 10, 10, 0,0);


      String s = "           YES      leading spaces        are valid,    problemsetters are         evillllll";
      List<Character> chars = Arrays.asList(new Character[]{' ', '!', ',', '?', '.', '_', '\'', '@'});
      List<String> str = new ArrayList();
      String st = "";
      for(int i=0; i<s.length(); i++) {
        char ch = s.charAt(i);
        if(chars.contains(ch)) {
          if(!st.equals("")) {
            str.add(st);
          }
          st="";
        } else {
          st=st+ch;
        }
      }
      if(!st.equals("")) {
        str.add(st);
      }
      System.out.println(str.size());
      for(String s1 : str) {
        System.out.println(s1);
      }

//     try {
//       Float f1 = 3.0f;
//       int x = f1.intValue();
//       byte b = f1.byteValue();
//       double d = f1.doubleValue();
//       System.out.println(x + b + d);
//     } catch(NumberFormatException e) {
//       System.out.println("x + b + d");
//     }

//     String s = "abc";
//     s = s.toLowerCase();
//     System.out.print(Character.toUpperCase(s.charAt(0))+s.substring(1,s.length()));
//     s.compareTo(s);
//
//     Math.pow(10, 2);
//     Map<Character,Integer> map = new HashMap();
//     map.keySet();
//     int t = s.charAt(0);
//      List<Character> chars = Arrays.asList(new Character[]{' ', '!', ',', '?', '.', '_', '\'', '@','\n'});


      }






}
