/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import java.io.FileNotFoundException;

/**
 *
 * @author NOTE
 */
public class teste {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        
        String entrada = "";
        
            for(int i=0; i<10; i++){
                if(Math.random()<0.5){
                    entrada = entrada+0;
                }else{
                    entrada = entrada+1;
                }
            }

        System.out.println("palavra "+entrada);
        
        System.out.println("tamano "+entrada.length());
        
        entrada="1111111111";
        
       // double teste = Math.pow(2, 4);
        
     //   System.out.println("teste "+teste);   Integer.valueOf()
        double soma=0;
        for(int i=0; i<entrada.length(); i++){
            
          int bit = Integer.valueOf(entrada.charAt(i));
            System.out.println("bit - "+bit);
            
            if(bit==48){ // bit 0
                soma += ((Math.pow(2, (entrada.length()-1)-i))*0);
            }else{ // bit 1
                soma += ((Math.pow(2, (entrada.length()-1)-i))*1);
            }
            }
        
        System.out.println("resultado binario "+entrada);
        System.out.println("resultado decimal "+soma);
        
        int test = 39;
        
        test = 39/2;
        
        
        
        
        System.out.println("test --== "+test);
        System.out.println("mod --== "+test%2);
        int resultado = (int)soma;
        String nova = "";
        while(resultado!=1){            
            nova = nova+(resultado%2);
            resultado= resultado/2;
        }
        nova = nova+"1";
        
        
        System.out.println("nova "+nova);
    }
    
}
