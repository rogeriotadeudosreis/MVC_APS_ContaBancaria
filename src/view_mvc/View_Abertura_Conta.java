package view_mvc;

import controller_mvc.ClienteControle;
import javax.swing.JOptionPane;
import controller_mvc.ContaComumControle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model_mvc.ClienteModel;
import model_mvc.ContaComumModel;
import classes_utilitarias.Enum_TipoDeConta;
import controller_mvc.ContaEspecialControle;
import model_mvc.ContaEspecialModel;

public class View_Abertura_Conta extends javax.swing.JDialog {

    ContaComumControle controleComum;
    ContaEspecialControle controleEspecial;

    ContaComumModel contaComum;
    ContaEspecialModel contaEspecial;

    ContaComumModel contaAnterior;
    ClienteControle clienteControle;

    /**
     * Creates new form View_Abertura_Conta
     */
    public View_Abertura_Conta(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        controleComum = new ContaComumControle();
        controleEspecial = new ContaEspecialControle();

        contaComum = new ContaComumModel();
        contaEspecial = new ContaEspecialModel();

        clienteControle = new ClienteControle();

        imprimirDadosClientes(clienteControle.recuperar());
        imprimirDadosContas(controleComum.recuperarContas());

        jComboBoxTipoDeConta.removeAllItems();
        String[] opcaoTipoDeConta = {"Selecione aqui o tipo da conta", "Conta Comum", "Conta Especial"};
        for (int i = 0; i < opcaoTipoDeConta.length; i++) {
            jComboBoxTipoDeConta.addItem(opcaoTipoDeConta[i]);
        }
    }

    public void imprimirDadosClientes(ArrayList<ClienteModel> lista) throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTableCadClientes.getModel();
        model.setNumRows(0);
        Collections.sort(lista);
        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[4];
            ClienteModel aux = lista.get(pos);
            linha[0] = "" + aux.getId();
            linha[1] = aux.getNome().trim().toUpperCase();
            linha[2] = aux.getEmail();
            model.addRow(linha);
        }
    }

    public void imprimirDadosContas(ArrayList<ContaComumModel> lista) throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTableContasExistentes.getModel();
        model.setNumRows(0);

        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[6];
            ContaComumModel aux = lista.get(pos);
            linha[0] = aux.getId() + "";
            linha[1] = aux.getConta().toString();
            linha[2] = aux.getidCliente() + "";
            linha[3] = aux.getTipoDeConta() + "";
            linha[4] = aux.getSaldo() + "";
            linha[5] = aux.getLimite() + "";
            model.addRow(linha);
        }
    }

    public void habilitaCampos() {
        jComboBoxTipoDeConta.setEnabled(true);
        jTextFieldValorDepositoInicialDeAbertura.setEnabled(true);
        jTextFieldContaNumDaConta.setEnabled(true);
    }

    public void limpacampos() {
        jTextFieldClienteSelecionado.setText("");
        jComboBoxTipoDeConta.setSelectedItem("Selecione aqui o tipo da conta");
        jTextFieldLimite.setText("0");
        jTextFieldContaNumDaConta.setText("0");
        jTextFieldValorDepositoInicialDeAbertura.setText("0");
    }

    public void preencherCamposDaConta() {
        int linha = jTableCadClientes.getSelectedRow();
        if (linha >= 0) {
            String nome_Cliente = jTableCadClientes.getValueAt(linha, 1).toString();
            jTextFieldClienteSelecionado.setText(nome_Cliente);
        }
    }

    public void preencherCamposDaContaParaAlteração() {
        int linha = jTableContasExistentes.getSelectedRow();
        if (linha >= 0) {

            String idConta = jTableContasExistentes.getValueAt(linha, 0).toString();
            String numDaConta = jTableContasExistentes.getValueAt(linha, 1).toString();
            String clienteSelecionado = jTableContasExistentes.getValueAt(linha, 2).toString();
            String tipoDaConta = jTableContasExistentes.getValueAt(linha, 3).toString();
            String saldoAtual = jTableContasExistentes.getValueAt(linha, 4).toString();
            String limite = jTableContasExistentes.getValueAt(linha, 5).toString();

            contaAnterior = new ContaComumModel();
            contaAnterior.setId(Integer.parseInt(idConta));
            jTextFieldContaNumDaConta.setText(numDaConta);
            jTextFieldClienteSelecionado.setText(clienteSelecionado);
            jComboBoxTipoDeConta.setSelectedItem(tipoDaConta);
            jTextFieldSaldoAtual.setText(saldoAtual);
            jTextFieldLimite.setText(limite);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelAberturaConta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldLimite = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldContaNumDaConta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldClienteSelecionado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValorDepositoInicialDeAbertura = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvarConta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableContasExistentes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonDeposito = new javax.swing.JButton();
        jButtonSaque = new javax.swing.JButton();
        jTextFieldNovoSaldo = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jComboBoxTipoDeConta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldSaldoAtual = new javax.swing.JTextField();
        jButtonEditarConta = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDigitaDadosCliente = new javax.swing.JTextField();
        jButtonPesquisarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Abertura de Conta - Banco MVC");
        setResizable(false);

        jTableCadClientes.setAutoCreateRowSorter(true);
        jTableCadClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadClientes);
        if (jTableCadClientes.getColumnModel().getColumnCount() > 0) {
            jTableCadClientes.getColumnModel().getColumn(0).setMinWidth(50);
            jTableCadClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableCadClientes.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableCadClientes.getColumnModel().getColumn(1).setMinWidth(250);
            jTableCadClientes.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTableCadClientes.getColumnModel().getColumn(1).setMaxWidth(250);
        }

        jLabel1.setText("Tipo de Conta:");

        jTextFieldLimite.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldLimite.setText("0");
        jTextFieldLimite.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldLimiteFocusGained(evt);
            }
        });

        jLabel3.setText("Núm. da Conta:");

        jTextFieldContaNumDaConta.setText("0");

        jLabel4.setText("Cliente Selecionado:");

        jTextFieldClienteSelecionado.setEditable(false);

        jLabel5.setText("Depósito Inicial ? :");

        jTextFieldValorDepositoInicialDeAbertura.setText("0");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvarConta.setText("Salvar Conta");
        jButtonSalvarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarContaActionPerformed(evt);
            }
        });

        jTableContasExistentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Conta", "Cliente", "Conta Tipo", "Saldo com Limite", "Limite"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContasExistentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContasExistentesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableContasExistentes);
        if (jTableContasExistentes.getColumnModel().getColumnCount() > 0) {
            jTableContasExistentes.getColumnModel().getColumn(0).setMinWidth(50);
            jTableContasExistentes.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableContasExistentes.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableContasExistentes.getColumnModel().getColumn(1).setMinWidth(80);
            jTableContasExistentes.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableContasExistentes.getColumnModel().getColumn(1).setMaxWidth(80);
            jTableContasExistentes.getColumnModel().getColumn(2).setMinWidth(200);
            jTableContasExistentes.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTableContasExistentes.getColumnModel().getColumn(2).setMaxWidth(200);
            jTableContasExistentes.getColumnModel().getColumn(3).setMinWidth(80);
            jTableContasExistentes.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableContasExistentes.getColumnModel().getColumn(3).setMaxWidth(80);
            jTableContasExistentes.getColumnModel().getColumn(4).setMinWidth(110);
            jTableContasExistentes.getColumnModel().getColumn(4).setPreferredWidth(110);
            jTableContasExistentes.getColumnModel().getColumn(4).setMaxWidth(110);
            jTableContasExistentes.getColumnModel().getColumn(5).setMinWidth(80);
            jTableContasExistentes.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Operações:");

        jLabel9.setText("Novo Saldo:");

        jLabel10.setText("Valor:");

        jButtonDeposito.setText("Deposito");
        jButtonDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepositoActionPerformed(evt);
            }
        });

        jButtonSaque.setText("Saque");
        jButtonSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaqueActionPerformed(evt);
            }
        });

        jTextFieldNovoSaldo.setEditable(false);

        jTextFieldValor.setEditable(false);

        jComboBoxTipoDeConta.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxTipoDeConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione aqui o tipo da conta" }));
        jComboBoxTipoDeConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxTipoDeContaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBoxTipoDeContaMousePressed(evt);
            }
        });
        jComboBoxTipoDeConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoDeContaActionPerformed(evt);
            }
        });

        jLabel2.setText("Limite:");

        jLabel13.setText("Lista de Contas Bancárias Existentes");

        jLabel7.setText("Saldo Atual:");

        jTextFieldSaldoAtual.setEditable(false);

        jButtonEditarConta.setText("Editar Conta");
        jButtonEditarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarContaActionPerformed(evt);
            }
        });

        jLabel8.setText("Lista de Clientes Cadastros no Banco MVC");

        jTextFieldDigitaDadosCliente.setText("Digite aqui o nome ou email do cliente");
        jTextFieldDigitaDadosCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDigitaDadosClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDigitaDadosClienteFocusLost(evt);
            }
        });

        jButtonPesquisarCliente.setText("Pesquisar");
        jButtonPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAberturaContaLayout = new javax.swing.GroupLayout(jPanelAberturaConta);
        jPanelAberturaConta.setLayout(jPanelAberturaContaLayout);
        jPanelAberturaContaLayout.setHorizontalGroup(
            jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAberturaContaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAberturaContaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoDeConta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEditarConta)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalvarConta)
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar)
                    .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldLimite, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                        .addComponent(jTextFieldSaldoAtual))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAberturaContaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldClienteSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldValorDepositoInicialDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldContaNumDaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNovoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDeposito)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSaque)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                        .addComponent(jTextFieldDigitaDadosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisarCliente)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelAberturaContaLayout.setVerticalGroup(
            jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDigitaDadosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarCliente))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldClienteSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoDeConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValorDepositoInicialDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldContaNumDaConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalvarConta)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonEditarConta))
                        .addGap(20, 20, 20))
                    .addGroup(jPanelAberturaContaLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDeposito)
                        .addComponent(jButtonSaque)
                        .addComponent(jLabel10)
                        .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanelAberturaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldNovoSaldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAberturaConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jPanelAberturaConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTipoDeContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoDeContaActionPerformed
        if (jComboBoxTipoDeConta.getSelectedIndex() == 1) {
            jTextFieldLimite.setEnabled(false);
            jTextFieldLimite.setText("0");

        } else if (jComboBoxTipoDeConta.getSelectedIndex() == 2) {
            jTextFieldLimite.setEnabled(true);
            jTextFieldLimite.setText("");
            JOptionPane.showMessageDialog(null, "Informe o limite para este tipo de conta");
            jTextFieldLimite.requestFocus();
        }

    }//GEN-LAST:event_jComboBoxTipoDeContaActionPerformed

    private void jComboBoxTipoDeContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxTipoDeContaMouseClicked

    }//GEN-LAST:event_jComboBoxTipoDeContaMouseClicked

    private void jButtonSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaqueActionPerformed
        try {

            jTextFieldValor.setText("");
            jTextFieldValor.requestFocus();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonSaqueActionPerformed

    private void jButtonDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDepositoActionPerformed
        try {

            contaComum.deposito(Double.parseDouble(jTextFieldValor.getText()));

            jTextFieldNovoSaldo.setText(contaComum.getSaldo() + "");

        } catch (Exception ex) {
            Logger.getLogger(View_Abertura_Conta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDepositoActionPerformed

    private void jTableContasExistentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContasExistentesMouseClicked
        preencherCamposDaContaParaAlteração();
        jTextFieldValor.requestFocus();
        String saldo = jTableContasExistentes.getValueAt(jTableContasExistentes.getSelectedRow(), 4).toString();
        jTextFieldNovoSaldo.setText(saldo);

    }//GEN-LAST:event_jTableContasExistentesMouseClicked

    private void jButtonSalvarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarContaActionPerformed

        if (jTextFieldContaNumDaConta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o número da conta\n");
            jTextFieldContaNumDaConta.requestFocus();
        } else if (jTextFieldClienteSelecionado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome do cliente\n");
            jTextFieldDigitaDadosCliente.requestFocus();
        } else {

            try {
                contaComum.setId(contaAnterior.getId());

                //Aqui é feita uma opção do tipo de conta a ser criada através do switch
                switch (jComboBoxTipoDeConta.getSelectedIndex()) {
                    case 1: // Opção 1 indica tipo de conta COMUM.
                        contaComum.setConta(jTextFieldContaNumDaConta.getText());
                        int id_cliente = Integer.parseInt(jTableCadClientes.getValueAt(jTableCadClientes.getSelectedRow(), 0).toString());
                        contaComum.setIdCliente(id_cliente);
                        contaComum.setTipoDeConta(Enum_TipoDeConta.COMUM);
                        switch (jTextFieldValorDepositoInicialDeAbertura.getText()) {
                            case "0":
                                JOptionPane.showMessageDialog(null, "Depósito inicial não realizado.");
                                break;

                            default:
                                contaComum.deposito(Double.parseDouble(jTextFieldValorDepositoInicialDeAbertura.getText()));
                                JOptionPane.showMessageDialog(null, "Depósito inicial realizado!");
                                break;
                        }
                        contaComum.setLimite(Double.parseDouble(jTextFieldLimite.getText()));

                        if (contaComum.getidCliente() == 0) {
                            controleComum.incluirConta(contaComum);
                            limpacampos();
                            imprimirDadosContas(controleComum.recuperarContas());
                            jTextFieldNovoSaldo.setText(contaComum.getSaldo() + "");
                            System.out.println(contaComum.toString());
                        } else {
                            controleComum.alterarContaComum(contaComum);
                            limpacampos();
                            imprimirDadosContas(controleComum.recuperarContas());
                            jTextFieldSaldoAtual.setText(contaComum.getSaldo() + "");
                            jTextFieldNovoSaldo.setText(contaComum.getSaldo() + "");
                            System.out.println(contaComum.toString());
                        }

                        break;

                    case 2:// Opção 2 indica tipo de conta ESPECIAL
                        contaEspecial.setConta(jTextFieldContaNumDaConta.getText());
                        id_cliente = Integer.parseInt(jTableCadClientes.getValueAt(jTableCadClientes.getSelectedRow(), 0).toString());
                        contaEspecial.setIdCliente(id_cliente);
                        contaEspecial.setTipoDeConta(Enum_TipoDeConta.ESPECIAL);
                        switch (jTextFieldValorDepositoInicialDeAbertura.getText()) {
                            case "0":
                                JOptionPane.showMessageDialog(null, "Depósito inicial não realizado.");
                                break;

                            default:
                                contaEspecial.deposito(Double.parseDouble(jTextFieldValorDepositoInicialDeAbertura.getText()));
                                JOptionPane.showMessageDialog(null, "Depósito inicial realizado!");
                                break;
                        }
                        contaEspecial.setLimite(Double.parseDouble(jTextFieldLimite.getText()));

                        controleEspecial.incluirContaEspecial(contaEspecial);
                        limpacampos();
                        imprimirDadosContas(controleComum.recuperarContas());
                        jTextFieldNovoSaldo.setText(contaEspecial.getSaldo() + "");
                        System.out.println(contaEspecial.toString());
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Informe o tipo da conta por favor");
                        jComboBoxTipoDeConta.requestFocus();
                        break;
                }

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonSalvarContaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldLimiteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLimiteFocusGained

    }//GEN-LAST:event_jTextFieldLimiteFocusGained

    private void jTableCadClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadClientesMouseClicked
        try {
            preencherCamposDaConta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "opa !\n" + erro.getMessage());
        }
    }//GEN-LAST:event_jTableCadClientesMouseClicked

    private void jButtonPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarClienteActionPerformed
        try {
            imprimirDadosClientes(clienteControle.pesquisar(jTextFieldDigitaDadosCliente.getText()));
            jTextFieldDigitaDadosCliente.requestFocus();
            jTextFieldDigitaDadosCliente.setText("");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonPesquisarClienteActionPerformed

    private void jTextFieldDigitaDadosClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDigitaDadosClienteFocusLost
        if (jTextFieldDigitaDadosCliente.getText().equals("")) {
            jTextFieldDigitaDadosCliente.setText("Digite aqui o nome ou email do cliente");
        }
    }//GEN-LAST:event_jTextFieldDigitaDadosClienteFocusLost

    private void jTextFieldDigitaDadosClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDigitaDadosClienteFocusGained
        if (jTextFieldDigitaDadosCliente.getText().equals("Digite aqui o nome ou email do cliente")) {
            jTextFieldDigitaDadosCliente.setText("");
        }
    }//GEN-LAST:event_jTextFieldDigitaDadosClienteFocusGained

    private void jButtonEditarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarContaActionPerformed
        jTextFieldLimite.setEnabled(true);
    }//GEN-LAST:event_jButtonEditarContaActionPerformed

    private void jComboBoxTipoDeContaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxTipoDeContaMousePressed
    }//GEN-LAST:event_jComboBoxTipoDeContaMousePressed

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
            java.util.logging.Logger.getLogger(View_Abertura_Conta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Abertura_Conta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Abertura_Conta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Abertura_Conta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View_Abertura_Conta dialog = new View_Abertura_Conta(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(View_Abertura_Conta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonDeposito;
    private javax.swing.JButton jButtonEditarConta;
    private javax.swing.JButton jButtonPesquisarCliente;
    private javax.swing.JButton jButtonSalvarConta;
    private javax.swing.JButton jButtonSaque;
    private javax.swing.JComboBox<String> jComboBoxTipoDeConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelAberturaConta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCadClientes;
    private javax.swing.JTable jTableContasExistentes;
    private javax.swing.JTextField jTextFieldClienteSelecionado;
    private javax.swing.JTextField jTextFieldContaNumDaConta;
    private javax.swing.JTextField jTextFieldDigitaDadosCliente;
    private javax.swing.JTextField jTextFieldLimite;
    private javax.swing.JTextField jTextFieldNovoSaldo;
    private javax.swing.JTextField jTextFieldSaldoAtual;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldValorDepositoInicialDeAbertura;
    // End of variables declaration//GEN-END:variables
}
