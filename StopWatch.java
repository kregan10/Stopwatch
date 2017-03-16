package q3;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <p>Sets up StopWatch panel.</p>
 *
 * @author Kerry Regan
 * @version 1.0
 */
public class StopWatch {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        
        JPanel stopWatchPanel = new StopWatchPanel();
        JFrame frame = new JFrame("Stop Watch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(stopWatchPanel);
        frame.pack();
        frame.setVisible(true);
        System.out.println("Question three was called and ran sucessfully.");
    }

};
