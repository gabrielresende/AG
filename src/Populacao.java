
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NOTE
 */
public class Populacao {

    int tamanho = AG.tamanhoPopulacao;
    Individuo2[] ind = new Individuo2[this.tamanho];
    double totalAvaliacao;

    //MersenneTwisterFast random = new MersenneTwisterFast(System.nanoTime());

    public Populacao(int tamanho) {
        this.tamanho = tamanho;
    }

    public void geraPopulacao() {
        for (int i = 0; i < this.ind.length; i++) {
            ind[i] = new Individuo2();
            ind[i].geraIndividuo();
        }
    }

    public void avaliaPop(double[] serie) {
        this.totalAvaliacao =0;
        for (int i = 0; i < this.ind.length; i++) {
            ind[i].avaliaIndividuo(serie);
            this.totalAvaliacao += ind[i].avaliacao;
        }
        this.rank();
    }

    public int roleta() {

        int i;
        double aux = 0;

        double limite = AG.random.nextDouble() * this.totalAvaliacao;
        for (i = 0; ((i < this.tamanho) && (aux < limite)); i++) {
            aux += ((this.ind[i]).getAvaliacao());
        }

        i--;	// ajuste do indice selecionado
        // System.out.println("Escolhi o elemento de indice "+i);
        return (i);
    }
    
    public int torneio(int tamanhoRing) {

        int[] pais = new int[tamanhoRing];
        
        int vencedor=0;
        
        for(int i=0; i<tamanhoRing; i++){        
            pais[i]=AG.random.nextInt(this.tamanho);            
        }
        
        Arrays.sort(pais);
        
        double selecao = 1;
        
        double ganhador = AG.random.nextDouble();
        
        for(int i=0; i<tamanhoRing; i++){
            selecao = selecao/2;
            
            if(ganhador>selecao){
                vencedor = pais[i];
                break;
            }            
        }
            vencedor = this.rank(vencedor);
        return vencedor;
    }
    
        public void rank() { 
        double[] lista = new double[this.ind.length];
        double[] auxDes = new double[this.ind.length];

        int retorno = 0;

        for (int i = 0; i < lista.length; i++) {
            lista[i] = this.ind[i].getAvaliacao();
            auxDes[i] = this.ind[i].getAvaliacao();
            //   System.out.println("lista = "+i+" valor = "+populacao[i].getAvaliacao());
        }
        Arrays.sort(lista);
        int indice = lista.length;
        for (int i = 0; i < lista.length; i++) {
            for (int j = 0; j < lista.length; j++) {
                if (lista[i] == auxDes[j]) {
                    indice--;
                    this.ind[j].setRank(indice);
                    auxDes[j] = (-100000);
                }
            }
        }
    }
    
    
     public int rank(int index) {  // metodo para encontrar o indice do individuo no vetor, 
        int retorno = 0;
        for (int i = 0; i < this.tamanho; i++) {
            if(this.ind[i].getRank()==index){
                retorno = i;
            }
        }
        return retorno;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Individuo2[] getInd() {
        return ind;
    }
    public Individuo2 getInd(int posicao) {
        return ind[posicao];
    }
    

    public void setInd(Individuo2[] ind) {
        this.ind = ind;
    }
    public void setInd(Individuo2 ind, int posicao) {
        this.ind[posicao] = ind;
    }
    
    public void setIndRank(Individuo2 ind, int rank) {
        
        int retorno = 0;
        for (int i = 0; i < this.tamanho; i++) {
            if(this.ind[i].getRank()==rank){
                retorno = i;
            }
        }
        
        this.ind[retorno] = ind;
        
    }

    public double getTotalAvaliacao() {
        return totalAvaliacao;
    }

    public void setTotalAvaliacao(double totalAvaliacao) {
        this.totalAvaliacao = totalAvaliacao;
    }
     
     

}
