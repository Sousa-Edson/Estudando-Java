/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import controller.EntradaController;
import controller.PedidoController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import service.Conversor;
import service.DataHoraAtual;

/**
 *
 * @author hp
 */
public class PedidoForm extends javax.swing.JFrame {

    private final PedidoController controller;
    Conversor conversor = new Conversor();
    int idProduto = 0;
    int idNota = 0;
    int idItem = 0;

    public PedidoForm() {
        initComponents();
        

        controller = new PedidoController(this);
        controller.loadTable("", false);
        btnExcluir.setVisible(false);
        btnSalvar.setEnabled(false);

        controller.PreencheEmpresa(0);
        controller.PreencheCfop(0);

//        controller.PreencheTipo(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pnHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblPesquisa = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        lblVersao = new javax.swing.JLabel();
        pnConteiner = new javax.swing.JLayeredPane();
        pnModo2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtDataHora = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItem = new javax.swing.JTable();
        btnIncluir = new javax.swing.JButton();
        cbComplemento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnMain.setBackground(new java.awt.Color(204, 204, 204));

        pnHeader.setBackground(new java.awt.Color(153, 153, 255));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Pedidos");

        lblPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lupa.png"))); // NOI18N
        lblPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPesquisaMouseClicked(evt);
            }
        });

        txtPesquisa.setBackground(new java.awt.Color(153, 153, 255));
        txtPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        lblVersao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVersao.setForeground(new java.awt.Color(255, 255, 255));
        lblVersao.setText("Listar e cadastrar pedidos");

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPesquisa)
                .addGap(19, 19, 19))
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnHeaderLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnHeaderLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(lblVersao, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(371, Short.MAX_VALUE))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVersao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPesquisa))
                .addGap(16, 16, 16))
        );

        pnHeaderLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblPesquisa, txtPesquisa});

        pnModo2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setText("ID");

        txtIdProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdProdutoKeyReleased(evt);
            }
        });

        jLabel20.setText("Itens");

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salve-.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalvarKeyPressed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vassoura-16.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 0, 0));
        btnExcluir.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vassoura-16.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/de-volta-16.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtDataHora.setText("44");

        txtNomeUsuario.setText("teste");

        jLabel9.setText("Descrição");

        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyReleased(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Qtd");

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyReleased(evt);
            }
        });

        jLabel11.setText("Complemento");

        tabelaItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaItemMouseClicked(evt);
            }
        });
        tabelaItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaItemKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaItem);

        btnIncluir.setBackground(new java.awt.Color(0, 204, 0));
        btnIncluir.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnIncluir.setForeground(new java.awt.Color(255, 255, 255));
        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salve-.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        btnIncluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIncluirKeyPressed(evt);
            }
        });

        cbComplemento.setEditable(true);
        cbComplemento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "bom", "c/ defeito", "outro" }));
        cbComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbComplementoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnModo2Layout = new javax.swing.GroupLayout(pnModo2);
        pnModo2.setLayout(pnModo2Layout);
        pnModo2Layout.setHorizontalGroup(
            pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnModo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnModo2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(pnModo2Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(553, 553, 553)
                        .addComponent(btnIncluir)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnModo2Layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(btnVoltar)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnModo2Layout.createSequentialGroup()
                        .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbComplemento, 0, 187, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnModo2Layout.setVerticalGroup(
            pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnModo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(btnIncluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnModo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar)
                        .addComponent(btnExcluir)
                        .addComponent(btnVoltar))
                    .addComponent(btnSalvar)
                    .addGroup(pnModo2Layout.createSequentialGroup()
                        .addComponent(txtDataHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeUsuario)))
                .addContainerGap())
        );

        pnConteiner.setLayer(pnModo2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnConteinerLayout = new javax.swing.GroupLayout(pnConteiner);
        pnConteiner.setLayout(pnConteinerLayout);
        pnConteinerLayout.setHorizontalGroup(
            pnConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConteinerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnModo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnConteinerLayout.setVerticalGroup(
            pnConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConteinerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnModo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnConteiner)
                .addContainerGap())
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnConteiner)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (controller.create() == true) {
            

            controller.clearDataHora();
            controller.clearDados();
            // controller.loadTableItem();
            controller.loadTable("", false);
            btnSalvar.setText("Salvar");
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void lblPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesquisaMouseClicked
        
        if (txtPesquisa.getText().length() >= 0) {
            controller.loadTable(txtPesquisa.getText(), false);
        }
        if (evt.getButton() == 3) {
            controller.loadTable(txtPesquisa.getText(), true);
        }
    }//GEN-LAST:event_lblPesquisaMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        controller.clear();
        controller.clearDataHora();
        controller.clearDados();
        controller.loadTableItem();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
//        controller.destroy(idUnidade);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        
        controller.PreencheEmpresa(0);
        btnSalvar.setText("Salvar");
        controller.clear();
        controller.clearDataHora();
        controller.clearDados();
        controller.loadTableItem();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (txtPesquisa.getText().length() >= 2) {
                controller.loadTable(txtPesquisa.getText(), true);
            }
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void txtDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            System.out.println("view.EntradaForm.txtDescricaoKeyReleased()");

        }
    }//GEN-LAST:event_txtDescricaoKeyReleased

    private void txtQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtQuantidade.setText(conversor.stringAmount(txtQuantidade.getText()));
            btnIncluir.requestFocus();
        }
    }//GEN-LAST:event_txtQuantidadeKeyReleased

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
//        controller.testeItem();
        controller.addItem();
        controller.pressKeys();

    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnIncluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIncluirKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            controller.addItem();
            controller.pressKeys();
        }
    }//GEN-LAST:event_btnIncluirKeyPressed

    private void txtIdProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProdutoKeyReleased

        txtIdProduto.setText("" + conversor.stringForInteger(txtIdProduto.getText()));
        if (evt.getKeyCode() == evt.VK_ENTER) {
            controller.buscarProduto(txtIdProduto.getText());
            controller.pressKeys();

        }
    }//GEN-LAST:event_txtIdProdutoKeyReleased

    private void cbComplementoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbComplementoKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtQuantidade.requestFocus();
        }
    }//GEN-LAST:event_cbComplementoKeyReleased

    private void tabelaItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaItemMouseClicked
//        if (evt.getClickCount() == 2) {
        idItem = (int) tabelaItem.getValueAt(tabelaItem.getSelectedRow(), 0);
        System.out.println("selecionado para deletar id = " + idItem);

//        }
    }//GEN-LAST:event_tabelaItemMouseClicked

    private void tabelaItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaItemKeyPressed
        if (evt.getKeyCode() == evt.VK_DELETE) {
            if (idItem != 0) {
                Object[] options = {"Confirmar", "Cancelar"};
                int op = JOptionPane.showOptionDialog(null, "Deseja realmente deletar " + idItem, "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[1]);
                System.out.println("op = " + op);
                if (op == 0) {
                    controller.removeItem(idItem);
                    idItem = 0;
                }
            }
        }

    }//GEN-LAST:event_tabelaItemKeyPressed

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
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbComplemento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVersao;
    private javax.swing.JLayeredPane pnConteiner;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnModo2;
    private javax.swing.JTable tabelaItem;
    private javax.swing.JLabel txtDataHora;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JLabel txtNomeUsuario;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables

    public PedidoController getController() {
        return controller;
    }

    public Conversor getConversor() {
        return conversor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getIdNota() {
        return idNota;
    }

    public int getIdItem() {
        return idItem;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JButton getBtnIncluir() {
        return btnIncluir;
    }

    public JButton getBtnLimpar() {
        return btnLimpar;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }

    public JComboBox<String> getCbComplemento() {
        return cbComplemento;
    }

    
    public JLabel getjLabel10() {
        return jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }
 

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JLabel getLblPesquisa() {
        return lblPesquisa;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public JLabel getLblVersao() {
        return lblVersao;
    }

    public JLayeredPane getPnConteiner() {
        return pnConteiner;
    }

    public JPanel getPnHeader() {
        return pnHeader;
    }

    public JPanel getPnMain() {
        return pnMain;
    }

    public JPanel getPnModo2() {
        return pnModo2;
    }

    public JTable getTabelaItem() {
        return tabelaItem;
    }

    public JLabel getTxtDataHora() {
        return txtDataHora;
    }

    public JTextField getTxtDescricao() {
        return txtDescricao;
    }

    public JTextField getTxtIdProduto() {
        return txtIdProduto;
    }

    public JLabel getTxtNomeUsuario() {
        return txtNomeUsuario;
    }

    public JTextField getTxtPesquisa() {
        return txtPesquisa;
    }

    public JTextField getTxtQuantidade() {
        return txtQuantidade;
    }

  
 
}
