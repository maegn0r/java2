package homework4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ApplicationFrame {
    private JFrame mainFrame;
    private JButton sendBtn;
    private TextArea mainTextArea;
    private TextArea inputTextArea;
    private JPanel chatArea;

    public ApplicationFrame() {
        this.mainFrame = new JFrame();
        this.chatArea = new JPanel(new BorderLayout());
        this.mainTextArea = new TextArea();
        this.inputTextArea = new TextArea();
        this.sendBtn = new JButton();

        mainFrame.setTitle("My Chat v. 0.01");
        mainFrame.setBounds(new Rectangle(700, 500));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setJMenuBar(getJMenuBar());

        LayoutManager layoutManager = new BorderLayout();
        mainFrame.setLayout(layoutManager);

        setupListeners();
        setLayouts();

        sendBtn.setText("Send message");

        mainFrame.setVisible(true);

    }

    private void setLayouts() {
        chatArea.add(mainTextArea, BorderLayout.CENTER);

        JPanel sendArea = new JPanel(new BorderLayout());
        sendArea.add(inputTextArea, BorderLayout.CENTER);
        sendArea.add(sendBtn, BorderLayout.EAST);

        mainFrame.add(chatArea, BorderLayout.CENTER);
        mainFrame.add(sendArea, BorderLayout.SOUTH);
    }

    private void setupListeners() {
        sendBtn.addActionListener(e -> {
            if (mainTextArea.getText().length() == 0) {
                mainTextArea.append(inputTextArea.getText());
            } else
                mainTextArea.append("\n" + inputTextArea.getText());
            inputTextArea.setText("");
        });

        inputTextArea.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (mainTextArea.getText().length() == 0) {
                        mainTextArea.append(inputTextArea.getText());
                    } else
                        mainTextArea.append("\n" + inputTextArea.getText());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    inputTextArea.setText("");
                }
            }
        });
    }


    private JMenuBar getJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(getFileJMenu());
        return jMenuBar;
    }

    private JMenu getFileJMenu() {
        JMenu jMenu = new JMenu();
        jMenu.setText("File");

        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem closeMenuItem = new JMenuItem("Close");
        jMenu.add(openMenuItem);
        jMenu.add(closeMenuItem);

        return jMenu;
    }

}
