package Entidade;

import lombok.Data;

import java.util.List;

public @Data class Banco {
    private String nome;
    private List<Conta> contas;
}
