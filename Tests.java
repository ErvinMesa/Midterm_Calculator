package Calculator;

public class Tests {
    public static void main(String[] args) {
        PostFix test = new PostFix();

        System.out.println(test.convertEquation("A*((B+C)*X)+(D+B)"));
    }
}
