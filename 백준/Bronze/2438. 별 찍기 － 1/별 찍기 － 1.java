import java.util.Scanner;


class Characters
{
    private final char character;
    private final int num;
    public Characters(char character, int num) {
        this.character = character;
        this.num = num;
    }

    public void Print() {
        for (int i = 0; i < num; ++i)
            System.out.print(character);
    }
}


class Line {
    private final Characters character;
    private final int num;
    public Line(Characters ch, int num) {
        character = ch;
        this.num = num;
    }

    public void Print() {
        for (int i = 0; i < num; ++i) {
            character.Print();
        }
        System.out.println();
    }

}

class Pattern {
    private final Line[] lines;

    public Pattern(int n) {
        lines = new Line[n];
        for (int i = 0; i < n; ++i) {
            lines[i] = new Line(new Characters('*', 1), i+1);
        }
    }

    public void Print() {
        for (Line line : lines) {
            line.Print();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = new Pattern(scanner.nextInt());
        pattern.Print();
    }
}
