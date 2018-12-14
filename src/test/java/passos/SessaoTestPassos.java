package passos;



import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stefanini.desafio.model.Filme;
import com.stefanini.desafio.model.Sala;
import com.stefanini.desafio.model.Sessao;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class SessaoTestPassos  {


	private Sala sala;
	private Filme filme;
	private BigDecimal somaDosPrecosDaSalaEFilme;
	private Sessao sessao;
	
    private final Logger log = LoggerFactory.getLogger(SessaoTestPassos.class);

	
	@Dado("^que as sala tem nome \"(.*?)\" e preco \"(.*?)\"$")
	public void que_as_sala_tem_nome_e_preco(String nome, String preco) throws Throwable {
		//sala = new Sala(nome, new BigDecimal(preco));
	}

	@Dado("^que o filme possui nome \"(.*?)\" e duracao de (\\d+) e genero \"(.*?)\" e preco \"(.*?)\"$")
	public void que_o_filme_possui_nome_e_duracao_de_e_genero_e_preco(String nome, int duracao, String genero, String preco) throws Throwable {
	//	filme = new Filme(nome,duracao+"",  
	 //            genero, new BigDecimal(preco));	   
	}


	@Dado("^o horario da sessao \"(.*?)\" e filme e sala$")
	public void o_horario_da_sessao_e_filme_e_sala(String horario) throws Throwable {
	//	 sessao = new Sessao(horario, filme, sala);
	}

	@Entao("^o preco da sessao deve ser igual a soma da sala e filme$")
	public void o_preco_da_sessao_deve_ser_igual_a_soma_da_sala_e_filme() throws Throwable {
		somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
		assertEquals( "O preco da sessao esta incorreto",somaDosPrecosDaSalaEFilme , sessao.getPreco() );
	}
	
}
