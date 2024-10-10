import java.util.*;

interface LineFactory {
    int lineNum();
    Line create(int i);
}

interface Content {
    void print();
}

class Characters implements Content {
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


class CharactersWithStars implements Content {
    private final Content content;

    public CharactersWithStars(Content content) {
        this.content = content;
    }

    public void print() {
        System.out.print('*');
        content.print();
        System.out.print('*');
    }

}


class Line {
    private final List<Content> charactersList;
    public Line(List<Content> list) {
        charactersList = list;
    }

    public void print() {
        for (Content characters : charactersList) {
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

class P10992 implements LineFactory {
    private final int num;
    public P10992(int n) {
        num = n;
    }

    public int lineNum() {
        return num;
    }

    public Line create(int i) {
        List<Content> list = new ArrayList<>();
        int totWidth = num*2 - 1;

        if (i == 0) {
            list.add(new Characters(' ', (totWidth - 1)/2 ));
            list.add(new Characters('*', 1));
        }
        else if (i == num - 1) {
            list.add(new Characters('*', totWidth));
        }
        else {
            int innerBlankNum = (i+1)*2 - 3;
            int outerBlankNum = (totWidth - innerBlankNum - 2) / 2;
            list.add(new Characters(' ', outerBlankNum));
            list.add(new CharactersWithStars(new Characters(' ', innerBlankNum) ) );
        }

        return new Line(list);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Pattern(new P10992(sc.nextInt())).print();
        sc.close();
    }
}



