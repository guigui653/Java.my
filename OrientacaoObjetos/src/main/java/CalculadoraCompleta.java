import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalculadoraCompleta {

    static class CalculadoraLogica {
        private double numeroAnterior = 0;
        private double numeroAtual = 0;
        private String operacaoSelecionada = "";
        private boolean novoNumero = true;

        public void adicionarDigito(String digito) {
            if (novoNumero) {
                numeroAtual = Double.parseDouble(digito);
                novoNumero = false;
            } else {
                numeroAtual = numeroAtual * 10 + Double.parseDouble(digito);
            }
        }

        public void selecionarOperacao(String operacao) {
            if (!operacaoSelecionada.isEmpty()) {
                calcular();
            }
            numeroAnterior = numeroAtual;
            operacaoSelecionada = operacao;
            novoNumero = true;
        }

        public double calcular() {
            double resultado = 0;

            switch (operacaoSelecionada) {
                case "+": resultado = numeroAnterior + numeroAtual; break;
                case "-": resultado = numeroAnterior - numeroAtual; break;
                case "*": resultado = numeroAnterior * numeroAtual; break;
                case "/":
                    if (numeroAtual != 0) resultado = numeroAnterior / numeroAtual;
                    else return Double.NaN;
                    break;
                default: resultado = numeroAtual;
            }

            numeroAtual = resultado;
            operacaoSelecionada = "";
            novoNumero = true;
            return resultado;
        }

        public void limpar() {
            numeroAnterior = 0;
            numeroAtual = 0;
            operacaoSelecionada = "";
            novoNumero = true;
        }

        public double getNumeroAtual() {
            return numeroAtual;
        }
    }

    static class CalculadoraGUI extends JFrame {
        private CalculadoraLogica logica;
        private JTextField visor;
        private JButton[] botoesNumeros;
        private JButton botaoSoma, botaoSubtracao, botaoMultiplicacao, botaoDivisao;
        private JButton botaoIgual, botaoLimpar;

        // --- PALETA DE CORES MODERNA (DARK MODE) ---
        private final Color COR_FUNDO = new Color(32, 32, 32);
        private final Color COR_VISOR = new Color(40, 40, 40);
        private final Color COR_BOTAO_NUMERO = new Color(60, 60, 60);
        private final Color COR_BOTAO_OPERACAO = new Color(255, 149, 0); // Laranja estilo iOS
        private final Color COR_BOTAO_LIMPAR = new Color(212, 53, 53);   // Vermelho suave

        public CalculadoraGUI() {
            logica = new CalculadoraLogica();

            setTitle("Calculadora Premium");
            setSize(350, 500); // Deixei um pouco mais fina, estilo celular
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            getContentPane().setBackground(COR_FUNDO); // Fundo da janela

            criarVisor();
            criarBotoes();

            setVisible(true);
        }

        private void criarVisor() {
            visor = new JTextField();
            visor.setFont(new Font("Segoe UI", Font.BOLD, 48)); // Fonte maior e mais limpa
            visor.setEditable(false);
            visor.setText("0");
            visor.setHorizontalAlignment(JTextField.RIGHT);
            visor.setPreferredSize(new Dimension(350, 90));

            // Estilizando o visor para ficar invisível e integrado ao fundo
            visor.setBackground(COR_VISOR);
            visor.setForeground(Color.WHITE);
            visor.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Margem interna
            visor.setCaretColor(COR_VISOR); // Esconde o cursor piscante

            add(visor, BorderLayout.NORTH);
        }

        private void criarBotoes() {
            JPanel painelBotoes = new JPanel();
            painelBotoes.setLayout(new GridLayout(5, 4, 8, 8)); // Espaçamento maior entre botões
            painelBotoes.setBackground(COR_FUNDO);
            painelBotoes.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            botoesNumeros = new JButton[10];
            for (int i = 0; i < 10; i++) {
                final int numero = i;
                botoesNumeros[i] = criarBotao(String.valueOf(numero), COR_BOTAO_NUMERO);
                botoesNumeros[i].addActionListener(e -> aoClicarNumero(String.valueOf(numero)));
            }

            botaoSoma = criarBotao("+", COR_BOTAO_OPERACAO);
            botaoSoma.addActionListener(e -> aoClicarOperacao("+"));

            botaoSubtracao = criarBotao("-", COR_BOTAO_OPERACAO);
            botaoSubtracao.addActionListener(e -> aoClicarOperacao("-"));

            botaoMultiplicacao = criarBotao("×", COR_BOTAO_OPERACAO); // Usando símbolo de Multiplicação bonito
            botaoMultiplicacao.addActionListener(e -> aoClicarOperacao("*"));

            botaoDivisao = criarBotao("÷", COR_BOTAO_OPERACAO); // Usando símbolo de Divisão bonito
            botaoDivisao.addActionListener(e -> aoClicarOperacao("/"));

            botaoIgual = criarBotao("=", COR_BOTAO_OPERACAO);
            botaoIgual.addActionListener(e -> aoClicarIgual());

            botaoLimpar = criarBotao("C", COR_BOTAO_LIMPAR);
            botaoLimpar.addActionListener(e -> aoClicarLimpar());

            // Linha 1
            painelBotoes.add(botaoLimpar);
            painelBotoes.add(criarBotaoVazio());
            painelBotoes.add(criarBotaoVazio());
            painelBotoes.add(botaoDivisao);

            // Linha 2
            painelBotoes.add(botoesNumeros[7]);
            painelBotoes.add(botoesNumeros[8]);
            painelBotoes.add(botoesNumeros[9]);
            painelBotoes.add(botaoMultiplicacao);

            // Linha 3
            painelBotoes.add(botoesNumeros[4]);
            painelBotoes.add(botoesNumeros[5]);
            painelBotoes.add(botoesNumeros[6]);
            painelBotoes.add(botaoSubtracao);

            // Linha 4
            painelBotoes.add(botoesNumeros[1]);
            painelBotoes.add(botoesNumeros[2]);
            painelBotoes.add(botoesNumeros[3]);
            painelBotoes.add(botaoSoma);

            // Linha 5
            painelBotoes.add(criarBotaoVazio());
            painelBotoes.add(botoesNumeros[0]);
            painelBotoes.add(criarBotaoVazio());
            painelBotoes.add(botaoIgual);

            add(painelBotoes, BorderLayout.CENTER);
        }

        // Método atualizado que aplica o design Flat e o efeito visual do mouse
        private JButton criarBotao(String texto, Color corFundoBotao) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Segoe UI", Font.BOLD, 26)); // Fonte moderna
            botao.setBackground(corFundoBotao);
            botao.setForeground(Color.WHITE);

            // Tira os efeitos nativos feios do Java Swing
            botao.setFocusPainted(false);
            botao.setBorderPainted(false);
            botao.setOpaque(true);

            // Efeito Hover: O botão fica levemente mais claro quando o mouse passa por cima
            botao.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    botao.setBackground(corFundoBotao.brighter());
                }
                public void mouseExited(MouseEvent evt) {
                    botao.setBackground(corFundoBotao);
                }
            });

            return botao;
        }

        // Método para criar os espaços vazios sem parecer um botão quebrado
        private JButton criarBotaoVazio() {
            JButton botao = new JButton();
            botao.setBackground(COR_FUNDO); // Mesma cor do fundo da tela
            botao.setBorderPainted(false);
            botao.setEnabled(false); // Não clica
            return botao;
        }

        private void aoClicarNumero(String numero) {
            logica.adicionarDigito(numero);
            atualizarVisor();
        }

        private void aoClicarOperacao(String operacao) {
            logica.selecionarOperacao(operacao);
            atualizarVisor();
        }

        private void aoClicarIgual() {
            logica.calcular();
            atualizarVisor();
        }

        private void aoClicarLimpar() {
            logica.limpar();
            atualizarVisor();
        }

        private void atualizarVisor() {
            double numero = logica.getNumeroAtual();

            if (numero == (long) numero) {
                visor.setText(String.valueOf((long) numero));
            } else {
                visor.setText(String.valueOf(numero));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraGUI());
    }
}