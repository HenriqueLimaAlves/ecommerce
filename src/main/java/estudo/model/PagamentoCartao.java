package estudo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_pagamento_cartao")
public class PagamentoCartao {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    @Column(name = "status_pedido")
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPedido;
    private String numero;
}
