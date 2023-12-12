public class BuscaBinariaRecursiva {
    public static int buscaBinariaRecursiva(int[] arr, int chave, int esquerda, int direita) {
        if (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (arr[meio] == chave) {
                return meio; // Chave encontrada
            }

            if (arr[meio] < chave) {
                return buscaBinariaRecursiva(arr, chave, meio + 1, direita); // Buscar na metade direita
            } else {
                return buscaBinariaRecursiva(arr, chave, esquerda, meio - 1); // Buscar na metade esquerda
            }
        }

        return -1; // Chave não encontrada

    }
}