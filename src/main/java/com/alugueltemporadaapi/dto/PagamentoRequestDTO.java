package com.alugueltemporadaapi.dto;

import jakarta.validation.constraints.*;

public class PagamentoRequestDTO {

    @NotNull(message = "ReservaId é obrigatório")
    @Positive(message = "ReservaId deve ser um ID válido (positivo)")
    private Long reservaId;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private java.math.BigDecimal valor;
    @NotBlank(message = "forma pagamento não pode estar em branco")
    private String formaPagamento;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @FutureOrPresent(message = "data hora não pode ser retroativo")
    @NotNull(message = "data hora não pode ser nulo")
    private java.time.LocalDateTime dataHora;
    @NotBlank(message = "comprovante não pode estar em branco")
    private String comprovante;

    public Long getReservaId() { return reservaId; }
    public void setReservaId(Long reservaId) { this.reservaId = reservaId; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public java.time.LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(java.time.LocalDateTime dataHora) { this.dataHora = dataHora; }
    public String getComprovante() { return comprovante; }
    public void setComprovante(String comprovante) { this.comprovante = comprovante; }
}
