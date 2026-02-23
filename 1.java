import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class AWT extends Frame implements MouseListener {

    Label l;
    Timer hideTimer;

    AWT() {

        // Label
        l = new Label("");
        l.setBounds(30, 40, 240, 30);

        // Screen position (bottom-right)
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width - 320, d.height - 240);

        // Frame settings
        setLayout(null);
        setSize(300, 150);
        setAlwaysOnTop(true);
        setVisible(true);

        // Add components
        add(l);

        // Add MouseListener to BOTH frame and label
        addMouseListener(this);
        l.addMouseListener(this);

        // Close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    // Mouse clicked → open new window
    public void mouseClicked(MouseEvent e) {

        if (hideTimer != null)
            hideTimer.cancel();

        Frame msgFrame = new Frame("Message Details");
        msgFrame.setSize(300, 200);
        msgFrame.setLayout(new FlowLayout());

        TextArea ta = new TextArea(
                "Message 1: Hi!\n" +
                        "Message 2: Project review\n" +
                        "Message 3: Submit assignment",
                6, 30, TextArea.SCROLLBARS_VERTICAL_ONLY
        );

        msgFrame.add(ta);
        msgFrame.setVisible(true);
    }

    // Mouse entered → show message
    public void mouseEntered(MouseEvent e) {
        l.setText("You have 3 new messages");

        if (hideTimer != null)
            hideTimer.cancel();
    }

    // Mouse exited → auto-hide after 2 seconds
    public void mouseExited(MouseEvent e) {
        hideTimer = new Timer();
        hideTimer.schedule(new TimerTask() {
            public void run() {
                setVisible(false);
            }
        }, 2000);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public static void main(String[] args) {
        new AWT();
    }
}
