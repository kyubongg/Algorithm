import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double res1 = (a * b) / c;
        double res2 = (a / b) * c;

        long answer = (long) Math.max(res1, res2);

        System.out.println(answer);
        
        sc.close();
    }
}