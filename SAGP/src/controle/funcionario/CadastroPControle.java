package controle.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import modelo.classes.Funcionario;
import modelo.dao.ProdutoDAO;
import modelo.enumerador.Categoria;
import visao.Funcionário.TelaCadastroP;
import visao.TelasDeAviso.MensagemView;

public class CadastroPControle {
	private TelaCadastroP view;
	private Funcionario f;
	private String nome;
	private float preco;
	private int quantidade;
	private Categoria categoria;
	private FileInputStream fin;
	
	public CadastroPControle(Funcionario f) {
		this.f = f;
		view = new TelaCadastroP(f);
		view.setVisible(true);
		listeners();
	}
	
	private class CadastroPListeners implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "btSalvar":
				Salvar();
				break;
			case "btFile":
				Imagem();
				break;
			case "btLimpa":
				view.limpar();
				break;
			case"btCancelar":
				new GerenciamentoPControle(f);
				view.dispose();
				break;
			}
		}
		
	}
	
	private void listeners() {
		view.addCadastroP(new CadastroPListeners());
	}
	
	private void Salvar() {
		try {
		nome = view.getNome();
		preco = Float.parseFloat(view.getPreco());
		quantidade = Integer.parseInt(view.getQuantidade());
		categoria = view.getCategoria();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (nome.isEmpty() || preco ==0 || quantidade ==0) {
			//Todos os campos precisam ser preenchidos
	} else {
		try {
			new ProdutoDAO().cadastrarProduto(nome, preco, quantidade, categoria.toString(), fin);
			view.dispose();
			new GerenciamentoPControle(f);
			new MensagemView("Produto cadastrado com sucesso!",3);
		} catch (SQLException e) {
			e.printStackTrace();
			new MensagemView("Não foi possivel adicionar esse produto",0);

		}
	}
	}
	
	private void Imagem() {
		JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                fin = new FileInputStream(selectedFile);
                if(fin ==null) {
                	//Não foi possivel colocar a imagem
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
	}

}
