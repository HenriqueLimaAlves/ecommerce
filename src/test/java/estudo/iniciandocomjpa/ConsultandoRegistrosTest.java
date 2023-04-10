package estudo.iniciandocomjpa;

import estudo.EntityManagerTest;
import estudo.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {

    @Test
    public void buscarPorIdentificador(){
        Produto produto = entityManager.find(Produto.class, 1);
        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }
}
