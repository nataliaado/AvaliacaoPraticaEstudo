package controller;

import java.util.ArrayList;

import model.bo.MontadoraBO;
import model.vo.Montadora;

public class MontadoraController {
	
	public ArrayList<Montadora> consultarMontadoras(){
		MontadoraBO bo = new MontadoraBO();
		return bo.consultarMontadoras();
	}
	
	
	/**
	 * Exclui uma montadora selecionada
	 * @param montadoraSelecionada
	 * @return String uma mensagem:
	 * 		 - Caso a montadora não foi selecionada: "selecione uma montadora"
	 *  	 - Caso contrário: uma mensagem devolvida pelo BO 
	 */
	public String excluirMontadora(Montadora montadoraSelecionada) {
		//implementar (itens 2.c e 2.d da avaliação)
		String mensagem = "";
		
		if(montadoraSelecionada == null) {
			mensagem = "Selecione uma montadora";
		}else {
			MontadoraBO bo = new MontadoraBO();
			mensagem = bo.excluirMontadora(montadoraSelecionada);
		}
		
		return mensagem;
	}
}
