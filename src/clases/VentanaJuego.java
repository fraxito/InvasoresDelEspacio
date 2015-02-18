package clases;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author jorgecisneros
 */
public class VentanaJuego extends javax.swing.JFrame {
        //alto y ancho de la ventana
    int anchoPantalla = 600;
    int altoPantalla = 450;

    //buffer para dibujar
    BufferedImage buffer = null;

    //declaro un objeto de tipo nave
    Nave miNave = new Nave();
    //declaro dos variables booleanas que controlen el movimiento de la nave
    boolean pulsadaDerecha = false;
    boolean pulsadaIzquierda = false;
    
    Timer temporizador = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //aqui llamo al método del juego
            bucleDelJuego();
        }
    });

    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego() {
        initComponents();
        //cambiamos las dimensiones de la ventana
        this.setSize(anchoPantalla, altoPantalla+40);

        //creamos el buffer a partir del jPanel
        buffer = (BufferedImage) jPanel1.createImage(anchoPantalla, altoPantalla);
        buffer.createGraphics();

        //inicio el juego
        temporizador.start();
        
        //posiciona la nave abajo del todo
        miNave.setX(anchoPantalla /2);
        miNave.setY(altoPantalla - miNave.imagenNave.getHeight(null));
        
    }


    
    
private void bucleDelJuego() {
    
        //primero apunto al buffer
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        
        
        
        //pinto un rectángulo negro del tamaño de la ventana
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, anchoPantalla, altoPantalla);
        /////////////////////////////////////////////////////
        //////    codigo del juego    ///////////////////////
        if (pulsadaIzquierda){
            miNave.setX(miNave.getX() - 1);
        }
        else if (pulsadaDerecha){
            miNave.setX(miNave.getX() + 1);
        }        
        g2.drawImage(miNave.imagenNave, miNave.getX(), miNave.getY(), null);

        /////////////////////////////////////////////////////
        //apunto al jPanel y dibujo el buffer sobre el jPanel
        g2 = (Graphics2D) jPanel1.getGraphics();
        g2.drawImage(buffer, 0, 0, null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_LEFT)
        {
           pulsadaIzquierda = true;
           pulsadaDerecha = false;
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
           pulsadaIzquierda = false;
           pulsadaDerecha = true;
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
           pulsadaIzquierda = false;
           pulsadaDerecha = false;       
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
