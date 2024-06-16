package View;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.element.Image;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaVisualizarRelat extends JPanel {

    private Connection conexao;
    private JSpinner startDateSpinner;
    private JSpinner endDateSpinner;
    private JPanel filterPanel;
    private JButton printButton;
    private JButton btnVoltar;

    public TelaVisualizarRelat() {
        setLayout(new BorderLayout());
        createFilterPanel();
        conexao = conectar();
    }

    private void createFilterPanel() {
        JLabel startDateLabel = new JLabel("Data Inicial:");
        startDateLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 10));
        startDateSpinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor startDateEditor = new JSpinner.DateEditor(startDateSpinner, "dd/MM/yyyy");
        startDateSpinner.setEditor(startDateEditor);
        startDateSpinner.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        startDateSpinner.setBackground(new java.awt.Color(255, 255, 255));
        startDateSpinner.setForeground(java.awt.Color.BLACK);

        JLabel endDateLabel = new JLabel("Data Final:");
        endDateLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 10));
        endDateSpinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor endDateEditor = new JSpinner.DateEditor(endDateSpinner, "dd/MM/yyyy");
        endDateSpinner.setEditor(endDateEditor);
        endDateSpinner.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        endDateSpinner.setBackground(new java.awt.Color(255, 255, 255));
        endDateSpinner.setForeground(java.awt.Color.BLACK);

        JButton filterButton = new JButton("Filtrar");
        filterButton.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        filterButton.setBackground(new java.awt.Color(255, 255, 255));
        filterButton.setForeground(java.awt.Color.BLACK);
        filterButton.addActionListener(e -> gerarGrafico());

        printButton = new JButton("Imprimir");
        printButton.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        printButton.setBackground(new java.awt.Color(255, 255, 255));
        printButton.setForeground(java.awt.Color.BLACK);
        printButton.addActionListener(e -> gerarRelatorioPDF());

        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        btnVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltar.setForeground(java.awt.Color.BLACK);
        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	JFrame parentFrame = (JFrame) TelaVisualizarRelat.this.getTopLevelAncestor();
                if (parentFrame != null) {
                    parentFrame.dispose();
                }
            }
        });

        filterPanel = new JPanel();
        filterPanel.add(startDateLabel);
        filterPanel.add(startDateSpinner);
        filterPanel.add(endDateLabel);
        filterPanel.add(endDateSpinner);
        filterPanel.add(filterButton);
        filterPanel.add(printButton);
        filterPanel.add(btnVoltar);
        add(filterPanel, BorderLayout.NORTH);
    }

    private Connection conectar() {
        Connection conexao = null;
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=CASHTAB;encrypt=false";
            String usuario = "sa";
            String senha = "pi";
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }

    private BigDecimal somarDespesasPorDia(Date dia) throws SQLException {
        BigDecimal totalDespesas = BigDecimal.ZERO;

        String queryDespesas = "SELECT ValorPago FROM Despesa WHERE DataFaturamento = ?";
        try (PreparedStatement psDespesas = conexao.prepareStatement(queryDespesas)) {
            psDespesas.setDate(1, new java.sql.Date(dia.getTime()));
            try (ResultSet rsDespesas = psDespesas.executeQuery()) {
                while (rsDespesas.next()) {
                    String valorPagoStr = rsDespesas.getString("ValorPago").replace(",", ".");
                    try {
                        BigDecimal valorDespesa = new BigDecimal(valorPagoStr);
                        totalDespesas = totalDespesas.add(valorDespesa);
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter valor de despesa: " + valorPagoStr);
                    }
                }
            }
        }
        return totalDespesas;
    }

    private BigDecimal somarReceitasPorDia(Date dia) throws SQLException {
        BigDecimal totalReceitas = BigDecimal.ZERO;

        String queryReceitas = "SELECT ValorRecebido FROM Receita WHERE DataRecebimento = ?";
        try (PreparedStatement psReceitas = conexao.prepareStatement(queryReceitas)) {
            psReceitas.setDate(1, new java.sql.Date(dia.getTime()));
            try (ResultSet rsReceitas = psReceitas.executeQuery()) {
                while (rsReceitas.next()) {
                    String valorRecebidoStr = rsReceitas.getString("ValorRecebido").replace(",", ".");
                    try {
                        BigDecimal valorReceita = new BigDecimal(valorRecebidoStr);
                        totalReceitas = totalReceitas.add(valorReceita);
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter valor de receita: " + valorRecebidoStr);
                    }
                }
            }
        }
        return totalReceitas;
    }

    private List<String> listarDespesasReceitas(Date startDate, Date endDate) throws SQLException {
        List<String> despesasReceitas = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Despesas
        String queryDespesas = "SELECT ValorPago, DescDespesa, DataFaturamento FROM Despesa WHERE DataFaturamento BETWEEN ? AND ?";
        try (PreparedStatement psDespesas = conexao.prepareStatement(queryDespesas)) {
            psDespesas.setDate(1, new java.sql.Date(startDate.getTime()));
            psDespesas.setDate(2, new java.sql.Date(endDate.getTime()));
            try (ResultSet rsDespesas = psDespesas.executeQuery()) {
                while (rsDespesas.next()) {
                    String valorPago = rsDespesas.getString("ValorPago").replace(",", ".");
                    try {
                        BigDecimal valorDespesa = new BigDecimal(valorPago);
                        String descDespesa = rsDespesas.getString("DescDespesa");
                        String dataFaturamento = dateFormat.format(rsDespesas.getDate("DataFaturamento"));
                        despesasReceitas.add("Despesa: " + descDespesa + " | Valor: " + valorPago + " | Data: " + dataFaturamento);
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter valor de despesa: " + valorPago);
                    }
                }
            }
        }

        // Receitas
        String queryReceitas = "SELECT ValorRecebido, DescReceita, DataRecebimento FROM Receita WHERE DataRecebimento BETWEEN ? AND ?";
        try (PreparedStatement psReceitas = conexao.prepareStatement(queryReceitas)) {
            psReceitas.setDate(1, new java.sql.Date(startDate.getTime()));
            psReceitas.setDate(2, new java.sql.Date(endDate.getTime()));
            try (ResultSet rsReceitas = psReceitas.executeQuery()) {
                while (rsReceitas.next()) {
                    String valorRecebido = rsReceitas.getString("ValorRecebido").replace(",", ".");
                    try {
                        BigDecimal valorReceita = new BigDecimal(valorRecebido);
                        String descReceita = rsReceitas.getString("DescReceita");
                        String dataRecebimento = dateFormat.format(rsReceitas.getDate("DataRecebimento"));
                        despesasReceitas.add("Receita: " + descReceita + " | Valor: " + valorRecebido + " | Data: " + dataRecebimento);
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter valor de receita: " + valorRecebido);
                    }
                }
            }
        }

        return despesasReceitas;
    }

    private void gerarRelatorioPDF() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateString = dateFormat.format(startDateSpinner.getValue());
        String endDateString = dateFormat.format(endDateSpinner.getValue());

        if (!startDateString.isEmpty() && !endDateString.isEmpty()) {
            try {
                Date startDate = dateFormat.parse(startDateString);
                Date endDate = dateFormat.parse(endDateString);
                List<String> despesasReceitas = listarDespesasReceitas(startDate, endDate);

                BigDecimal totalReceitas = BigDecimal.ZERO;
                BigDecimal totalDespesas = BigDecimal.ZERO;
                BigDecimal mediaDiariaReceitas = BigDecimal.ZERO;
                BigDecimal mediaDiariaDespesas = BigDecimal.ZERO;

                PdfWriter writer = new PdfWriter("relatorio.pdf");
                PdfDocument pdfDoc = new PdfDocument(writer);
                Document document = new Document(pdfDoc);

                // Caminho absoluto para o logotipo
                String caminhoLogo = "C:/Users/Dellis/eclipse-workspace/CASHTAB/logo.png";
                ImageData imageData = ImageDataFactory.create(caminhoLogo);
                Image image = new Image(imageData);
                image.setWidth(50);
                image.setHeight(50);
                document.add(image);

                SimpleDateFormat displayFormat = new SimpleDateFormat("dd/MM/yyyy");
                document.add(new Paragraph("Relatório de Despesas e Receitas"));
                document.add(new Paragraph("Período: " + displayFormat.format(startDate) + " a " + displayFormat.format(endDate)));
                document.add(new Paragraph(" "));

                int totalDias = 0;
                Color red = new DeviceRgb(255, 0, 0);
                Color green = new DeviceRgb(0, 255, 0);

                for (String item : despesasReceitas) {
                    Text text = new Text(item);
                    if (item.startsWith("Despesa:")) {
                        text.setFontColor(red);
                        String valor = item.split(" \\| Valor: ")[1].split(" \\| Data: ")[0];
                        valor = valor.replace(",", ".");
                        try {
                            BigDecimal valorDespesa = new BigDecimal(valor);
                            totalDespesas = totalDespesas.add(valorDespesa);
                        } catch (NumberFormatException e) {
                            System.err.println("Erro ao converter valor de despesa: " + valor);
                        }
                    } else if (item.startsWith("Receita:")) {
                        text.setFontColor(green);
                        String valor = item.split(" \\| Valor: ")[1].split(" \\| Data: ")[0];
                        valor = valor.replace(",", ".");
                        try {
                            BigDecimal valorReceita = new BigDecimal(valor);
                            totalReceitas = totalReceitas.add(valorReceita);
                        } catch (NumberFormatException e) {
                            System.err.println("Erro ao converter valor de receita: " + valor);
                        }
                    }
                    document.add(new Paragraph(text));
                    totalDias++;
                }

                if (totalDias > 0) {
                    mediaDiariaReceitas = totalReceitas.divide(BigDecimal.valueOf(totalDias), BigDecimal.ROUND_HALF_UP);
                    mediaDiariaDespesas = totalDespesas.divide(BigDecimal.valueOf(totalDias), BigDecimal.ROUND_HALF_UP);
                }

                BigDecimal saldo = totalReceitas.subtract(totalDespesas);

                document.add(new Paragraph(" "));
                document.add(new Paragraph("Resumo do Período:"));
                document.add(new Paragraph("Total de Receitas: " + totalReceitas));
                document.add(new Paragraph("Total de Despesas: " + totalDespesas));
                document.add(new Paragraph("Saldo: " + saldo));
                document.add(new Paragraph("Média Diária de Receitas: " + mediaDiariaReceitas));
                document.add(new Paragraph("Média Diária de Despesas: " + mediaDiariaDespesas));

                String observacao = saldo.compareTo(BigDecimal.ZERO) >= 0 ? "O período resultou em lucro." : "O período resultou em prejuízo.";
                document.add(new Paragraph("Observação: " + observacao));

                document.close();
                JOptionPane.showMessageDialog(this, "Relatório PDF gerado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao gerar relatório PDF.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, insira ambas as datas de início e fim.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void gerarGrafico() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateString = dateFormat.format(startDateSpinner.getValue());
        String endDateString = dateFormat.format(endDateSpinner.getValue());

        if (!startDateString.isEmpty() && !endDateString.isEmpty()) {
            try {
                Date startDate = dateFormat.parse(startDateString);
                Date endDate = dateFormat.parse(endDateString);

                XYDataset dataset = criarDataset(startDate, endDate);
                JFreeChart chart = criarGrafico(dataset);

                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new Dimension(800, 400));
                removeAll(); // Remove todos os componentes anteriores
                add(filterPanel, BorderLayout.NORTH); // Re-adiciona o painel de filtros
                add(chartPanel, BorderLayout.CENTER); // Adiciona o painel do gráfico
                revalidate();
                repaint();

                printButton.setEnabled(true);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao gerar gráfico.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, insira ambas as datas de início e fim.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private XYDataset criarDataset(Date startDate, Date endDate) throws SQLException {
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries seriesReceitas = new TimeSeries("Receitas");
        TimeSeries seriesDespesas = new TimeSeries("Despesas");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        while (!calendar.getTime().after(endDate)) {
            Date dia = calendar.getTime();

            BigDecimal totalDespesas = somarDespesasPorDia(dia);
            BigDecimal totalReceitas = somarReceitasPorDia(dia);

            seriesDespesas.add(new Day(dia), totalDespesas);
            seriesReceitas.add(new Day(dia), totalReceitas);

            calendar.add(Calendar.DATE, 1);
        }

        dataset.addSeries(seriesDespesas);
        dataset.addSeries(seriesReceitas);

        return dataset;
    }

    private JFreeChart criarGrafico(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Despesas e Receitas",
                "Data",
                "Valor",
                dataset,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);

        return chart;
    }
}
