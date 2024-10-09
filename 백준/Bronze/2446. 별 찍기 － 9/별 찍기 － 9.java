import java.util.Scanner;

interface PatternFactory {
    int lineNum();
    Line create(int i);
}

class Characters {
    private final char character;
    private final int num;
    public Characters(char _character, int _num) {
        character = _character;
        num = _num;
    }

    public void print() {
        for (int i = 0; i < num; ++i) {
            System.out.print(character);
        }
    }
}


class Line {
    private final Characters[] characters;
    public Line(Characters ... _characters) {
        characters = _characters;
    }

    public void print() {
        for (Characters c : characters) {
            c.print();
        }
    }
}


class Pattern {
    private final Line[] lines;
    public Pattern(PatternFactory p, int n) {
        lines = new Line[p.lineNum()];
        for (int i = 0; i < p.lineNum(); ++i) {
            lines[i] = p.create(i);
        }
    }

    public void print() {
        for (Line line : lines) {
            line.print();
            System.out.println();
        }

    }
}

class P2446 implements PatternFactory {
    private final int num;
    public P2446 (int _num) {
        num = _num;
    }

    @Override
    public int lineNum() {
        return num * 2 - 1;
    }

    @Override
    public Line create(int i) {
        if (i <= (lineNum() / 2)) {
            int starNum = num*2 - 1 - i*2;
            int blankNum = (num*2 - starNum)/2;
            return new Line(
                    new Characters(' ', blankNum),
                    new Characters('*', starNum)
            );
        } else {
            int j = i - (lineNum() / 2);
            int starNum = j*2 + 1;
            int blankNum = (num*2 - starNum)/2;
            return new Line(
                    new Characters(' ',  blankNum),
                    new Characters('*', starNum)
            );
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        new Pattern(new P2446(n), n).print();
        scanner.close();
    }
}
