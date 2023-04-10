package estudo.mapeamentobasico;

import estudo.EntityManagerTest;
import estudo.model.Cliente;
import estudo.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void testarEnum(){

        Cliente cliente = new Cliente();
        cliente.setNome("Abrão");
        cliente.setSexoCliente(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Assert.assertNotNull(cliente);
    }
}
