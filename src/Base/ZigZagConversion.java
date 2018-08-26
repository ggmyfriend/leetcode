package Base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        StringBuffer [] buffer = new StringBuffer[numRows];
        for(int i = 0;i<numRows;i++){
            buffer[i] = new StringBuffer();
        }
        for(int i = 0;i<s.length();){
            for(int j = 0;j<numRows&&i<s.length();j++){
                buffer[j].append(s.charAt(i));
                i++;
            }
            for(int j = 1;j<numRows-1&&i<s.length();j++){
                buffer[j].append(s.charAt(i));
                i++;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(StringBuffer x : buffer){
            stringBuffer.append(x);
        }
        return stringBuffer.toString();
    }
}
