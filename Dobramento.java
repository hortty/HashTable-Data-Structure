

public class Dobramento implements IHash {
    
    @Override
    public int hash(Registro registro, int tamanho) {
        int codigo = registro.getCodigo();
        int hash = 0;

        while (codigo != 0) {
            hash += codigo % 1000; 
            codigo /= 1000;
        }

        return hash % tamanho;
    }

}

