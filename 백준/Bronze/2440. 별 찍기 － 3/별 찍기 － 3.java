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


class Line {;
    private final Characters star;
    public Line(Characters star) {
        this.star = star;
    }

    public void Print() {
        star.Print();
        System.out.println();
    }

}

class Pattern {
    private final Line[] lines;

    public Pattern(int n) {
        lines = new Line[n];
        for (int i = n; i > 0; --i) {
            lines[n-i] = new Line( 
                new Characters('*', i)
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
        Pattern p = new Pattern(sc.nextInt());
        p.Print();
        sc.close();
    }
}
