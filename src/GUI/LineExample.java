
package GUI;

//Melvin Astorga Guevara  B70785
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LineExample extends JPanel{

    public LineExample() {
        this.setPreferredSize(new Dimension(1800, 1000));
    } // constructor
    
    JButton botonLineas = new JButton("Generate more lines");
    
    private void draw(Graphics g){
 
        
        
        //Ciclo que pinta  n  cantidad de lineas.
        for (int i = 0; i < 5000; i++) {
         
         //Hacer las rayas de varios colores
         int R = (int)(Math.random()*255);
         int G = (int)(Math.random()*255);
         int B = (int)(Math.random()*255);
         Color randomColor = new Color (R,G,B);
         g.setColor(randomColor);
         
         // le da una posicion aleatoria a las rayas/lineas.
         int ramdonX0 = (int)(Math.random()*180)*10;   
         int ramdonY0 = (int)(Math.random()*100)*10;   
         int ramdonX1 = (int)(Math.random()*180)*10;   
         int ramdonY1 = (int)(Math.random()*100)*10;   
           
         linearFunction(g, ramdonX0, ramdonY0, ramdonX1, ramdonY1);
            
        }

    } // draw
    
    
    
    // funcion lineal f(x) = m x + b
    // x1 y x2 es el rango en el que se graficara la funcion
    private void linearFunction(Graphics g, double x0, double y0, double x1, double y1){        
        
        double y;
        setBackground(Color.cyan);
        //double punto;
        
        //calculo de pendiente y del termino b (interseccion con eje y)
        double m = (y0 - y1) / (x0 - x1);
        double b = y0 - ((y0 - y1) / (x0 - x1)) * x0;
        
        for(double x = x0; x <= x1; x += 1){
        //for(double x = x0; x <= x1; x += 0.1){
             y = (m * x + b);// * 10; // se multiplica por 10 para escalar el punto a representar en pantalla
             //punto = x;// * 10;
             g.drawLine((int)coord_x(x0), (int)coord_y(y0), (int)coord_x(x1), (int)coord_y(y1)); 
        } // for

    }// linearFunction
    
    
    private double coord_x(double x)
    {
        return x;
    }
    
    private double coord_y(double y)
    {
        double real_y = (double)this.getHeight() - y;
        return real_y;
    }   
    
    
   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // se llama al meto draw
        draw(g);

    }
    
    public static void main(String[] args) {
        JFrame window = new JFrame("Graphing Function");
        window.setContentPane(new LineExample());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.pack();
        window.setResizable(false);
        window.setLocation(70, 20);
        window.setVisible(true);         
    }
    
} // fin clase



