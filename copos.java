import java.util.Scanner;

public class copos {

    static void insereMoeda(char posicaoInicial, int[] vetorPosicoes){
        if(posicaoInicial == 'A'){
            vetorPosicoes[0] = 1;
        }else if(posicaoInicial == 'B'){
            vetorPosicoes[1] = 1;
        }else if(posicaoInicial == 'C'){
            vetorPosicoes[2] = 1;
        }else{
            System.out.printf("Erro");
            System.exit(0);
        }
    }

    static void trocaAB(int[] vetorPosicoes){
        if(vetorPosicoes[0] == 0 && vetorPosicoes[1] == 1 && vetorPosicoes[2] == 0){
            vetorPosicoes[0] = 1;
            vetorPosicoes[1] = 0;
            vetorPosicoes[2] = 0;
        }else if(vetorPosicoes[0] == 1 && vetorPosicoes[1] == 0 && vetorPosicoes[2] == 0){
            vetorPosicoes[0] = 0;
            vetorPosicoes[1] = 1;
            vetorPosicoes[2] = 0;
        }
    }

    static void trocaBC(int[] vetorPosicoes){
        if(vetorPosicoes[0] == 0 && vetorPosicoes[1] == 1 && vetorPosicoes[2] == 0){
            vetorPosicoes[0] = 0;
            vetorPosicoes[1] = 0;
            vetorPosicoes[2] = 1;
        }else if(vetorPosicoes[0] == 0 && vetorPosicoes[1] == 0 && vetorPosicoes[2] == 1){
            vetorPosicoes[0] = 0;
            vetorPosicoes[1] = 1;
            vetorPosicoes[2] = 0;
        }
    }

    static void trocaAC(int[] vetorPosicoes){
        if(vetorPosicoes[0] == 1 && vetorPosicoes[1] == 0 && vetorPosicoes[2] == 0){
            vetorPosicoes[0] = 0;
            vetorPosicoes[1] = 0;
            vetorPosicoes[2] = 1;
        }else if(vetorPosicoes[0] == 0 && vetorPosicoes[1] == 0 && vetorPosicoes[2] == 1){
            vetorPosicoes[0] = 1;
            vetorPosicoes[1] = 0;
            vetorPosicoes[2] = 0;
        }
    }

    static void descobreMoeda(int[] vetorPosicoes){
        if(vetorPosicoes[0] == 1){
            System.out.println("A");
        }
        if(vetorPosicoes[1] == 1){
            System.out.println("B");
        }
        if(vetorPosicoes[2] == 1){
            System.out.println("C");
        }
    }

    public static void main(String[] args) {
        
        //Temos 3 copos, A, B e C.
        //Banca pode realizar 3 tipos de movimentos. 
        //Os movimentos consistem em trocar a posição dos copos A com o B, B com C e A com C.
        //Utilizaremos um vetor de três elementos. Inicialmente o vetor começará zerado. 
        //A posição 0 representará o copo A. A posição 1 representará o copo B e a posição 2 o copo C.
        //Caso a moeda esteja no copo A e um movimento do tipo trocaAB seja realizado, o vetor sairá de [1,0,0] para [0,0,1]
    	//Para isso serão criadas 3 funções void que realizarão as trocas chamadas: trocaAB, trocaBC, trocaAC.
    	//Como o desafio pede, primeiro armazenaremos o número de trocas que serão realizadas.
        int vetorPosicoes[] = {0,0,0};
        char posicaoInicial = ' ';
        int numeroDaTroca = 0;
        Scanner in = new Scanner(System.in);
        int numeroMaxTrocas = in.nextInt();

        //Em seguida escolheremos a posição em que a moeda irá começar.
        posicaoInicial = in.next().charAt(0);
        
        //Esse método apenas insere a moeda na posição desejada.
        insereMoeda(posicaoInicial, vetorPosicoes);

        //Agora que temos a moeda posicionada em um dos copos, faremos N iterações chamando as funções de troca.

        while(numeroMaxTrocas > 0){
            numeroDaTroca = in.nextInt();
            switch (numeroDaTroca){
                case 1:
                    trocaAB(vetorPosicoes);
                    break;
                
                case 2:
                    trocaBC(vetorPosicoes);    
                    break;

                case 3:
                    trocaAC(vetorPosicoes);
                    break;
            }
            numeroMaxTrocas--;
        }

        //Finalmente depois de realizar N trocas, obtemos o resultado
        descobreMoeda(vetorPosicoes);

    }
}