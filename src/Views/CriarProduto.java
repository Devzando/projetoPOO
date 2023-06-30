package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ProdutoController;
import entities.Cliente;
import entities.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CriarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField inputNome;
	private JTextField inputMarca;
	private JTextField inputCor;
	private JTextField inputTipo;
	private JTextField inputEnergia;
	private JTextField inputDimensoes;
	private JTextField inputuCapacidade;
	private JTextField inputPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarProduto frame = new CriarProduto(null);
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
	public CriarProduto(Cliente clienteLogin) {
		Cliente meuCliente;
		{
			meuCliente = clienteLogin;
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 90, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 115, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 174, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cor:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 143, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Preço:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(208, 174, 102, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Capacidade:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(208, 143, 102, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Dimensões:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(208, 115, 102, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Consumo de energia:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(166, 90, 144, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Crie um novo produto");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_8.setBounds(49, 11, 336, 29);
		contentPane.add(lblNewLabel_8);
		
		inputNome = new JTextField();
		inputNome.setBounds(83, 87, 86, 20);
		contentPane.add(inputNome);
		inputNome.setColumns(10);
		
		inputMarca = new JTextField();
		inputMarca.setColumns(10);
		inputMarca.setBounds(83, 112, 86, 20);
		contentPane.add(inputMarca);
		
		inputCor = new JTextField();
		inputCor.setColumns(10);
		inputCor.setBounds(83, 140, 86, 20);
		contentPane.add(inputCor);
		
		inputTipo = new JTextField();
		inputTipo.setColumns(10);
		inputTipo.setBounds(83, 171, 86, 20);
		contentPane.add(inputTipo);
		
		inputEnergia = new JTextField();
		inputEnergia.setBounds(313, 87, 86, 20);
		contentPane.add(inputEnergia);
		inputEnergia.setColumns(10);
		
		inputDimensoes = new JTextField();
		inputDimensoes.setBounds(313, 112, 86, 20);
		contentPane.add(inputDimensoes);
		inputDimensoes.setColumns(10);
		
		inputuCapacidade = new JTextField();
		inputuCapacidade.setBounds(313, 140, 86, 20);
		contentPane.add(inputuCapacidade);
		inputuCapacidade.setColumns(10);
		
		inputPreco = new JTextField();
		inputPreco.setBounds(313, 171, 86, 20);
		contentPane.add(inputPreco);
		inputPreco.setColumns(10);
		
		JButton buttonCriar = new JButton("Criar");
		buttonCriar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto meuProduto = new Produto();
				meuProduto.setNome(inputNome.getText());
				meuProduto.setMarca(inputMarca.getText());
				meuProduto.setCapacidade(inputuCapacidade.getText());
				meuProduto.setTipo(inputTipo.getText());
				meuProduto.setConsumoDeEnergia(inputEnergia.getText());
				meuProduto.setDimensoes(inputDimensoes.getText());
				meuProduto.setCor(inputCor.getText());
				meuProduto.setPreco(Double.parseDouble(inputPreco.getText()));
				
				try {
					ProdutoController produtoController = new ProdutoController();
					produtoController.handleCreateProduto(meuProduto);
					JOptionPane.showMessageDialog(buttonCriar, "Produto Criado com Sucesso!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(buttonCriar, ex.getMessage());
				}
			}
		});
		buttonCriar.setBounds(166, 210, 102, 40);
		contentPane.add(buttonCriar);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeAdm screenHomeAdmin = new HomeAdm(meuCliente);
				dispose();
				screenHomeAdmin.setVisible(true);
				screenHomeAdmin.setTitle("TechNew (Home)");
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
