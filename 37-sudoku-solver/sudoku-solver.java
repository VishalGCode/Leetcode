class Solution {
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[] boxes = new int[9];
    List<int[]> empty = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    empty.add(new int[]{r, c});
                } else {
                    int num = board[r][c] - '1';
                    int bit = 1 << num;
                    int box = (r / 3) * 3 + (c / 3);
                    rows[r] |= bit;
                    cols[c] |= bit;
                    boxes[box] |= bit;
                }
            }
        }
        solve(board);
    }

    private boolean solve(char[][] board) {

        if (empty.isEmpty()) {
            return true;
        }

        int bestIdx = -1;
        int minChoices = 10;
        int bestMask = 0;

        for (int i = 0; i < empty.size(); i++) {
            int r = empty.get(i)[0];
            int c = empty.get(i)[1];
            int box = (r / 3) * 3 + (c / 3);
            int used = rows[r] | cols[c] | boxes[box];
            int available = (~used) & 0x1FF;
            int choices = Integer.bitCount(available);
            if (choices < minChoices) {
                minChoices = choices;
                bestIdx = i;
                bestMask = available;
                if (choices == 1) break;
            }
        }
        if (minChoices == 0) {
            return false;
        }
        int[] cell = empty.remove(bestIdx);
        int r = cell[0];
        int c = cell[1];
        int box = (r / 3) * 3 + (c / 3);

        while (bestMask != 0) {
            int bit = bestMask & -bestMask;
            bestMask -= bit;
            int digit = Integer.numberOfTrailingZeros(bit);
            board[r][c] = (char) ('1' + digit);
            rows[r] |= bit;
            cols[c] |= bit;
            boxes[box] |= bit;

            if (solve(board)) return true;
            rows[r] ^= bit;
            cols[c] ^= bit;
            boxes[box] ^= bit;
            board[r][c] = '.';
        }
        empty.add(bestIdx, cell);
        return false;
    }
}