package 장성훈.week8;

public class wordSearch_sh {
    public boolean exist(char[][] board, String word) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};



        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(0,0, board, word,0)) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

    public boolean dfs(int x, int y, char[][] board, String word, int index) {
        if (x < 0 || x >= board.length
        || y < 0 || y >= board[0].length
        || word.charAt(index) != board[x][y]) {
            return false;
        }

        board[x][y] = (char) - board[x][y];
        if ( dfs(x + 1, y, board, word, index + 1)
          || dfs(x, y + 1, board, word, index + 1)
          || dfs(x - 1, y, board, word, index + 1)
          || dfs(x, y - 1, board, word, index + 1)
        ) {
            return true;
        }
        board[x][y] = (char) - board[x][y];

        return false;
    }


}
