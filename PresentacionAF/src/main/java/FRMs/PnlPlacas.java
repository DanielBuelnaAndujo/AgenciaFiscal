package FRMs;

import DTOs.HistorialPlacasDTO;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author daniel
 */
public class PnlPlacas extends javax.swing.JPanel {

    /**
     * Creates new form PnlPlacas
     */
    public PnlPlacas(HistorialPlacasDTO p) {
        initComponents();
        
        txfNumero.setText(p.getNumero());
        txfEstado.setText(p.getEstado());
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        txfFechaTramite.setText(p.getFechaTramite().format(formato));
        txfCosto.setText(p.getCosto().toString());
        
        if (p.getFechaRecepcion() != null) {
            txfFechaRecepcion.setText(p.getFechaRecepcion().format(formato));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfNumero = new javax.swing.JTextField();
        txfEstado = new javax.swing.JTextField();
        txfCantidad = new javax.swing.JTextField();
        txfFechaTramite = new javax.swing.JTextField();
        txfCosto = new javax.swing.JTextField();
        txfFechaRecepcion = new javax.swing.JTextField();

        setBackground(new java.awt.Color(217, 217, 217));
        setMaximumSize(new java.awt.Dimension(816, 28));
        setMinimumSize(new java.awt.Dimension(816, 28));

        txfNumero.setEditable(false);
        txfNumero.setBackground(new java.awt.Color(217, 217, 217));
        txfNumero.setText("jTextField1");
        txfNumero.setBorder(null);

        txfEstado.setEditable(false);
        txfEstado.setBackground(new java.awt.Color(217, 217, 217));
        txfEstado.setText("jTextField1");
        txfEstado.setBorder(null);

        txfCantidad.setEditable(false);
        txfCantidad.setBackground(new java.awt.Color(217, 217, 217));
        txfCantidad.setText("jTextField1");
        txfCantidad.setBorder(null);

        txfFechaTramite.setEditable(false);
        txfFechaTramite.setBackground(new java.awt.Color(217, 217, 217));
        txfFechaTramite.setText("jTextField1");
        txfFechaTramite.setBorder(null);

        txfCosto.setEditable(false);
        txfCosto.setBackground(new java.awt.Color(217, 217, 217));
        txfCosto.setText("jTextField1");
        txfCosto.setBorder(null);

        txfFechaRecepcion.setEditable(false);
        txfFechaRecepcion.setBackground(new java.awt.Color(217, 217, 217));
        txfFechaRecepcion.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfFechaTramite, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfFechaTramite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField txfCantidad;
    private javax.swing.JTextField txfCosto;
    private javax.swing.JTextField txfEstado;
    private javax.swing.JTextField txfFechaRecepcion;
    private javax.swing.JTextField txfFechaTramite;
    private javax.swing.JTextField txfNumero;
    // End of variables declaration//GEN-END:variables
}
