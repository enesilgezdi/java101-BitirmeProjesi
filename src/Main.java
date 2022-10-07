import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mayın tarlası oynuna hoş geldin ! ");
        int x , y ;
        System.out.print("Satır Sayısını Giriniz: " );
        x = scanner.nextInt();
        System.out.print("Sutün Sayısını Giriniz: " );
        y = scanner.nextInt();
        MineSweeper mineSweeper = new MineSweeper(x, y);
        mineSweeper.run();
    }
}
