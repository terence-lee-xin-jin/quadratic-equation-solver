import controllers.QuadraticEquationSolverRootPanel;

import javax.swing.*;

/**
 * Contains only the main method to start up the swing application
 *
 * @author Terence Lee
 * */
public class Main {

    public static void main(String [] args){

        QuadraticEquationSolverRootPanel rootPanel = new QuadraticEquationSolverRootPanel();
        rootPanel.setVisible(true);

        JFrame mainFrame = new JFrame();
        mainFrame.setContentPane(rootPanel);
        mainFrame.setVisible(true);
        mainFrame.setSize(680, 550);
        mainFrame.setResizable(false);
        mainFrame.setTitle("Quadratic Equation Solver By Terence Lee");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
