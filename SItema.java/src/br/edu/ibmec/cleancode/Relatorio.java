package br.edu.ibmec.cleancode;

import java.util.List;

public class Relatorio {

    public void gerar(List<Pedido> pedidos) {
        System.out.println("=== RELATORIO ===");

        int quantidade = 0;
        double soma = 0;

        for (Pedido p : pedidos) {
            quantidade++;
            soma += p.getTotal();

            System.out.println(p.getId() + " - " +
                    p.getCliente().getNome() + " - " +
                    p.getTotal());
        }

        System.out.println("Total: " + soma);
        System.out.println("Media: " + (quantidade > 0 ? soma / quantidade : 0));
    }
}