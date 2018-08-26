package Base;
/*
Given n non-negative integers a1, a2, ..., an ,
where each represents a point at coordinate (i, ai). n
vertical lines are drawn such that the two endpoints of line
i is at (i, ai) and (i, 0). Find two lines, which together
with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    /**
     * @param height
     * @return
     * @error  Time Limit Exceeded
     */
    public int maxArea(int[] height) {
        int max=-1;
        for(int i = 0;i<height.length;i++){
            for(int j = i;j<height.length;j++){
                int area = (j-i)*(height[i]>height[j]?height[j]:height[i]);
                if(max<area){
                    max = area;
                }
            }
        }
        return max;
    }
    /**
     * accepted
     */
    public int maxArea1(int[] height) {
        int max=-1;
        int i = 0,j = height.length-1;
        while(i<j){
            int area = (j-i)*(height[i]>height[j]?height[j]:height[i]);
            if(area>max){
                max = area;
            }
            if(height[i]>height[j])
                j--;
            else
                i++;
        }
        return max;
    }
}
