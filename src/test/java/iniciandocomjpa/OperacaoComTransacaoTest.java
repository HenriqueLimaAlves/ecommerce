package iniciandocomjpa;

import estudo.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacaoComTransacaoTest extends EntityManagerTest {


    @Test
    public void impedirOperacaoComBancoDeDados(){
        Produto produto = entityManager.find(Produto.class, 1);
        entityManager.detach(produto);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2º Geração");
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle", produtoVerificacao.getNome());
    }
    @Test
    public void inserirObjetoComMerge(){
        Produto produto = new Produto();

        produto.setDescricao("A melhor qualidade de som!");
        produto.setId(4);
        produto.setNome("Mic AKG");
        produto.setPreco(new BigDecimal(7000));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Assert.assertNotNull(entityManager.find(produto.getClass(), produto.getId()));
    }
    @Test
    public void atualizarObjetoGerenciado(){
        Produto produto = entityManager.find(Produto.class, 1);


        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2º Geração");
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle Paperwhite 2º Geração", produtoVerificacao.getNome());
    }
    @Test
    public void atualizarObjeto(){

        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Kindle Paperwhite");
        produto.setDescricao("conheça o novo kindle");
        produto.setPreco(new BigDecimal(1900));


        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Kindle Paperwhite", produtoVerificacao.getNome());
    }
    @Test
    public void removerObjeto(){
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);
    }
    @Test
    public void inserirOPrimeiroObjeto(){
        Produto produto = new Produto();

        produto.setDescricao("A melhor definição para suas fotos!");
        produto.setId(2);
        produto.setNome("Camera Canon");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Assert.assertNotNull(entityManager.find(produto.getClass(), produto.getId()));
    }
}
