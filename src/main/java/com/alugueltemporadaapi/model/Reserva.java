package com.alugueltemporadaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
    @Column(nullable = false)
    private String nomeHospede;
    @Column(nullable = false)
    private String emailHospede;
    @Column(nullable = false)
    private String telefoneHospede;
    private java.time.LocalDateTime dataEntrada;
    private java.time.LocalDateTime dataSaida;
    private Integer numHospedes;
    private Double valorTotal;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Imovel getImovel() { return imovel; }
    public void setImovel(Imovel imovel) { this.imovel = imovel; }
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
