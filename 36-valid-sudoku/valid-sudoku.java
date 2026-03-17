class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row check 
        for(int i=0;i<9;i++) {
            HashMap<Character,Integer> map=new HashMap<>();
            for(int j=0;j<9;j++) {
                char curr = board[i][j];
                if(curr != '.') {
                   map.put(curr,map.getOrDefault(curr,0)+1);
                    if(map.get(curr)==2) {
                        return false;
                     }
                }
            }
        }
        // col check 
        for(int j=0;j<9;j++) {
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0;i<9;i++) {
                char curr = board[i][j];
                if(curr != '.') {
                    map.put(curr,map.getOrDefault(curr,0)+1);
                    if(map.get(curr)==2) {
                        return false;
                    }
                }
            }
        }
        // 3x3 check
          for(int row=0; row<9;row += 3) {
              for(int col=0; col<9;col += 3) {
                     HashMap<Character,Integer> map=new HashMap<>();
                  for(int i=row;i<row+3;i++) {
                      for(int j=col;j<col+3;j++) {
                         char curr=board[i][j];
                               if(curr != '.') {
                               map.put(curr,map.getOrDefault(curr,0)+1);
                               if(map.get(curr)==2) {
                                   return false;
                                }
                              }
                     } 
                 }  
            }
         }
        return true;
    }
}