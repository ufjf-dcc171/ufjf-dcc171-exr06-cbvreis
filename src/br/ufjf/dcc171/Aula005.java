package br.ufjf.dcc171;

import java.util.Random;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class JanelaRadio extends JFrame {

    private final JLabel mensagem = new JLabel("Escolha uma das opções para jogar: ");
    private final JRadioButton pedra;
    private final JRadioButton papel;
    private final JRadioButton tesoura;
    private final ButtonGroup bgEstilo;
    private final JButton buttonResultado;
    private final JLabel jbResultado;
    private int palpiteJogador, palpiteComputador;
    private int placarComputador = 0;
    private int placarJogador = 0;
    private final JLabel jbPlacar = new JLabel("Jogador : " + placarJogador
            + " X " + placarComputador
            + " Computador");

    public JanelaRadio() throws HeadlessException {
        super("Pedra Papel ou Tesoura");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        pedra = new JRadioButton("Pedra", true);
        papel = new JRadioButton("Papel", false);
        tesoura = new JRadioButton("Tesoura", false);
        buttonResultado = new JButton("Gerar Resultado");
        jbResultado = new JLabel();
        add(mensagem);
        add(pedra);
        add(papel);
        add(tesoura);
        add(buttonResultado);
        add(jbResultado);
        add(jbPlacar);
        jbResultado.setVisible(false);
        bgEstilo = new ButtonGroup();
        bgEstilo.add(tesoura);
        bgEstilo.add(pedra);
        bgEstilo.add(papel);

        buttonResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                geraPalpiteComputador();
                geraPalpiteJogador();
                gameControle();
                finalDeJogo();

            }

            private void finalDeJogo() {
                if (placarComputador > 3) {
                    jbResultado.setText("Você perdeu");
                    jbResultado.setVisible(true);
                    buttonResultado.setVisible(false);
                } else if (placarJogador > 3) {
                    jbResultado.setText("Final de jogo, você ganhou");
                    jbResultado.setVisible(true);
                    buttonResultado.setVisible(false);
                }
            }

            private void limpaCache() {
                palpiteComputador = 4;
                palpiteJogador = 4;
            }

            private void gameControle() {
                if (palpiteComputador == 0 && palpiteJogador == 2) {
                    jbResultado.setVisible(true);
                    placarComputador++;
                    jbPlacar.setText("Jogador : " + placarJogador + " X " + placarComputador + " Computador");
                } else if (palpiteComputador == 1 && palpiteJogador == 0) {
                    jbResultado.setVisible(true);
                    placarComputador++;
                    jbPlacar.setText("Jogador : " + placarJogador + " X " + placarComputador + " Computador");
                } else if (palpiteComputador == 2 && palpiteJogador == 1) {
                    jbResultado.setVisible(true);
                    placarComputador++;
                    jbPlacar.setText("Jogador : " + placarJogador + " X " + placarComputador + " Computador");
                } else if (palpiteComputador == 1 && palpiteJogador == 2) {
                    jbResultado.setVisible(true);
                    placarJogador++;
                    jbPlacar.setText("Jogador : " + placarJogador + " X " + placarComputador + " Computador");
                } else if (palpiteComputador == 2 && palpiteJogador == 0) {

                    jbResultado.setVisible(true);
                    placarJogador++;
                    jbPlacar.setText("Jogador : " + placarJogador + " X " + placarComputador + " Computador");
                } else if (palpiteComputador == 0 && palpiteJogador == 1) {
                    jbResultado.setVisible(true);
                    placarJogador++;
                    jbPlacar.setText("Jogador : " + placarJogador + " X " + placarComputador + " Computador");
                } else {
                    jbResultado.setText("Empatou ");
                    jbResultado.setVisible(true);
                    jbPlacar.setText("Jogador : " + placarJogador + " X " + placarComputador + " Computador");
                }

            }

            private void geraPalpiteComputador() {
                int result;

                Random gerador = new Random();
                result = gerador.nextInt(3);
                switch (result) {
                    case 0:
                        palpiteComputador = 0;  //PEDRA
                        break;
                    case 1:
                        palpiteComputador = 1; //PAPEL
                        break;
                    default:
                        palpiteComputador = 2;   //TESOURA
                        break;
                }

            }

            private void geraPalpiteJogador() {
                if (pedra.isSelected()) {
                    palpiteJogador = 0; //PEDRA
                } else if (papel.isSelected()) {
                    palpiteJogador = 1; //PAPEL
                } else {

                    palpiteJogador = 2; //TESORA

                }
            }
        }
        );
    }
}
