package br.edu.ibmec.cleancode;

import java.util.ArrayList;
import java.util.List;

public class Db {

    private static List<Pedido> banco = new ArrayList<>();

    public void save(Pedido pedido) {
        banco.add(pedido);
        System.out.println("Salvo no banco");
    }

    public List<Pedido> getAll() {
        return banco;
    }

    public Pedido getById(int id) {
        for (Pedido p : banco) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}