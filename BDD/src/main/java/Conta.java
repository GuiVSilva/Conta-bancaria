import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Uma classe que representa uma conta com funcionalidades de saque usando o Cucumber para desenvolvimento orientado a comportamento.
 */
public class Conta {
	 /** Saldo atual da conta. */
	 private int saldoAtual;
	 
	 /** Mensagem de erro associada a operações de saque. */
	 private String mensagemErro;
	/**
     * Configura uma conta de cliente especial com o saldo inicial fornecido.
     *
     * @param saldoInicial O saldo inicial da conta.
     * @throws Throwable Se ocorrer um erro durante a configuração.
     */
	@Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
	public void um_cliente_especial_com_saldo_atual_de_reais(int saldoInicial) throws Throwable {
        saldoAtual = -saldoInicial;
    }
	
	
	 /**
     * Processa a solicitação de saque para um cliente especial.
     *
     * @param valorDoSaque O valor do saque solicitado.
     * @throws Throwable Se ocorrer um erro durante o processamento.
     */
	@When("^for solicitado um saque no valor de (\\d+) reais$")
	 public void for_solicitado_um_saque_no_valor_de_reais(int valorDoSaque) throws Throwable {
        if (valorDoSaque <= saldoAtual) {
            saldoAtual -= valorDoSaque;
        } else {
            mensagemErro = "Saldo Insuficiente";
        }
    }

	 /**
     * Verifica se o saque foi efetuado com sucesso e se o saldo foi atualizado corretamente.
     *
     * @param novoSaldo O saldo esperado após o saque.
     * @throws Throwable Se ocorrer um erro durante a verificação.
     */
	@Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
	 public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int novoSaldo) throws Throwable {
        assertEquals(novoSaldo, saldoAtual);
    }
	
	 /**
     * Realiza verificações adicionais após o saque.
     *
     * @throws Throwable Se ocorrer um erro durante as verificações adicionais.
     */
	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
		 assertTrue(saldoAtual >= 0);
	}
	
	/**
     * Configura uma conta de cliente comum com o saldo inicial fornecido.
     *
     * @param saldoInicial O saldo inicial da conta.
     * @throws Throwable Se ocorrer um erro durante a configuração.
     */
	@Given("^Um cliente comum com saldo atual de -(\\d+) reais$")
	public void um_cliente_comum_com_saldo_atual_de_reais(int saldoInicial) throws Throwable {
        saldoAtual = -saldoInicial;
    }
	
	 /**
     * Processa a solicitação de saque para um cliente comum.
     *
     * @param valorDoSaque O valor do saque solicitado.
     * @throws Throwable Se ocorrer um erro durante o processamento.
     */
	@When("^solicitar um saque de (\\d+) reais$")
	 public void solicitar_um_saque_de_reais(int valorDoSaque) throws Throwable {
        if (valorDoSaque <= saldoAtual) {
            saldoAtual -= valorDoSaque;
        } else {
            mensagemErro = "Saldo Insuficiente";
        }
    }
	
	/**
     * Verifica se o saque não foi efetuado devido a saldo insuficiente.
     *
     * @throws Throwable Se ocorrer um erro durante a verificação.
     */
	@Then("^não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente$")
	  public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_Saldo_Insuficiente() throws Throwable {
        assertEquals("Saldo Insuficiente", mensagemErro);
    }
}
