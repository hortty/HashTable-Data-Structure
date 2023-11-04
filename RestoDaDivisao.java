

public class RestoDaDivisao implements IHash {

    @Override
    public int hash(Registro registro, int tamanho) {
        int codigo = registro.getCodigo();
        int hash = codigo % tamanho;
        return hash;
    }
}


