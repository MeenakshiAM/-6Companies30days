class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean row[][] = new boolean[9][9];
        boolean col[][] = new boolean[9][9];
        boolean box[][] = new boolean[9][9];

        for(int i = 0; i < 9 ; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c != '.'){
                    int num = c -'1';
                    int index = (i / 3) * 3 + j / 3; 
                    //this index is to know which sub box is it belong to
                    if(row[i][num] || col[j][num] || box[index][num]){
                        return false;
                    }

                    row[i][num] = true;
                    col[j][num] = true;
                    box[index][num] = true;
                }   
            }
        }

        return true;
    }
}