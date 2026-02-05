package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(filme.getValor());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = DataUtils.incrementarQntDias(1, dataEntrega);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.
		
		return locacao;
	}

	public static void main(String[] args) {
		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Joao");
		Filme filme = new Filme("Titulo1", 1, 10.00);
		
		// ação
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//verificação
		//System.out.println(locacao.getValorLocacao() == 10.00);
		//System.out.println(DataUtils.boDatasIguais(locacao.getDataLocacao(), new Date()));
		//System.out.println(DataUtils.boDatasIguais(locacao.getDataRetorno(), DataUtils.incrementarQntDias(1)));
		
		// exercicio
		// nome do usuario
		System.out.println(usuario.getNome() == "Joao");
		
		//titulo do filme
		System.out.println(filme.getTitulo() == "Titulo1");
		
		//estoque do filme
		System.out.println(filme.getEstoque() == 1);
		
	}
}