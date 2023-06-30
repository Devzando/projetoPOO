package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;

import Controller.ClienteController;
import Controller.ProdutoController;
import entities.Cliente;
import entities.Produto;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeCliente extends JFrame {
	private JTable table;
	private JTable table_1;
	private JTextField inputNome;
	private JTextField inputEmail;
	private JTextField inputSenha;
	private JTextField inputSaldo;
	
	private void carregarTabela() {
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		modelo.setNumRows(0);
		
		table.getColumnModel().getColumn(0);
		table.getColumnModel().getColumn(1);
		table.getColumnModel().getColumn(2);
		
		ProdutoController produtoController = new ProdutoController();
		
		try {
			for(Produto p: produtoController.handleReadProduto()) {
				modelo.addRow(new Object[] {
					p.getNome(),
					p.getPreco(),
					p.getEstoque(),
				});
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	private void carregarPerfil(Cliente meuCliente) {
		inputNome.setText(meuCliente.getNome());
		inputEmail.setText(meuCliente.getEmail());
		inputSenha.setText(meuCliente.getSenha());
		inputSaldo.setText(Double.toString(meuCliente.getSaldo()));
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeCliente frame = new HomeCliente(null);
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
	public HomeCliente(Cliente loginCliente) {
		Cliente meuCliente;
		{
			meuCliente = loginCliente;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 560);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 881, 521);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Produtos", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(383, 11, 109, 29);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(237, 157, 402, 245);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Pre\u00E7o", "Estoque"
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Produto p = new Produto();
				ProdutoController controllerProduto = new ProdutoController();
				
				int index = table.getSelectedRow();
				
				p = controllerProduto.handleReadProduto().get(index);
				
				try {
					ScreenProduto screenPageProduto = new ScreenProduto(p.getIdProduto(), meuCliente);
					dispose();
					screenPageProduto.setVisible(true);
					screenPageProduto.setTitle("TechNew (Home)");					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Não foi possivel acessar a pagina deste produto");
				}
			}
		});
		carregarTabela();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha um dos produtos citados abaixo para ver as especificações e efetuar a compra");
		lblNewLabel_1.setBounds(189, 49, 498, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Saldo:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(718, 468, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(Double.toString(meuCliente.getSaldo()));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(774, 468, 53, 14);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Perfil", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_2 = new JLabel("Meu Perfil");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(362, 30, 151, 44);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Você pode alterar seu nome de usuário, seu email, sua senha e seu saldo ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(222, 85, 432, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(222, 146, 91, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Email:");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setBounds(222, 171, 91, 14);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Senha:");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1_1.setBounds(222, 196, 91, 14);
		panel_1.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Saldo:");
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1_1_1.setBounds(222, 221, 91, 14);
		panel_1.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Compras:");
		lblNewLabel_4_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1_1_1_1_1.setBounds(222, 249, 91, 14);
		panel_1.add(lblNewLabel_4_1_1_1_1_1);
		
		inputNome = new JTextField();
		inputNome.setBounds(323, 143, 238, 20);
		panel_1.add(inputNome);
		inputNome.setColumns(10);
		
		inputEmail = new JTextField();
		inputEmail.setColumns(10);
		inputEmail.setBounds(323, 168, 238, 20);
		panel_1.add(inputEmail);
		
		inputSenha = new JTextField();
		inputSenha.setColumns(10);
		inputSenha.setBounds(323, 193, 238, 20);
		panel_1.add(inputSenha);
		
		inputSaldo = new JTextField();
		inputSaldo.setColumns(10);
		inputSaldo.setBounds(323, 218, 238, 20);
		panel_1.add(inputSaldo);
		carregarPerfil(meuCliente);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController clienteController = new ClienteController();
				
				try {
					Cliente clienteAtualizado = new Cliente(inputNome.getText(), inputEmail.getText(), inputSenha.getText());
					clienteAtualizado.setSaldo(Double.parseDouble(inputSaldo.getText()));
					clienteAtualizado.setQuantidadeCompras(meuCliente.getQuantidadeCompras());
					
					clienteController.handleUpdateCliente(clienteAtualizado, meuCliente.getIdCliente());
					JOptionPane.showMessageDialog(btnNewButton, "Perfil atualizado com Sucesso!!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(btnNewButton, ex.getMessage());
				}
			}
		});
		btnNewButton.setBounds(369, 290, 138, 51);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Deletar sua conta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController clienteController = new ClienteController();
				try {
					Login screenLogin = new Login();
					clienteController.handleDeleteCliente(meuCliente.getIdCliente());
					JOptionPane.showMessageDialog(btnNewButton_1, "Seu perfil foi deletado");
					dispose();
					screenLogin.setVisible(true);
					screenLogin.setTitle("TechNew (Login)");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(btnNewButton_1, ex.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(346, 375, 183, 32);
		panel_1.add(btnNewButton_1);
		
		JLabel numCompras = new JLabel(Integer.toString(meuCliente.getQuantidadeCompras()));
		numCompras.setBounds(323, 249, 46, 14);
		panel_1.add(numCompras);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login screenLogin = new Login();
				dispose();
				screenLogin.setVisible(true);
				screenLogin.setTitle("TechNew (Login)");
			}
		});
		btnNewButton_2.setBounds(777, 11, 89, 23);
		panel_1.add(btnNewButton_2);
	}
}
