public class Main {
    public static void main(String[] args) {
        int[] array = criarArrayGrande(); // Substitua isso com o método que cria um grande array de dados

        int chave = array[array.length / 2]; // Vamos procurar um elemento que está no meio do array

        long inicioIterativa = System.nanoTime();
        int resultadoIterativa = BuscaBinariaIterativa.buscaBinaria(array, chave);
        long fimIterativa = System.nanoTime();

        long inicioRecursiva = System.nanoTime();
        int resultadoRecursiva = BuscaBinariaRecursiva.buscaBinariaRecursiva(array, chave, 0, array.length - 1);
        long fimRecursiva = System.nanoTime();

        System.out.println("Resultado da Busca Binária Iterativa: " + resultadoIterativa);
        System.out.println("Tempo da Busca Binária Iterativa: " + (fimIterativa - inicioIterativa) + " nanossegundos");

        System.out.println("\nResultado da Busca Binária Recursiva: " + resultadoRecursiva);
        System.out.println("Tempo da Busca Binária Recursiva: " + (fimRecursiva - inicioRecursiva) + " nanossegundos");

        // Comparando tempos
        if ((fimIterativa - inicioIterativa) < (fimRecursiva - inicioRecursiva)) {
            System.out.println("\nBusca Binária Iterativa é mais rápida.");
        } else {
            System.out.println("\nBusca Binária Recursiva é mais rápida.");
        }
    }

    // Método para criar um grande array de dados para teste
    private static int[] criarArrayGrande() {
        int tamanho = 1000000; // Altere o tamanho conforme necessário
        int[] array = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            array[i] = i;
        }

        return array;
    }
}
