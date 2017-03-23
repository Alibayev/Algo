package com.company.CrackingTheCodingInterview.Various;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bekzodalibayev on 3/18/17.
 */
public class LongestPalindrom {
    int max = 0;
    String longestPal = null;

    public static void main(String[] args){
        LongestPalindrom obj = new LongestPalindrom();
        System.out.println(obj.longestPalindrome("\"ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy\""));
    }
//    public String longestPalindrome(String s) {
//        longestPalindromeUtil(s, new HashSet<String>());
//        return longestPal;
//    }
//
//    public void longestPalindromeUtil(String s, Set<String> set){
//        if(s.length() == 0 || max >= s.length() || set.contains(s)){
//            return;
//        }
//        set.add(s);
//        if(IsPalindrome(s)){
//            if(max < s.length()){
//                longestPal = s;
//                max = s.length();
//            }
//            return;
//        }
//        longestPalindromeUtil(s.substring(0, s.length() - 1), set);
//        longestPalindromeUtil(s.substring(1, s.length()), set);
//    }
public String longestPalindrome(String s) {
    for(int i = 0; i < s.length(); i++){
        for(int j = i; j < s.length(); j++){
            String temp = s.substring(i,j + 1);
            if(IsPalindrome(temp)){
                if(temp.length() > max){
                    max = temp.length();
                    longestPal = temp;
                }
            }
        }
    }
    return longestPal;
}

    public boolean IsPalindrome(String s){
        if(s.length() == 0) return false;
        if(s.length() == 1) return true;
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
