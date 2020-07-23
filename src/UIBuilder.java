import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class UIBuilder {
    private static final JFrame mainPanel = createJFrame();
    private static final JFrame milesToInchesPanel = createJFrame();
    private static final JFrame areaOfCirclePanel = createJFrame();

    public static void mainWindow() {
        setMainPanel();
        setAreaOfCircleWindow();
        setMilesToInchesWindow();

        showMainPanel();
    }

    private static void showMainPanel() {
        mainPanel.setVisible(true);
        milesToInchesPanel.setVisible(false);
        areaOfCirclePanel.setVisible(false);
    }

    private static void showMilesToInchesPanel() {
        mainPanel.setVisible(false);
        milesToInchesPanel.setVisible(true);
        areaOfCirclePanel.setVisible(false);
    }

    private static void showAreaOfCirclePanel() {
        mainPanel.setVisible(false);
        milesToInchesPanel.setVisible(false);
        areaOfCirclePanel.setVisible(true);
    }

    private static void setMainPanel() {
        JButton milesToInches = new JButton("Miles to Inches");
        milesToInches.setBounds(70, 80, 150, 30);
        milesToInches.addActionListener(actionEvent -> showMilesToInchesPanel());
        mainPanel.add(milesToInches);

        JButton areaOfCircle = new JButton("Area of circle");
        areaOfCircle.setBounds(70, 130, 150, 30);
        areaOfCircle.addActionListener(actionEvent -> showAreaOfCirclePanel());
        mainPanel.add(areaOfCircle);
    }

    private static @NotNull JFrame createJFrame() {
        JFrame f = new JFrame("Converter");

        f.setLayout(null);
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(false);

        return f;
    }

    private static @NotNull JTextField createUnitInput() {
        JTextField jTextField = new JTextField();

        jTextField.setEditable(true);
        jTextField.setBounds(50, 60, 200, 30);

        return jTextField;
    }

    private static @NotNull JButton createCalculateButton(JTextField textField, JLabel message, int whichCalculation) {
        JButton b = new JButton("Calculate");
        b.setBounds(100, 100, 100, 30);

        b.addActionListener(actionEvent -> {
            Converter converter = new Converter();
            String strTextField = textField.getText();

            try {
                if (whichCalculation == Options.MILES_TO_INCHES.getLevelCode()) {
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

    private static @NotNull JLabel createTitle(String text) {
        JLabel label = new JLabel();

        label.setBounds(100, 20, 150, 30);
        label.setText(text);

        return label;
    }

    private static void setMilesToInchesWindow() {
        JLabel label = createTitle("Miles to Inches");
        JLabel message = new JLabel();
        message.setBounds(100, 140, 200, 60);
        JTextField unitInput = createUnitInput();
        JButton calculateButton = createCalculateButton(unitInput, message, Options.MILES_TO_INCHES.getLevelCode());

        milesToInchesPanel.add(label);
        milesToInchesPanel.add(unitInput);
        milesToInchesPanel.add(calculateButton);
        milesToInchesPanel.add(backButton());
        milesToInchesPanel.add(message);

        unitInput.requestFocusInWindow();
    }

    private static @NotNull JButton backButton() {
        JButton backButton = new JButton();

        backButton.setText("Back");
        backButton.setBounds(5, 5, 80, 30);
        backButton.addActionListener(actionEvent -> mainWindow());

        return backButton;
    }

    private static void setAreaOfCircleWindow() {
        JLabel label = createTitle("Area of Circle");
        JLabel message = new JLabel();
        message.setBounds(100, 140, 200, 60);
        JTextField unitInput = createUnitInput();
        JButton calculateButton = createCalculateButton(unitInput, message, Options.AREA_OF_CIRCLE.getLevelCode());

        areaOfCirclePanel.add(backButton());
        areaOfCirclePanel.add(label);
        areaOfCirclePanel.add(unitInput);
        areaOfCirclePanel.add(calculateButton);
        areaOfCirclePanel.add(message);

        unitInput.requestFocusInWindow();
    }
}