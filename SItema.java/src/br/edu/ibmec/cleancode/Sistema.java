package br.edu.ibmec.cleancode;

import java.util.*;

public class Sistema {

    private Scanner sc = new Scanner(System.in);
    private List<Pedido> pedidos = new ArrayList<>();
    private Db db = new Db();
    private PedidoService service = new PedidoService();

    public void run() {
        int op = -1;

        while (op != 0) {
            System.out.println("1 - Novo pedido");
            System.out.println("2 - Listar");
            System.out.println("0 - Sair");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1: novoPedido(); break;
                case 2: listar(); break;
            }
        }
    }

    private void novoPedido() {
        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Tipo (1 comum, 2 premium, 3 vip):");
        int tipo = Integer.parseInt(sc.nextLine());

        Cliente c = new Cliente();
        c.setNome(nome);
        c.setEmail(nome + "@email.com");

        if (tipo == 1) c.setTipo(TipoCliente.COMUM);
        else if (tipo == 2) c.setTipo(TipoCliente.PREMIUM);
        else c.setTipo(TipoCliente.VIP);

        Pedido p = new Pedido();
        p.setId(pedidos.size() + 1);
        p.setCliente(c);
        p.setItens(new ArrayList<>());
        p.setStatus("NOVO");

        Item item = new Item();
        item.setNome("Produto");
        item.setPreco(100);
        item.setQuantidade(2);

        p.getItens().add(item);

        double total = service.calcularTotal(p);
        p.setTotal(total);

        pedidos.add(p);
        db.save(p);

        System.out.println("Total: " + total);
    }

    private void listar() {
        for (Pedido p : pedidos) {
            System.out.println(p.getId() + " - " + p.getTotal());
        }
    }
}