package AlgorithmExercise.Week4.middle;

/**
 * @description
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:wuhaizhong
 * @date:2020/10/13
 */
public class SearchMatrix {

    /**
     * 单调递增，二分法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int[] arr = new int[matrix.length*matrix[0].length];
        int index =0;
        for (int i =0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                arr[index++] = matrix[i][j];
            }
        }
        int left =0,right = arr.length -1;
        int middle =0;
        while (left<=right){
            middle = (left+right)/2;
            if (arr[middle]==target){
                return true;
            }
            if (arr[middle]>=target){
                right = middle -1;
            }else {
                left = middle + 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] ints = {{1, 3}};
        new SearchMatrix().searchMatrix(ints,3);
    }

}
