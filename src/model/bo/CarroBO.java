package model.bo;

import java.util.ArrayList;

import model.dao.CarroDAO;
import model.vo.Carro;
import model.vo.Montadora;

public class CarroBO {

	public ArrayList<Carro> consultarCarros(String placa, Montadora montadoraSelecionada) {
		// regras do item 1.c (c.1, c.2 e c.3) da avaliação
		CarroDAO dao = new CarroDAO();
		ArrayList<Carro> carros = new ArrayList<Carro>();
		
		if(placa != null && !placa.isEmpty() && montadoraSelecionada != null) {
			carros = dao.listarPorPlacaEMontadora(placa, montadoraSelecionada);
		}else if(placa != null && !placa.isEmpty()) {
			carros = dao.listarPorPlaca(placa);
		}else if(montadoraSelecionada != null){
			carros = dao.listarPorMontadora(montadoraSelecionada);
		}else {
			carros = dao.listarTodos();
		}	
		return carros;
	}
}
