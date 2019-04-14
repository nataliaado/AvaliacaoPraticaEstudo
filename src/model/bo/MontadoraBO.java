package model.bo;

import java.util.ArrayList;

import model.dao.MontadoraDAO;
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

		// TODO implementar as regras do item 1.c (c.1, c.2 e c.3) da avaliação

		return mensagem;
	}
}
