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
import javax.swing.JOptionPane;

import modelo.classes.Funcionario;
import modelo.enumerador.Categoria;
import visao.Funcionário.TelaCadastroP;

public class CadastroPControle {
	private TelaCadastroP tcp;
	private Funcionario f;
	private String nome;
	private float preco;
	private int quantidade;
	private Categoria categoria;
	private Image imagemProduto;
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
				salvar();
				break;
			}
		}
		
	}
	
	private void listeners() {
		tcp.addCadastroP(new CadastroPListeners());
	}
	
	private void salvar() {
		try {
		nome = tcp.getNome();
		preco = Float.parseFloat(tcp.getPreco());
		quantidade = Integer.parseInt(tcp.getQuantidade());
		categoria = tcp.getCategoria();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (nome.isEmpty() || preco ==0 || quantidade ==0) {
			//Todos os campos precisam ser preenchidos
	} else {
		try {
			
			cadastrarProduto(nome, preco, quantidade, categoria.toString(),fin);
			tcp.dispose();
			telaGerenciamentoP.setVisible(true);
			//Produto cadastrado com sucesso
		} catch (SQLException e) {
			e.printStackTrace();
			//Não foi possivel adicionar esse produto

		}
	}
	}
	
	private void imagem() {
		JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                imagemProduto = ImageIO.read(selectedFile);
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
