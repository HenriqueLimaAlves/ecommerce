package iniciandocomjpa;

import estudo.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void clienteInsertTest(){
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Jamal");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }

    @Test
    public void clienteUpdateTest(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        cliente.setNome("Irineu");
        entityManager.getTransaction().commit();
        entityManager.clear();

        Assert.assertEquals("Irineu", cliente.getNome());
    }

    @Test
    public  void clienteBuscarPorId(){
        Cliente cliente = entityManager.find(Cliente.class, 5);
        Assert.assertNotNull(cliente);
        Assert.assertEquals("Vitor Pereira", cliente.getNome());
    }

    @Test
    public  void clienteDelete(){
        Cliente cliente = entityManager.find(Cliente.class, 5);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Assert.assertNull(entityManager.find(Cliente.class, cliente.getId()));
    }
}
