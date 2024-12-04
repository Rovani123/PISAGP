package controle.funcionario;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import modelo.classes.Funcionario;
import modelo.dao.ProdutoDAO;
import modelo.enumerador.Categoria;
import visao.Funcionário.TelaCadastroP;
import visaoTelasDeAviso.MensagemView;

public class CadastroPControle {
	private TelaCadastroP tcp;
	private Funcionario f;
	private String nome;
	private float preco;
	private int quantidade;
	private Categoria categoria;
	private FileInputStream fin;
	
	public CadastroPControle(Funcionario f) {
		this.f = f;
		tcp = new TelaCadastroP(f);
		tcp.setVisible(true);
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
				tcp.limpar();
				break;
			case"btCancelar":
				new GerenciamentoPControle(f);
				tcp.dispose();
				break;
			}
		}
		
	}
	
	private void listeners() {
		tcp.addCadastroP(new CadastroPListeners());
	}
	
	private void Salvar() {
//		try {
//		nome = tcp.getNome();
//		preco = Float.parseFloat(tcp.getPreco());
//		quantidade = Integer.parseInt(tcp.getQuantidade());
//		categoria = tcp.getCategoria();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		if (nome.isEmpty() || preco ==0 || quantidade ==0) {
			//Todos os campos precisam ser preenchidos
	} else {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.cadastrarProduto(nome, preco, quantidade, categoria.toString(), fin);
			tcp.dispose();
			new GerenciamentoPControle(f);
			new MensagemView("Produto cadastrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			new MensagemView("Não foi possivel adicionar esse produto");

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
