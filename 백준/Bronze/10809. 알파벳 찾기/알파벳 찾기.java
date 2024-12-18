import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        final char base = 'a';

        for (char i = base; i < base + 26; i++) {
            System.out.printf("%d ", input.indexOf(i));
        }
        System.out.println();
    }
}
