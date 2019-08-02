package Calculator;

public class Tests {
    public static void main(String[] args) {
        PostFix test = new PostFix();
        PostFix_Calculator cal = new PostFix_Calculator();
        System.out.println(test.convertEquation("1+2^9*(6-3)^2"));
        System.out.println(cal.solve(test.convertEquation("1+2^9*(6-3)^2")));
    }
}
