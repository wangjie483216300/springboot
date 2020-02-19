package com.company;

/**给定两个字符串 s 和 t，它们只包含小写字母。
        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
        请找出在 t 中被添加的字母。*/
public class FindTheDifference {
    public static String findTheDifference(String s, String t) {
        String str1="";
        String[] s1 = s.split("");
        String[] t1 = t.split("");
        for (int i = 0 ; i < t1.length ; i++ ){
            int str = 0 ;
            for (int j = 0 ; j < s1.length ; j++){
                if (t1[i].equals(s1[j])){
                    str = 1;
                }
            }
            if (str!=1){
                str1=t1[i];
            }
        }
        return str1;
    }
    public static void main(String[] args) {
        String s="abcdefgh";
        String t="dhcgkaebf";
        System.out.println("输入:\ns = "+s+"\nt = "+t);
        System.out.println("输出: ''"+findTheDifference(s,t)+ "'' 是被添加的那个字母。");
    }
}
