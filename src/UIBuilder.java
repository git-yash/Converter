import org.jetbrains.annotations.NotNull;
import javax.swing.*;

public class UIBuilder {
    private static final JLabel answer = new JLabel();
    // TODO: YMS - Validate empty input string, set default focus to text input

    private static @NotNull JFrame createJFrame() {
        JFrame f = new JFrame("Converter");

        f.setLayout(null);
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        return f;
    }

    private static @NotNull JTextField createUnitInput() {
        JTextField jTextField = new JTextField();

        jTextField.setEditable(true);
        jTextField.setBounds(50, 60, 200, 30);

        return jTextField;
    }

    private static @NotNull JButton createCalculateButton(JTextField textField, String whichCalculation) {
        JButton b = new JButton("Calculate");
        b.setBounds(100, 100, 100, 30);

        b.addActionListener(actionEvent -> {
            Converter converter = new Converter();
            String strTextField = textField.getText();

            // TODO - YMS - Create Enum
            if (whichCalculation.equals("milesToInches")) {
                double inches = converter.milesToInches(Double.parseDouble(strTextField));
                String numberOfInches = String.valueOf(inches);
                answer.setText(numberOfInches + " inches");
            } else {
                double area = converter.areaOfCircle(Double.parseDouble(strTextField));
                String strArea = String.valueOf(area);
                answer.setText(strArea + " units ^2");
            }
        });
        return b;
    }

    private static JLabel createTitle(String text) {
        JLabel label = new JLabel();

        label.setBounds(100, 20, 150, 30);
        label.setText(text);

        return label;
    }

    private static void createMilesToInchesWindow() {
        JFrame f = createJFrame();
        JLabel label = createTitle("Miles to Inches");
        JTextField jTextField = createUnitInput();
        JButton b = createCalculateButton(jTextField, "milesToInches");

        f.add(label);
        f.add(jTextField);
        f.add(b);
        f.add(backButton());

        answer.setBounds(100, 140, 200, 60);
        f.add(answer);
    }

    private static JButton backButton() {
        JButton backButton = new JButton();

        backButton.setText("Back");
        backButton.setBounds(5, 5, 80, 30);

        backButton.addActionListener(actionEvent -> {
            mainWindow();
            answer.setText("");
        });

        return backButton;
    }

    public static void mainWindow() {
        JFrame f = createJFrame();

        JButton milesToInches = new JButton("Miles to Inches");
        milesToInches.setBounds(70, 80, 150, 30);
        milesToInches.addActionListener(actionEvent -> createMilesToInchesWindow());
        f.add(milesToInches);

        JButton areaOfCircle = new JButton("Area of circle");
        areaOfCircle.setBounds(70, 130, 150, 30);
        areaOfCircle.addActionListener(actionEvent -> createAreaOfCircleWindow());
        f.add(areaOfCircle);
    }

    private static void createAreaOfCircleWindow() {
        JFrame frame = createJFrame();
        JLabel label = createTitle("Area of Circle");
        JTextField textField = createUnitInput();
        JButton b = createCalculateButton(textField, "");

        frame.add(backButton());
        frame.add(label);
        frame.add(textField);
        frame.add(b);

        answer.setBounds(100, 140, 200, 60);
        frame.add(answer);
    }
}