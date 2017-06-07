package br.com.correios.estimativa;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Classe que representa uma estimativa calculada pelo servico do Correios
 * que possui <b>somente o prazo</b> da encomenda
 *
 * @since 0.0.17-BETA
 */
public class EstimativaComPrazo {

	/**
	 * Codigo do Servico de Entrega.
	 */
	private String codigoServico;

	/**
	 * Prazo estimado em dias para entrega do produto.
	 * Se o valor retornado for 0 (zero), indica que o prazo nao foi retornado corretamente.
	 * Mas nesso modelo use {@link #isEstimativaValida()} para validar se a estimativa esta valida
	 */
	private Integer prazoEntrega;

	/**
	 * Informa se a localidade informada possui entrega domiciliaria.
	 * Se o prazo nao for retornado corretamente, o retorno deste parametro sera vazio.
	 */
	private boolean entregaDomiciliar;

	/**
	 * Informa se a localidade informada possui entrega domiciliaria aos sabados.
	 * Se o prazo nao for retornado corretamente, o retorno deste parametro sera vazio.
	 */
	private boolean entregaAosSabados;

	/**
	 * Codigo do Erro retornado pelo calculador
	 */
	private String codigoErro;

	/**
	 * Descricao do erro gerado.
	 */
	private String mensagemErro;

	public String getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(String codigoServico) {
		this.codigoServico = codigoServico;
	}

	public Integer getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Integer prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public boolean isEntregaDomiciliar() {
		return entregaDomiciliar;
	}

	public void setEntregaDomiciliar(boolean entregaDomiciliar) {
		this.entregaDomiciliar = entregaDomiciliar;
	}

	public boolean isEntregaAosSabados() {
		return entregaAosSabados;
	}

	public void setEntregaAosSabados(boolean entregaAosSabados) {
		this.entregaAosSabados = entregaAosSabados;
	}

	public String getCodigoErro() {
		return codigoErro;
	}

	public void setCodigoErro(String codigoErro) {
		this.codigoErro = codigoErro;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	/**
	 * @return se uma estimativa esta valida, ou seja, nao possui nenhum erro
	 * retornado pelo calculador
	 */
	public boolean isEstimativaValida() {
		return StringUtils.isBlank(codigoErro) || "0".equals(codigoErro);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
