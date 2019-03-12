package Base;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    List<String> allIP;
    public List<String> restoreIpAddresses(String s) {
        allIP = new ArrayList<>();
        String IP = new String("");
        recursionIP(s,3,IP);
        return allIP;
    }
    public void recursionIP(String s,int dotNum,String IP){
        if(dotNum == 0 && s.length()>=1){
            if(s.length()<=3&&Integer.parseInt(s)<=255) {
                if (s.charAt(0) != '0') {
                    allIP.add(IP + s);
                } else if (s.length() == 1) {
                    allIP.add(IP + s);
                }
                return;
            }
        }else{
            if(s.length()>=1) {
                if (s.charAt(0) == '0') {
                    recursionIP(s.substring(1), dotNum - 1, IP + "0.");
                } else {
                    recursionIP(s.substring(1), dotNum - 1, IP + s.charAt(0) + ".");
                    if(s.length()>=2&&Integer.parseInt(s.substring(0,2))<=255) {
                        recursionIP(s.substring(2), dotNum - 1, IP+s.substring(0,2)+".");
                    }
                    if(s.length()>=3&&Integer.parseInt(s.substring(0,3))<=255){
                        recursionIP(s.substring(3), dotNum - 1, IP+s.substring(0,3)+".");
                    }
                }
            }else{
                return;
            }
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        System.out.println(restoreIPAddresses.restoreIpAddresses("0000"));
    }
}
