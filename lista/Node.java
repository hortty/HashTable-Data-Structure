package lista;

public class Node {
    private Integer informacao;
    private Node proximo;

    public Node()
    {
        this.informacao = null;
        this.proximo = null;
    }

    public void SetInfo(Integer info)
    {
        this.informacao = info;
    }

    public Integer GetInfo()
    {
        return this.informacao;
    }

    public void SetProx(Node proximo)
    {
        this.proximo = proximo;
    }

    public Node GetProx()
    {
        return this.proximo;
    }

}
