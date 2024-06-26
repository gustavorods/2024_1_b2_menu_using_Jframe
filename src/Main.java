import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {
    // Objetos
    JMenuBar BarraMenu;
    JMenu Operacoes, Menu;
    JMenuItem Soma, Subtracao, Multiplicacao, Divisao, Sair, Sobre, SairPopUp, SobrePopUp;

    JButton BtnSoma, BtnSubtracao, BtnMultiplicacao, BtnDivisao, BtnSair;
    JToolBar BarraFerramentas;

    JPopupMenu MenuPopUp;


    public Main() {
        // Configurações da janela
            super("Main");
            Container tela = getContentPane();
            setLayout(null);
            setSize(500,500);
            setResizable(false);

        // Criando elementos
            // Menu
            Soma = new JMenuItem("Soma");
            Subtracao = new JMenuItem("Subtracao");
            Multiplicacao = new JMenuItem("Multiplicacao");
            Divisao = new JMenuItem("Divisao");
            Sair = new JMenuItem("Sair");
            Sobre = new JMenuItem("Sobre");

            Operacoes = new JMenu("Operacoes");
            Operacoes.add(Soma);
            Operacoes.add(Subtracao);
            Operacoes.add(Multiplicacao);
            Operacoes.add(Divisao);

            Menu = new JMenu("Menu");
            Menu.add(Sair);
            Menu.add(Sobre);

            BarraMenu = new JMenuBar();
            setJMenuBar(BarraMenu);

            BarraMenu.add(Menu);
            Menu.add(Operacoes);

            // Botões
            BtnSoma = new JButton("Soma");
            BtnSubtracao = new JButton("Subtracao");
            BtnMultiplicacao = new JButton("Multiplicacao");
            BtnDivisao = new JButton("Divisao");
            BtnSair = new JButton("Sair");

            // Barra de ferramentas
            BarraFerramentas = new JToolBar();
            BarraFerramentas.add(BtnSoma);
            BarraFerramentas.add(BtnSubtracao);
            BarraFerramentas.add(BtnMultiplicacao);
            BarraFerramentas.add(BtnDivisao);
            BarraFerramentas.add(BtnSair);
            BarraFerramentas.setBounds(20,20,400,30);

            // PopUp
            SairPopUp = new JMenuItem("Sair");
            SobrePopUp = new JMenuItem("Sobre");

            MenuPopUp = new JPopupMenu();
            MenuPopUp.add(SairPopUp);
            MenuPopUp.add(SobrePopUp);
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                    }
                }

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                    }
                }
            });


        // Métodos
            // Método sair
            ActionListener sairAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int status = JOptionPane.showConfirmDialog(null,"Deseja realmente fechar o programa?", "Mensagem de Saida", JOptionPane.YES_NO_OPTION);
                    if(status == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            };
            Sair.addActionListener(sairAction);
            BtnSair.addActionListener(sairAction);
            SairPopUp.addActionListener(sairAction);

            // Abrindo janela Sobre
            ActionListener sobreAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sobre JanelaSobre = new sobre(null,"Janela Sobre",true);
                    JanelaSobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSobre.setVisible(true);
                }
            };
            Sobre.addActionListener(sobreAction);
            SobrePopUp.addActionListener(sobreAction);

            // Abrindo janela Soma
            ActionListener somaAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    soma JanelaSoma = new soma(null,"Janela Soma",true);
                    JanelaSoma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSoma.setVisible(true);
                }
            };
            Soma.addActionListener(somaAction);
            BtnSoma.addActionListener(somaAction);

            // Abrindo janela Subtracao
            ActionListener subAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    subtracao JanelaSub = new subtracao(null,"Janela Subtração",true);
                    JanelaSub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSub.setVisible(true);
                }
            };
            Subtracao.addActionListener(subAction);
            BtnSubtracao.addActionListener(subAction);

            // Abrindo janela Multiplicação
            ActionListener multAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    multiplicacao JanelaMult = new multiplicacao(null,"Janela Multiplicação",true);
                    JanelaMult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaMult.setVisible(true);
                }
            };
            Multiplicacao.addActionListener(multAction);
            BtnMultiplicacao.addActionListener(multAction);

            // Abrindo janela Divisão
            ActionListener diviAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    divisao JanelaDivi = new divisao(null,"Janela Multiplicação",true);
                    JanelaDivi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaDivi.setVisible(true);
                }
            };
            Divisao.addActionListener(diviAction);
            BtnDivisao.addActionListener(diviAction);

        // Adicionando elemento á tela
            tela.add(BarraFerramentas);


        //  Deixando a janela visível
            setVisible(true);
    }

    public static void main (String[] args) {
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class sobre extends JDialog {
        JMenuBar BarraMenu;
        JMenu Operacoes, Menu;
        JMenuItem Soma, Subtracao, Multiplicacao, Divisao, Sair, Sobre, SairPopUp, SobrePopUp;

        JButton BtnSoma, BtnSubtracao, BtnMultiplicacao, BtnDivisao, BtnSair, BtnVoltar;
        JToolBar BarraFerramentas;

        JPopupMenu MenuPopUp;

        JLabel Nome, Data, Sala;

        public sobre(Frame owner, String title,boolean modal) {
            // Configurações da janela
            super(owner,title,modal);
            Container tela = getContentPane();
            setLayout(null);
            setSize(500,500);
            setResizable(false);

            // Criando elementos
                // Menu
                Soma = new JMenuItem("Soma");
                Subtracao = new JMenuItem("Subtracao");
                Multiplicacao = new JMenuItem("Multiplicacao");
                Divisao = new JMenuItem("Divisao");
                Sair = new JMenuItem("Sair");
                Sobre = new JMenuItem("Sobre");

                Operacoes = new JMenu("Operacoes");
                Operacoes.add(Soma);
                Operacoes.add(Subtracao);
                Operacoes.add(Multiplicacao);
                Operacoes.add(Divisao);

                Menu = new JMenu("Menu");
                Menu.add(Sair);
                Menu.add(Sobre);

                BarraMenu = new JMenuBar();
                setJMenuBar(BarraMenu);

                BarraMenu.add(Menu);
                Menu.add(Operacoes);

                // Botões
                BtnSoma = new JButton("Soma");
                BtnSubtracao = new JButton("Subtracao");
                BtnMultiplicacao = new JButton("Multiplicacao");
                BtnDivisao = new JButton("Divisao");
                BtnSair = new JButton("Sair");

                // Barra de ferramentas
                BarraFerramentas = new JToolBar();
                BarraFerramentas.add(BtnSoma);
                BarraFerramentas.add(BtnSubtracao);
                BarraFerramentas.add(BtnMultiplicacao);
                BarraFerramentas.add(BtnDivisao);
                BarraFerramentas.add(BtnSair);
                BarraFerramentas.setBounds(20,20,400,30);

                // PopUp
                SairPopUp = new JMenuItem("Sair");
                SobrePopUp = new JMenuItem("Sobre");

                MenuPopUp = new JPopupMenu();
                MenuPopUp.add(SairPopUp);
                MenuPopUp.add(SobrePopUp);
                addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        if (evt.isPopupTrigger()) {
                            MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                    }

                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        if (evt.isPopupTrigger()) {
                            MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                    }
                });

                // Jlabels
                Nome = new JLabel("GUSTAVO RODRIGUES LEITE DA SILVA");
                Data = new JLabel("27/06/2024");
                Sala = new JLabel("2° ADS - AMS - TARDE");

                // Botões
                BtnVoltar = new JButton("Voltar");


            // Posicionando elementos
                Nome.setBounds(20,60,350,30);
                Data.setBounds(20,90,350,30);
                Sala.setBounds(20,120,350,30);
                BtnVoltar.setBounds(20,160,100,30);


            // Métodos
                // Método sair
                ActionListener sairAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int status = JOptionPane.showConfirmDialog(null,"Deseja realmente fechar o programa?", "Mensagem de Saida", JOptionPane.YES_NO_OPTION);
                        if(status == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                    }
                };
                Sair.addActionListener(sairAction);
                BtnSair.addActionListener(sairAction);
                SairPopUp.addActionListener(sairAction);

                // Abrindo janela Sobre
                ActionListener sobreAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sobre JanelaSobre = new sobre(null,"Segunda Janela",true);
                        JanelaSobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JanelaSobre.setVisible(true);
                    }
                };
                Sobre.addActionListener(sobreAction);
                SobrePopUp.addActionListener(sobreAction);

                // Abrindo janela Soma
                ActionListener somaAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        soma JanelaSoma = new soma(null,"Janela Soma",true);
                        JanelaSoma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JanelaSoma.setVisible(true);
                    }
                };
                Soma.addActionListener(somaAction);
                BtnSoma.addActionListener(somaAction);

                // Abrindo janela Subtracao
                ActionListener subAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        subtracao JanelaSub = new subtracao(null,"Janela Subtração",true);
                        JanelaSub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JanelaSub.setVisible(true);
                    }
                };
                Subtracao.addActionListener(subAction);
                BtnSubtracao.addActionListener(subAction);

                // Abrindo janela Multiplicação
                ActionListener multAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        multiplicacao JanelaMult = new multiplicacao(null,"Janela Multiplicação",true);
                        JanelaMult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JanelaMult.setVisible(true);
                    }
                };
                Multiplicacao.addActionListener(multAction);
                BtnMultiplicacao.addActionListener(multAction);

                // Abrindo janela Divisão
                ActionListener diviAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        divisao JanelaDivi = new divisao(null,"Janela Multiplicação",true);
                        JanelaDivi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JanelaDivi.setVisible(true);
                    }
                };
                Divisao.addActionListener(diviAction);
                BtnDivisao.addActionListener(diviAction);

                // Botão voltar
                BtnVoltar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                });

            // Adicionando elemento á tela
                tela.add(BarraFerramentas);
                tela.add(Nome);
                tela.add(Data);
                tela.add(Sala);
                tela.add(BtnVoltar);

        }
    }

    private class soma extends JDialog  {
        // Objetos
        JMenuBar BarraMenu;
        JMenu Operacoes, Menu;
        JMenuItem Soma, Subtracao, Multiplicacao, Divisao, Sair, Sobre, SairPopUp, SobrePopUp;

        JButton BtnSoma, BtnSubtracao, BtnMultiplicacao, BtnDivisao, BtnSair, BtnVoltar, BtnSomar, BtnLimpar;
        JToolBar BarraFerramentas;

        JPopupMenu MenuPopUp;

        JLabel lblNum1, lblNum2, lblResultado;

        JTextField txtFNum1, txtFNum2;

        public soma(Frame owner, String title,boolean modal) {
            // Configurações da janela
            super(owner,title,modal);
            Container tela = getContentPane();
            setLayout(null);
            setSize(500,500);
            setResizable(false);

            // Criando elementos
                // Menu
                Soma = new JMenuItem("Soma");
                Subtracao = new JMenuItem("Subtracao");
                Multiplicacao = new JMenuItem("Multiplicacao");
                Divisao = new JMenuItem("Divisao");
                Sair = new JMenuItem("Sair");
                Sobre = new JMenuItem("Sobre");

                Operacoes = new JMenu("Operacoes");
                Operacoes.add(Soma);
                Operacoes.add(Subtracao);
                Operacoes.add(Multiplicacao);
                Operacoes.add(Divisao);

                Menu = new JMenu("Menu");
                Menu.add(Sair);
                Menu.add(Sobre);

                BarraMenu = new JMenuBar();
                setJMenuBar(BarraMenu);

                BarraMenu.add(Menu);
                Menu.add(Operacoes);

                // Botões
                BtnSoma = new JButton("Soma");
                BtnSubtracao = new JButton("Subtracao");
                BtnMultiplicacao = new JButton("Multiplicacao");
                BtnDivisao = new JButton("Divisao");
                BtnSair = new JButton("Sair");

                // Barra de ferramentas
                BarraFerramentas = new JToolBar();
                BarraFerramentas.add(BtnSoma);
                BarraFerramentas.add(BtnSubtracao);
                BarraFerramentas.add(BtnMultiplicacao);
                BarraFerramentas.add(BtnDivisao);
                BarraFerramentas.add(BtnSair);
                BarraFerramentas.setBounds(20,20,400,30);

                // PopUp
                SairPopUp = new JMenuItem("Sair");
                SobrePopUp = new JMenuItem("Sobre");

                MenuPopUp = new JPopupMenu();
                MenuPopUp.add(SairPopUp);
                MenuPopUp.add(SobrePopUp);
                addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        if (evt.isPopupTrigger()) {
                            MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                    }

                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        if (evt.isPopupTrigger()) {
                            MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                    }
                });

                //Botões
                BtnVoltar = new JButton("Voltar");
                BtnSomar = new JButton("Somar");
                BtnLimpar = new JButton("Limpar");

                // Jlabels
                lblResultado = new JLabel(" ");
                lblNum1 = new JLabel("Número 1: ");
                lblNum2 = new JLabel("Número 2: ");

                // TextField
                txtFNum1 = new JTextField();
                txtFNum2 = new JTextField();


            // Posicionando elementos
                lblNum1.setBounds(20,60,150,30);
                txtFNum1.setBounds(100,60,100,20);
                lblNum2.setBounds(20,90,350,30);
                txtFNum2.setBounds(100,90,100,20);
                BtnSomar.setBounds(20,120,100,20);
                lblResultado.setBounds(20,140,150,30);
                BtnVoltar.setBounds(20,200,100,20);
                BtnLimpar.setBounds(20,230,100,20);

            // Métodos
                // Método sair
                ActionListener sairAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int status = JOptionPane.showConfirmDialog(null,"Deseja realmente fechar o programa?", "Mensagem de Saida", JOptionPane.YES_NO_OPTION);
                        if(status == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                    }
                };
                Sair.addActionListener(sairAction);
                BtnSair.addActionListener(sairAction);
                SairPopUp.addActionListener(sairAction);

                // Abrindo janela Sobre
                ActionListener sobreAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sobre JanelaSobre = new sobre(null,"Segunda Janela",true);
                        JanelaSobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JanelaSobre.setVisible(true);
                    }
                };
                Sobre.addActionListener(sobreAction);
                SobrePopUp.addActionListener(sobreAction);

                // Abrindo janela Soma
                ActionListener somaAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        soma JanelaSoma = new soma(null,"Janela Soma",true);
                        JanelaSoma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JanelaSoma.setVisible(true);
                    }
                };
                Soma.addActionListener(somaAction);
                BtnSoma.addActionListener(somaAction);

                // Soma
                BtnSomar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        float n1 = Float.parseFloat(txtFNum1.getText());
                        float n2 = Float.parseFloat(txtFNum2.getText());

                        float soma = n1 + n2;

                        lblResultado.setText("Resultado: " + soma);
                    }
                });

                // Abrindo janela Subtracao
                ActionListener subAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        subtracao JanelaSub = new subtracao(null,"Janela Subtração",true);
                        JanelaSub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JanelaSub.setVisible(true);
                    }
                };
                Subtracao.addActionListener(subAction);
                BtnSubtracao.addActionListener(subAction);

                // Abrindo janela Multiplicação
                ActionListener multAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        multiplicacao JanelaMult = new multiplicacao(null,"Janela Multiplicação",true);
                        JanelaMult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JanelaMult.setVisible(true);
                    }
                };
                Multiplicacao.addActionListener(multAction);
                BtnMultiplicacao.addActionListener(multAction);

                // Abrindo janela Divisão
                ActionListener diviAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        divisao JanelaDivi = new divisao(null,"Janela Multiplicação",true);
                        JanelaDivi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JanelaDivi.setVisible(true);
                    }
                };
                Divisao.addActionListener(diviAction);
                BtnDivisao.addActionListener(diviAction);

                // Botão voltar
                BtnVoltar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                });

                // Botão limpar
                BtnLimpar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txtFNum1.setText(" ");
                        txtFNum2.setText(" ");
                    }
                });


            // Adicionando elemento á tela
                tela.add(BarraFerramentas);
                tela.add(BtnVoltar);
                tela.add(BtnLimpar);
                tela.add(BtnSomar);
                tela.add(lblNum1);
                tela.add(lblNum2);
                tela.add(lblResultado);
                tela.add(txtFNum1);
                tela.add(txtFNum2);

        }
    }

    private class subtracao extends JDialog {
        // Objetos
        JMenuBar BarraMenu;
        JMenu Operacoes, Menu;
        JMenuItem Soma, Subtracao, Multiplicacao, Divisao, Sair, Sobre, SairPopUp, SobrePopUp;

        JButton BtnSoma, BtnSubtracao, BtnMultiplicacao, BtnDivisao, BtnSair, BtnVoltar, BtnSub, BtnLimpar;
        JToolBar BarraFerramentas;

        JPopupMenu MenuPopUp;

        JLabel lblNum1, lblNum2, lblResultado;

        JTextField txtFNum1, txtFNum2;

        public subtracao(Frame owner, String title,boolean modal) {
            // Configurações da janela
            super(owner,title,modal);
            Container tela = getContentPane();
            setLayout(null);
            setSize(500,500);
            setResizable(false);

            // Criando elementos
            // Menu
            Soma = new JMenuItem("Soma");
            Subtracao = new JMenuItem("Subtracao");
            Multiplicacao = new JMenuItem("Multiplicacao");
            Divisao = new JMenuItem("Divisao");
            Sair = new JMenuItem("Sair");
            Sobre = new JMenuItem("Sobre");

            Operacoes = new JMenu("Operacoes");
            Operacoes.add(Soma);
            Operacoes.add(Subtracao);
            Operacoes.add(Multiplicacao);
            Operacoes.add(Divisao);

            Menu = new JMenu("Menu");
            Menu.add(Sair);
            Menu.add(Sobre);

            BarraMenu = new JMenuBar();
            setJMenuBar(BarraMenu);

            BarraMenu.add(Menu);
            Menu.add(Operacoes);

            // Botões
            BtnSoma = new JButton("Soma");
            BtnSubtracao = new JButton("Subtracao");
            BtnMultiplicacao = new JButton("Multiplicacao");
            BtnDivisao = new JButton("Divisao");
            BtnSair = new JButton("Sair");

            // Barra de ferramentas
            BarraFerramentas = new JToolBar();
            BarraFerramentas.add(BtnSoma);
            BarraFerramentas.add(BtnSubtracao);
            BarraFerramentas.add(BtnMultiplicacao);
            BarraFerramentas.add(BtnDivisao);
            BarraFerramentas.add(BtnSair);
            BarraFerramentas.setBounds(20,20,400,30);

            // PopUp
            SairPopUp = new JMenuItem("Sair");
            SobrePopUp = new JMenuItem("Sobre");

            MenuPopUp = new JPopupMenu();
            MenuPopUp.add(SairPopUp);
            MenuPopUp.add(SobrePopUp);
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                    }
                }

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                    }
                }
            });

            //Botões
            BtnVoltar = new JButton("Voltar");
            BtnSub = new JButton("Subtrair");
            BtnLimpar = new JButton("Limpar");

            // Jlabels
            lblResultado = new JLabel(" ");
            lblNum1 = new JLabel("Número 1: ");
            lblNum2 = new JLabel("Número 2: ");

            // TextField
            txtFNum1 = new JTextField();
            txtFNum2 = new JTextField();


            // Posicionando elementos
            lblNum1.setBounds(20,60,150,30);
            txtFNum1.setBounds(100,60,100,20);
            lblNum2.setBounds(20,90,350,30);
            txtFNum2.setBounds(100,90,100,20);
            BtnSub.setBounds(20,120,100,20);
            lblResultado.setBounds(20,140,150,30);
            BtnVoltar.setBounds(20,200,100,20);
            BtnLimpar.setBounds(20,230,100,20);

            // Métodos
            // Método sair
            ActionListener sairAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int status = JOptionPane.showConfirmDialog(null,"Deseja realmente fechar o programa?", "Mensagem de Saida", JOptionPane.YES_NO_OPTION);
                    if(status == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            };
            Sair.addActionListener(sairAction);
            BtnSair.addActionListener(sairAction);
            SairPopUp.addActionListener(sairAction);

            // Abrindo janela Sobre
            ActionListener sobreAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sobre JanelaSobre = new sobre(null,"Segunda Janela",true);
                    JanelaSobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSobre.setVisible(true);
                }
            };
            Sobre.addActionListener(sobreAction);
            SobrePopUp.addActionListener(sobreAction);

            // Abrindo janela Soma
            ActionListener somaAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    soma JanelaSoma = new soma(null,"Janela Soma",true);
                    JanelaSoma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSoma.setVisible(true);
                }
            };
            Soma.addActionListener(somaAction);
            BtnSoma.addActionListener(somaAction);

            // Subtração
            BtnSub.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    float n1 = Float.parseFloat(txtFNum1.getText());
                    float n2 = Float.parseFloat(txtFNum2.getText());

                    float sub = n1 - n2;

                    lblResultado.setText("Resultado: " + sub);
                }
            });

            // Abrindo janela Subtracao
            ActionListener subAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    subtracao JanelaSub = new subtracao(null,"Janela Subtração",true);
                    JanelaSub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSub.setVisible(true);
                }
            };
            Subtracao.addActionListener(subAction);
            BtnSubtracao.addActionListener(subAction);

            // Abrindo janela Multiplicação
            ActionListener multAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    multiplicacao JanelaMult = new multiplicacao(null,"Janela Multiplicação",true);
                    JanelaMult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaMult.setVisible(true);
                }
            };
            Multiplicacao.addActionListener(multAction);
            BtnMultiplicacao.addActionListener(multAction);

            // Abrindo janela Divisão
            ActionListener diviAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    divisao JanelaDivi = new divisao(null,"Janela Multiplicação",true);
                    JanelaDivi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaDivi.setVisible(true);
                }
            };
            Divisao.addActionListener(diviAction);
            BtnDivisao.addActionListener(diviAction);

            // Botão voltar
            BtnVoltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            // Botão limpar
            BtnLimpar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtFNum1.setText(" ");
                    txtFNum2.setText(" ");
                }
            });


            // Adicionando elemento á tela
            tela.add(BarraFerramentas);
            tela.add(BtnVoltar);
            tela.add(BtnLimpar);
            tela.add(BtnSub);
            tela.add(lblNum1);
            tela.add(lblNum2);
            tela.add(lblResultado);
            tela.add(txtFNum1);
            tela.add(txtFNum2);

        }
    }

    private class multiplicacao extends JDialog {
        // Objetos
        JMenuBar BarraMenu;
        JMenu Operacoes, Menu;
        JMenuItem Soma, Subtracao, Multiplicacao, Divisao, Sair, Sobre, SairPopUp, SobrePopUp;

        JButton BtnSoma, BtnSubtracao, BtnMultiplicacao, BtnDivisao, BtnSair, BtnVoltar, BtnMult, BtnLimpar;
        JToolBar BarraFerramentas;

        JPopupMenu MenuPopUp;

        JLabel lblNum1, lblNum2, lblResultado;

        JTextField txtFNum1, txtFNum2;

        public multiplicacao(Frame owner, String title,boolean modal) {
            // Configurações da janela
            super(owner,title,modal);
            Container tela = getContentPane();
            setLayout(null);
            setSize(500,500);
            setResizable(false);

            // Criando elementos
            // Menu
            Soma = new JMenuItem("Soma");
            Subtracao = new JMenuItem("Subtracao");
            Multiplicacao = new JMenuItem("Multiplicacao");
            Divisao = new JMenuItem("Divisao");
            Sair = new JMenuItem("Sair");
            Sobre = new JMenuItem("Sobre");

            Operacoes = new JMenu("Operacoes");
            Operacoes.add(Soma);
            Operacoes.add(Subtracao);
            Operacoes.add(Multiplicacao);
            Operacoes.add(Divisao);

            Menu = new JMenu("Menu");
            Menu.add(Sair);
            Menu.add(Sobre);

            BarraMenu = new JMenuBar();
            setJMenuBar(BarraMenu);

            BarraMenu.add(Menu);
            Menu.add(Operacoes);

            // Botões
            BtnSoma = new JButton("Soma");
            BtnSubtracao = new JButton("Subtracao");
            BtnMultiplicacao = new JButton("Multiplicacao");
            BtnDivisao = new JButton("Divisao");
            BtnSair = new JButton("Sair");

            // Barra de ferramentas
            BarraFerramentas = new JToolBar();
            BarraFerramentas.add(BtnSoma);
            BarraFerramentas.add(BtnSubtracao);
            BarraFerramentas.add(BtnMultiplicacao);
            BarraFerramentas.add(BtnDivisao);
            BarraFerramentas.add(BtnSair);
            BarraFerramentas.setBounds(20,20,400,30);

            // PopUp
            SairPopUp = new JMenuItem("Sair");
            SobrePopUp = new JMenuItem("Sobre");

            MenuPopUp = new JPopupMenu();
            MenuPopUp.add(SairPopUp);
            MenuPopUp.add(SobrePopUp);
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                    }
                }

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                    }
                }
            });

            //Botões
            BtnVoltar = new JButton("Voltar");
            BtnMult = new JButton("Multiplicar");
            BtnLimpar = new JButton("Limpar");

            // Jlabels
            lblResultado = new JLabel(" ");
            lblNum1 = new JLabel("Número 1: ");
            lblNum2 = new JLabel("Número 2: ");

            // TextField
            txtFNum1 = new JTextField();
            txtFNum2 = new JTextField();


            // Posicionando elementos
            lblNum1.setBounds(20,60,150,30);
            txtFNum1.setBounds(100,60,100,20);
            lblNum2.setBounds(20,90,350,30);
            txtFNum2.setBounds(100,90,100,20);
            BtnMult.setBounds(20,120,150,20);
            lblResultado.setBounds(20,140,150,30);
            BtnVoltar.setBounds(20,200,100,20);
            BtnLimpar.setBounds(20,230,100,20);

            // Métodos
            // Método sair
            ActionListener sairAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int status = JOptionPane.showConfirmDialog(null,"Deseja realmente fechar o programa?", "Mensagem de Saida", JOptionPane.YES_NO_OPTION);
                    if(status == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            };
            Sair.addActionListener(sairAction);
            BtnSair.addActionListener(sairAction);
            SairPopUp.addActionListener(sairAction);

            // Abrindo janela Sobre
            ActionListener sobreAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sobre JanelaSobre = new sobre(null,"Segunda Janela",true);
                    JanelaSobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSobre.setVisible(true);
                }
            };
            Sobre.addActionListener(sobreAction);
            SobrePopUp.addActionListener(sobreAction);

            // Abrindo janela Soma
            ActionListener somaAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    soma JanelaSoma = new soma(null,"Janela Soma",true);
                    JanelaSoma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSoma.setVisible(true);
                }
            };
            Soma.addActionListener(somaAction);
            BtnSoma.addActionListener(somaAction);

            // Multiplicação
            BtnMult.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    float n1 = Float.parseFloat(txtFNum1.getText());
                    float n2 = Float.parseFloat(txtFNum2.getText());

                    float mult = n1 * n2;

                    lblResultado.setText("Resultado: " + mult);
                }
            });

            // Abrindo janela Subtracao
            ActionListener subAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    subtracao JanelaSub = new subtracao(null,"Janela Subtração",true);
                    JanelaSub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSub.setVisible(true);
                }
            };
            Subtracao.addActionListener(subAction);
            BtnSubtracao.addActionListener(subAction);

            // Abrindo janela Multiplicação
            ActionListener multAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    multiplicacao JanelaMult = new multiplicacao(null,"Janela Multiplicação",true);
                    JanelaMult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaMult.setVisible(true);
                }
            };
            Multiplicacao.addActionListener(multAction);
            BtnMultiplicacao.addActionListener(multAction);

            // Abrindo janela Divisão
            ActionListener diviAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    divisao JanelaDivi = new divisao(null,"Janela Multiplicação",true);
                    JanelaDivi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaDivi.setVisible(true);
                }
            };
            Divisao.addActionListener(diviAction);
            BtnDivisao.addActionListener(diviAction);

            // Botão voltar
            BtnVoltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            // Botão limpar
            BtnLimpar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtFNum1.setText(" ");
                    txtFNum2.setText(" ");
                }
            });


            // Adicionando elemento á tela
            tela.add(BarraFerramentas);
            tela.add(BtnVoltar);
            tela.add(BtnMult);
            tela.add(lblNum1);
            tela.add(lblNum2);
            tela.add(lblResultado);
            tela.add(txtFNum1);
            tela.add(txtFNum2);
            tela.add(BtnLimpar);
        }
    }

    private class divisao extends JDialog {
        // Objetos
        JMenuBar BarraMenu;
        JMenu Operacoes, Menu;
        JMenuItem Soma, Subtracao, Multiplicacao, Divisao, Sair, Sobre, SairPopUp, SobrePopUp;

        JButton BtnSoma, BtnSubtracao, BtnMultiplicacao, BtnDivisao, BtnSair, BtnVoltar, BtnDivi, BtnLimpar;
        JToolBar BarraFerramentas;

        JPopupMenu MenuPopUp;

        JLabel lblNum1, lblNum2, lblResultado;

        JTextField txtFNum1, txtFNum2;

        public divisao(Frame owner, String title,boolean modal) {
            // Configurações da janela
            super(owner,title,modal);
            Container tela = getContentPane();
            setLayout(null);
            setSize(500,500);
            setResizable(false);

            // Criando elementos
            // Menu
            Soma = new JMenuItem("Soma");
            Subtracao = new JMenuItem("Subtracao");
            Multiplicacao = new JMenuItem("Multiplicacao");
            Divisao = new JMenuItem("Divisao");
            Sair = new JMenuItem("Sair");
            Sobre = new JMenuItem("Sobre");

            Operacoes = new JMenu("Operacoes");
            Operacoes.add(Soma);
            Operacoes.add(Subtracao);
            Operacoes.add(Multiplicacao);
            Operacoes.add(Divisao);

            Menu = new JMenu("Menu");
            Menu.add(Sair);
            Menu.add(Sobre);

            BarraMenu = new JMenuBar();
            setJMenuBar(BarraMenu);

            BarraMenu.add(Menu);
            Menu.add(Operacoes);

            // Botões
            BtnSoma = new JButton("Soma");
            BtnSubtracao = new JButton("Subtracao");
            BtnMultiplicacao = new JButton("Multiplicacao");
            BtnDivisao = new JButton("Divisao");
            BtnSair = new JButton("Sair");

            // Barra de ferramentas
            BarraFerramentas = new JToolBar();
            BarraFerramentas.add(BtnSoma);
            BarraFerramentas.add(BtnSubtracao);
            BarraFerramentas.add(BtnMultiplicacao);
            BarraFerramentas.add(BtnDivisao);
            BarraFerramentas.add(BtnSair);
            BarraFerramentas.setBounds(20,20,400,30);

            // PopUp
            SairPopUp = new JMenuItem("Sair");
            SobrePopUp = new JMenuItem("Sobre");

            MenuPopUp = new JPopupMenu();
            MenuPopUp.add(SairPopUp);
            MenuPopUp.add(SobrePopUp);
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                    }
                }

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        MenuPopUp.show(evt.getComponent(), evt.getX(), evt.getY());
                    }
                }
            });

            //Botões
            BtnVoltar = new JButton("Voltar");
            BtnDivi = new JButton("Dividir");
            BtnLimpar = new JButton("Limpar");

            // Jlabels
            lblResultado = new JLabel(" ");
            lblNum1 = new JLabel("Número 1: ");
            lblNum2 = new JLabel("Número 2: ");

            // TextField
            txtFNum1 = new JTextField();
            txtFNum2 = new JTextField();


            // Posicionando elementos
            lblNum1.setBounds(20,60,150,30);
            txtFNum1.setBounds(100,60,100,20);
            lblNum2.setBounds(20,90,350,30);
            txtFNum2.setBounds(100,90,100,20);
            BtnDivi.setBounds(20,120,150,20);
            lblResultado.setBounds(20,140,150,30);
            BtnVoltar.setBounds(20,200,100,20);
            BtnLimpar.setBounds(20,230,100,20);

            // Métodos
            // Método sair
            ActionListener sairAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int status = JOptionPane.showConfirmDialog(null,"Deseja realmente fechar o programa?", "Mensagem de Saida", JOptionPane.YES_NO_OPTION);
                    if(status == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            };
            Sair.addActionListener(sairAction);
            BtnSair.addActionListener(sairAction);
            SairPopUp.addActionListener(sairAction);

            // Abrindo janela Sobre
            ActionListener sobreAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sobre JanelaSobre = new sobre(null,"Segunda Janela",true);
                    JanelaSobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSobre.setVisible(true);
                }
            };
            Sobre.addActionListener(sobreAction);
            SobrePopUp.addActionListener(sobreAction);

            // Abrindo janela Soma
            ActionListener somaAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    soma JanelaSoma = new soma(null,"Janela Soma",true);
                    JanelaSoma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSoma.setVisible(true);
                }
            };
            Soma.addActionListener(somaAction);
            BtnSoma.addActionListener(somaAction);

            // Multiplicação
            BtnDivi.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    float n1 = Float.parseFloat(txtFNum1.getText());
                    float n2 = Float.parseFloat(txtFNum2.getText());

                    float divi = n1 / n2;

                    lblResultado.setText("Resultado: " + divi);
                }
            });

            // Abrindo janela Subtracao
            ActionListener subAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    subtracao JanelaSub = new subtracao(null,"Janela Subtração",true);
                    JanelaSub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaSub.setVisible(true);
                }
            };
            Subtracao.addActionListener(subAction);
            BtnSubtracao.addActionListener(subAction);

            // Abrindo janela Multiplicação
            ActionListener multAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    multiplicacao JanelaMult = new multiplicacao(null,"Janela Multiplicação",true);
                    JanelaMult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaMult.setVisible(true);
                }
            };
            Multiplicacao.addActionListener(multAction);
            BtnMultiplicacao.addActionListener(multAction);

            // Abrindo janela Divisão
            ActionListener diviAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    divisao JanelaDivi = new divisao(null,"Janela Multiplicação",true);
                    JanelaDivi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JanelaDivi.setVisible(true);
                }
            };
            Divisao.addActionListener(diviAction);
            BtnDivisao.addActionListener(diviAction);

            // Botão voltar
            BtnVoltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            // Botão limpar
            BtnLimpar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtFNum1.setText(" ");
                    txtFNum2.setText(" ");
                }
            });


            // Adicionando elemento á tela
            tela.add(BarraFerramentas);
            tela.add(BtnVoltar);
            tela.add(BtnDivi);
            tela.add(lblNum1);
            tela.add(lblNum2);
            tela.add(lblResultado);
            tela.add(txtFNum1);
            tela.add(txtFNum2);
            tela.add(BtnLimpar);

        }
    }

}