package Base;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String result = "0";
        for(int i = num2.length()-1;i>=0;i--){
            result = this.addString(result,this.mutiplyTwoString(num1,String.valueOf(num2.charAt(i)-'0'),num2.length() - 1 - i));
        }
        return result;
    }

    /**
     * num2 must less than 10
     * @param num1
     * @param num2
     * @param zeroNum Complement 0 at end
     * @return
     */
    public String mutiplyTwoString(String num1,String num2,int zeroNum){
        if(num1.equals("0")){
            return "0";
        }
        if(num2.equals("0")){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int index1=num1.length()-1;
        int carry = 0;
        int multiplier = num2.charAt(0) - '0';
        while(index1>=0){
            int sum = carry + (num1.charAt(index1) - '0') * multiplier;
            if(sum >= 10){
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            result.insert(0,sum);
            index1--;

        }
        if(carry>0){
            result.insert(0,carry);
        }
        for(int i = 0 ;i<zeroNum;i++){
            result.append(0);
        }
        return result.toString();
    }
    /**
     * add two string
     * @param num1
     * @param num2
     * @return
     */
    public String addString(String num1, String num2){
        StringBuilder result = new StringBuilder();
        int index1=num1.length()-1,index2=num2.length()-1;
        int carry = 0;
        while(index1>=0&&index2>=0){
            int sum = carry + num1.charAt(index1) - '0' + num2.charAt(index2) - '0';
            if(sum >= 10){
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            result.insert(0,sum);
            index1--;
            index2--;
        }
        while(index1>=0) {
            int sum = carry + num1.charAt(index1) - '0';
            if(sum >= 10){
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            result.insert(0,sum);
            index1--;
        }
        while(index2>=0) {
            int sum = carry + num2.charAt(index2) - '0';
            if(sum >= 10){
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            result.insert(0,sum);
            index2--;
        }
        if(carry>0){
            result.insert(0,carry);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("1230013","10"));
    }
}
