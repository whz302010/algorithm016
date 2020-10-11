package AlgorithmExercise.Week4.middle;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 *
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 *
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 *
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 *
 * 注意:
 *
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 示例 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * 返回值: 1
 * 示例 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * 返回值: 2
 * 示例 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * 返回值: 3
 *
 * 来源：力扣（LeetCode）
 * @author:wuhaizhong
 * @date:2020/10/5
 */
public class MinMutation {

    int count = Integer.MAX_VALUE;
    boolean hasReturn =false;
    /**
     * 思路：遍历基因库，查找与当前基因差一的基因，基因数++
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<>(),start,end,bank,0);
        return count == Integer.MAX_VALUE?-1:count;
    }

    public void dfs(HashSet<String> bak,String current, String end, String[] bank,int step){
        if (current.equals(end)){
            count = Math.min(step,count);
        }
        System.out.println(step);
        char[] starts = current.toCharArray();
        for (String str: bank){
            char[] chars = str.toCharArray();
            int diff = 0;
            for(int i = 0 ;i<chars.length;i++){
                if (chars[i]!=starts[i]){
                    diff++;
                    if (diff>1){
                        break;
                    }
                }
            }
            if (diff==1 && !bak.contains(str)){
                bak.add(str);
                dfs(bak,str,end,bank,step + 1);
                bak.remove(str);
            }
        }
    }
    public static void main(String[] args) {

        MinMutation minMutation = new MinMutation();
        minMutation.minMutation("AAAAACCC","AACCCCCC",
                new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"});
        System.out.println(minMutation.count);
    }
}
