class Solution {
  public boolean isValidSudoku(char[][] board) {

    for (int j = 0; j < board[0].length; j++) {
      Set<Character> digitList = new HashSet<>();
      for (int i = 0; i < board.length; i++) {
        char elem = board[i][j];
        if (elem != '.') {
          if (!digitList.contains(board[i][j])) {
            digitList.add(elem);
          } else
            return false;
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      Set<Character> digitList = new HashSet<>();
      for (int j = 0; j < board.length; j++) {
        char elem = board[i][j];
        if (elem != '.') {
          if (!digitList.contains(elem)) {
            digitList.add(elem);
          } else
            return false;
        }
      }
    }

    Set<String> cubeList = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        char elem = board[i][j];
        if (elem != '.') {
          String elemBlock = board[i][j] + "b" + i / 3 + j / 3;
          if (!cubeList.contains(elemBlock)) {
            cubeList.add(elemBlock);
          } else
            return false;
        }
      }
    }

    return true;
  }
}