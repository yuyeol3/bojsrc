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
    private final Characters[] characters;
    public Line(Characters ... chars) {
        this.characters = chars;
    }

    public void Print() {
        for (Characters c : characters) {
            c.Print();
        }
        System.out.println();
    }

}

class Pattern {
    private final Line[] lines;

    public Pattern(int n) {
        lines = new Line[n];
        for (int i = 0; i < n; ++i) {
            int starNum = (i + 1) * 2 - 1;
            lines[i] = new Line( 
                new Characters(' ', (n*2 - starNum)/2),
                new Characters('*', starNum)
                // new Characters('o', (n*2 - starNum)/2)
            );
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
        Scanner sc = new Scanner(System.in);
        new Pattern(sc.nextInt()).Print();
    }
}
