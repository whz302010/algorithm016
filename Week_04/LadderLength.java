package AlgorithmExercise.Week4.middle;

import javafx.util.Pair;

import java.util.*;

/**
 * @description
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:wuhaizhong
 * @date:2020/10/8
 */
public class LadderLength {

    private int count = Integer.MAX_VALUE;
    /**
     * dfs
     * 超时
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dfs(beginWord,endWord,wordList,1,new HashSet<>());
        return count == Integer.MAX_VALUE?0:count;
    }

    public void dfs(String beginWord, String endWord, List<String> wordList, int count, HashSet<String> findWords){
        if (beginWord.equals(endWord)){
            this.count = Math.min(this.count,count);
            System.out.println("count ="+count);
            return;
        }
        char[] begins = beginWord.toCharArray();
        for (String word : wordList){
            int c = 0;
            char[] words = word.toCharArray();
            for (int i=0 ;i<words.length;i++){
                if (begins[i]!=words[i]){
                    if (++c>1){
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(findWords.toArray()));
            if (c==1 && !findWords.contains(word)){
//                System.out.println("发现"+word);
                findWords.add(word);
                dfs(word,endWord,wordList,count+1,findWords);
                findWords.remove(word);
            }
        }
    }

    /**
     * bfs
     * 1333 ms
     * , 在所有 Java 提交中击败了
     * 10.93%
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        int count = 0;
        Queue<String> queue = new LinkedList<>();
//        Set<String > visited = new HashSet<>();
        //优化
        boolean[] visited = new boolean[wordList.size()];
        queue.offer(beginWord);
//        visited.add(beginWord);
        int i = wordList.indexOf(beginWord);
        if (i!=-1){
            visited[i] = true;
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            while (size>0){
                size--;
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int j = 0; j<wordList.size();j++){
                    String c = wordList.get(j);
//                for (String c : wordList){
//                    if (visited.contains(c)){
//                        continue;
//                    }
                    if (visited[j]){
                        continue;
                    }
                    if (!canConvert(chars, c)){
                        continue;
                    }
                    if (c.equals(endWord)){
                        return count + 1;
                    }
//                    visited.add(c);
                    visited[j] = true;
                    queue.offer(c);
                }
            }

        }
        return 0;
    }

    /**
     * 字符串相差一
     * @param chars
     * @param c
     * @return
     */
    private boolean canConvert(char[] chars, String c) {
        if (chars.length!=c.length()){
            return false;
        }
        char[] chars1 = c.toCharArray();
        int temp =0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]!=chars1[i]){
                if (++temp>1){
                    return false;
                }
            }
        }
        return temp==1;
    }


    /**
     * 双向bfs
     * 39.70%
     * 的用户
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList){
        if (!wordList.contains(endWord)){
            return 0;
        }
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        visited1.add(beginWord);
        visited2.add(endWord);

        int count = 0;
        while (!queue1.isEmpty() &&! queue2.isEmpty()){
            //选取深度最小的作bfs
            count++;
            if (queue1.size()>queue2.size()){
                Queue<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size = queue1.size();
            while (size-->0){
                String word = queue1.poll();
                for (String w : wordList){
                    if (visited1.contains(w)){
                        continue;
                    }
                    if (!canConvert(word.toCharArray(),w)){
                        continue;
                    }
                    if (visited2.contains(w)){
                        return count + 1;
                    }
                    queue1.offer(w);
                    visited1.add(w);
                }
            }
        }
        return 0;
    }

    /**
     * 官方题解
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthOffical(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        List<String> res = Arrays.asList("si","go","se","cm","so","ph","mt",
                "db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca",
                "br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po",
                "fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt",
                "lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh",
                "co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os",
                "uh","wm","an","me","mo","na","la","st","er","sc","ne","mn",
                "mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa",
                "he","lr","sq","ye");
        LadderLength ladderLength = new LadderLength();
        ladderLength.ladderLength("qa","sq",res);
    }
}
