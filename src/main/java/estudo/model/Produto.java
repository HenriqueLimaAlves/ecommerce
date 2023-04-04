package estudo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
//@EqualsAndHashcode pode gerar problemas de performance, ler mais em: https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
public class Produto {

    @Id
    private Integer id;

    private String nome;

    private BigDecimal preco;

    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Produto))
            return false;

        Produto other = (Produto) o;

        return id != null &&
                id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
