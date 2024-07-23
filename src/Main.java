import Entidade.Cliente;
import Entidade.Conta;
import Entidade.ContaCorrente;
import Entidade.ContaPoupança;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente joao = new Cliente();
        joao.setNome("João");

        Conta cc = new ContaCorrente(joao);
        Conta cp = new ContaPoupança(joao);

        cc.depositar(100);
        cc.transferir(100, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        for(){

        }

    }
}