package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ProdutoController;
import entities.Cliente;
import entities.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeletarProduto extends JFrame {

	private JPanel contentPane;
	
//	private void carregarTabela() {
//		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
//		modelo.setNumRows(0);
//		
//		table.getColumnModel().getColumn(0);
//		table.getColumnModel().getColumn(1);
//		table.getColumnModel().getColumn(2);
//		
//		ProdutoController produtoController = new ProdutoController();
//		
//		try {
//			for(Produto p: produtoController.handleReadProduto()) {
//				modelo.addRow(new Object[] {
//					p.getNome(),
//					p.getPreco(),
//					p.getEstoque(),
//				});
//			}
//		} catch (Exception ex) {
//			JOptionPane.showMessageDialog(null, ex.getMessage());
//		}
//	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarProduto frame = new DeletarProduto(null);
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
	public DeletarProduto(Cliente clienteLogin) {
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
		
		JLabel lblNewLabel = new JLabel("Aperte no produto e ele será deletado automaticamente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 11, 397, 22);
		contentPane.add(lblNewLabel);
		
	}

}
