public class BuscaBinariaIterativa {
    public static int buscaBinaria(int[] arr, int chave) {
        int esquerda = 0;
        int direita = arr.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (arr[meio] == chave) {
                return meio; // Chave encontrada
            }

            if (arr[meio] < chave) {
                esquerda = meio + 1; // Descartar metade esquerda
            } else {
                direita = meio - 1; // Descartar metade direita
            }
        }

        return -1; // Chave não encontrada
    }

}
