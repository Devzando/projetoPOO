package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ClienteController;
import Controller.ProdutoController;
import entities.Cliente;
import entities.Produto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField inputEmail;
	private JPasswordField inputSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setTitle("TechNew (Login)");
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteController clienteController = new ClienteController();
					String email = inputEmail.getText();
					String senha = String.valueOf(inputSenha.getPassword());
					Cliente clienteLogin = clienteController.handleLoginCliente(email, senha);
					if(clienteLogin.getTipoCliente().equals("Cliente")) {
						HomeCliente screenHomeCliente = new HomeCliente(clienteLogin);
						dispose();
						screenHomeCliente.setVisible(true);
						screenHomeCliente.setTitle("TechNew (Home)");
					} else if (clienteLogin.getTipoCliente().equals("admin")) {
						HomeAdm screenHomeAdmin = new HomeAdm(clienteLogin);
						dispose();
						screenHomeAdmin.setVisible(true);
						screenHomeAdmin.setTitle("TechNew (Home)");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(buttonLogin, ex.getMessage());
				}
			}
		});
		buttonLogin.setBounds(170, 182, 95, 32);
		contentPane.add(buttonLogin);
		
		JButton buttonCadastro = new JButton("Cadastro");
		buttonCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro screenCadastro = new Cadastro();
				dispose();
				screenCadastro.setVisible(true);
				screenCadastro.setTitle("TechNew (Cadastro)");
			}
		});
		buttonCadastro.setBounds(175, 222, 86, 19);
		contentPane.add(buttonCadastro);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(48, 25, 66, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Entre com seus dados corretamente para acessar o sistema.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(48, 62, 338, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setBounds(115, 116, 37, 11);
		contentPane.add(lblNewLabel_2);
		
		inputEmail = new JTextField();
		inputEmail.setBounds(151, 113, 148, 17);
		contentPane.add(inputEmail);
		inputEmail.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha:");
		lblNewLabel_2_1.setBounds(107, 147, 46, 11);
		contentPane.add(lblNewLabel_2_1);
		
		inputSenha = new JPasswordField();
		lblNewLabel_2_1.setLabelFor(inputSenha);
		inputSenha.setBounds(151, 145, 148, 17);
		contentPane.add(inputSenha);
	}

}
