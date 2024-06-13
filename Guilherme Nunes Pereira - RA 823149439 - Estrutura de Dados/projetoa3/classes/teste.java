package classes;
public class teste {

        public static void main(String[] args) {
            
            listaduplamenteencadeada.Fila<Integer> fila = new listaduplamenteencadeada().new Fila<>();
    
            // Testando se a fila está vazia
            System.out.println("A fila está vazia? " + fila.isEmpty());
    
            // Enfileirando elementos
            fila.enqueue(10);
            fila.enqueue(20);
            fila.enqueue(30);
            System.out.println("Elementos após enfileirar 10, 20, 30:");
            fila.printQueue();
    
            // Verificando o tamanho da fila
            System.out.println("Tamanho da fila: " + fila.size());
    
            // Espiando o elemento na frente da fila
            System.out.println("Elemento na frente da fila (peek): " + fila.peek());
    
            // Desenfileirando elementos
            System.out.println("Elemento removido: " + fila.dequeue());
            System.out.println("Elementos após desenfileirar:");
            fila.printQueue();
    
            System.out.println("Elemento removido: " + fila.dequeue());
            System.out.println("Elemento removido: " + fila.dequeue());
    
            // Tentando desenfileirar de uma fila vazia
            try {
                fila.dequeue();
            } catch (RuntimeException e) {
                System.out.println("Exceção ao desenfileirar de uma fila vazia: " + e.getMessage());
            }
    
            // Testando se a fila está vazia após todas as remoções
            System.out.println("A fila está vazia? " + fila.isEmpty());
        }
    }
