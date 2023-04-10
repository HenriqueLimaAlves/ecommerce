package estudo.mapeamentobasico;

import estudo.EntityManagerTest;
import estudo.model.EnderecoEntregaPedido;
import estudo.model.Pedido;
import estudo.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutido extends EntityManagerTest {

    @Test
    public void analisarMapeamentoObjEmbutido(){
        EnderecoEntregaPedido enderecoEntregaPedido = new EnderecoEntregaPedido();
        enderecoEntregaPedido.setCep("00000-000");
        enderecoEntregaPedido.setLogradouro("Rua tal");
        enderecoEntregaPedido.setBairro("Fazenda da juta");
        enderecoEntregaPedido.setEstado("São paulo");
        enderecoEntregaPedido.setCidade("SP");
        enderecoEntregaPedido.setNumero("123");

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(1000));
        pedido.setEnderecoEntregaPedido(enderecoEntregaPedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Assert.assertNotNull(entityManager.find(Pedido.class, pedido.getId()));
    }
}
