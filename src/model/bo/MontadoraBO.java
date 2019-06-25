package model.bo;

import java.util.ArrayList;

import model.dao.CarroDAO;
import model.dao.MontadoraDAO;
import model.vo.Carro;
import model.vo.Montadora;

public class MontadoraBO {

	public ArrayList<Montadora> consultarMontadoras() {
		MontadoraDAO mDAO = new MontadoraDAO();
		return mDAO.listarTodas();
	}

	/**
	 * Montadora só pode ser excluída se não possuir nenhum carro associado.
	 * 
	 * @param montadoraSelecionada
	 * @return String uma mensagem, dentre as seguintes possibilidades:
	 * 	       1 - "Montadora não pode ser excluída, pois possui carros";
	 * 	       2 - "Excluída com sucesso";
	 *         3 - "Erro ao excluir montadora".
	 *          
	 */
	public String excluirMontadora(Montadora montadoraSelecionada) {
		String mensagem = "";

		CarroDAO cDAO = new CarroDAO();
		// implementar as regras do item 1.c (c.1, c.2 e c.3) da avaliação
		ArrayList<Carro> carrosDaMontadoraSelecionada = cDAO.listarPorMontadora(montadoraSelecionada);
		
		if(carrosDaMontadoraSelecionada.isEmpty()) {
			MontadoraDAO mDAO = new MontadoraDAO();
			boolean excluiu = mDAO.excluir(montadoraSelecionada.getId());
			
			if(excluiu) {
				mensagem = "Excluída com sucesso";
			}else {
				mensagem = "Erro ao excluir montadora";
			}
		}else {
			mensagem = "Montadora não pode ser excluída, pois possui carros";
		}
		return mensagem;
	}
}