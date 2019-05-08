package com.lewis.learn.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;


/**
 * @author zhangminghua
 * @date 2019/05/08
 * <p>
 * https://leetcode.com/problems/roman-to-integer/
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5)
 * and X (10) to make 4 and 9.
 * X can be placed before L (50)
 * and C (100) to make 40 and 90.
 * C can be placed before D (500)
 * and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomainToInteger {

    public static void main(String[] args) {
        RomainToInteger romainToInteger = new RomainToInteger();
        int iv = romainToInteger.fastRomanToInt("IV");
        System.out.println(iv);
    }


    private static Map<Character, Character> substractPairMap = new HashMap<>(8);
    private static Map<Character, Integer> letter2NumberMap = new HashMap<>(8);

    static {
        substractPairMap.put('V', 'I');
        substractPairMap.put('X', 'I');
        substractPairMap.put('L', 'X');
        substractPairMap.put('C', 'X');
        substractPairMap.put('D', 'C');
        substractPairMap.put('M', 'C');

        letter2NumberMap.put('I', 1);
        letter2NumberMap.put('V', 5);
        letter2NumberMap.put('X', 10);
        letter2NumberMap.put('L', 50);
        letter2NumberMap.put('C', 100);
        letter2NumberMap.put('D', 500);
        letter2NumberMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; ) {
            char firstChar = chars[i];
            if (i + 1 < chars.length) {
                char secondChar = chars[i + 1];
                if (substractPairMap.containsKey(secondChar) && substractPairMap.get(secondChar) == firstChar) {
                    sum += (letter2NumberMap.get(secondChar) - letter2NumberMap.get(firstChar));
                    i += 2;
                } else {
                    sum += letter2NumberMap.get(firstChar);
                    i++;
                }
            } else {
                sum += letter2NumberMap.get(firstChar);
                i++;
            }
        }
        return sum;
    }

    public int fastRomanToInt(String input) {
        char[] chars = input.toCharArray();
        char pre = ' ';
        int sum = 0;
        for (char aChar : chars) {
            sum += getValueNumber(aChar, pre);
            pre = aChar;
        }
        return sum;
    }

    private int getValueNumber(char aChar, char pre) {
        switch (aChar) {
            case 'I':
                return 1;
            case 'V':
                return pre == 'I' ? 3 : 5;
            case 'X':
                return pre == 'I' ? 8 : 10;
            case 'L':
                return pre == 'X' ? 30 : 50;
            case 'C':
                return pre == 'X' ? 80 : 100;
            case 'D':
                return pre == 'C' ? 300 : 500;
            case 'M':
                return pre == 'C' ? 800 : 1000;
            default:
                break;
        }
        return 0;
    }
}
