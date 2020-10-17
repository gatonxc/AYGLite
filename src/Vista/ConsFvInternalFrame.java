package Vista;


import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Julian Gato
 */
public class ConsFvInternalFrame extends javax.swing.JInternalFrame {

    public Controlador.GestorFvControl gestorfvControl;
    private DefaultTableModel tabla;
    public ConsFvInternalFrame() {
        initComponents();
        gestorfvControl= new Controlador.GestorFvControl(this);
        String titulosTabla[]={"Factura","","Paciente","Facturador","Cod Cup","Descripcion","Subtotal","Impuesto","Total"};
        tabla=new DefaultTableModel(null,titulosTabla);
        tbl_datos.setModel(tabla);
        tbl_datos.getColumnModel().getColumn(1).setMaxWidth(0);
        tbl_datos.getColumnModel().getColumn(1).setMinWidth(0);
        tbl_datos.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tbl_datos.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        btn_buscar.addActionListener(gestorfvControl);
        btn_cerrar.addActionListener(gestorfvControl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbd_factura = new javax.swing.JRadioButton();
        rbd_paciente = new javax.swing.JRadioButton();
        rbd_facturador = new javax.swing.JRadioButton();
        rbd_todos = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new javax.swing.JTable();
        btn_cerrar = new javax.swing.JButton();

        setTitle("Consultar Factura de Venta");

        buttonGroup1.add(rbd_factura);
        rbd_factura.setText("Factura");

        buttonGroup1.add(rbd_paciente);
        rbd_paciente.setText("Id Paciente");

        buttonGroup1.add(rbd_facturador);
        rbd_facturador.setText("Id Facturador");

        buttonGroup1.add(rbd_todos);
        rbd_todos.setText("Todos");

        jLabel1.setText("Valor a buscar:");

        btn_buscar.setText("Buscar");
        btn_buscar.setName("Btn_buscar"); // NOI18N

        tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_datos);

        btn_cerrar.setText("Cerrar");
        btn_cerrar.setName("Btn_cerrar"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbd_factura)
                                .addGap(18, 18, 18)
                                .addComponent(rbd_paciente)
                                .addGap(18, 18, 18)
                                .addComponent(rbd_facturador)
                                .addGap(18, 18, 18)
                                .addComponent(rbd_todos))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_buscar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_cerrar)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbd_factura)
                    .addComponent(rbd_paciente)
                    .addComponent(rbd_facturador)
                    .addComponent(rbd_todos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(btn_cerrar)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_buscar;
    public javax.swing.JButton btn_cerrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JRadioButton rbd_factura;
    public javax.swing.JRadioButton rbd_facturador;
    public javax.swing.JRadioButton rbd_paciente;
    public javax.swing.JRadioButton rbd_todos;
    public javax.swing.JTable tbl_datos;
    public javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
