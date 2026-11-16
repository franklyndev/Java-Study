package revisao.desafio.entities;

/*
 * Entidade do DESAFIO FINAL.
 *
 * TODO
 *  - "extends Veiculo"
 *  - private int portas;
 *  - @Override calcularAluguel(int dias):
 *        total = diaria * dias;
 *        se dias > 7 -> total = total * 0.90
 */
public class Carro extends Veiculo {
    private int portas;

    public Carro(String placa, String modelo, Double diaria, int portas) {
        super(placa, modelo, diaria);
        this.portas = portas;
    }

    @Override
    public double calcularAluguel(int dias) {
        double total = getDiaria() * dias;
        if(dias > 7) {
            total *= 0.90;
        }
        return total;
    }
}
