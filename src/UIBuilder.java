import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class UIBuilder {
    private final JFrame mainPanel = createJFrame();
    private final JFrame milesToInchesPanel = createJFrame();
    private final JFrame areaOfCirclePanel = createJFrame();
    private final JTextField milesUnitInput = createUnitInput();
    private final JTextField areasUnitInput = createUnitInput();

    public void mainWindow() {
        setMainPanel();
        setPanel(milesToInchesPanel, milesUnitInput, Options.MILES_TO_INCHES);
        setPanel(areaOfCirclePanel, areasUnitInput, Options.AREA_OF_CIRCLE);

        showMainPanel();
    }

    private void showMainPanel() {
        mainPanel.setVisible(true);
        milesToInchesPanel.setVisible(false);
        areaOfCirclePanel.setVisible(false);
    }

    private void showMilesToInchesPanel() {
        mainPanel.setVisible(false);
        areaOfCirclePanel.setVisible(false);

        milesToInchesPanel.setVisible(true);
        milesUnitInput.requestFocusInWindow();
    }

    private void showAreaOfCirclePanel() {
        mainPanel.setVisible(false);
        milesToInchesPanel.setVisible(false);

        areaOfCirclePanel.setVisible(true);
        areasUnitInput.requestFocusInWindow();
    }

    private void setMainPanel() {
        JButton milesToInches = new JButton("Miles to Inches");
        milesToInches.setBounds(70, 80, 150, 30);
        milesToInches.addActionListener(actionEvent -> showMilesToInchesPanel());
        mainPanel.add(milesToInches);

        JButton areaOfCircle = new JButton("Area of circle");
        areaOfCircle.setBounds(70, 130, 150, 30);
        areaOfCircle.addActionListener(actionEvent -> showAreaOfCirclePanel());
        mainPanel.add(areaOfCircle);
    }

    private @NotNull JFrame createJFrame() {
        JFrame f = new JFrame("Converter");

        f.setLayout(null);
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(false);

        return f;
    }

    private @NotNull JTextField createUnitInput() {
        JTextField jTextField = new JTextField();

        jTextField.setEditable(true);
        jTextField.setBounds(50, 60, 200, 30);

        return jTextField;
    }

    private @NotNull JButton createCalculateButton(JTextField textField, JLabel message, Options whichCalculation) {
        JButton b = new JButton("Calculate");
        b.setBounds(100, 100, 100, 30);

        b.addActionListener(actionEvent -> {
            Converter converter = new Converter();
            String strTextField = textField.getText();

            try {
                if (whichCalculation == Options.MILES_TO_INCHES) {
                    double inches = converter.milesToInches(Double.parseDouble(strTextField));
                    String numberOfInches = String.valueOf(inches);
                    message.setForeground(Color.black);
                    message.setText(numberOfInches + " inches");
                } else {
                    double area = converter.areaOfCircle(Double.parseDouble(strTextField));
                    String strArea = String.valueOf(area);
                    message.setForeground(Color.black);
                    message.setText(strArea + " units ^2");
                }
            } catch (NumberFormatException e) {
                message.setText("Error: Invalid Input");
                message.setForeground(Color.red);
            }
        });
        return b;
    }

    private @NotNull JLabel createTitle(String text) {
        JLabel label = new JLabel();

        label.setBounds(100, 20, 150, 30);
        label.setText(text);

        return label;
    }

    private @NotNull JButton backButton() {
        JButton backButton = new JButton();

        backButton.setText("Back");
        backButton.setBounds(5, 5, 80, 30);
        backButton.addActionListener(actionEvent -> mainWindow());

        return backButton;
    }

    private JLabel createMessage() {
        JLabel message = new JLabel();
        message.setBounds(100, 140, 200, 60);
        return message;
    }

    private void setPanel(JFrame panel, JTextField unitInput, Options options) {
        JLabel label = createTitle(options.getTitle());
        JLabel message = createMessage();
        JButton calculateButton = createCalculateButton(unitInput, message, options);

        panel.add(backButton());
        panel.add(label);
        panel.add(calculateButton);
        panel.add(message);
        panel.add(unitInput);
    }
}