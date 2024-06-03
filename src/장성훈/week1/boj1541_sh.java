import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] splitInput = input.split("-");
        int answer = 0;

        if (splitInput.length > 0) {
            answer += sumOfString(splitInput[0]);
        }

        for (int i = 1; i < splitInput.length; i++) {
            answer -= sumOfString(splitInput[i]);
        }

        System.out.println(answer);
    }

    private static int sumOfString(String str) {
        String[] splitStr = str.split("\\+");  // "+" 컴파일 에러
        int sum = 0;

        for (String num : splitStr) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
