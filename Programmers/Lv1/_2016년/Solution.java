package _2016년;

class Solution {
    public String solution(int a, int b) {
        String[] str = {"THU","FRI", "SAT","SUN", "MON", "TUE", "WED"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int day = 0;
        for(int i=0; i<a-1; i++) day += month[i];
        day+=b;
        return str[day%7];
    }
}