package Principal;

import javax.swing.*;
import java.awt.*;

class Output {

    private JTextArea console;
    private JScrollPane scrollPane;
    private final int output_height;
    private boolean output_visible;

    public Output() {
        output_height = 200;
        output_visible = false;
    }

    public int addOutput(Container contentPane, int panel_height, int panel_width) {
        int previous_panel_height = panel_height;
        panel_height = panel_height + output_height;
        //contentPane.setSize(panel_width, panel_height);
        console = new JTextArea(10, 50);
        console.setEditable(false);
        console.setBackground(Color.BLACK);
        console.setFont(new Font("Arial", Font.PLAIN, 12));
        console.setForeground(Color.WHITE);

        scrollPane = new JScrollPane(console);
        scrollPane.setBounds(0, previous_panel_height - 23, panel_width - 15, output_height - 15);
        contentPane.add(scrollPane);

        output_visible = true;
        return panel_height;
    }

    public int removeOutput(Container contentPane, int panel_height, int panel_width) {
        contentPane.remove(scrollPane);
        panel_height = panel_height - output_height;
        //contentPane.setSize(panel_width, panel_height);

        output_visible = false;
        return panel_height;
    }

    public boolean isOutput_visible() {
        return output_visible;
    }

    public JTextArea getConsole() {
        return console;
    }
}