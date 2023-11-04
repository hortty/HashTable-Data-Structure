

public class Multiplicacao implements IHash {

    private static final int P = 31;

    @Override
    public int hash(Registro registro, int tamanho) {
        int codigo = registro.getCodigo(); 

        int hash = 1;
        hash = (hash * P + codigo) % tamanho;

        return hash;
    }
}
