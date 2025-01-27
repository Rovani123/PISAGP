package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import controle.funcionario.GerenciamentoPControle;
import controle.inicio.TelaInicialControle;
import modelo.classes.Funcionario;
import modelo.classes.Vendas;
import modelo.dao.CarrinhoDAO;
import modelo.dao.VendaDAO;
import modelo.tableModel.CarrinhoTableModel;
import modelo.tableModel.VendasTableModel;
import visao.Administrador.TelaAnáliseVendas;
import visao.TelasDeAviso.MensagemView;
import visao.TelasDeAviso.MensagemViewProdutos;

public class AnaliseVendasControle {
	private TelaAnáliseVendas view;
	private Funcionario f;
	
	public AnaliseVendasControle (Funcionario f) {
		this.f =f;
		view = new TelaAnáliseVendas(f);
		view.setVisible(true);
		listeners();
	}
	

	private class AnaliseVendas implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				case"mVoltar":
					view.dispose();
					new TelaInicialControle(f);
					break;
				case"mGFuncionarios":
					view.dispose();
					new GerenciamentoFControle(f);
					break;
				case"mFuncionario":
					view.dispose();
					new GerenciamentoPControle(f);
					break;
				case"btPesquisar":
					view.filtrarRegistros();
					break;
			}
		}
	}
	
	private class TabelaMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				Vendas v=view.getItemTabela();
				try {
					CarrinhoTableModel model = new CarrinhoTableModel(new CarrinhoDAO().getCarrinhos(v));
					new MensagemViewProdutos(v, model);
				} catch (IOException e1) {
					new MensagemView("Erro ao conectar com o banco de dados",0);
				}
			}
		}
	}
	
	
	private void listeners() {
		view.addAnaliseVendas(new AnaliseVendas());
		view.addTabelaListeners(new TabelaMouseListener());
		view.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				carregarDados();
			}
		});		
	}
	
	private void carregarDados() {
		VendasTableModel model = new VendasTableModel(new VendaDAO().getVendas());
		view.setTabela(model);
		view.rowsorter(model);
	}
}