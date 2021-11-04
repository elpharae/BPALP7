package pkg;

import java.util.Objects;
import java.util.Random;

public class Main {

    private String[][] field;
    private final int ROWS = 8;
    private final int COLUMNS = 8;
    private final int TOWERS = 8;

    private Main() {
        initField();
        initGame();
        drawField();
    }

    //Vytvoreni hraci desky
    private void initField() {
        this.field = new String[this.ROWS][this.COLUMNS];
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = 0; j < this.COLUMNS; j++) {
                //this.field[i][j] = (i % 2 == ((j % 2 == 0) ? 1 : 0)) ? 1 : 0; sachovnice, 0 a 1
                this.field[i][j] = "_";
            }
        }
    }

    //Pridani vezi do pole
    private void initGame() {
        Random rn = new Random();
        int y;
        boolean repeat;
        for (int x = 0; x < TOWERS; x++) {
            repeat = false;
            y = rn.nextInt(8);
            for (int i = 0; i < ROWS; i++) {
                if (this.field[i][y].equals("T")) {
                    repeat = true;
                    break;
                }
            }
            if (repeat) x--;
            else this.field[x][y] = "T";
        }
    }

    //Vykresleni hraci desky
    private void drawField() {
        System.out.println("A  B  C  D  E  F  G  H");
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = 0; j < this.COLUMNS; j++)
                System.out.print(this.field[i][j] + "  ");
            System.out.println((i + 1) + " ");
        }
    }

    public static void main(String[] args) {
	    new Main();
    }
}
