import javax.swing.*;
import java.awt.*;

public class SWING extends JFrame {
    private JTextField txtMarca, txtModelo, txtPreco, txtArmazenamento;
    private JLabel lblBateria, lblInfo;
    private JProgressBar progressBateria;
    private JButton btnCriar, btnUsar, btnCarregar, btnDesconto;

    private Celular celular;

    public SWING() {

        setTitle("Sistema de Gerenciamento de Celular");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela
        setLayout(new BorderLayout(10, 10));


        JPanel painelCadastro = criarPainelCadastro();
        add(painelCadastro, BorderLayout.NORTH);


        JPanel painelInfo = criarPainelInfo();
        add(painelInfo, BorderLayout.CENTER);


        JPanel painelAcoes = criarPainelAcoes();
        add(painelAcoes, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel criarPainelCadastro() {
        JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));
        painel.setBorder(BorderFactory.createTitledBorder("Cadastrar Celular"));


        painel.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        painel.add(txtMarca);

        painel.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        painel.add(txtModelo);

        painel.add(new JLabel("Preço (R$):"));
        txtPreco = new JTextField();
        painel.add(txtPreco);

        painel.add(new JLabel("Armazenamento (GB):"));
        txtArmazenamento = new JTextField();
        painel.add(txtArmazenamento);


        btnCriar = new JButton("Criar Celular");
        btnCriar.setBackground(new Color(76, 175, 80));
        btnCriar.setForeground(Color.WHITE);
        btnCriar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCriar.addActionListener(e -> criarCelular());
        painel.add(new JLabel());
        painel.add(btnCriar);

        return painel;
    }

    private JPanel criarPainelInfo() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createTitledBorder("Informações do Celular"));


        lblInfo = new JLabel("<html>Nenhum celular cadastrado ainda.<br>Preencha os campos acima.</html>");
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblInfo.setVerticalAlignment(SwingConstants.TOP);
        painel.add(lblInfo, BorderLayout.CENTER);


        JPanel painelBateria = new JPanel(new BorderLayout(5, 5));
        lblBateria = new JLabel("Bateria: 0%");
        lblBateria.setFont(new Font("Arial", Font.BOLD, 12));
        progressBateria = new JProgressBar(0, 100);
        progressBateria.setValue(0);
        progressBateria.setStringPainted(true);
        progressBateria.setForeground(new Color(76, 175, 80));

        painelBateria.add(lblBateria, BorderLayout.NORTH);
        painelBateria.add(progressBateria, BorderLayout.CENTER);
        painel.add(painelBateria, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarPainelAcoes() {
        JPanel painel = new JPanel(new GridLayout(1, 3, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        btnUsar = new JButton("Usar (30 min)");
        btnUsar.setEnabled(false);
        btnUsar.addActionListener(e -> usarCelular());
        painel.add(btnUsar);


        btnCarregar = new JButton("Carregar (20%)");
        btnCarregar.setEnabled(false);
        btnCarregar.addActionListener(e -> carregarCelular());
        painel.add(btnCarregar);


        btnDesconto = new JButton("Desconto (10%)");
        btnDesconto.setEnabled(false);
        btnDesconto.addActionListener(e -> aplicarDesconto());
        painel.add(btnDesconto);

        return painel;
    }

    private void criarCelular() {
        try {
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            int armazenamento = Integer.parseInt(txtArmazenamento.getText());

            celular = new Celular(marca, modelo, preco, armazenamento, 100);

            atualizarInterface();

            // Habilita os botões
            btnUsar.setEnabled(true);
            btnCarregar.setEnabled(true);
            btnDesconto.setEnabled(true);

            JOptionPane.showMessageDialog(this,
                    "Celular criado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, preencha todos os campos corretamente!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void usarCelular() {
        if (celular != null) {
            int novaBateria = celular.getBateria() - 10;
            if (novaBateria < 0) novaBateria = 0;
            celular.setBateria(novaBateria);
            atualizarInterface();
            JOptionPane.showMessageDialog(this,
                    "Celular usado por 30 minutos!\nBateria: " + celular.getBateria() + "%");
        }
    }

    private void carregarCelular() {
        if (celular != null) {
            int novaBateria = celular.getBateria() + 20;
            if (novaBateria > 100) novaBateria = 100;
            celular.setBateria(novaBateria);

            atualizarInterface();
            JOptionPane.showMessageDialog(this,
                    "Celular carregado em 20%!\nBateria: " + celular.getBateria() + "%");
        }
    }

    private void aplicarDesconto() {
        if (celular != null) {
            double novoPreco = celular.getPreco() * 0.9;
            celular.setPreco(novoPreco);
            atualizarInterface();
            JOptionPane.showMessageDialog(this,
                    "Desconto de 10% aplicado!\nNovo preço: R$ " + String.format("%.2f", celular.getPreco()));
        }
    }

    private void atualizarInterface() {
        if (celular != null) {
            String info = "<html><b>Marca:</b> " + celular.getMarca() + "<br>" +
                    "<b>Modelo:</b> " + celular.getModelo() + "<br>" +
                    "<b>Preço:</b> R$ " + String.format("%.2f", celular.getPreco()) + "<br>" +
                    "<b>Armazenamento:</b> " + celular.getArmazenamento() + " GB</html>";
            lblInfo.setText(info);

            int bateria = celular.getBateria();
            lblBateria.setText("Bateria: " + bateria + "%");
            progressBateria.setValue(bateria);


            if (bateria > 50) {
                progressBateria.setForeground(new Color(76, 175, 80)); // Verde
            } else if (bateria > 20) {
                progressBateria.setForeground(new Color(255, 193, 7)); // Amarelo
            } else {
                progressBateria.setForeground(new Color(244, 67, 54)); // Vermelho
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SWING());
    }
}
