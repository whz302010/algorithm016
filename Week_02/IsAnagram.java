package AlgorithmExercise.Week1.diffcult;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * @author:wuhaizhong
 * @date:2020/9/14
 */
public class IsAnagram {

    /**
     * 排序对比
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return charS.equals(charT);
    }

    /**
     * 击败22.33%的用户 12ms 垃圾
     *
     * map存放次数，对比
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram_2(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0;i<charS.length;i++){
            map.compute(charS[i],(k,v)->v==null?1:++v);
        }
        for (int j=0;j<charT.length;j++){
            Integer integer = map.compute(charT[j], (k, v) ->v==null?-1:--v);
            if (integer==0){
                map.remove(charT[j]);
            }
        }

        return map.isEmpty();
    }

    /**
     * 注意，假设只包含小写字母
     *击败99.88%  2ms
     * 空间复杂度：O(n)
     * 时间复杂度：O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_3(String s, String t){
        if (s.length()!=t.length()){
            return false;
        }
        int[] cacheArr = new int[26];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i=0;i<charS.length;i++){
            cacheArr[charS[i]-'a'] ++;
            cacheArr[charT[i]-'a'] --;
        }
        for (int j=0;j<cacheArr.length;j++){
            if (cacheArr[j]>0){
                return false;
            }
        }
        return true;
    }

}
