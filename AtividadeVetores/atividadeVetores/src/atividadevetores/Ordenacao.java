package atividadevetores;

import javax.swing.JOptionPane;

public class Ordenacao {

    public static void main(String[] args) {

        int qtds;

        qtds = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade do vetor:"));
        int[] numbers = new int[qtds];
        for (int i = 0; i < numbers.length; i++) {
            String input = JOptionPane.showInputDialog("Coloque o numero de sua posicao " + i + ":");
            numbers[i] = Integer.parseInt(input);
            System.out.println();
        }
        System.out.println("Array desordenado: ");
        for (int i = 0; i < numbers.length; i++) {

            System.out.println(numbers[i]);
        }
        System.out.println("\n");

        for (int i = 0; i < numbers.length; i++) {
            
            
        }
        String input = JOptionPane.showInputDialog("Qual operação deseja realizar:? \n"
                + "'S' SelectionSort\n "
                + "'I' InsertionSort\n"
                + "'B' BubbleSort\n ");
        switch (input.toUpperCase()) {

            case "S" -> {
                selectionSort(numbers);
                System.out.println("Ordenado pelo selection sort: ");
                for (int number : numbers) {
                    System.out.println(number);
                }
                break;
            }
            
            case "I" -> {
                insertionSort(numbers);
                System.out.println("Ordenado pelo insertion sort: ");
                for (int number : numbers) {
                    System.out.println(number);
                }
                break;
            }

            case "B" -> {
                bubbleSort(numbers);
                System.out.println("Ordenado pelo Bubble Sort: ");
                for (int number : numbers) {
                    System.out.println(number);
                }
                break;
            }
            
        }

        mostraTempoTodas(numbers);

    }

    public static void bubbleSort(int[] arr) {
        int qtd = 0;
        int troca = 0;
        long inicio = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    qtd++;
                    troca++;
                } else {
                    qtd++;
                }
            }
        }
        long fim = System.nanoTime();
        long tempo = fim - inicio;
        System.out.println("Quantidade de movimentos: " + qtd);
        System.out.println("Quantidade de trocas: " + troca);
        System.out.println("Tempo de execução: " + tempo + " ms");
        System.out.println("\n");
    }

    public static void selectionSort(int[] arr) {
        long inicio = System.nanoTime();
        int qtd = 0;
        int troca = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[posMenor]) {
                    posMenor = j;
                }
                qtd++;
            }
            if (posMenor != i) {
                int aux = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = aux;
                qtd++;
                troca++;
            }
        }
        long fim = System.nanoTime();
        long tempo = fim - inicio;
        System.out.println("Quantidade de movimentos: " + qtd);
        System.out.println("Quantidade de trocas: " + troca);
        System.out.println("Tempo de execução: " + tempo + " ms");
        System.out.println("\n");
    }

    public static void insertionSort(int[] arr) {
        long inicio = System.nanoTime();

        int qtd = 0;
        for (int i = 1; i < arr.length; i++) {
            int chave = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > chave; j--) {
                arr[j + 1] = arr[j];
                qtd++;
            }
            arr[j + 1] = chave;
            qtd++;
        }
        long fim = System.nanoTime();
        long tempoExecucao = fim - inicio;
        System.out.println("Quantidade de movimentos: " + qtd);
        System.out.println("Tempo de execução: " + tempoExecucao + " ms");
        System.out.println("\n");
    }

    public static void mostraTempoTodas(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

}

