package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public abstract class AjustaPreco {
	
	public abstract double getLimitedetaxadeacrescimo();

	public abstract double getTaxadeacrescimo();

	public abstract int getLimiteacrescimoduracao();

	public abstract double getTaxaacrescimoduracao();

	public BigDecimal calculaPrecoAjustado(Sessao sessao, double percentualDeDisponiveis) {
		BigDecimal preco;
		if(percentualDeDisponiveis <= getLimitedetaxadeacrescimo()) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(getTaxadeacrescimo())));
		} else {
			preco = sessao.getPreco();
		}
		
		if(sessao.getDuracaoEmMinutos() > getLimiteacrescimoduracao()){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(getTaxaacrescimoduracao())));
		}
		
		return preco;
	}

	public static AjustaPreco getInstace(TipoDeEspetaculo tipoDeEspetaculo) {
		
		switch (tipoDeEspetaculo) {
		case BALLET : return new AjustaPrecoBallet();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
