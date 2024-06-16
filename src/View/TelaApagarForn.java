package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import DAO.FornecedorDAO;
import Model.Fornecedor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

/**
 * Um JPanel para apagar dados de fornecedores do sistema.
 * Este painel permite aos usuários inserir informações do fornecedor e deletá-las do banco de dados.
 */
public class TelaApagarForn extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textTelForn;
    private JTextField textMailForn;
    private JTextField textNomeForn;
    private JTextField textEndForn;
    private JTextField textEstadoForn;
    private JTextField textCidForn;
    private JTextField textCodForn;

    /**
     * Cria o painel e inicializa seus componentes.
     */
    public TelaApagarForn() {
        setBackground(new Color(245, 245, 245));
        setLayout(null);
        
        JLabel lblApagarForn = new JLabel("Apagar Dados de Fornecedores");
        lblApagarForn.setHorizontalAlignment(SwingConstants.CENTER);
        lblApagarForn.setForeground(new Color(47, 79, 79));
        lblApagarForn.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblApagarForn.setBackground(Color.BLACK);
        lblApagarForn.setBounds(10, 23, 779, 43);
        add(lblApagarForn);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame parentFrame = (JFrame) TelaApagarForn.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // Isso fechará o JFrame
                }
            }
        });
        btnVoltar.setForeground(new Color(47, 79, 79));
        btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnVoltar.setBackground(new Color(245, 245, 245));
        btnVoltar.setBounds(263, 394, 117, 31);
        add(btnVoltar);
        
        JButton btnApagar = new JButton("Apagar");
        btnApagar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FornecedorDAO fornecedorDAO = new FornecedorDAO(null);
                Fornecedor fornecedor = new Fornecedor();

                try {
                    fornecedor.setIdFornecedor(Integer.parseInt(textCodForn.getText()));
                    fornecedorDAO.delete(fornecedor);
                    JOptionPane.showMessageDialog(null, "Fornecedor deletado com sucesso!");
                    // Limpar os campos de texto após salvar
                    textCodForn.setText("");
                    textNomeForn.setText("");
                    textTelForn.setText("");
                    textEndForn.setText("");
                    textCidForn.setText("");
                    textEstadoForn.setText("");
                    textMailForn.setText("");
                } catch (Exception ex) {
                    System.out.println("Erro ao formatar número: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao apagar fornecedor! " + ex.getMessage());
                }
            }
        });
        btnApagar.setForeground(new Color(47, 79, 79));
        btnApagar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnApagar.setBackground(new Color(245, 245, 245));
        btnApagar.setBounds(433, 394, 117, 31);
        add(btnApagar);
        
        textTelForn = new JTextField();
        textTelForn.setHorizontalAlignment(SwingConstants.LEFT);
        textTelForn.setForeground(Color.BLACK);
        textTelForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textTelForn.setColumns(10);
        textTelForn.setBackground(Color.WHITE);
        textTelForn.setBounds(253, 237, 402, 39);
        add(textTelForn);
        
        JLabel lblTelefoneForn = new JLabel("Telefone:");
        lblTelefoneForn.setHorizontalAlignment(SwingConstants.CENTER);
        lblTelefoneForn.setForeground(new Color(47, 79, 79));
        lblTelefoneForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblTelefoneForn.setBackground(Color.BLACK);
        lblTelefoneForn.setBounds(128, 237, 128, 39);
        add(lblTelefoneForn);
        
        JLabel lblEmailForn = new JLabel("E-mail:");
        lblEmailForn.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmailForn.setForeground(new Color(47, 79, 79));
        lblEmailForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblEmailForn.setBackground(Color.BLACK);
        lblEmailForn.setBounds(148, 187, 115, 39);
        add(lblEmailForn);
        
        textMailForn = new JTextField();
        textMailForn.setHorizontalAlignment(SwingConstants.LEFT);
        textMailForn.setForeground(Color.BLACK);
        textMailForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textMailForn.setColumns(10);
        textMailForn.setBackground(Color.WHITE);
        textMailForn.setBounds(253, 187, 402, 39);
        add(textMailForn);
        
        textNomeForn = new JTextField();
        textNomeForn.setHorizontalAlignment(SwingConstants.LEFT);
        textNomeForn.setForeground(Color.BLACK);
        textNomeForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textNomeForn.setColumns(10);
        textNomeForn.setBackground(Color.WHITE);
        textNomeForn.setBounds(253, 137, 402, 39);
        add(textNomeForn);
        
        JLabel lblNomeForn = new JLabel("Fornecedor:");
        lblNomeForn.setHorizontalAlignment(SwingConstants.CENTER);
        lblNomeForn.setForeground(new Color(47, 79, 79));
        lblNomeForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblNomeForn.setBackground(Color.BLACK);
        lblNomeForn.setBounds(107, 137, 145, 39);
        add(lblNomeForn);
        
        JLabel lblEndForn = new JLabel("Endereço:");
        lblEndForn.setHorizontalAlignment(SwingConstants.CENTER);
        lblEndForn.setForeground(new Color(47, 79, 79));
        lblEndForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblEndForn.setBackground(Color.BLACK);
        lblEndForn.setBounds(128, 287, 128, 39);
        add(lblEndForn);
        
        textEndForn = new JTextField();
        textEndForn.setHorizontalAlignment(SwingConstants.LEFT);
        textEndForn.setForeground(Color.BLACK);
        textEndForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textEndForn.setColumns(10);
        textEndForn.setBackground(Color.WHITE);
        textEndForn.setBounds(253, 287, 402, 39);
        add(textEndForn);
        
        textEstadoForn = new JTextField();
        textEstadoForn.setHorizontalAlignment(SwingConstants.LEFT);
        textEstadoForn.setForeground(Color.BLACK);
        textEstadoForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textEstadoForn.setColumns(10);
        textEstadoForn.setBackground(Color.WHITE);
        textEstadoForn.setBounds(553, 336, 102, 39);
        add(textEstadoForn);
        
        JLabel lblEstadoForn = new JLabel("Estado:");
        lblEstadoForn.setHorizontalAlignment(SwingConstants.CENTER);
        lblEstadoForn.setForeground(new Color(47, 79, 79));
        lblEstadoForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblEstadoForn.setBackground(Color.BLACK);
        lblEstadoForn.setBounds(447, 336, 115, 39);
        add(lblEstadoForn);
        
        JLabel lblCidadeForn = new JLabel("Cidade:");
        lblCidadeForn.setHorizontalAlignment(SwingConstants.CENTER);
        lblCidadeForn.setForeground(new Color(47, 79, 79));
        lblCidadeForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblCidadeForn.setBackground(Color.BLACK);
        lblCidadeForn.setBounds(146, 337, 117, 39);
        add(lblCidadeForn);
        
        textCidForn = new JTextField();
        textCidForn.setHorizontalAlignment(SwingConstants.LEFT);
        textCidForn.setForeground(Color.BLACK);
        textCidForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textCidForn.setColumns(10);
        textCidForn.setBackground(Color.WHITE);
        textCidForn.setBounds(253, 337, 202, 39);
        add(textCidForn);
        
        JLabel lblCodForn = new JLabel("Código:");
        lblCodForn.setHorizontalAlignment(SwingConstants.CENTER);
        lblCodForn.setForeground(new Color(47, 79, 79));
        lblCodForn.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblCodForn.setBackground(Color.BLACK);
        lblCodForn.setBounds(133, 88, 145, 39);
        add(lblCodForn);
        
        textCodForn = new JTextField();
        textCodForn.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    int idForn = Integer.parseInt(textCodForn.getText());
                    Connection conexao = null;
                    FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
                    Fornecedor fornecedor = fornecedorDAO.read(idForn);

                    if (fornecedor != null) {
                        textNomeForn.setText(fornecedor.getNomeFornecedor());
                        textTelForn.setText(fornecedor.getTelefone());
                        textEndForn.setText(fornecedor.getEndereco());
                        textCidForn.setText(fornecedor.getCidade());
                        textEstadoForn.setText(fornecedor.getEstado());
                        textMailForn.setText(fornecedor.getEmailForn());
                    } else {
                        JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        textCodForn.setHorizontalAlignment(SwingConstants.LEFT);
        textCodForn.setForeground(Color.BLACK);
        textCodForn.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textCodForn.setColumns(10);
        textCodForn.setBackground(Color.WHITE);
        textCodForn.setBounds(253, 88, 402, 39);
        add(textCodForn);
    }

    /**
     * Preenche os campos de entrada com as informações do fornecedor fornecidas.
     * 
     * @param idForn     o ID do fornecedor
     * @param nomeForn   o nome do fornecedor
     * @param telefone   o telefone do fornecedor
     * @param endereco   o endereço do fornecedor
     * @param emailForn  o email do fornecedor
     * @param cidade     a cidade do fornecedor
     * @param estado     o estado do fornecedor
     */
    public void preencherCampos(String idForn, String nomeForn, String telefone, String endereco, String emailForn, String cidade, String estado) {
        textCodForn.setText(idForn);
        textNomeForn.setText(nomeForn);
        textTelForn.setText(telefone);
        textEndForn.setText(endereco);
        textCidForn.setText(cidade);
        textEstadoForn.setText(estado);
        textMailForn.setText(emailForn);
    }
}
