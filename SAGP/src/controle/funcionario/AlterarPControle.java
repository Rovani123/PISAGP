package controle.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import modelo.classes.Funcionario;
import modelo.classes.Produto;
import modelo.dao.ProdutoDAO;
import visao.Funcionário.TelaAlteracaoP;
import visao.TelasDeAviso.MensagemView;

public class AlterarPControle {
	private TelaAlteracaoP view;
	private Funcionario f;
	private Produto p;
	private FileInputStream fin;
	
	public AlterarPControle(Funcionario f, Produto p){
		this.f = f;
		this.p =p;
		view = new TelaAlteracaoP(p,f);
		view.setVisible(true);
		listerners();
		
	}

	private void listerners() {
		view.addAlteracaoPListener(new  AlterarPListener());
		view.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				view.setCampos(p);
				try {
			        BufferedImage bufferedImage = new BufferedImage(p.getFoto().getWidth(null), p.getFoto().getHeight(null), BufferedImage.TYPE_INT_ARGB);
			        bufferedImage.getGraphics().drawImage(p.getFoto(), 0, 0, null);
			        ByteArrayOutputStream baos = new ByteArrayOutputStream();
			        ImageIO.write(bufferedImage, "png", baos);
			        baos.flush();
			        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			        java.io.File tempFile = java.io.File.createTempFile("tempImage", ".png");
			        java.nio.file.Files.copy(bais, tempFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
			        fin = new FileInputStream(tempFile);
				} catch (Exception e2) {
					new MensagemView("Erro ao Definir a imagem do produto!",2);
				}
			}
		});
	}
	
	private class AlterarPListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "btLimpa":
				view.limpa();
				break;
			case "btSalvar":
				salvar();
				break;
			case"btSelecionarFoto":
				Imagem();
				break;
			case "btCancelar":
				cancelar();
			}
		}
	}
	
	private void salvar() {
		p.setNomeProduto(view.getNome());
		p.setPreco(Float.parseFloat(view.getPreco()));
		p.setQuantidadeEstoque(Integer.parseInt(view.getQuantidade()));
		p.setCategoria(view.getCategoria());
		try {
			new ProdutoDAO().alterarProduto(p,fin);
			view.dispose();
			new GerenciamentoPControle(f);
			new MensagemView("Produto alterado com sucesso!",3);
		} catch (SQLException e) {
			new MensagemView("não foi possível alterar esse produto!",0);
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
                	new MensagemView("Não foi possivel colocar a imagem", 0);
                }
            } catch (IOException e1) {
            	new MensagemView("Não foi possivel colocar a imagem", 0);
            }
        }
	}
	
	private void cancelar() {
		view.dispose();
		new GerenciamentoPControle(f);
	}

}


