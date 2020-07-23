import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Builder {
    private static JLabel answer = new JLabel();

    private static JFrame createJFrame() {
        JFrame f = new JFrame("Converter");
        f.setLayout(null);
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        return f;

    }

    private static JTextField createTextField() {
        JTextField jTextField = new JTextField();
        jTextField.setEditable(true);
        jTextField.setBounds(50, 60, 200, 30);

        return jTextField;
    }

    private static JButton createCalculateButton(JTextField textField, String whichCalculation) {
        JButton b = new JButton("Calculate");
        b.setBounds(100, 100, 100, 30);
        b.addActionListener(actionEvent -> {
            Converter converter = new Converter();
            String strTextField = textField.getText();
            if (whichCalculation.equals("milesToInches")) {
                int inches = converter.milesToInches(Integer.parseInt(strTextField));
                String numberOfInches = String.valueOf(inches);
                answer.setText(numberOfInches + " inches");
            } else {
                double area = converter.areaOfCircle(Double.parseDouble(strTextField));
                String strArea = String.valueOf(area);
                answer.setText(strArea + " units^2");
            }
        });
        return b;
    }

    private static JLabel createJLabel(String text) {
        JLabel label = new JLabel();
        label.setBounds(100, 20, 150, 30);
        label.setText(text);
        return label;
    }

    private static void createMilesToInchesWindow() {
        JFrame f = createJFrame();
        JLabel label = createJLabel("Miles to Inches");
        JTextField jTextField = createTextField();
        JButton b = createCalculateButton(jTextField, "milesToInches");

        f.add(label);

        f.add(jTextField);

        f.add(b);

        answer.setBounds(100, 140, 200, 60);
        f.add(answer);

        f.add(backButton());

    }

    private static JButton backButton() {
        JButton backButton = new JButton();
        backButton.setText("Back");
        backButton.setBounds(5, 5, 80, 30);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainWindow();
                answer.setText("");
            }
        });
        return backButton;
    }

    public static void mainWindow() {
        JFrame f = createJFrame();
        JButton milesToInches = new JButton("Miles to Inches");
        JButton areaOfCircle = new JButton("Area of circle");

        milesToInches.setBounds(70, 80, 150, 30);
        areaOfCircle.setBounds(70, 130, 150, 30);

        f.add(milesToInches);
        f.add(areaOfCircle);

        milesToInches.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                createMilesToInchesWindow();
            }
        });
        f.add(milesToInches);

        areaOfCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                createAreaOfCircleWindow();
            }
        });

    }

    private static void createAreaOfCircleWindow() {
        JFrame frame = createJFrame();
        JLabel label = createJLabel("Area of Circle");
        JTextField textField = createTextField();
        JButton b = createCalculateButton(textField, "");

        frame.add(backButton());

        frame.add(label);

        frame.add(textField);

        frame.add(b);

        answer.setBounds(100, 140, 200, 60);
        frame.add(answer);
    }
}
