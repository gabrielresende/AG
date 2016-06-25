/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NOTE
 */
public class Individuo2 {
    
    int[] alelo = new int[10];
    double valorDecodificado;
    double avaliacao;
    int rank;

    public void geraIndividuo() {
        for (int i = 0; i < alelo.length; i++) {         
            if(AG.random.nextDouble()<0.5){ // bit 0
                    alelo[i] = 0;
                }else{   // bit 1
                    alelo[i]  = 1;
                }
        }
    }
    
    
     public void avaliaIndividuo(double[] serie) {   // recebi a serie temporal como parametro para avaliar o fitness
        
        this.decodificaBin(this.alelo);
        double lim1 = this.valorDecodificado/3;
        double lim2 = lim1*2;
        double lim3 = this.valorDecodificado;
        
        double soma = 0;
        double penalidade = 0;
        int countLim1=0;
        int countLim2=0;
        int countLim3=0;
        int erro=0;
        double totalMedia=0;
               
        for(int j=0; j<serie.length; j++){
            
            if(serie[j]>0 && serie[j]<lim1){
                soma+=25;
                countLim1++;
 
            }
            if(serie[j]>=lim1 && serie[j]<lim2){
                soma+=75;
                countLim2++;
            }
            if(serie[j]>=lim2 && serie[j]<=lim3){
                soma+=100;
                countLim3++;
            }
            if(serie[j]>lim3){
                penalidade += (lim3 - serie[j]);
                erro++;
            }
            

            
            
        } 
        
        
            totalMedia =  (countLim1+countLim2+countLim3)/3;
            int limite1 = Math.abs((int)(totalMedia-countLim1));
            int limite2 = Math.abs((int)(totalMedia-countLim2));
            int limite3 = Math.abs((int)(totalMedia-countLim3));
            
            int somaDIferencas =  (limite1+limite2+limite3);

            this.avaliacao = (1/((1+somaDIferencas)+((erro*AG.ajusteErro)+(lim3/1000))));

    }
     
     public void decodificaBin(int[] entrada){
     
        double soma=0;
        for(int i=0; i<entrada.length; i++){           
            if(entrada[i]==0){ // bit 0
                soma += ((Math.pow(2, (entrada.length -1)-i))*0);
            }else{ // bit 1
                soma += ((Math.pow(2, (entrada.length -1)-i))*1);
            }
        }
        this.valorDecodificado = soma;
     
     }
     
     public void recebiAlelo(int[] vetor){     
         for(int i=0; i<vetor.length; i++){         
             this.alelo[i] = vetor[i];         
         }     
     }
     

     
     
    public Individuo2 crossoverPonto(Individuo2 pai2, double tx_crossover) {    // para teste crossover simples

        String aux1;
        Individuo2 filho = new Individuo2();

        int ponto1 = (int) AG.random.nextDouble() * pai2.alelo.length;	   // sorteia ponto de corte!
        int ponto2 = (int) AG.random.nextDouble() * (pai2.alelo.length-ponto1);	   // sorteia ponto de corte!
        ponto2 = ponto1+ponto2;
        
        if (AG.random.nextDouble() < tx_crossover) {
            filho.alelo = this.alelo;
            for (int i = ponto1; i < pai2.alelo.length; i++) {
                filho.alelo[i] = pai2.alelo[i];
            }
            for (int i = ponto2; i < pai2.alelo.length; i++) {
                filho.alelo[i] = this.alelo[i];
            }
        } else {
            filho.alelo = this.alelo;
        }

        return filho;
    }
    
    public void mutacaoAleatoria(double tx_mutacao) {    // mutatação para testes

        for (int i = 0; i < this.alelo.length; i++) {
            if (AG.random.nextDouble() < tx_mutacao) {
                int mutacao;
                boolean valida = false;
                while (valida != true) {
                    mutacao = AG.random.nextInt(2);
                    if (mutacao != this.alelo[i]) {
                        this.alelo[i] = mutacao;
                        valida = true;
                        break;
                    }
                }
            }
        }
    }
    
    public void printIndividuo(){
               System.out.print("valor : "+(int)this.valorDecodificado+" - fit : "+this.avaliacao+" : rank : "+this.rank+" : ");
        System.out.print(" | ");
        for(int i=0; i<this.alelo.length; i++){
            System.out.print(this.alelo[i]+" | ");
        }
        System.out.println("");
 
        
    }
    
    
    public int[] getAlelo() {
        return alelo;
    }

    public void setAlelo(int[] alelo) {
        this.alelo = alelo;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
}
