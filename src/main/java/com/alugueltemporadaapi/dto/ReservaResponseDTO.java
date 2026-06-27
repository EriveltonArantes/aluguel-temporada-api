package com.alugueltemporadaapi.dto;

public class ReservaResponseDTO {

    private Long id;
    private Long imovelId;
    private String nomeHospede;
    private String emailHospede;
    private String telefoneHospede;
    private java.time.LocalDateTime dataEntrada;
    private java.time.LocalDateTime dataSaida;
    private Integer numHospedes;
    private Double valorTotal;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
