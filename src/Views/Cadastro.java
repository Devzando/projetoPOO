package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ClienteController;
import entities.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField inputNome;
	private JTextField inputEmail;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPasswordField inputSenha;
	private JButton buttonCadastro;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPasswordField inputConfirmSenha;
	private JButton buttonVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(164, 18, 107, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(130, 97, 37, 11);
		contentPane.add(lblNewLabel_1);
		
		inputNome = new JTextField();
		lblNewLabel_1.setLabelFor(inputNome);
		inputNome.setBounds(169, 94, 133, 17);
		contentPane.add(inputNome);
		inputNome.setColumns(10);
		
		inputEmail = new JTextField();
		inputEmail.setColumns(10);
		inputEmail.setBounds(169, 129, 133, 17);
		contentPane.add(inputEmail);
		
		lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setLabelFor(inputEmail);
		lblNewLabel_2.setBounds(130, 132, 37, 11);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setBounds(123, 166, 64, 11);
		contentPane.add(lblNewLabel_3);
		
		inputSenha = new JPasswordField();
		lblNewLabel_3.setLabelFor(inputSenha);
		inputSenha.setBounds(169, 163, 133, 17);
		contentPane.add(inputSenha);
		
		buttonCadastro = new JButton("Cadastrar");
		buttonCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = inputNome.getText();
				String email = inputEmail.getText();
				String senha = String.valueOf(inputSenha.getPassword());
				String confirmSenha = String.valueOf(inputConfirmSenha.getPassword());
				
				if(senha.equals(confirmSenha)) {
					try {
						Cliente novoCliente = new Cliente(nome, email, senha);
						ClienteController clienteController = new ClienteController();
						
						clienteController.handleCreateCliente(novoCliente);
						JOptionPane.showMessageDialog(buttonCadastro, "Usuário cadastrado com sucesso volte para o login para acessar o sistema");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(buttonCadastro, ex.getMessage());						
					}
				} else {
					JOptionPane.showMessageDialog(buttonCadastro, "As senhas digitadas estão diferentes");											
				}
			}
		});
		buttonCadastro.setBounds(167, 226, 102, 29);
		contentPane.add(buttonCadastro);
		
		lblNewLabel_4 = new JLabel("Insira os dados para realizar o seu cadastro");
		lblNewLabel_4.setBounds(82, 55, 271, 11);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Confirmar senha:");
		lblNewLabel_5.setBounds(67, 197, 107, 11);
		contentPane.add(lblNewLabel_5);
		
		inputConfirmSenha = new JPasswordField();
		lblNewLabel_5.setLabelFor(inputConfirmSenha);
		inputConfirmSenha.setBounds(169, 194, 133, 17);
		contentPane.add(inputConfirmSenha);
		
		buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login screenLogin = new Login();
				dispose();
				screenLogin.setVisible(true);
				screenLogin.setTitle("TechNew (Login)");
			}
		});
		buttonVoltar.setBounds(8, 8, 88, 19);
		contentPane.add(buttonVoltar);
	}

}
