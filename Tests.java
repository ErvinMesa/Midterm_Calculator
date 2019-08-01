package Calculator;

public class Tests {
    public static void main(String[] args) {
        PostFix test = new PostFix();
        PostFix_Calculator cal = new PostFix_Calculator();
        System.out.println(test.convertEquation("5^3+3"));
        System.out.println(cal.solve(test.convertEquation("5^2*3")));
    }
}
