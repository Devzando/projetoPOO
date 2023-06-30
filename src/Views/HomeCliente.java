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

public class HomeCliente extends JFrame {
	private JTable table;
	
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
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(386, 71, 109, 29);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 156, 402, 245);
		getContentPane().add(scrollPane);
		
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
					screenPageProduto.setTitle("Weijinto - TechNew (Home)");					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Não foi possivel acessar a pagina deste produto");
				}
			}
		});
		carregarTabela();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha um dos produtos citados abaixo para ver as especificações e efetuar a compra");
		lblNewLabel_1.setBounds(192, 108, 498, 13);
		getContentPane().add(lblNewLabel_1);
	}
}
