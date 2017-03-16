package q3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * <p>Stopwatch with a start, stop and reset button.</p>
 *
 * @author Kerry Regan
 * @version 1.0
 */
public class StopWatchPanel extends JPanel
{
    /*
     * Creating button objects.
     */
    private JButton stop;
    private JButton start;
    private JButton reset;
    
    /*
     * Creating time objects.
     */
    private JLabel hours;
    private JLabel minutes;
    private JLabel seconds;
    private JLabel milliseconds;
    
    /*
     * Initializing time variables that will be updated as timer
     * is run.
     */
    private int currentMilliSeconds;
    private int currentSeconds;
    private int currentMinutes;
    private int currentHours;
    
    /*
     * Initializing constants for time.
     */
    final int MILLISEC_TO_SEC = 10;
    final int SEC_TO_MIN = 60;
    final int MIN_TO_HOUR = 60;
    final int delay = 100;        
    
    /*
     * creating DecimalFormat object to make sure time is displayed
     * appropriately.
     */
    DecimalFormat fmt = new DecimalFormat("00");
    
   /**
    * Constructor sets up the GUI
    */
    public StopWatchPanel()

    {
        ButtonListener listener = new ButtonListener();
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,1));
        
        JPanel timeDisplay = new JPanel();
        JPanel buttons = new JPanel();
        JPanel title = new JPanel();
        JLabel label = new JLabel("Stop Watch");
        title.add(label);
        
        hours = new JLabel("" + fmt.format(currentHours));
        minutes = new JLabel(": " + fmt.format(currentMinutes));
        seconds = new JLabel(": " + fmt.format(currentSeconds));
        milliseconds = new JLabel(": " + fmt.format(currentMilliSeconds));
        
        timeDisplay.add(hours);
        timeDisplay.add(minutes);
        timeDisplay.add(seconds);
        timeDisplay.add(milliseconds);

        stop = new JButton("Stop");
        stop.addActionListener(listener);
    
        start = new JButton("Start");
        start.addActionListener(listener);
        
        reset = new JButton("Reset");
        reset.addActionListener(listener);
        
        buttons.add(stop);
        buttons.add(start);
        buttons.add(reset);

        mainPanel.add(title); // putting the title at the top
        mainPanel.add(timeDisplay);
        mainPanel.add(buttons); // putting the panel in the middle

        this.add(mainPanel);
     
        setPreferredSize(new Dimension(400, 130));
        setBackground(Color.green);
     }    
    /**
     * <p>Updates the timer as everytime it is called.</p>
     */
    ActionListener timeUpdater = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            
            currentMilliSeconds++;

            if(currentMilliSeconds >= MILLISEC_TO_SEC)
            {
                currentSeconds++;
                seconds.setText(": " + fmt.format(currentSeconds));
                currentMilliSeconds = 0;
            }
            if(currentSeconds >= SEC_TO_MIN)
            {
                currentMinutes++;
                minutes.setText(": " + fmt.format(currentMinutes));
                currentSeconds = 0;
            }
            if(currentMinutes >= MIN_TO_HOUR)
            {
                currentHours++;
                hours.setText("" + fmt.format(currentHours));
                currentMinutes = 0;
            }
            milliseconds.setText(": " + fmt.format(currentMilliSeconds));
        }
    };
    
    Timer timer = new Timer(delay, timeUpdater);

    /**
     * <p>Listener class for start, stop and reset buttons.</p>
     */
    public class ButtonListener implements ActionListener
    {
        /**
         * <p>Determines the course of action to take for a particular button,
         * and updates the timer accordingly.</p>
         * @param event
         */
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == start) {
                timer.start();
            }

            if(event.getSource() == stop) {
                timer.stop();
            }
            
            if(event.getSource() == reset) {
                timer.stop();
                currentMilliSeconds = 0;
                currentSeconds = 0;
                currentMinutes = 0;
                currentHours = 0;
                milliseconds.setText(":" + fmt.format(currentMilliSeconds));
                seconds.setText(":" + fmt.format(currentSeconds));
                minutes.setText(":" + fmt.format(currentMinutes));
                hours.setText("" + fmt.format(currentHours));
            }
        }
    }
}