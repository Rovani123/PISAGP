package controle;

import java.sql.SQLException;
import modelo.dao.VendaDAO;

public class VendaControle {
	public void cadastrarVenda(int idFuncionario,int idCliente,String metodoPagamento,float total) throws SQLException {
		VendaDAO dao = new VendaDAO();
		dao.cadastrarVenda(idFuncionario, idCliente, metodoPagamento, total);
	}	
	public int getIdVenda() {
		VendaDAO dao = new VendaDAO();
		return dao.getIdVenda();
	}

}
