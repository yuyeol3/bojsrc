import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String toTest = sc.nextLine();
        
        boolean isPalindrome = true;
        int strLen = toTest.length();
        for (int i = 0; i < strLen / 2; ++i) {
            if (toTest.charAt(i) != toTest.charAt(strLen - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome ? 1 : 0);
        sc.close();
    }
}
