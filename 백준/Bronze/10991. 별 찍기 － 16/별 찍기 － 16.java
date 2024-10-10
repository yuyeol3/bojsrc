import java.util.*;

interface LineFactory {
    int lineNum();
    Line create(int i);
}

class Characters {
    private final char character;
    private final int num;
    public Characters(char character, int num) {
        this.character = character;
        this.num = num;
    }

    public void print() {
        for (int i = 0; i < num; ++i) {
            System.out.print(character);
        }
    }
}

class Line {
    private final List<Characters> charactersList;
    public Line(List<Characters> list) {
        charactersList = list;
    }

    public void print() {
        for (Characters characters : charactersList) {
            characters.print();
        }
    }

}

class Pattern {
    private final List<Line> linesList;
    public Pattern(LineFactory lineFactory) {
        linesList = new ArrayList<>(lineFactory.lineNum());
        for (int i = 0; i < lineFactory.lineNum(); ++i) {
            linesList.add(lineFactory.create(i));
        }
    }

    public void print() {
        for (Line line : linesList) {
            line.print();
            System.out.println();
        }
    }
}

class P10991 implements LineFactory {
    private final int num;
    public P10991(int n) {
        num = n;
    }

    @Override
    public int lineNum() {
        return num;
    }

    @Override
    public Line create(int i) {
        List<Characters> list = new ArrayList<>();
        int blankNum = num - i - 1;
        list.add(new Characters(' ', blankNum));
        for (int j = 0; j < i+1; ++j) {
            list.add(new Characters('*', 1));
            list.add(new Characters(' ', 1));
        }

        return new Line(list);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Pattern(new P10991(sc.nextInt())).print();
        sc.close();
    }
}
