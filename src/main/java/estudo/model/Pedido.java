package estudo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_pedido")
public class Pedido {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;
    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Column(name = "nota_fiscal_id")
    private Integer notaFiscalId;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    private BigDecimal total;

    @Embedded
    private EnderecoEntregaPedido enderecoEntregaPedido;


}
