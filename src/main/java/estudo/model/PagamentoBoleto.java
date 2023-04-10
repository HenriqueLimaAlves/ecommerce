package estudo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_pagamento_boleto")
public class PagamentoBoleto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    @Column(name = "status_pagamento")
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;
    @Column(name = "codigo_de_barras")
    private String codigoDeBarras;
}
