import java.awt.Graphics;

import javax.swing.JPanel;

public class Renderer extends JPanel
{

    private static final long serialVersionUID = 1L;
    private  Jumper jumper ;

    public Renderer(Jumper jumper) {
        this.jumper = jumper;
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        jumper.repaint(g);

    }



}