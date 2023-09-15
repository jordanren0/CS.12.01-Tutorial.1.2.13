public class Crossword {

    private Square[][] puzzle;

    public Crossword(boolean[][] blackSquares)
    {
        this.puzzle = new Square[blackSquares.length][blackSquares[0].length];
        int count = 1;
        for(int i = 0; i < blackSquares.length; i++){
            for(int j = 0; j < blackSquares[i].length; j++){
                boolean label = toBeLabeled(i, j, blackSquares);
                if(label){
                    puzzle[i][j] = new Square(blackSquares[i][j], count);
                    count++;
                }
                else{
                    puzzle[i][j] = new Square(blackSquares[i][j], 0);
                }
            }
        }
    }

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares)
    {
        if(blackSquares[r][c]) return false;
        if(r == 0 || blackSquares[r-1][c]) return true;
        return c == 0 || blackSquares[r][c - 1];
    }

    public Square[][] getPuzzle() {
        return puzzle;
    }

}