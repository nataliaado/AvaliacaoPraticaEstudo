package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.CarroController;
import controller.MontadoraController;
import model.vo.Carro;
import model.vo.Montadora;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * Tela de listagem de carros (item 1 da avaliação)
 * 
 */
public class ConsultaCarrosGUI {

	private JFrame frmConsultaCarros;
	private JTextField txtPlaca;
	private JComboBox cbMontadora;
	private List<Montadora> montadoras;
	private JTable tblCarros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCarrosGUI window = new ConsultaCarrosGUI();
					window.frmConsultaCarros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultaCarrosGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		frmConsultaCarros = new JFrame();
		frmConsultaCarros.setTitle("Consulta de carros");
		frmConsultaCarros.setBounds(100, 100, 520, 215);
		frmConsultaCarros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultaCarros.getContentPane().setLayout(null);

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(6, 20, 44, 15);
		frmConsultaCarros.getContentPane().add(lblPlaca);

		JLabel lblNivel = new JLabel("Montadora");
		lblNivel.setBounds(149, 20, 76, 15);
		frmConsultaCarros.getContentPane().add(lblNivel);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(46, 13, 90, 28);
		frmConsultaCarros.getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);

		this.consultarMontadoras(); 
		cbMontadora = new JComboBox();
		cbMontadora.setModel(new DefaultComboBoxModel(montadoras.toArray()));

		//Inicia sem nada selecionado no combo
		cbMontadora.setSelectedIndex(-1);

		cbMontadora.setBounds(223, 14, 165, 28);
		frmConsultaCarros.getContentPane().add(cbMontadora);

		JButton btnConsultarCarros = new JButton("Consultar");
		btnConsultarCarros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarroController controller = new CarroController();
				ArrayList<Carro> carros = controller.consultarCarros(txtPlaca.getText(), 
						(Montadora) cbMontadora.getSelectedItem());

				atualizarTabelaCarros(carros);
			}
		});
		btnConsultarCarros.setBounds(387, 13, 125, 30);
		frmConsultaCarros.getContentPane().add(btnConsultarCarros);

		//Novo componente: tabela
		tblCarros = new JTable();
		tblCarros.setVisible(true);

		//Cria a tabela vazia apenas com as colunas
		tblCarros.setModel(new DefaultTableModel(
				new Object[][] {
					{"Placa", "Modelo", "Montadora", "Ano", "Valor"}
				},
				new String[] {
						"Placa", "Modelo", "Montadora", "Ano", "Valor"
				}
				));

		tblCarros.setBounds(6, 47, 506, 140);
		frmConsultaCarros.getContentPane().add(tblCarros);
	}

	/**
	 * Atualiza o JTable de carros.
	 * @param carros a lista de carros que irá popular a tabela;
	 */
	protected void atualizarTabelaCarros(ArrayList<Carro> carros) {
		//Cria a tabela vazia apenas com as colunas
		tblCarros.setModel(new DefaultTableModel(
				new Object[][] {
					{"Placa", "Modelo", "Montadora", "Ano", "Valor"}
				},
				new String[] {
						"Placa", "Modelo", "Montadora", "Ano", "Valor"
				}
				));

		DefaultTableModel model = (DefaultTableModel) tblCarros.getModel();

		Object novaLinha[] = new Object[5];
		for(Carro carro: carros){
			novaLinha[0] = carro.getPlaca();
			novaLinha[1] = carro.getModelo();
			novaLinha[2] = carro.getMontadora().getNome();
			novaLinha[3] = carro.getAno();
			novaLinha[4] = "R$" + String.valueOf(carro.getValor()).replace(".", ",");

			model.addRow(novaLinha);
		}
	}

	private void consultarMontadoras() {
		//Consulta as montadoras cadastradas no banco (item 1.b)
		MontadoraController mc = new MontadoraController();
		montadoras = mc.consultarMontadoras();
	}
}