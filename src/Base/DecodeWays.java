package Base;

public class DecodeWays {
    public int numDecodings(String s) {
        int[] nums = new int[s.length()];
        if(Integer.parseInt(s.substring(0,1))!=0){
            nums[0] = 1;
        }else{
            nums[0] = 0;
        }
        if(s.length()>=2) {
            if(Integer.parseInt(s.substring(0, 2)) == 0){
                nums[1] = 0;
            }
            else if (Integer.parseInt(s.substring(0, 2)) < 10) {
                nums[1] = 0;
            } else if (Integer.parseInt(s.substring(0, 2)) == 10) {
                nums[1] = 1;
            } else if (Integer.parseInt(s.substring(0, 2)) == 20) {
                nums[1] = 1;
            } else if (Integer.parseInt(s.substring(0, 2)) <= 26) {
                nums[1] = 2;
            } else {
                if(Integer.parseInt(s.substring(0, 2))%10==0) {
                    return 0;
                }
                else{
                    nums[1] = 1;
                }
            }
        }
        for(int i = 2;i<s.length();i++){
            if(Integer.parseInt(s.substring(i-1,i+1)) == 0){
                return 0;
            }else if(Integer.parseInt(s.substring(i-1,i+1))<10){
                nums[i] = nums[i-2];
            }else if(Integer.parseInt(s.substring(i-1,i+1))==10){
                nums[i] = nums[i-2];
            }else if(Integer.parseInt(s.substring(i-1,i+1))==20){
                nums[i] = nums[i-2];
            }else if(Integer.parseInt(s.substring(i-1,i+1))<=26){
                nums[i] = nums[i-1]+nums[i-2];
            }else{
                if(Integer.parseInt(s.substring(i-1, i+1))%10==0) {
                    return 0;
                }
                else{
                    nums[i] = nums[i-1];
                }
            }
        }
        return nums[s.length()-1];
    }
    //更简便更加好的解决方案
    public int numDecodingsBetter(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("1001"));
    }
}
