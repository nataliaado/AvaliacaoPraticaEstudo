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

import model.vo.Carro;
import model.vo.Montadora;

/**
 * 
 * Tela de listagem de carros (item 1 da avaliação)
 * 
 */
public class ConsultaCarrosGUI {

	private JFrame frmConsultaCarros;
	private JTextField txtNome;
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

		JLabel lblNome = new JLabel("Placa");
		lblNome.setBounds(6, 20, 44, 15);
		frmConsultaCarros.getContentPane().add(lblNome);

		JLabel lblNivel = new JLabel("Montadora");
		lblNivel.setBounds(149, 20, 76, 15);
		frmConsultaCarros.getContentPane().add(lblNivel);

		txtNome = new JTextField();
		txtNome.setBounds(46, 13, 90, 28);
		frmConsultaCarros.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		this.consultarMontadoras(); 
		cbMontadora = new JComboBox();
		cbMontadora.setModel(new DefaultComboBoxModel(montadoras.toArray()));

		//Inicia sem nada selecionado no combo
		cbMontadora.setSelectedIndex(-1);

		cbMontadora.setBounds(223, 14, 165, 28);
		frmConsultaCarros.getContentPane().add(cbMontadora);

		JButton btnConsultarCarros = new JButton("Consultar");
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
		DefaultTableModel model = (DefaultTableModel) tblCarros.getModel();

		Object novaLinha[] = new Object[5];
		for(Carro carro: carros){
			novaLinha[0] = carro.getPlaca();

			//TODO preencher as demais linhas da tabela (modelo, nome da montadora, ano e valor)

			//Preencher o valor formatado no padrão "R$0,00"

			model.addRow(novaLinha);
		}
	}

	private void consultarMontadoras() {
		//TODO consultar as montadoras cadastradas no banco (item 1.b)

		//Preencher o resultado na lista "montadoras"
	}
}