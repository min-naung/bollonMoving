import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myPanel_04 extends JPanel implements ActionListener {
    int x = 0, y = 0;
    int dx = 1, dy = 1, d = 10;
    Timer pTimer;
    final int width, height;

    public myPanel_04(int w, int h){
        width = w;
        height = h;
        pTimer = new Timer(1000,this);
    }

    public void start(){
        pTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += d * dx;
        y += d * dy;

        if (x < 0){
            x += d;
            dx *= -1;
        }else if (x > width - 100){
            x -= d;
            dx *= -1;
        }
        if (y < 0){
            y += d;
            dy *= -1;
        }else if (y > height - 100){
            y -= d;
            dy *= -1;
        }
        repaint();
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(Color.lightGray);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int i,x,y,width=600,cn;
        Color co;
        g.drawRect(0,0,width,width);
        for (i=0;i<200;i++){
            x = (int)(width*Math.random());
            y = (int)(width*Math.random());
            cn = (int) (10*Math.random()+1);
            switch (cn){
                case 1: co=new Color(0,0,255);break;
                case 2: co=new Color(0,255,0);break;
                case 3: co=new Color(0,255,255);break;
                case 4: co=new Color(255,0,0);break;
                case 5: co=new Color(255,0,255);break;
                case 6: co=new Color(255,255,0);break;
                case 7: co=new Color(255,255,255);break;
                case 8: co=new Color(255,102,255);break;
                case 9: co=new Color(153,102,0);break;
                case 10: co=new Color(255,102,0);break;
                default: co=new Color(0,0,0);
            }
            g.setColor(co);
            g.fillOval(x,y,50,50);
        }
    }
}
public class Gui_04 extends JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Gui_04");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600,500);
        f.setResizable(false);
        Container contentPane = f.getContentPane();
        myPanel_04 p = new myPanel_04(600,500);
        contentPane.add(p);
        p.start();

        f.setVisible(true);
    }
}

