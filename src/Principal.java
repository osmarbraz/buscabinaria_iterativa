/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 *
 *
 * Página 580 Thomas H. Cormen 3 ed
 *
 * Algoritmo de Busca Binária Iterativa/Iterative BinarySearch
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtração de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 * 
 */

/**
 *
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

    /**
     * Retorna o maior valor entre dois valores inteiros.
     *
     * @param a primeiro valor inteiro.
     * @param b segundo valor inteiro.
     * @return o maior valor entre os a e b
     */
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    
     /**
     * O piso (= floor) de um número real x é o resultado do arredondamento de x
     * para baixo. Em outras palavras, o piso de x é o único número inteiro i
     * tal que i<=x<i+1. Ex. O piso de 3.9 é 3
     *
     * Em java pode ser utilizando Math.floor(double)
     *
     * @param x Número real a ser calculado o piso.
     * @return um valor inteiro com o piso de x.
     */
    public static int piso(double x) {
        //Pego a parte inteira de x
        int parteInteira = (int) x;
        //Pego a parte fracionária de x
        double parteFracionaria = x - parteInteira;
        //Retorno x subtraindo a parte fracionária 
        return (int) (x - parteFracionaria);
    }    
          
    /**
     * Busca Binária Iterativa.
     * Entrada: Vetor A, delimitadores e e d do subvetor e x.
     * B Saída: Índice 1 <= i <= n tal que A[i] = x ou i = 0
     * 
     * Pior caso Theta(log n)
     * 
     * Página 580 Thomas H. Cormen 3 ed
     * 
     * @param x valor a ser procurado no vetor
     * @param T vetor com os valores 
     * @param p índice do inicio do vetor
     * @param r índice do final do vetor
     *
     */
    public static int buscaBinaria(int x, int[] T, int p , int r) {
        int menor = p;
        int maior = max(p,r);
        while (menor < maior) {
            int meio = piso(((menor+maior)/2));            
            if (x <= T[meio-1]){
                maior = meio;
            } else {
                menor = meio + 1;
            }
        }        
        return maior;
    }       
    
    public static void main(String[] args) {
        
        //Vetor dos dados    
        int T[] = {10, 20, 30, 40, 50, 60, 70, 80};
        
        //Inicio do vetor
        int p = 1;
        //Fim do vetor
        int r = T.length;
        
        System.out.println(">>> Algoritmo de Busca Binária Iterativa/Iterative BinarySearch <<<");
                
        //Valor a ser procurado
        int x = 10;        
        int i = buscaBinaria(x, T, p , r);
        System.out.println("Teste 1: o valor: "+ x + " está na posição :"+i);
        
        //Valor a ser procurado
        x = 40;        
        i = buscaBinaria(x, T, p , r);
        System.out.println("Teste 2: o valor: "+ x + " está na posição :"+i);
        
        //Valor a ser procurado
        x = 80;        
        i = buscaBinaria(x, T, p , r);
        System.out.println("Teste 3: o valor: "+ x + " está na posição :"+i);
    }    
}