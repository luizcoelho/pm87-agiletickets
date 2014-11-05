package br.com.caelum.agiletickets.domain.precos;



public class AjustaPrecoBallet extends AjustaPreco {

	private static final double limiteDeTaxaDeAcrescimo = 0.50;
	private static final double taxaDeAcrescimo = 0.20;
	private static final int limiteAcrescimoDuracao = 60;
	private static final double taxaAcrescimoDuracao = 0.10;
	
	public double getLimitedetaxadeacrescimo() {
		return limiteDeTaxaDeAcrescimo;
	}

	public double getTaxadeacrescimo() {
		return taxaDeAcrescimo;
	}

	public  int getLimiteacrescimoduracao() {
		return limiteAcrescimoDuracao;
	}

	public double getTaxaacrescimoduracao() {
		return taxaAcrescimoDuracao;
	}
	
	

}
