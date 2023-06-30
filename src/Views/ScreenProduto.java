package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CompraController;
import Controller.ProdutoController;
import entities.Cliente;
import entities.Compra;
import entities.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class ScreenProduto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenProduto frame = new ScreenProduto("error", null);
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
	public ScreenProduto(String produto, Cliente loginCliente) {
		String produtoId;
		Cliente meuCliente;
		{			
			produtoId = produto;
			meuCliente = loginCliente;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ProdutoController produtoController = new ProdutoController();
		Produto pageProduto = produtoController.handleReadProduto(produtoId);
		
		JLabel lblNewLabel = new JLabel(pageProduto.getNome());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(-19, 47, 618, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(24, 186, 126, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Capacidade:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(24, 212, 126, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(24, 235, 126, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Cor:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setBounds(24, 258, 126, 13);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Dimensões:");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setBounds(24, 281, 126, 13);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Consumo de Energia:");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1.setBounds(24, 304, 126, 13);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Quantidade de venda:");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1.setBounds(24, 327, 126, 13);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Estoque:");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(24, 350, 126, 13);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel(pageProduto.getMarca());
		lblNewLabel_2.setBounds(160, 186, 150, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(pageProduto.getCapacidade());
		lblNewLabel_2_1.setBounds(160, 212, 150, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel(pageProduto.getTipo());
		lblNewLabel_2_1_1.setBounds(160, 235, 150, 13);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel(pageProduto.getCor());
		lblNewLabel_2_1_2.setBounds(160, 258, 150, 13);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel(pageProduto.getDimensoes());
		lblNewLabel_2_1_3.setBounds(160, 281, 150, 13);
		contentPane.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel(pageProduto.getConsumoDeEnergia());
		lblNewLabel_2_1_4.setBounds(160, 304, 150, 13);
		contentPane.add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_2_1_5 = new JLabel(Integer.toString(pageProduto.getQuantidadeVendida()));
		lblNewLabel_2_1_5.setBounds(160, 327, 150, 13);
		contentPane.add(lblNewLabel_2_1_5);
		
		JLabel lblNewLabel_2_1_6 = new JLabel(Integer.toString(pageProduto.getEstoque()));
		lblNewLabel_2_1_6.setBounds(160, 350, 150, 13);
		contentPane.add(lblNewLabel_2_1_6);
		
		JLabel lblNewLabel_3 = new JLabel("Preço:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(274, 216, 93, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(Double.toString(pageProduto.getPreco()));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(371, 216, 126, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Digite aqui a quantidade que deseja comprar:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(242, 258, 286, 13);
		contentPane.add(lblNewLabel_5);
		
		
		JSpinner inputQuantidade = new JSpinner();
		inputQuantidade.setBounds(526, 255, 30, 20);
		contentPane.add(inputQuantidade);

		JButton btnNewButton = new JButton("Comprar");
		btnNewButton.setBounds(320, 311, 126, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeAdm screenHomeAdmin = new HomeAdm(meuCliente);
				dispose();
				screenHomeAdmin.setVisible(true);
				screenHomeAdmin.setTitle("TechNew (Home)");
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int teste = Integer.parseInt(inputQuantidade.getValue().toString());
				try {
					if(teste >= 1) {
						CompraController compraController = new CompraController();
						Compra produtoCompra = new Compra(meuCliente.getIdCliente(), produtoId, teste);
						
						JOptionPane.showMessageDialog(btnNewButton, "Parabéns sua Compra foi realizada com Sucesso!!");						
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Verifique o valor no campo de quantidade que você deseja comprar");												
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(btnNewButton, ex.getMessage());					
				}
			}
		});
	}
}
