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
    private final Characters blank;
    private final Characters star;
    public Line(Characters blank, Characters star) {
        this.blank = blank;
        this.star = star;
    }

    public void Print() {
        blank.Print();
        star.Print();
        System.out.println();
    }

}

class Pattern {
    private final Line[] lines;

    public Pattern(int n) {
        lines = new Line[n];
        for (int i = 0; i < n; ++i) {
            lines[i] = new Line(
                new Characters(' ', n-i-1), 
                new Characters('*', i+1)
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
