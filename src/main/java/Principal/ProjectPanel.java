package Principal;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class ProjectPanel extends JPanel {


    private final int x_initial = 50;
    private final int y_initial = 50;

    private final int x_margin = 10;

    private final int jl_order_size = 30;

    private final int jl_path_width = 400;

    private final int jl_path_height = 30;

    private final int jb_fc_width = 90;
    private final int jb_fc_height = 30;

    private final JLabel jl_order;
    private final Border jl_order_border;

    private final JLabel jl_path;
    private final JButton jb_fc;
    private final Border fc_border;
    private BufferedImage tick;

    private JLabel tickLabel;
    private final int tickLabel_size = 35;

    private int id;

    private final FileChooser fc = new FileChooser();

    public ProjectPanel() {
        this.jl_order = new JLabel("", SwingConstants.CENTER);
        this.jl_order_border = BorderFactory.createLineBorder(Color.GRAY, 1);
        this.jl_path = new JLabel(". . .", SwingConstants.CENTER);
        fc.setProjectName(jl_path);
        this.jb_fc = fc.getGo();
        this.fc_border = BorderFactory.createLineBorder(Color.GRAY, 1);
        try {
            this.tick = ImageIO.read(getClass().getClassLoader().getResource("tick.png"));
            if (tick==null){
                System.out.println("Error reading image: tick.png");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.tickLabel = new JLabel(new ImageIcon(this.tick));
    }

    public void configureProjectPan(int n) {
        this.id = n;
        jl_order.setText(String.valueOf(id));
        jl_order.setBounds(x_initial, y_initial * n, jl_order_size, jl_order_size);
        jl_order.setBorder(jl_order_border);
        jl_path.setBounds(x_initial + jl_order_size + x_margin,
                y_initial * n, jl_path_width, jl_path_height);
        jl_path.setBorder(fc_border);
        jb_fc.setBounds(x_initial + jl_order_size + jl_path_width + x_margin * 2,
                y_initial * n, jb_fc_width, jb_fc_height);
        tickLabel.setBounds(x_initial + jl_order_size + jl_path_width + tickLabel_size + x_margin * 9,
                y_initial * n - 5, tickLabel_size, tickLabel_size);
        tickLabel.setVisible(false);
    }

    public void addProjectPan(Container contentPane) {
        contentPane.add(jl_order);
        contentPane.add(jl_path);
        contentPane.add(jb_fc);
        contentPane.add(tickLabel);
    }

    public FileChooser getFc() {
        return fc;
    }

    public int getJl_path_height() {
        return jl_path_height;
    }

    public int getId() {
        return id;
    }

    public JLabel getTickLabel() {
        return tickLabel;
    }

    public JLabel getJl_path() {
        return jl_path;
    }
}