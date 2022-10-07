import java.util.Scanner;
public class MineSweeper {
    int rowNumber;
    int colNumber;

    public MineSweeper(int rowNum, int colNum) {

        this.rowNumber = rowNum;
        this.colNumber = colNum;
    }

    public void putMine(String [][][] _arr) {

        int mineCount = (int)(this.rowNumber * this.colNumber / 4);
        while (mineCount > 0){
            int location = (int) (Math.random() * this.rowNumber * this.colNumber);
            int x = location / this.colNumber;
            int y = location % this.colNumber;
            if (x < this.rowNumber && y < this.colNumber){
                _arr[x][y][0] = "*";
                _arr[x][y][1] = "0";
                mineCount--;
            }
        }
    }

    public int control(int x, int y, String[][][] _arr) {

        int sum = 0;
        for(int i = - 1; i < 2; i++) {
            for(int j = - 1; j < 2; j++) {
                if (x + i < 0 || y +j < 0) continue;
                if (x + i >= this.rowNumber || y +j >= this.colNumber) continue;
                if (i == 0 && j == 0) continue;
                if (_arr[x + i][y + j][0] == "*") sum++;
            }
        }
        return sum;
    }

    public void placeNumber(String[][][] _arr) {
        for(int i = 0; i < this.rowNumber; i++){
            for(int j = 0;j < this.colNumber; j++){
                if( _arr[i][j][0] == null) {
                    _arr[i][j][0] = String.valueOf(control(i, j, _arr));
                    _arr[i][j][1] = "0";
                }
            }
        }
    }

    public void printField(String[][][] _arr) {
        for(int i = 0;  i < this.rowNumber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                if (_arr[i][j][1] == "0") {
                    System.out.print("- ");
                } else {
                    System.out.print(_arr[i][j][0] + " ");
                }
            }
            System.out.print("\n");
        }
    }

    public void dataEntry(int x, int y , String[][][] _arr) {
        _arr[x][y][1]="1";
    }


    public void run() {

        String[][][] arr = new String[this.rowNumber][this.colNumber][2];

        Scanner input = new Scanner(System.in);
        putMine(arr);
        placeNumber(arr);
        int entrance = 0;
        int row;
        int col;
        while(this.rowNumber * this.colNumber - entrance>(int)(this.colNumber * this.rowNumber / 4)) {
            printField(arr);
            System.out.print("Satir sayisini giriniz : ");
            row = input.nextInt();
            System.out.print("Sutun sayisini giriniz : ");
            col = input.nextInt();
            if (arr[row][col][0].equals("*")) {
                dataEntry(row,col,arr);
                printField(arr);
                System.out.println("...Game Over...");
                break;
            } else {
                dataEntry(row, col, arr);
            }
            System.out.println("----------------------------------------------------");
        }
    }
}
