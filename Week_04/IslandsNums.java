package AlgorithmExercise.Week4.middle;

/**
 * @description
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:wuhaizhong
 * @date:2020/10/9
 */
public class IslandsNums {

    /**
     * 思路：dfs
     * @param grid
     * @return
     */
    int count =0;
    public int numIslands(char[][] grid) {
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if (grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j,char[][] grid){
        if (grid[i][j]=='1'){
            grid[i][j] ='0';
            if (i > 0){
            }
            if (i<grid.length-1){
                dfs(i+1,j,grid);
            }
            if (j>0){
                dfs(i,j-1,grid);
            }
            if (j<grid[i].length-1){
                dfs(j,j+1,grid);
            }
        }
    }

    public static void main(String[] args) {
        IslandsNums islandsNums = new IslandsNums();
        char[][] chars={{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','0'}
        ,{'1','1','1','1','0'}};
        System.out.println(islandsNums.numIslands(chars));
    }
}
