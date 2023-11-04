package lista;

public class ListaEncadeada {
    private Node head;
    private Node tail;
    private int tamanho;

    public ListaEncadeada() {
        head = null;
        tail = null;
        tamanho = 0;
    }

    public Node getHead()
    {
        return this.head;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void adicionar(Integer data) {
        Node newNode = new Node();
        newNode.SetInfo(data);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.SetProx(newNode);
            tail = newNode;
        }

        tamanho++;
    }

    public void remover(Integer data) {
        Node current = head;
        Node previous = null;
    
        if (current != null && (current.GetInfo().intValue() == data)) {
            head = current.GetProx();
            if (head == null) {
                tail = null;
            }
            tamanho--;
            return;
        }
    
        while (current != null && !(current.GetInfo().intValue() == data)) {
            previous = current;
            current = current.GetProx();
        }
    
        if (current == null) {
            System.out.println("Elemento não encontrado na lista.");
            return;
        }
    
        if (previous != null) {
            previous.SetProx(current.GetProx());
        }
    
        if (current == tail) {
            tail = previous;
        }
    
        tamanho--;
    }
    

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.GetInfo() + " ");
            current = current.GetProx();
        }
    } 
}
