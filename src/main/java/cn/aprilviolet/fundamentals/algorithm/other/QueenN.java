package cn.aprilviolet.fundamentals.algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 51. N 皇后
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.02.04 星期四 22:32
 * @since V1.0.0
 */
public class QueenN {
    List<List<String>> resultQueen = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        // 初始化
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(new String(row));
        }
        backTrack(board, 0);
        return resultQueen;
    }

    private void backTrack(List<String> board, int row) {
        // 结束条件
        if (row == board.size()) {
            resultQueen.add(new ArrayList<>(board));
            return ;
        }

        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 排除不合法的
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            char[] rowTemp = board.get(row).toCharArray();
            rowTemp[col] = 'Q';
            board.set(row, new String(rowTemp));
            // 进入下一次决策
            backTrack(board, row + 1);
            // 撤销选择
            char[] revokeRowTemp = board.get(row).toCharArray();
            revokeRowTemp[col] = '.';
            board.set(row, new String(revokeRowTemp));
        }
    }

    /**
     * 是否可以在board[row][col]位置防止皇后
     *
     * @param board 棋盘
     * @param row 行
     * @param col 列
     * @return 是否冲突
     */
    private boolean isValid(List<String> board, int row, int col) {
        int size = board.size();
        // 检查列是否冲突
        for (int i = 0; i < size; i++) {
            if (board.get(i).toCharArray()[col] == 'Q') {
                return false;
            }
        }
        // 检查右上方是否冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < size; i--, j++) {
            if (board.get(i).toCharArray()[j] == 'Q') {
                return false;
            }
        }
        // 检查左下方是否冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).toCharArray()[j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> solveNQueensTwo(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row,
                          Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 结束条件
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                // 有冲突的直接结束
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }

                // 做选择
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                // 进入下一步决策
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                // 撤销选择
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
