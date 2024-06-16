package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;

import Model.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import DAO.ReceitaDAO;
import Model.Receita;

public class TelaAtualizarRec extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textDescRec;
    private JTextField textDtRecebRec;
    private JTextField textVlrRec;
    private JTextField textCodRec;

    public TelaAtualizarRec(Connection conexao, Usuario usuario) {
        setBackground(new Color(245, 245, 245));
        setLayout(null);
        
        JLabel lblAtualizarDadosDe = new JLabel("Atualizar Dados de Receitas");
        lblAtualizarDadosDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblAtualizarDadosDe.setForeground(new Color(47, 79, 79));
        lblAtualizarDadosDe.setFont(new Font("OCR A Extended", Font.BOLD, 40));
        lblAtualizarDadosDe.setBounds(53, 29, 706, 55);
        add(lblAtualizarDadosDe);
        
        JLabel lblNewLabel = new JLabel("Descrição: ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(47, 79, 79));
        lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblNewLabel.setBounds(178, 161, 144, 47);
        add(lblNewLabel);
        
        JLabel lblDataDoRecebimento = new JLabel("Data do Recebimento:");
        lblDataDoRecebimento.setHorizontalAlignment(SwingConstants.CENTER);
        lblDataDoRecebimento.setForeground(new Color(47, 79, 79));
        lblDataDoRecebimento.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblDataDoRecebimento.setBounds(52, 225, 262, 40);
        add(lblDataDoRecebimento);
        
        JLabel lblValorRecebido = new JLabel("Valor Recebido: ");
        lblValorRecebido.setHorizontalAlignment(SwingConstants.CENTER);
        lblValorRecebido.setForeground(new Color(47, 79, 79));
        lblValorRecebido.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblValorRecebido.setBounds(81, 275, 279, 47);
        add(lblValorRecebido);
        
        textDescRec = new JTextField();
        textDescRec.setHorizontalAlignment(SwingConstants.LEFT);
        textDescRec.setForeground(new Color(0, 0, 0));
        textDescRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textDescRec.setColumns(10);
        textDescRec.setBackground(Color.WHITE);
        textDescRec.setBounds(317, 165, 402, 39);
        add(textDescRec);
        
        textDtRecebRec = new JTextField();
        textDtRecebRec.setHorizontalAlignment(SwingConstants.LEFT);
        textDtRecebRec.setForeground(new Color(0, 0, 0));
        textDtRecebRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textDtRecebRec.setColumns(10);
        textDtRecebRec.setBackground(Color.WHITE);
        textDtRecebRec.setBounds(317, 223, 402, 39);
        add(textDtRecebRec);
        
        textVlrRec = new JTextField();
        textVlrRec.setHorizontalAlignment(SwingConstants.LEFT);
        textVlrRec.setForeground(new Color(0, 0, 0));
        textVlrRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textVlrRec.setColumns(10);
        textVlrRec.setBackground(Color.WHITE);
        textVlrRec.setBounds(317, 279, 402, 39);
        add(textVlrRec);
        
        JButton btnAtualizar = new JButton("Salvar");
        btnAtualizar.setForeground(new Color(47, 79, 79));
        btnAtualizar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnAtualizar.setBackground(new Color(245, 245, 245));
        btnAtualizar.setBounds(412, 350, 117, 31);
        add(btnAtualizar);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setForeground(new Color(47, 79, 79));
        btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnVoltar.setBackground(new Color(245, 245, 245));
        btnVoltar.setBounds(242, 350, 117, 31);
        add(btnVoltar);
        
        JLabel lblCodRec = new JLabel("Código:");
        lblCodRec.setHorizontalAlignment(SwingConstants.CENTER);
        lblCodRec.setForeground(new Color(47, 79, 79));
        lblCodRec.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        lblCodRec.setBounds(191, 104, 144, 47);
        add(lblCodRec);
        
        textCodRec = new JTextField();
        textCodRec.setHorizontalAlignment(SwingConstants.LEFT);
        textCodRec.setForeground(new Color(0, 0, 0));
        textCodRec.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        textCodRec.setColumns(10);
        textCodRec.setBackground(Color.WHITE);
        textCodRec.setBounds(317, 108, 402, 39);
        add(textCodRec);

        // Criando uma instância de ReceitaDAO
        ReceitaDAO receitaDAO = new ReceitaDAO(conexao);

        // Adicionando FocusListener ao campo de código
        textCodRec.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                String codigo = textCodRec.getText();
                if (!codigo.isEmpty()) {
                    try {
                        int id = Integer.parseInt(codigo);
                        Receita receita = receitaDAO.read(id);
                        if (receita != null) {
                            textDescRec.setText(receita.getDescReceita());
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            textDtRecebRec.setText(sdf.format(receita.getDataRecebimento()));
                            textVlrRec.setText(receita.getValorRecebido().toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Receita não encontrada!");
                            textDescRec.setText("");
                            textDtRecebRec.setText("");
                            textVlrRec.setText("");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Código inválido!");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao buscar receita: " + ex.getMessage());
                    }
                }
            }

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
        });

        // Definindo o ActionListener para o botão "Salvar"
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textCodRec.getText());
                    String descricao = textDescRec.getText();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date date = sdf.parse(textDtRecebRec.getText());
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    BigDecimal valorRecebido = new BigDecimal(textVlrRec.getText());

                    // Criar uma instância de Receita com os valores obtidos
                    Receita receita = new Receita();
                    receita.setIdReceita(id);
                    receita.setDescReceita(descricao);
                    receita.setDataRecebimento(sqlDate);
                    receita.setValorRecebido(valorRecebido);

                    // Atualizar a receita no banco de dados
                    if (receitaDAO.update(receita)) {
                        JOptionPane.showMessageDialog(null, "Receita atualizada com sucesso!");
                        // Limpar os campos após a atualização
                        textCodRec.setText("");
                        textDescRec.setText("");
                        textDtRecebRec.setText("");
                        textVlrRec.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar receita!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido para o campo 'Valor Recebido'.");
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar receita: " + ex.getMessage());
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JFrame parentFrame = (JFrame) TelaAtualizarRec.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();  // Isso fechará o JFrame
                }
            }
        });
    }
    
    public void preencherCampos(String id, String descricao, String dataRecebimento, String valorRecebido) {
        textCodRec.setText(id);
        textDescRec.setText(descricao);
        textDtRecebRec.setText(dataRecebimento);
        textVlrRec.setText(valorRecebido);
    }
}
