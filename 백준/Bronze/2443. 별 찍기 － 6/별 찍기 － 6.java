import java.util.Scanner;

class Characters {
    // 변경할 일이 없으므로 final로..
    private final char character;
    private final int num;
    public Characters(char character, int num) {
        this.character = character;
        this.num = num;
    }

    public void Print() {
        for (int i = 0; i < num; ++i) {
            System.out.print(character);
        }
    }
}

class Line {
    private final Characters[] characters;
    private final boolean endline;

    public Line (Characters ... chars) {
        characters = chars;
        this.endline = true;
    }

    public Line (boolean endline, Characters ... chars) {
        characters = chars;
        this.endline = endline;
    }

    public void Print() {
        for (Characters c : characters) {
            c.Print();
        }
        
        if (endline)
            System.out.println();
            
    }
}

class Pattern {
    private final Line[] lines;

    public Pattern(int n) {
        // 필요한 줄 개수만큼 인스턴스 생성
        lines = new Line[n];
        for (int i = n-1; i >= 0; --i) {
            int starNum = (i+1)*2 - 1;
            lines[n - i - 1] = new Line(
                new Characters(' ', (n*2-starNum)/2),    
                new Characters('*', starNum)  
            );
        }
    }

    public void Print() {
        for (Line line: lines) {
            line.Print();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new Pattern(scanner.nextInt()).Print();

    }
}
