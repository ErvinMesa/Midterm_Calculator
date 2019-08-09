package Front;

import Back.PostFix;
import Back.PostFix_Calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.StringTokenizer;

public class FinalUIController {

    @FXML
    private AnchorPane mainuipane;

    @FXML
    private TextArea process;

    @FXML
    private Label menu;

    @FXML
    private TextField equation;

    @FXML
    private Button calculate;

    PostFix converter = new PostFix();
    PostFix_Calculator calculator = new PostFix_Calculator();
    StringTokenizer tokenizer;
    public void calculate() {
        String postfix = converter.convertEquation(equation.getText());
        process.setText("PostFix Equation \n"+postfix+"\n");
        tokenizer = new StringTokenizer(calculator.showProcess(postfix),"|");
        while (tokenizer.hasMoreTokens()) {
            process.appendText(tokenizer.nextToken()+"\n");
        }
        process.appendText(Double.toString(calculator.solve(postfix)));

    }

}
