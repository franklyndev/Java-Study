package revisao.desafio.entities;

/*
 * Entidade do DESAFIO FINAL.
 *
 * TODO
 *  - "public abstract class Veiculo"
 *  - private String placa, modelo;  protected Double diaria;
 *  - private boolean disponivel = true;
 *  - construtor(placa, modelo, diaria)
 *  - getters
 *  - public void alugar()   -> valida se ja esta alugado
 *  - public void devolver()
 *  - public boolean estaDisponivel()
 *  - public abstract double calcularAluguel(int dias);
 *  - public String toString() -> "ABC1234 - Gol (R$ 120.00/dia) [DISPONIVEL]"
 */
public abstract class Veiculo {
    private String placa, modelo;
    protected Double diaria;
    private boolean disponivel = true;

    public Veiculo(String placa, String modelo, Double diaria) {
        this.placa = placa;
        this.modelo = modelo;
        this.diaria = diaria;
    }

    public void alugar() { // Método concreto (com implementação)
        if(!disponivel) {
            System.out.println("Veiculo indisponivel");
        } else {
            disponivel = false;
        }
    }

    public void devolver() {
        disponivel = true;
    }


    public abstract double calcularAluguel(int dias); // Método abstrato, as subclasses implementam

    public String toString() {
        String status = disponivel ? "DISPONIVEL" : "INDISPONIVEL";
        return String.format("%s - %s (R$ %.2f/dia) [%s]", placa, modelo, diaria, status);
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getDiaria() {
        return diaria;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

}
