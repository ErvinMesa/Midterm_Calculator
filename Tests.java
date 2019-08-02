package Calculator;

public class Tests {
    public static void main(String[] args) {
        PostFix test = new PostFix();
        PostFix_Calculator cal = new PostFix_Calculator();
        System.out.println(test.convertEquation("36-2*(20+12/4*3-2*2)+10"));
        System.out.println(cal.solve(test.convertEquation("36-2*(20+12/4*3-2*2)+10")));
    }
}