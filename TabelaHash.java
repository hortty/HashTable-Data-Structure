import lista.ListaEncadeada;
import lista.Node;
import java.util.Random;



public class TabelaHash {
    private int tamanho;
    private IHash hashInterface;
    private ListaEncadeada[] lista;
    long tempoInsercao = 0;
    long tempoBusca = 0;
    long numColisoes = 0;
    long numComparacacoes = 0;

    public long getTempoInsercao()
    {
        return this.tempoInsercao;
    }

    public long getTempoBusca()
    {
        return this.tempoBusca;
    }

    public long getNumColisoes()
    {
        return this.numColisoes;
    }

    public long getNumComparacacoes()
    {
        return this.numComparacacoes;
    }

    public void getInfo()
    {
        System.out.println("tempo inser " + getTempoInsercao());
        System.out.println("tempo busca " + getTempoBusca());
        System.out.println("num colisoes " + getNumColisoes());
        System.out.println("num comparacoes " + getNumComparacacoes());
    }

    // public void printar() {
    //     for (ListaEncadeada listaEncadeada : lista) {
    //         System.out.println("\n\nNova lista");
    //         listaEncadeada.display();
    //     }
    // }

    public TabelaHash(int tamanho, IHash hashInterface) {
        this.tamanho = tamanho;
        this.hashInterface = hashInterface;
        this.lista = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            this.lista[i] = new ListaEncadeada();
        }
    }

    public Registro buscar(Registro registro) {
        long inicio = System.currentTimeMillis();
        int indice = this.hashInterface.hash(registro, tamanho);
        ListaEncadeada listaEncadeada = this.lista[indice];
        Node current = listaEncadeada.getHead();
        Registro r = new Registro(0);
        while (current != null) {
            numComparacacoes++;
            r.setCodigo(current.GetInfo());

            if (r.getCodigo() == registro.getCodigo()) {
                long fim = System.currentTimeMillis();
                tempoBusca += fim - inicio;
                return r;
            }

            current = current.GetProx();
        }

        long fim = System.currentTimeMillis();
        tempoBusca += fim - inicio;
        return null;
    }

    public void inserir(Registro registro) {
        long inicio = System.currentTimeMillis();
        int indice = this.hashInterface.hash(registro, tamanho);

        ListaEncadeada listaEncadeada = this.lista[indice];
        listaEncadeada.adicionar(registro.getCodigo());

        if (this.lista[indice].getTamanho() > 0) {
            numColisoes++;
        }

        long fim = System.currentTimeMillis();
        tempoInsercao += fim - inicio;
    }

    public void remover(Registro registro) {
        int indice = this.hashInterface.hash(registro, tamanho);
        ListaEncadeada listaEncadeada = this.lista[indice];
        listaEncadeada.remover(registro.getCodigo());
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public IHash getHash() {
        return this.hashInterface;
    }

    public static void main(String[] args) {
        TabelaHash tabela_d1 = new TabelaHash(10, new Dobramento());
        TabelaHash tabela_d2 = new TabelaHash(50, new Dobramento());
        TabelaHash tabela_d3 = new TabelaHash(100, new Dobramento());
        TabelaHash tabela_d4 = new TabelaHash(200, new Dobramento());
        TabelaHash tabela_d5 = new TabelaHash(300, new Dobramento());

        TabelaHash tabela_r1 = new TabelaHash(10, new RestoDaDivisao());
        TabelaHash tabela_r2 = new TabelaHash(50, new RestoDaDivisao());
        TabelaHash tabela_r3 = new TabelaHash(100, new RestoDaDivisao());
        TabelaHash tabela_r4 = new TabelaHash(200, new RestoDaDivisao());
        TabelaHash tabela_r5 = new TabelaHash(300, new RestoDaDivisao());

        TabelaHash tabela_m1 = new TabelaHash(10, new Multiplicacao());
        TabelaHash tabela_m2 = new TabelaHash(50, new Multiplicacao());
        TabelaHash tabela_m3 = new TabelaHash(100, new Multiplicacao());
        TabelaHash tabela_m4 = new TabelaHash(200, new Multiplicacao());
        TabelaHash tabela_m5 = new TabelaHash(300, new Multiplicacao());

        long seed = 12L; 

        Random random = new Random(seed);
        
        Registro dadosTemp = new Registro(0);

        for(int i=0;i<20000;i++)
        {
            dadosTemp = new Registro(random.nextInt(50000));


            tabela_d1.inserir(dadosTemp);
            tabela_d2.inserir(dadosTemp);
            tabela_d3.inserir(dadosTemp);
            tabela_d4.inserir(dadosTemp);
            tabela_d5.inserir(dadosTemp);

            tabela_r1.inserir(dadosTemp);
            tabela_r2.inserir(dadosTemp);
            tabela_r3.inserir(dadosTemp);
            tabela_r4.inserir(dadosTemp);
            tabela_r5.inserir(dadosTemp);

            tabela_m1.inserir(dadosTemp);
            tabela_m2.inserir(dadosTemp);
            tabela_m3.inserir(dadosTemp);
            tabela_m4.inserir(dadosTemp);
            tabela_m5.inserir(dadosTemp);

        }

        for(int i=0;i<10;i++)
        {
            dadosTemp = new Registro(random.nextInt(50000));

            tabela_d1.buscar(dadosTemp);
            tabela_d2.buscar(dadosTemp);
            tabela_d3.buscar(dadosTemp);
            tabela_d4.buscar(dadosTemp);
            tabela_d5.buscar(dadosTemp);
            tabela_r1.buscar(dadosTemp);
            tabela_r2.buscar(dadosTemp);
            tabela_r3.buscar(dadosTemp);
            tabela_r4.buscar(dadosTemp);
            tabela_r5.buscar(dadosTemp);
            tabela_m1.buscar(dadosTemp);
            tabela_m2.buscar(dadosTemp);
            tabela_m3.buscar(dadosTemp);
            tabela_m4.buscar(dadosTemp);
            tabela_m5.buscar(dadosTemp);

        }





        for(int i=0;i<100000;i++)
        {
            dadosTemp = new Registro(random.nextInt(50000));


            tabela_d1.inserir(dadosTemp);
            tabela_d2.inserir(dadosTemp);
            tabela_d3.inserir(dadosTemp);
            tabela_d4.inserir(dadosTemp);
            tabela_d5.inserir(dadosTemp);

            tabela_r1.inserir(dadosTemp);
            tabela_r2.inserir(dadosTemp);
            tabela_r3.inserir(dadosTemp);
            tabela_r4.inserir(dadosTemp);
            tabela_r5.inserir(dadosTemp);

            tabela_m1.inserir(dadosTemp);
            tabela_m2.inserir(dadosTemp);
            tabela_m3.inserir(dadosTemp);
            tabela_m4.inserir(dadosTemp);
            tabela_m5.inserir(dadosTemp);

        }

        for(int i=0;i<10;i++)
        {
            dadosTemp = new Registro(random.nextInt(50000));

            tabela_d1.buscar(dadosTemp);
            tabela_d2.buscar(dadosTemp);
            tabela_d3.buscar(dadosTemp);
            tabela_d4.buscar(dadosTemp);
            tabela_d5.buscar(dadosTemp);
            tabela_r1.buscar(dadosTemp);
            tabela_r2.buscar(dadosTemp);
            tabela_r3.buscar(dadosTemp);
            tabela_r4.buscar(dadosTemp);
            tabela_r5.buscar(dadosTemp);
            tabela_m1.buscar(dadosTemp);
            tabela_m2.buscar(dadosTemp);
            tabela_m3.buscar(dadosTemp);
            tabela_m4.buscar(dadosTemp);
            tabela_m5.buscar(dadosTemp);

        }





        for(int i=0;i<500000;i++)
        {
            dadosTemp = new Registro(random.nextInt(50000));


            tabela_d1.inserir(dadosTemp);
            tabela_d2.inserir(dadosTemp);
            tabela_d3.inserir(dadosTemp);
            tabela_d4.inserir(dadosTemp);
            tabela_d5.inserir(dadosTemp);

            tabela_r1.inserir(dadosTemp);
            tabela_r2.inserir(dadosTemp);
            tabela_r3.inserir(dadosTemp);
            tabela_r4.inserir(dadosTemp);
            tabela_r5.inserir(dadosTemp);

            tabela_m1.inserir(dadosTemp);
            tabela_m2.inserir(dadosTemp);
            tabela_m3.inserir(dadosTemp);
            tabela_m4.inserir(dadosTemp);
            tabela_m5.inserir(dadosTemp);

        }

        for(int i=0;i<10;i++)
        {
            dadosTemp = new Registro(random.nextInt(50000));

            tabela_d1.buscar(dadosTemp);
            tabela_d2.buscar(dadosTemp);
            tabela_d3.buscar(dadosTemp);
            tabela_d4.buscar(dadosTemp);
            tabela_d5.buscar(dadosTemp);
            tabela_r1.buscar(dadosTemp);
            tabela_r2.buscar(dadosTemp);
            tabela_r3.buscar(dadosTemp);
            tabela_r4.buscar(dadosTemp);
            tabela_r5.buscar(dadosTemp);
            tabela_m1.buscar(dadosTemp);
            tabela_m2.buscar(dadosTemp);
            tabela_m3.buscar(dadosTemp);
            tabela_m4.buscar(dadosTemp);
            tabela_m5.buscar(dadosTemp);

        }





        for(int i=0;i<1000000;i++)
        {
            dadosTemp = new Registro(random.nextInt(50000));


            tabela_d1.inserir(dadosTemp);
            tabela_d2.inserir(dadosTemp);
            tabela_d3.inserir(dadosTemp);
            tabela_d4.inserir(dadosTemp);
            tabela_d5.inserir(dadosTemp);

            tabela_r1.inserir(dadosTemp);
            tabela_r2.inserir(dadosTemp);
            tabela_r3.inserir(dadosTemp);
            tabela_r4.inserir(dadosTemp);
            tabela_r5.inserir(dadosTemp);

            tabela_m1.inserir(dadosTemp);
            tabela_m2.inserir(dadosTemp);
            tabela_m3.inserir(dadosTemp);
            tabela_m4.inserir(dadosTemp);
            tabela_m5.inserir(dadosTemp);

        }

        for(int i=0;i<10;i++)
        {
            dadosTemp = new Registro(random.nextInt(50000));

            tabela_d1.buscar(dadosTemp);
            tabela_d2.buscar(dadosTemp);
            tabela_d3.buscar(dadosTemp);
            tabela_d4.buscar(dadosTemp);
            tabela_d5.buscar(dadosTemp);
            tabela_r1.buscar(dadosTemp);
            tabela_r2.buscar(dadosTemp);
            tabela_r3.buscar(dadosTemp);
            tabela_r4.buscar(dadosTemp);
            tabela_r5.buscar(dadosTemp);
            tabela_m1.buscar(dadosTemp);
            tabela_m2.buscar(dadosTemp);
            tabela_m3.buscar(dadosTemp);
            tabela_m4.buscar(dadosTemp);
            tabela_m5.buscar(dadosTemp);

        }




        /* TODO: DESCOMENTAR ESSE TRECHO DO CÓDIGO
        for(int i=0;i<5000000;i++)
        {
            dadosTemp = new Registro(random.nextInt(50000));


            tabela_d1.inserir(dadosTemp);
            tabela_d2.inserir(dadosTemp);
            tabela_d3.inserir(dadosTemp);
            tabela_d4.inserir(dadosTemp);
            tabela_d5.inserir(dadosTemp);

            tabela_r1.inserir(dadosTemp);
            tabela_r2.inserir(dadosTemp);
            tabela_r3.inserir(dadosTemp);
            tabela_r4.inserir(dadosTemp);
            tabela_r5.inserir(dadosTemp);

            tabela_m1.inserir(dadosTemp);
            tabela_m2.inserir(dadosTemp);
            tabela_m3.inserir(dadosTemp);
            tabela_m4.inserir(dadosTemp);
            tabela_m5.inserir(dadosTemp);

        }
        for(int i=0;i<10;i++)
        {
            dadosTemp = new Registro(random.nextInt(50000));

            tabela_d1.buscar(dadosTemp);
            tabela_d2.buscar(dadosTemp);
            tabela_d3.buscar(dadosTemp);
            tabela_d4.buscar(dadosTemp);
            tabela_d5.buscar(dadosTemp);
            tabela_r1.buscar(dadosTemp);
            tabela_r2.buscar(dadosTemp);
            tabela_r3.buscar(dadosTemp);
            tabela_r4.buscar(dadosTemp);
            tabela_r5.buscar(dadosTemp);
            tabela_m1.buscar(dadosTemp);
            tabela_m2.buscar(dadosTemp);
            tabela_m3.buscar(dadosTemp);
            tabela_m4.buscar(dadosTemp);
            tabela_m5.buscar(dadosTemp);

        }
        */

        System.out.println("\n\n - Dobramento");
        tabela_d1.getInfo();
        tabela_d2.getInfo();
        tabela_d3.getInfo();
        tabela_d4.getInfo();
        tabela_d5.getInfo();

        System.out.println("\n\n - RestoDivisao");
        tabela_r1.getInfo();
        tabela_r2.getInfo();
        tabela_r3.getInfo();
        tabela_r4.getInfo();
        tabela_r5.getInfo();

        System.out.println("\n\n - Multiplicacao");
        tabela_m1.getInfo();
        tabela_m2.getInfo();
        tabela_m3.getInfo();
        tabela_m4.getInfo();
        tabela_m5.getInfo();

    }
}
