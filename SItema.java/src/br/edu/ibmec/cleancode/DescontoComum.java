package br.edu.ibmec.cleancode;

public class DescontoComum {

    public double aplicar(double total) {
        if (total > 300) {
            return total * 0.95;
        }
        return total;
    }
}