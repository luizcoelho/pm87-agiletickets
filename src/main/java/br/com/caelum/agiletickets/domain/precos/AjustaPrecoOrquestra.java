package br.com.caelum.agiletickets.domain.precos;



public class AjustaPrecoOrquestra extends AjustaPreco {

	private static final double limiteDeTaxaDeAcrescimo = 0.50;
	private static final double taxaDeAcrescimo = 0.20;
	private static final int limiteAcrescimoDuracao = 60;
	private static final double taxaAcrescimoDuracao = 0.10;
	
	@Override
	public double getLimitedetaxadeacrescimo() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getTaxadeacrescimo() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getLimiteacrescimoduracao() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getTaxaacrescimoduracao() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
