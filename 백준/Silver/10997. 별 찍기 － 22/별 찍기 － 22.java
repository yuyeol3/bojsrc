
import java.util.*;

// 1 -> 5 -> 9 -> 13...

interface LineFactory {
    int numOfLines();
    int numOfCols();
    Line create(int i);
}

interface Content {
    void print();
}


class Characters implements Content{
    private final char character;
    private final int num;
    public Characters(char c, int n) {
        character = c;
        num = n;
    }

    public void print() {
        for (int i = 0; i < num; ++i) {
            System.out.print(character);
        }
    }


}

class CharactersWithStars implements Content{
    private final Content innerContent;
    public CharactersWithStars(Content innerContent) {
        this.innerContent = innerContent;
    }

    public void print() {
        System.out.print("*");
        innerContent.print();
        System.out.print("*");
    }

}

class EquallySpacedStars implements Content{
    private final int totalWidth;
//    private final int starNum;
    public EquallySpacedStars(int totalWidth) {
        this.totalWidth = totalWidth;
//        this.starNum = (totalWidth / 2) + 1;
    }
    public void print() {
        for (int i = 0; i < totalWidth; ++i) {
            if (i % 2 == 0)
                System.out.print('*');
            else
                System.out.print(' ');
        }
    }

}

class Line implements Content{
    private final List<Content> contents;

    public Line(List<Content> c) {
        contents = c;
    }


    public void print() {
        for (Content c : contents) {
            c.print();
        }
    }

}

class Pattern {
//    private final List<Line> lines;
    private final LineFactory factory;
    public Pattern(LineFactory factory) {
        this.factory = factory;
    }

    public void print() {
        for (int i = 0; i < factory.numOfLines(); ++i) {
            factory.create(i).print();
            System.out.println();
//            System.out.println(' ');
        }
    }
}


/* Todo 
* OneSizeFactory
* TwoSizeFactory
* 구현하기
* */
class OneSizeFactory implements LineFactory {
    public OneSizeFactory() {

    }

    public int numOfLines() {
        return 1;
    }

    public int numOfCols() {
        return 1;
    }

    public Line create(int i) {
        List<Content> contents = new ArrayList<>();
        contents.add(new Characters('*', 1));
        return new Line(contents);
    }

}

class TwoSizeFactory implements LineFactory {
//    private final LineFactory prevLineFactory;
    private final int num;
    public TwoSizeFactory() {
        num = 2;
    }

    public int numOfLines() {
        return num*4 - 1;
    }

    public int numOfCols() {
        return (1 + 4 * (num-1));
    }

    public Line create(int i) {
        List<Content> contents = new ArrayList<>();
        if (i == 0 || i == numOfLines() - 1)
        {
            contents.add(new Characters('*', numOfCols()));
        }
        else if (i == 1) {
            contents.add(new Characters('*', 1));
//            contents.add(new Characters(' ', numOfCols()-1));
        }
        else if (i == 2) {
            contents.add(new Characters('*', 1));
            contents.add(new Characters(' ', 1));
            contents.add(new Characters('*', 3));
        }
        else if (i == 3 || i == 4) {
            contents.add(new EquallySpacedStars(numOfCols()));
        }
        else if (i == numOfLines() - 2) {
            contents.add(new Characters('*', 1));
            contents.add(new Characters(' ', numOfCols()-2));
            contents.add(new Characters('*', 1));
        }

        return new Line(contents);
    }

}

class NSizeFactory implements LineFactory {
    private final int num;
    private final LineFactory prevLineFactory;
    public NSizeFactory(int n) {
        num = n;
        if (n > 3)
            prevLineFactory = new NSizeFactory(n-1);
        else if (n == 3)
            prevLineFactory = new TwoSizeFactory();
        else
            prevLineFactory = null;
    }

    public int numOfLines() {
        return num*4 - 1;
    }


    public int numOfCols()
    {
        return (1 + 4 * (num - 1));
    }

    public Line create(int i) {

        List<Content> contents = new ArrayList<>();

        if (i == 0 || i == numOfLines() - 1)
        {
            contents.add(new Characters('*', numOfCols()));
        }
        else if (i == 1) {
            contents.add(new Characters('*', 1));
//            contents.add(new Characters(' ', numOfCols()-1));
        }
        else if (i == numOfLines() - 2) {
            contents.add(new Characters('*', 1));
            contents.add(new Characters(' ', numOfCols()-2));
            contents.add(new Characters('*', 1));
        }
        else {
            contents.add(new Characters('*', 1));
            contents.add(new Characters(' ', 1));

            if (i < prevLineFactory.numOfLines() + 2)
                contents.add(prevLineFactory.create(i - 2));

            if (i == 2) {
//                contents.add(new Characters(' ', this.numOfCols()-2));
                contents.add(new Characters('*', 2));
            }
            else if (i == 3) {
                contents.add(new Characters(' ', this.numOfCols()-4));
                contents.add(new Characters('*', 1));
            }
            else {
                contents.add(new Characters(' ', 1));
                contents.add(new Characters('*', 1));
            }
        }

        return new Line(contents);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LineFactory factory;

        switch (n) {
            case 1:
                factory = new OneSizeFactory();
                break;
            case 2:
                factory = new TwoSizeFactory();
                break;
            default:
                factory = new NSizeFactory(n);
                break;
        }
        
        new Pattern(factory).print();
        scanner.close();
    }
}
