package FRMs;

import Control.ControlNavegacion;
import DTOs.PlacasNuevasDTO;
import DTOs.SeleccionarVehiculoDTO;
import DTOs.VehiculoViejoDTO;
import javax.swing.SwingUtilities;

/**
 *
 * @author daniel
 */
public class PnlVehiculo extends javax.swing.JPanel {

    private SeleccionarVehiculoDTO vehiculo;
    
    /**
     * Creates new form PnlVehiculo
     */
    public PnlVehiculo(SeleccionarVehiculoDTO v) {
        initComponents();
        this.vehiculo = v;
        
        txfNoPlacas.setText(v.getNumPlacas());
        txfMarca.setText(v.getMarca());
        txfLinea.setText(v.getLinea());
        txfColor.setText(v.getColor());
        txfModelo.setText(v.getModelo());
        txfTipo.setText(v.getTipo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfNoPlacas = new javax.swing.JTextField();
        txfMarca = new javax.swing.JTextField();
        txfLinea = new javax.swing.JTextField();
        txfColor = new javax.swing.JTextField();
        txfModelo = new javax.swing.JTextField();
        txfTipo = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        btnHistorialPlacas = new javax.swing.JButton();

        setBackground(new java.awt.Color(217, 217, 217));
        setMaximumSize(new java.awt.Dimension(1056, 32));
        setMinimumSize(new java.awt.Dimension(1056, 32));

        txfNoPlacas.setEditable(false);
        txfNoPlacas.setBackground(new java.awt.Color(217, 217, 217));
        txfNoPlacas.setText("jTextField1");
        txfNoPlacas.setBorder(null);

        txfMarca.setEditable(false);
        txfMarca.setBackground(new java.awt.Color(217, 217, 217));
        txfMarca.setText("jTextField1");
        txfMarca.setBorder(null);

        txfLinea.setEditable(false);
        txfLinea.setBackground(new java.awt.Color(217, 217, 217));
        txfLinea.setText("jTextField1");
        txfLinea.setBorder(null);

        txfColor.setEditable(false);
        txfColor.setBackground(new java.awt.Color(217, 217, 217));
        txfColor.setText("jTextField1");
        txfColor.setBorder(null);

        txfModelo.setEditable(false);
        txfModelo.setBackground(new java.awt.Color(217, 217, 217));
        txfModelo.setText("jTextField1");
        txfModelo.setBorder(null);

        txfTipo.setEditable(false);
        txfTipo.setBackground(new java.awt.Color(217, 217, 217));
        txfTipo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txfTipo.setText("jTextField1");
        txfTipo.setBorder(null);

        btnSeleccionar.setBackground(new java.awt.Color(0, 0, 0));
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnHistorialPlacas.setBackground(new java.awt.Color(0, 0, 0));
        btnHistorialPlacas.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorialPlacas.setText("Historial Placas");
        btnHistorialPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialPlacasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txfNoPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfColor, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnHistorialPlacas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNoPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnHistorialPlacas))
                .addContainerGap(9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHistorialPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialPlacasActionPerformed
        ControlNavegacion.getInstancia().getVehiculoViejoDTO().setId(vehiculo.getId());
        
        ControlNavegacion.getInstancia().mostrarFrmHistorialPlacas();
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnHistorialPlacasActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        ControlNavegacion.getInstancia().getVehiculoViejoDTO().setId(vehiculo.getId());
        ControlNavegacion.getInstancia().setCostoLicensia(1000.0);
        ControlNavegacion.getInstancia().setPlacasNuevas(new PlacasNuevasDTO());
        
        ControlNavegacion.getInstancia().mostrarFrmOpcionesPago();
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorialPlacas;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JTextField txfColor;
    private javax.swing.JTextField txfLinea;
    private javax.swing.JTextField txfMarca;
    private javax.swing.JTextField txfModelo;
    private javax.swing.JTextField txfNoPlacas;
    private javax.swing.JTextField txfTipo;
    // End of variables declaration//GEN-END:variables
}
