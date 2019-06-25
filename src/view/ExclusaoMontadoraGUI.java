package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import controller.MontadoraController;
import model.vo.Montadora;

public class ExclusaoMontadoraGUI {

	private JFrame frmExclusaoDeMontadoras;

	private JComboBox cbMontadora;
	private List<Montadora> montadoras;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExclusaoMontadoraGUI window = new ExclusaoMontadoraGUI();
					window.frmExclusaoDeMontadoras.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExclusaoMontadoraGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExclusaoDeMontadoras = new JFrame();
		frmExclusaoDeMontadoras.setTitle("Exclusão de montadoras");
		frmExclusaoDeMontadoras.setBounds(100, 100, 370, 154);
		frmExclusaoDeMontadoras.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExclusaoDeMontadoras.getContentPane().setLayout(null);

		//TODO preencher o combobox com montadoras direto do banco
		cbMontadora = new JComboBox();
		consultarMontadoras();
		
		cbMontadora.setBounds(10, 40, 350, 27);
		frmExclusaoDeMontadoras.getContentPane().add(cbMontadora);

		JLabel lblSelecioneUmaMontadora = new JLabel("Selecione uma montadora para excluir:");
		lblSelecioneUmaMontadora.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneUmaMontadora.setBounds(10, 20, 350, 20);
		frmExclusaoDeMontadoras.getContentPane().add(lblSelecioneUmaMontadora);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//implementar (questão 2 da avaliação
				MontadoraController mc = new MontadoraController();
				
				Montadora montadoraSelecionada = (Montadora) cbMontadora.getSelectedItem();
				String mensagem = mc.excluirMontadora(montadoraSelecionada);
				
				//Mostrar mensagem após chamar a exclusão (sucesso/erro)
				JOptionPane.showMessageDialog(null, mensagem);
				
				//Atualizar o combo de montadoras após excluir
				consultarMontadoras();
			}
		});
		btnExcluir.setBounds(120, 70, 120, 30);
		frmExclusaoDeMontadoras.getContentPane().add(btnExcluir);
	}
	
	private void consultarMontadoras() {
		//Consulta as montadoras cadastradas no banco (item 1.b)
		MontadoraController mc = new MontadoraController();

		//Preencher o resultado na lista "montadoras"
		montadoras = mc.consultarMontadoras();
		
		cbMontadora.setModel(new DefaultComboBoxModel(montadoras.toArray()));
		cbMontadora.setSelectedIndex(-1);
	}
}
