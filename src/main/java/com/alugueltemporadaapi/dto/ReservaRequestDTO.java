package com.alugueltemporadaapi.dto;

import jakarta.validation.constraints.*;

public class ReservaRequestDTO {

    @NotNull(message = "ImovelId é obrigatório")
    @Positive(message = "ImovelId deve ser um ID válido (positivo)")
    private Long imovelId;
    @NotBlank(message = "nome hospede não pode estar em branco")
    private String nomeHospede;
    @NotBlank(message = "email hospede não pode estar em branco")
    @Email(message = "email hospede precisa ser um e-mail válido")
    private String emailHospede;
    @NotBlank(message = "telefone hospede não pode estar em branco")
    private String telefoneHospede;
    @NotNull(message = "data entrada não pode ser nulo")
    private java.time.LocalDateTime dataEntrada;
    @NotNull(message = "data saida não pode ser nulo")
    private java.time.LocalDateTime dataSaida;
    @NotNull(message = "num hospedes não pode ser nulo")
    private Integer numHospedes;
    @DecimalMin(value = "0.0", message = "valor total não pode ser negativo")
    @NotNull(message = "valor total não pode ser nulo")
    private Double valorTotal;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getImovelId() { return imovelId; }
    public void setImovelId(Long imovelId) { this.imovelId = imovelId; }
    public String getNomeHospede() { return nomeHospede; }
    public void setNomeHospede(String nomeHospede) { this.nomeHospede = nomeHospede; }
    public String getEmailHospede() { return emailHospede; }
    public void setEmailHospede(String emailHospede) { this.emailHospede = emailHospede; }
    public String getTelefoneHospede() { return telefoneHospede; }
    public void setTelefoneHospede(String telefoneHospede) { this.telefoneHospede = telefoneHospede; }
    public java.time.LocalDateTime getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(java.time.LocalDateTime dataEntrada) { this.dataEntrada = dataEntrada; }
    public java.time.LocalDateTime getDataSaida() { return dataSaida; }
    public void setDataSaida(java.time.LocalDateTime dataSaida) { this.dataSaida = dataSaida; }
    public Integer getNumHospedes() { return numHospedes; }
    public void setNumHospedes(Integer numHospedes) { this.numHospedes = numHospedes; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
