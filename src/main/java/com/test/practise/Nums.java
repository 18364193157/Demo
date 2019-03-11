package com.test.practise;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-02-14 16:12
 */
public class Nums {


    public static int[] twoSum(int[] nums, int target) {
        int[] result = null;
        for (int i = 0; i < nums.length -1; i++) {
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result = new int[]{i,j};
                }
            }
        }
        return result;
    }

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public static int[] easy(int[] nums, int target) {
        //[2,7,11,15]   9
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length -1; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 输入: -123
     * 输出: -321
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }



    //获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d){
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }


    //获取某个日期的结束时间
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

    //获取本周的结束时间
    public static Date getEndDayOfWeek(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }

    //获取本周的开始时间
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    public static String begin(){
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String startDate = simpleDateFormat1.format(new Date());
        return startDate;
    }


    public static void main(String[] args) {
//        Date beginDayOfWeek = getBeginDayOfWeek();
//        Date endDayOfWeek = getEndDayOfWeek();
//        String begin = begin();
//        System.out.println(begin);
//        System.out.println(beginDayOfWeek);
//        System.out.println(endDayOfWeek);
//        int reverse = reverse(-123);
//        System.out.println(Integer.MAX_VALUE/10);
//        int[] nums = {2,7,11,15};
//        nums = easy(nums,9);
//        System.out.println();
////        int[] ints = Nums.twoSum(nums, 0);
//        if(null != nums) {
//            System.out.println("[" + nums[0] + "," + nums[1] + "]");
//        }else {
//            System.out.println("算法错误");
//        }
//        System.out.println(9%10);




    }
}
