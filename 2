import java.awt.*;
import java.awt.event.*;
import java.io.*;

class SimpleAWTEditor extends Frame implements ActionListener {

    TextArea textArea;
    Label statusBar;

    MenuItem newItem, openItem, saveItem, exitItem;
    MenuItem incFontItem, decFontItem;

    int fontSize = 14;

    SimpleAWTEditor() {

        setLayout(new BorderLayout());

        // Text Area
        textArea = new TextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, fontSize));
        add(textArea, BorderLayout.CENTER);

        // Status Bar
        statusBar = new Label("Ready");
        add(statusBar, BorderLayout.SOUTH);

        // Menu Bar
        MenuBar mb = new MenuBar();

        // File Menu
        Menu fileMenu = new Menu("File");

        newItem = new MenuItem("New", new MenuShortcut(KeyEvent.VK_N));
        openItem = new MenuItem("Open", new MenuShortcut(KeyEvent.VK_O));
        saveItem = new MenuItem("Save", new MenuShortcut(KeyEvent.VK_S));
        exitItem = new MenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // View Menu
        Menu viewMenu = new Menu("View");
        incFontItem = new MenuItem("Increase Font Size");
        decFontItem = new MenuItem("Decrease Font Size");

        viewMenu.add(incFontItem);
        viewMenu.add(decFontItem);

        mb.add(fileMenu);
        mb.add(viewMenu);
        setMenuBar(mb);

        // Listeners
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        incFontItem.addActionListener(this);
        decFontItem.addActionListener(this);

        // Frame settings
        setTitle("Simple AWT Text Editor");
        setSize(600, 400);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == newItem) {
            textArea.setText("");
            statusBar.setText("New file");
        }

        else if (ae.getSource() == openItem) {
            FileDialog fd = new FileDialog(this, "Open", FileDialog.LOAD);
            fd.setVisible(true);

            if (fd.getFile() != null) {
                try {
                    BufferedReader br = new BufferedReader(
                            new FileReader(fd.getDirectory() + fd.getFile()));
                    textArea.setText("");
                    String line;
                    while ((line = br.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                    br.close();
                    statusBar.setText("File opened");
                } catch (Exception e) {
                    statusBar.setText("Error opening file");
                }
            }
        }

        else if (ae.getSource() == saveItem) {
            FileDialog fd = new FileDialog(this, "Save", FileDialog.SAVE);
            fd.setVisible(true);

            if (fd.getFile() != null) {
                try {
                    BufferedWriter bw = new BufferedWriter(
                            new FileWriter(fd.getDirectory() + fd.getFile()));
                    bw.write(textArea.getText());
                    bw.close();
                    statusBar.setText("File saved");
                } catch (Exception e) {
                    statusBar.setText("Error saving file");
                }
            }
        }

        else if (ae.getSource() == exitItem) {
            System.exit(0);
        }

        else if (ae.getSource() == incFontItem) {
            fontSize += 2;
            textArea.setFont(new Font("Arial", Font.PLAIN, fontSize));
            statusBar.setText("Font increased");
        }

        else if (ae.getSource() == decFontItem) {
            fontSize -= 2;
            textArea.setFont(new Font("Arial", Font.PLAIN, fontSize));
            statusBar.setText("Font decreased");
        }
    }

    public static void main(String[] args) {
        new SimpleAWTEditor();
    }
}
