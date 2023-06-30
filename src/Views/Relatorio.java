package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CompraController;
import entities.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Relatorio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio frame = new Relatorio(null);
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
	public Relatorio(Cliente clienteLogin) {
		Cliente meuCliente;
		{
			meuCliente = clienteLogin;
		}
		CompraController compraController = new CompraController();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Relatório da loja");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(93, 11, 248, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Melhor cliente:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(58, 132, 134, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Produto mais vendido:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(21, 96, 171, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Produto menos vendido:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(11, 78, 181, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total de vendas do mês:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 114, 182, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(compraController.handleGetProductWithMoreOrLessSales(0));
		lblNewLabel_5.setBounds(201, 79, 184, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel(compraController.handleGetProductWithMoreOrLessSales(1));
		lblNewLabel_5_1.setBounds(201, 96, 184, 14);
		contentPane.add(lblNewLabel_5_1);
		
//		Metodo Com defeito
		try {
			String totalMensal = Integer.toString(compraController.handleTotalSalesPerMonth());			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Não foi possivel obter essa informação");
		lblNewLabel_5_1_1.setBounds(201, 114, 184, 14);
		contentPane.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel(compraController.handleGetBetterClient());
		lblNewLabel_5_1_1_1.setBounds(201, 132, 184, 14);
		contentPane.add(lblNewLabel_5_1_1_1);
		
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
