
import java.io.FileNotFoundException;
import tabela.EntraPlanilha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NOTE
 */
public class AG {
    
    static MersenneTwisterFast random = new MersenneTwisterFast(System.currentTimeMillis());
    
    static int tamanhoPopulacao = 20;
    static int ajusteErro = 9;

    public static void main(String[] args) throws FileNotFoundException {

        int geracoes = 5000;
      //  int parada = 25;
        int n_filhos =2   ;
        double tx_mutacao = 0.03; //0.03
        double tx_crossover = 0.5; // 0.5
        
        
        EntraPlanilha entrada = new EntraPlanilha();     
        double[][] series = new double[133][4];
        series= entrada.entraPlanilha("D:\\STFag.xlsx", 133, 4);   /////////// arquivo com a serie temporal está em anexo do projeto
        double[] serie = new double[133];
        for( int i=0; i<133; i++){
            serie[i] = series[i][2];        
        }   
        
        
        

        Populacao pop = new Populacao(tamanhoPopulacao);
        pop.geraPopulacao();
        pop.avaliaPop(serie);
        System.out.print("pop ava : "+(pop.getTotalAvaliacao()/tamanhoPopulacao)+" : ");
        pop.getInd(pop.rank(0)).printIndividuo();

            for(int i=0; i<geracoes; i++){
                
                for(int j=0; j<n_filhos; j++){
                    
                    int pai1 = pop.torneio(5); //pop.roleta();
                    int pai2 = pop.torneio(5); //pop.roleta();
                    
                    Individuo2 filho = new Individuo2();
                    
                    filho.recebiAlelo(pop.getInd(pai1).getAlelo());
                    filho.crossoverPonto(pop.getInd(pai2), tx_crossover);
                    filho.mutacaoAleatoria(tx_mutacao);

                    int troca = ((pop.getTamanho()-n_filhos)+j);
                    pop.setIndRank(filho, troca);
                    pop.ind[troca].decodificaBin(pop.ind[troca].alelo);
                
                }
                
            pop.avaliaPop(serie);
                System.out.print("pop ava : "+(pop.getTotalAvaliacao()/tamanhoPopulacao)+" : ");
                pop.getInd(pop.rank(0)).printIndividuo();  // imprime o melhor individuo
                
            }
            
            }

    }

