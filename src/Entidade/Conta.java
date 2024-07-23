package Entidade;

import Interface.IConta;
import lombok.Data;

import java.util.List;

public @Data abstract class Conta  implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
       if(valor > saldo) {
           saldo -= valor;
       } else{
           System.out.println(String.format("Saldo insufuciente! Saldo atual: %.2f", this.saldo));
       }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println(String.format("Deposito realizado! Saldo atual: %.2f", this.saldo));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);
        System.out.println(String.format("Transferencia realizada com sucesso, para o cliente: %s", contaDestino.getCliente().getNome()));
    }

    protected void imprimirDadosCaontas() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }


}
