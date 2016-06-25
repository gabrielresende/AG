package tabela;

/*
classe para entrar planilha que está configurada na unidade D deste computador, arquivo 
 */

/**
 *
 * @author NOTE
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EntraPlanilha {
    
    double[][] saida;
    
    
    // --->>>    entra caminho do arquivo    
        
    // entra quantidade de colunas
    
    // entra quantidade de linhas
    
    // devolve array com os dados da planilha
    
    
    public double[][] entraPlanilha(String caminho, int linhas, int colunas) throws FileNotFoundException{
        
        saida = new double[linhas][colunas];
        
        File file = new File(caminho);
        
        FileInputStream fis = new FileInputStream(file);
        
        try {
            
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            
            XSSFSheet planilha = wb.getSheetAt(0);
            
            Iterator<Row> rowIterator = planilha.iterator();
            
            
        int countRow=0;
            
        while(rowIterator.hasNext()){
            
            System.out.println("-------------------------"+countRow);
            
            Row row = rowIterator.next();
            
            Iterator<Cell> cellIterator = row.iterator();
            
            while(cellIterator.hasNext()){
            
                Cell cell = cellIterator.next();
                
                switch(cell.getColumnIndex()){
                
                    case 0: // coluna 0                        
                        
                        this.saida[countRow][0]=cell.getNumericCellValue();
                        
                    case 1: // coluna 1

                        this.saida[countRow][1]=cell.getNumericCellValue();
                    break;
                    
                    case 2: // coluna 2

                        this.saida[countRow][2]=cell.getNumericCellValue();
                break;                
                
                    case 3: // coluna 3
                        this.saida[countRow][3]=cell.getNumericCellValue();
                        break;
                        
                        
                    case 4: // coluna 4
                        this.saida[countRow][4]=cell.getNumericCellValue();
                        break;
                        
                        
                    case 5: // coluna 5
                        this.saida[countRow][5]=cell.getNumericCellValue();
                        break;       
                        
                        
                    case 6: // coluna 6
                        this.saida[countRow][6]=cell.getNumericCellValue();
                        break;
                        
                        
                    case 7: // coluna 7
                        this.saida[countRow][7]=cell.getNumericCellValue();
                        break;
                        
                        
                    case 8: // coluna 8
                        this.saida[countRow][8]=cell.getNumericCellValue();
                        break;
                                
                    case 9: // coluna 9
                        this.saida[countRow][9]=cell.getNumericCellValue();
                        break;
                        
                        
                    case 10: // coluna 10
                        this.saida[countRow][10]=cell.getNumericCellValue();
                        break;
                        
                    case 11: // coluna 11                        
                        this.saida[countRow][11]=cell.getNumericCellValue();

                        
                }
                
            }
            countRow++;
            if(countRow>=linhas){
                break;
            }
        
        }
        
            System.out.println("saiu do laço");
            
    
        
        } catch (IOException ex) {
            Logger.getLogger(EntraPlanilha.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this.saida;
    }
    
    public void imprimePlanilha(){
    
        System.out.println("tamanho " + this.saida.length);
        
        
        System.out.println("saida da planilha");
        System.out.println("linha  |   ano    |   mês    |   valor  |");
        
        for(int i=0; i<this.saida.length; i++){
            
            System.out.print((i+1)+"      | ");
            
            for(int j=0; j<3; j++){
                
                System.out.print(this.saida[i][j]+"   |   ");
                

            }
            System.out.println();
            
        }
    
    }
    
    
}

