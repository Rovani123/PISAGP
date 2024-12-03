package controle.administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controle.inicio.TelaInicialControle;
import modelo.classes.Funcionario;
import modelo.dao.FuncionarioDAO;
import visao.Administrador.TelaGerenciamentoF;

public class GerenciamentoFControle {
	private TelaGerenciamentoF tgf;
	private Funcionario f;
	
	public GerenciamentoFControle(Funcionario f) {
		this.f =f;
		tgf = new TelaGerenciamentoF(f);
		tgf.setVisible(true);
		listeners();
		
	}
	
	private class GerenciamentoFListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "mVoltar":
				new TelaInicialControle();
				break;
			case "btRemover":
				remover();
				break;
			}
		}
	}
	private void listeners() {
		tgf.addGerenciamentoFListener(new GerenciamentoFListeners());
		tgf.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				
			}
		});
	}
	
	private void remover() {
		Funcionario f =tgf.getItemTabela();
		FuncionarioDAO dao = new FuncionarioDAO();
		
	}
}
