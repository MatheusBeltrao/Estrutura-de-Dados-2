import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Declare o caminho do arquivo diretamente aqui
        String caminhoDoArquivo = "C:\\Users\\Matheus\\Desktop\\ED 2\\AVL\\dados100_mil.txt";

        try {
            // Lê os números do arquivo
            int[] numbers = lerArquivo(caminhoDoArquivo);

            // Inicia o cronômetro
            long startTime = System.nanoTime();

            // Ordena os números usando QuickSort
            quickSort(numbers, 0, numbers.length - 1);

            // Para o cronômetro
            long endTime = System.nanoTime();

            // Calcula o tempo decorrido
            long duration = (endTime - startTime) / 1000000; // divide por 1000000 para converter nanossegundos em
                                                             // milissegundos

            // Imprime os números no final
            System.out.println("Números: " + Arrays.toString(numbers));
            System.out.println("Tempo de ordenação: " + duration + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] lerArquivo(String caminho) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            return br.lines()
                    .flatMap(line -> Arrays.stream(line.split(",\\s*")))
                    .filter(num -> num.matches("-?\\d+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
