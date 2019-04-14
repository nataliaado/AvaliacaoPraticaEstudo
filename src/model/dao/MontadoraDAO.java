package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Banco;
import model.vo.Montadora;

public class MontadoraDAO {

	/**
	 * Cria uma nova montadora
	 * @param m a nova montadora
	 * @return 1 caso tenha sucesso, 0 caso contrário.
	 */
	public int inserir(Montadora m) {
		int idInserido = -1;
		String sql = "INSERT INTO MONTADORA(NOME, PAIS, CNPJ) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = Banco.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			// Preenche a consulta com os atributos do objeto
			ps.setString(1, m.getNome());
			ps.setString(2, m.getPais());
			ps.setString(3, m.getCnpj());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				idInserido = rs.getInt(1);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar montadora. Erro: " + e.getMessage());
		}

		return idInserido;
	}

	/**
	 * Exclui uma montadora.
	 * @param id a chave primária da montadora selecionada
	 * @return true caso sucesso na exclusão, false caso contrário.
	 */
	public boolean excluir(int id) {
		boolean removidoSucesso = false;
		String sql = "DELETE FROM MONTADORA WHERE ID = ?";

		try {
			PreparedStatement ps = Banco.getConnection().prepareStatement(sql);
			ps.setInt(1, id);

			int codigoRetorno = ps.executeUpdate();
			if (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				removidoSucesso = true;
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return removidoSucesso;
	}

	public boolean atualizar(Montadora m) {
		boolean atualizadoSucesso = false;
		String sql = "UPDATE MONTADORA SET NOME=?, PAIS=?, CNPJ=? WHERE ID=?";

		try {
			PreparedStatement instrucaoSQL = Banco.getConnection().prepareStatement(sql);
			instrucaoSQL.setString(1, m.getNome());
			instrucaoSQL.setString(2, m.getPais());
			instrucaoSQL.setString(3, m.getCnpj());
			instrucaoSQL.setInt(4, m.getId());

			int codigoRetorno = instrucaoSQL.executeUpdate();
			atualizadoSucesso = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar montadora. Erro: " + e.getMessage());
		}
		return atualizadoSucesso;
	}



	public Montadora consultarPorId(int idMontadora) {
		Montadora m = null;

		String sql = " SELECT * FROM MONTADORA WHERE ID=? ";

		PreparedStatement stmt;
		try {
			stmt = Banco.getConnection().prepareStatement(sql);
			stmt.setInt(1, idMontadora);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				m = this.construirMontadoraDoResultSet(rs);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar montadora por id. Erro: " + e.getMessage());
		}

		return m;
	}

	public ArrayList<Montadora> listarTodas() {
		ArrayList<Montadora> montadoras = new ArrayList<Montadora>();

		String sql = "SELECT * FROM MONTADORA";

		try {
			PreparedStatement instrucaoSQL = Banco.getConnection().prepareStatement(sql);
			ResultSet resultadoConsulta = instrucaoSQL.executeQuery();

			while (resultadoConsulta.next()) {
				// Cria uma nova montadora para cada item retornado no resultSet
				// Usa como chave o nome da coluna na tabela
				Montadora m = construirMontadoraDoResultSet(resultadoConsulta);
				montadoras.add(m);
			}

		} catch (SQLException e) {
			System.out.println("Erro listar todas as montadoras. Erro: " + e.getMessage());
		}

		return montadoras;
	}

	/**
	 * Verifica se existe carro da montadora informada cadastrado no banco.
	 * 
	 * @param idMontadora a chave da montadora, que é a chave estrangeira no carro (ID_MONTADORA)
	 * @return true caso exista carro da montadora, false caso contrário.
	 * 
	 */
	public boolean montadoraTemCarroCadastrado(int idMontadora) {
		boolean temCarroDaMontadora = false;

		//TODO implementar (item 2.c)

		return temCarroDaMontadora;
	}

	private Montadora construirMontadoraDoResultSet(ResultSet resultadoConsulta) {
		Montadora m = null;

		try {
			m = new Montadora();
			m.setId(resultadoConsulta.getInt("id"));
			m.setNome(resultadoConsulta.getString("nome"));
			m.setPais(resultadoConsulta.getString("pais"));
			m.setCnpj(resultadoConsulta.getString("cnpj"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return m;
	}
}