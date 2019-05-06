package Principal;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FileChooser extends JPanel implements ActionListener {

    private final JButton go;
    private JFileChooser chooser;
    private final String chooser_title = "Select a project directory";

    private JLabel fc_jl_path;
    private String lastPath;

    public FileChooser() {
        go = new JButton("Choose");
        go.setBackground(new java.awt.Color(186, 195, 211));
        go.addActionListener(this);
        add(go);
    }

    public void actionPerformed(ActionEvent e) {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(".."));
        chooser.setDialogTitle(chooser_title);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            fc_jl_path.setText(chooser.getSelectedFile().getPath());
        } else {
            System.out.println("No Selection ");
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public JButton getGo() {
        return this.go;
    }

    public void setFc_jl_path(JLabel fc_jl_path) {
        this.fc_jl_path = fc_jl_path;
    }

    public JLabel getFc_jl_path() {
        return fc_jl_path;
    }
}