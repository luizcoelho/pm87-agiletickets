package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		
		int ingressosDisponiveis = sessao.getTotalIngressos() - sessao.getIngressosReservados();
		double percentualDeDisponiveis = ingressosDisponiveis / sessao.getTotalIngressos().doubleValue();
		
		if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.CINEMA) || sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.SHOW)) {
			//quando estiver acabando os ingressos... 
			preco = calculaPrecoAjustado(sessao, percentualDeDisponiveis, 0.05, 0.10);
		} else if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.BALLET)) {
			
			AjustaPreco ajustaPreco = AjustaPreco.getInstace(TipoDeEspetaculo.BALLET);
			
			preco = ajustaPreco.calculaPrecoAjustado(sessao, percentualDeDisponiveis);
			
		} else if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.ORQUESTRA)) {
			
			preco = calculaPrecoAjustado(sessao, percentualDeDisponiveis, 0.50, 0.20);

			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
		}  else {
			//nao aplica aumento para teatro (quem vai é pobretão)
			preco = sessao.getPreco();
		} 

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal calculaPrecoAjustado(Sessao sessao,
			double percentualDeDisponiveis, double limiteDeTaxaDeAcrescimo, double taxaDeAcrescimo) {
		BigDecimal preco;
		if(percentualDeDisponiveis <= limiteDeTaxaDeAcrescimo) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(taxaDeAcrescimo)));
		} else {
			preco = sessao.getPreco();
		}
		return preco;
	}

}