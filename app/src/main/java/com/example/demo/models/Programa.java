package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String orgao;
    private String orgaoVinculado;
    private String orgaoExecutor;
    private String tipoInstrumento;
    private String subtipoInstrumento;
    private String qualificacaoProposta;
    private String atende;
    private String categorias;
    private String nome;
    private String descricao;
    private boolean exigeLicitacao;
    private String dataInicioEmenda;
    private String dataFimEmenda;
    private String acaoOrcamentaria;
    private String estadosHabilitados;
    private boolean exigePlanoTrabalho;
    private boolean aceitaNaoCadastrado;
    private boolean possuiChamamento;
    private String fundamentoLegal;
    private String dataDisponibilizacao;
    private String dataRenovacao;
    private String dataPublicacaoDOU;
    private String situacaoDisponibilizacao;

    private String linkDetalhe;

    // Construtor com dois parâmetros
    public Programa(String codigo, String linkDetalhe) {
        this.codigo = codigo;
        this.linkDetalhe = linkDetalhe;
    }

    // Construtor sem parâmetros (necessário para JPA)
    public Programa() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getOrgaoVinculado() {
        return orgaoVinculado;
    }

    public void setOrgaoVinculado(String orgaoVinculado) {
        this.orgaoVinculado = orgaoVinculado;
    }

    public String getOrgaoExecutor() {
        return orgaoExecutor;
    }

    public void setOrgaoExecutor(String orgaoExecutor) {
        this.orgaoExecutor = orgaoExecutor;
    }

    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    public void setTipoInstrumento(String tipoInstrumento) {
        this.tipoInstrumento = tipoInstrumento;
    }

    public String getSubtipoInstrumento() {
        return subtipoInstrumento;
    }

    public void setSubtipoInstrumento(String subtipoInstrumento) {
        this.subtipoInstrumento = subtipoInstrumento;
    }

    public String getQualificacaoProposta() {
        return qualificacaoProposta;
    }

    public void setQualificacaoProposta(String qualificacaoProposta) {
        this.qualificacaoProposta = qualificacaoProposta;
    }

    public String getAtende() {
        return atende;
    }

    public void setAtende(String atende) {
        this.atende = atende;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isExigeLicitacao() {
        return exigeLicitacao;
    }

    public void setExigeLicitacao(boolean exigeLicitacao) {
        this.exigeLicitacao = exigeLicitacao;
    }

    public String getDataInicioEmenda() {
        return dataInicioEmenda;
    }

    public void setDataInicioEmenda(String dataInicioEmenda) {
        this.dataInicioEmenda = dataInicioEmenda;
    }

    public String getDataFimEmenda() {
        return dataFimEmenda;
    }

    public void setDataFimEmenda(String dataFimEmenda) {
        this.dataFimEmenda = dataFimEmenda;
    }

    public String getAcaoOrcamentaria() {
        return acaoOrcamentaria;
    }

    public void setAcaoOrcamentaria(String acaoOrcamentaria) {
        this.acaoOrcamentaria = acaoOrcamentaria;
    }

    public String getEstadosHabilitados() {
        return estadosHabilitados;
    }

    public void setEstadosHabilitados(String estadosHabilitados) {
        this.estadosHabilitados = estadosHabilitados;
    }

    public boolean isExigePlanoTrabalho() {
        return exigePlanoTrabalho;
    }

    public void setExigePlanoTrabalho(boolean exigePlanoTrabalho) {
        this.exigePlanoTrabalho = exigePlanoTrabalho;
    }

    public boolean isAceitaNaoCadastrado() {
        return aceitaNaoCadastrado;
    }

    public void setAceitaNaoCadastrado(boolean aceitaNaoCadastrado) {
        this.aceitaNaoCadastrado = aceitaNaoCadastrado;
    }

    public boolean isPossuiChamamento() {
        return possuiChamamento;
    }

    public void setPossuiChamamento(boolean possuiChamamento) {
        this.possuiChamamento = possuiChamamento;
    }

    public String getFundamentoLegal() {
        return fundamentoLegal;
    }

    public void setFundamentoLegal(String fundamentoLegal) {
        this.fundamentoLegal = fundamentoLegal;
    }

    public String getDataDisponibilizacao() {
        return dataDisponibilizacao;
    }

    public void setDataDisponibilizacao(String dataDisponibilizacao) {
        this.dataDisponibilizacao = dataDisponibilizacao;
    }

    public String getDataRenovacao() {
        return dataRenovacao;
    }

    public void setDataRenovacao(String dataRenovacao) {
        this.dataRenovacao = dataRenovacao;
    }

    public String getDataPublicacaoDOU() {
        return dataPublicacaoDOU;
    }

    public void setDataPublicacaoDOU(String dataPublicacaoDOU) {
        this.dataPublicacaoDOU = dataPublicacaoDOU;
    }

    public String getSituacaoDisponibilizacao() {
        return situacaoDisponibilizacao;
    }

    public void setSituacaoDisponibilizacao(String situacaoDisponibilizacao) {
        this.situacaoDisponibilizacao = situacaoDisponibilizacao;
    }

    public String getLinkDetalhe() {
        return linkDetalhe;
    }

    public void setLinkDetalhe(String linkDetalhe) {
        this.linkDetalhe = linkDetalhe;
    }

    @Override
    public String toString() {
        return "Programa {" + System.lineSeparator() +
                "  id=" + id + "," + System.lineSeparator() +
                "  codigo='" + codigo + "'," + System.lineSeparator() +
                "  orgao='" + (orgao != null ? orgao : "não disponível") + "'," + System.lineSeparator() +
                "  orgaoVinculado='" + (orgaoVinculado != null ? orgaoVinculado : "não disponível") + "'," + System.lineSeparator() +
                "  orgaoExecutor='" + (orgaoExecutor != null ? orgaoExecutor : "não disponível") + "'," + System.lineSeparator() +
                "  tipoInstrumento='" + (tipoInstrumento != null ? tipoInstrumento : "não disponível") + "'," + System.lineSeparator() +
                "  subtipoInstrumento='" + (subtipoInstrumento != null ? subtipoInstrumento : "não disponível") + "'," + System.lineSeparator() +
                "  qualificacaoProposta='" + (qualificacaoProposta != null ? qualificacaoProposta : "não disponível") + "'," + System.lineSeparator() +
                "  atende='" + (atende != null ? atende : "não disponível") + "'," + System.lineSeparator() +
                "  categorias='" + (categorias != null ? categorias : "não disponível") + "'," + System.lineSeparator() +
                "  nome='" + (nome != null ? nome : "não disponível") + "'," + System.lineSeparator() +
                "  descricao='" + (descricao != null ? descricao : "não disponível") + "'," + System.lineSeparator() +
                "  exigeLicitacao=" + exigeLicitacao + "," + System.lineSeparator() +
                "  dataInicioEmenda='" + (dataInicioEmenda != null ? dataInicioEmenda : "não disponível") + "'," + System.lineSeparator() +
                "  dataFimEmenda='" + (dataFimEmenda != null ? dataFimEmenda : "não disponível") + "'," + System.lineSeparator() +
                "  acaoOrcamentaria='" + (acaoOrcamentaria != null ? acaoOrcamentaria : "não disponível") + "'," + System.lineSeparator() +
                "  estadosHabilitados='" + (estadosHabilitados != null ? estadosHabilitados : "não disponível") + "'," + System.lineSeparator() +
                "  exigePlanoTrabalho=" + exigePlanoTrabalho + "," + System.lineSeparator() +
                "  aceitaNaoCadastrado=" + aceitaNaoCadastrado + "," + System.lineSeparator() +
                "  possuiChamamento=" + possuiChamamento + "," + System.lineSeparator() +
                "  fundamentoLegal='" + (fundamentoLegal != null ? fundamentoLegal : "não disponível") + "'," + System.lineSeparator() +
                "  dataDisponibilizacao='" + (dataDisponibilizacao != null ? dataDisponibilizacao : "não disponível") + "'," + System.lineSeparator() +
                "  dataRenovacao='" + (dataRenovacao != null ? dataRenovacao : "não disponível") + "'," + System.lineSeparator() +
                "  dataPublicacaoDOU='" + (dataPublicacaoDOU != null ? dataPublicacaoDOU : "não disponível") + "'," + System.lineSeparator() +
                "  situacaoDisponibilizacao='" + (situacaoDisponibilizacao != null ? situacaoDisponibilizacao : "não disponível") + "'," + System.lineSeparator() +
                "  linkDetalhe='" + (linkDetalhe != null ? linkDetalhe : "não disponível") + "'" + System.lineSeparator() +
                "}";
    }

}
