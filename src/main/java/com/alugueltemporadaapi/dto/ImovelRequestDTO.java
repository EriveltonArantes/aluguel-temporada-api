package com.alugueltemporadaapi.dto;

import jakarta.validation.constraints.*;

public class ImovelRequestDTO {

    @NotNull(message = "ProprietarioId é obrigatório")
    @Positive(message = "ProprietarioId deve ser um ID válido (positivo)")
    private Long proprietarioId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "endereco não pode estar em branco")
    private String endereco;
    @NotBlank(message = "cidade não pode estar em branco")
    private String cidade;
    @NotBlank(message = "estado não pode estar em branco")
    private String estado;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @Min(value = 0, message = "capacidade não pode ser negativo")
    @NotNull(message = "capacidade não pode ser nulo")
    private Integer capacidade;
    @DecimalMin(value = "0.0", message = "preco diaria não pode ser negativo")
    @NotNull(message = "preco diaria não pode ser nulo")
    private Double precoDiaria;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotNull(message = "ativo não pode ser nulo")
    private Boolean ativo;

    public Long getProprietarioId() { return proprietarioId; }
    public void setProprietarioId(Long proprietarioId) { this.proprietarioId = proprietarioId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }
    public Double getPrecoDiaria() { return precoDiaria; }
    public void setPrecoDiaria(Double precoDiaria) { this.precoDiaria = precoDiaria; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
