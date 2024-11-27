package controle.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.w3c.dom.Text;

import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.enumerador.Categoria;
import visao.RoundButton;
import visao.Funcionário.TelaAlteracaoP;
import visao.Funcionário.TelaGerenciamentoP;

public class AlteracaoPControle {
	private TelaAlteracaoP viewP;
	private Funcionario f;
	private Produto p;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private RoundButton btLimpa1;
	private RoundButton btSalvar;
	private RoundButton btCancelar;

	
	public AlteracaoPControle(Funcionario f, Produto p){
		this.f = f;
		viewP = new TelaAlteracaoP(p,f);
		viewP.setVisible(true);
		listerners();
		
	}

	private void listerners() {
		viewP.addAlteracaoPListener(new  AlterarPListener());
	}
	
	public class AlterarPListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "btLimpa1":
				limpar();

//				btLimpa1.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						txtNome.setText("");
//						txtQuantidade.setText("");
//						txtPreco.setText("");
//					}
//				});
//				metodoLimpar();
				break;
			case "btSalvar":
				salvar();
//				btSalvar.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						String nome = null;
//						float preco = 0;
//						int quantidade = 0;
//						Categoria categoria = null;
//						try {
//							nome = txtNome.getText();
//							preco = Float.parseFloat(txtPreco.getText());
//							quantidade = Integer.parseInt(txtQuantidade.getText());
//							categoria = (Categoria) cbCategoria.getSelectedItem();
//						} catch (Exception e1) {
//							e1.printStackTrace();
//						}
//						if (txtNome.getText().isEmpty() || txtPreco.getText().isEmpty() || txtQuantidade.getText().isEmpty()) {
//							JOptionPane.showMessageDialog(null, "Todos os campos precisam ser preenchidos");
//						} else {
//							try {
//								alterarProduto(p, nome, preco, quantidade, categoria);
//								TelaGerenciamentoP telaGerenciamentoP = new TelaGerenciamentoP(telaA, f);
//								dispose();
//								telaGerenciamentoP.setVisible(true);
//								JOptionPane.showMessageDialog(null, "Alteração feita com sucesso");
//							} catch (SQLException e1) {
//								e1.printStackTrace();
//								JOptionPane.showMessageDialog(null, "Não foi possivel alterar esse produto");
//							}
//						}
//					}
//				});
//				metodoSalvarr();
				break;
			case "btCancelar":
				cancelar();
//				btCancelar.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						TelaGerenciamentoP telaE = new TelaGerenciamentoP(telaA, f);
//						dispose();
//						telaE.setVisible(true);
//					}
//				});
//				metodoCancelar
			default:
				break;
				
			}
//			if ("btLimpa1".equals(e.getActionCommand())) {
//				limparCampos();
//			}
//			else if ("btLimpa2".equals(e.getActionCommand())) {
//				limparCampos();
//			}
//			else if("btLimpa3".equals(e.getActionCommand())) {
//				limparCampos();
//			}
//			else if ("btSalvar".equals(e.getActionCommand())) {
//				salvarP;
//			}
//			else if ("btCancelar".equals(e.getActionCommand())) {
//				cancelarP;
			}

		private void limpar() {
		}
		private void salvar() {			
		}
		private void cancelar() {			
		}

		}

	}


