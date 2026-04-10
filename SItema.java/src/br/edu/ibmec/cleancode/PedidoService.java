package br.edu.ibmec.cleancode;

public class PedidoService {

    private DescontoComum descontoComum = new DescontoComum();

    public double calcularTotal(Pedido pedido) {
        double total = pedido.calcularSubtotal();
        total = aplicarDesconto(pedido, total);
        total = aplicarFrete(total);
        return total;
    }

    private double aplicarDesconto(Pedido pedido, double total) {

        switch (pedido.getCliente().getTipo()) {

            case COMUM:
                return descontoComum.aplicar(total);

            case PREMIUM:
                if (total > 200) return total * 0.90;
                return total * 0.97;

            case VIP:
                return total * 0.85;

            default:
                return total;
        }
    }

    private double aplicarFrete(double total) {
        if (total < 100) return total + 25;
        if (total < 300) return total + 15;
        return total;
    }
}