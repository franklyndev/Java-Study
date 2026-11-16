package revisao.desafio.entities;

/*
 * Entidade do DESAFIO FINAL.
 *
 * TODO
 *  - "extends Veiculo"
 *  - private int cilindradas;
 *  - public static final double SEGURO = 15.00;
 *  - @Override calcularAluguel(int dias) -> diaria * dias + SEGURO
 */
public class Moto extends Veiculo {
    private int cilidradas;
    public static final double SEGURO = 15.00;

    public Moto(String placa, String modelo, Double diaria, int cilidradas) {
        super(placa, modelo, diaria);
        this.cilidradas = cilidradas;
    }

    @Override
    public double calcularAluguel(int dias) {
        return getDiaria() * dias + SEGURO;
    }
}
