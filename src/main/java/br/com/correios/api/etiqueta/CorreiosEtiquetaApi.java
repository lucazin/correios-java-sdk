package br.com.correios.api.etiqueta;

import static br.com.correios.api.etiqueta.TipoDestinatario.CLIENTE;

import java.util.List;

import com.google.common.base.Optional;

import br.com.correios.api.postagem.CorreiosPostagemApi;
import br.com.correios.api.postagem.adicional.ServicoCorreio;
import br.com.correios.api.postagem.cliente.ClienteEmpresa;
import br.com.correios.api.postagem.cliente.ContratoEmpresa;
import br.com.correios.api.postagem.exception.CorreiosEtiquetaDadosInvalidosException;
import br.com.correios.api.postagem.exception.CorreiosEtiquetaException;
import br.com.correios.api.postagem.webservice.CorreiosClienteApi;
import br.com.correios.api.postagem.webservice.CorreiosClienteWebService;
import br.com.correios.credentials.CorreiosCredenciais;

/**
 * Classe que deve ser usada para as chamadas a API de etiqueta dos Correios
 *
 * @since 0.0.13-BETA
 */
public class CorreiosEtiquetaApi {

	private final CorreiosCredenciais credenciais;
	private final CorreiosClienteApi clienteApi;

	public CorreiosEtiquetaApi(CorreiosCredenciais credenciais) {
		this(credenciais, new CorreiosClienteWebService());
	}

	public CorreiosEtiquetaApi(CorreiosCredenciais credenciais, CorreiosClienteApi clienteApi) {
		this.credenciais = credenciais;
		this.clienteApi = clienteApi;
	}

	public SolicitaEtiquetaBuilder solicita(int quantidadeDeEtiquetas) {
		return new SolicitaEtiquetaBuilder(quantidadeDeEtiquetas);
	}

	public class SolicitaEtiquetaBuilder {

		private final int quantidadeDeEtiquetas;

		public SolicitaEtiquetaBuilder(int quantidadeDeEtiquetas) {
			this.quantidadeDeEtiquetas = quantidadeDeEtiquetas;
		}

		public SolicitaEtiquetaBuilderComIdentificador usandoCodigoDoServicoDeEntrega(String codigoDoServicoDeEntrega) {
			return new SolicitaEtiquetaBuilderComIdentificador(quantidadeDeEtiquetas, codigoDoServicoDeEntrega);
		}

	}

	public class SolicitaEtiquetaBuilderComIdentificador {

		private final Integer quantidade;
		private final String codigoDoServicoDeEntrega;

		public SolicitaEtiquetaBuilderComIdentificador(Integer quantidade, String codigoDoServicoDeEntrega) {
			this.quantidade = quantidade;
			this.codigoDoServicoDeEntrega = codigoDoServicoDeEntrega;
		}

		public List<Etiqueta> comContrato(ContratoEmpresa contrato) {
			try {
				Optional<ClienteEmpresa> clienteOptional = buscaClienteCom(contrato);
				if (!clienteOptional.isPresent()) {
					throw new CorreiosEtiquetaDadosInvalidosException("As informações enviadas de Contrato não retornaram um cliente dos Correios");
				}
				Optional<ServicoCorreio> servicoOptional = clienteOptional.get().getServicoPeloCodigo(codigoDoServicoDeEntrega);
				if (!servicoOptional.isPresent()) {
					throw new CorreiosEtiquetaDadosInvalidosException("As informações enviadas de Contrato não retornaram um servico válido dos Correios");
				}

				String offsetDosCorreios = clienteApi
					.getCorreiosWebService()
					.solicitaEtiquetas(CLIENTE.getCodigoDoDestinatario(), contrato.getCnpj(), servicoOptional.get().getId(), quantidade, credenciais.getUsuario(), credenciais.getSenha());

				return EtiquetaGenerator.geraEtiquetasDo(offsetDosCorreios);
			} catch (Exception e) {
				throw new CorreiosEtiquetaException("Ocorreu um erro ao solicitar Etiquetas para os Correios", e);
			}
		}

	}

	private Optional<ClienteEmpresa> buscaClienteCom(ContratoEmpresa informacoesDeCadastro) {
		CorreiosPostagemApi correiosPostagemApi = new CorreiosPostagemApi(credenciais);

		return correiosPostagemApi.buscaCliente(informacoesDeCadastro);
	}

}
