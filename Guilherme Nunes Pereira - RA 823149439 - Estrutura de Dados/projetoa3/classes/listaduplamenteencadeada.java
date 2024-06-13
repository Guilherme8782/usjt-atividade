package classes;
public class listaduplamenteencadeada {

    public class Fila<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;
    
        public Fila() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
    
        // Método para adicionar um elemento ao final da fila
        public void enqueue(T data) {
            Node<T> newNode = new Node<>(data);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }
    
        // Método para remover um elemento do início da fila
        public T dequeue() {
            if (head == null) {
                throw new RuntimeException("A fila está vazia.");
            }
            T data = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
            size--;
            return data;
        }
    
        // Método para verificar o elemento no início da fila sem removê-lo
        public T peek() {
            if (head == null) {
                throw new RuntimeException("A fila está vazia.");
            }
            return head.data;
        }
    
        // Método para verificar se a fila está vazia
        public boolean isEmpty() {
            return size == 0;
        }
    
        // Método para obter o tamanho da fila
        public int size() {
            return size;
        }
    
        // Método para imprimir a fila (opcional)
        public void printQueue() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    
    
}
