/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocedorexpresiones;

/**
 *
 * @author cadav
 */
public class Analyzer {
    
    String xpression;
    
    public Analyzer(String xpression){
        this.xpression = xpression;
    }
    
    public void recognizeExpression(){
        
    }
    
    public static String validarCondicion(String condicional){
    condicional = condicional.toUpperCase();
    int i = 0;
    int estado = 0;
    char simbolo;
    while(condicional.charAt(i) != '┤'){
        if((condicional.charAt(i) == 'V') || (condicional.charAt(i) == 'F')){
            simbolo = 'S';
        }else if((condicional.charAt(i) == '=') || (condicional.charAt(i) == '&') || (condicional.charAt(i) == '|')){
            simbolo = 'O';
        }else if(condicional.charAt(i) == '!'){
            simbolo = 'N';
        }else{
           return "El caracter " + condicional.charAt(i) + " no es válido"; 
        }
        switch (estado){
            case 0: switch(simbolo){
                case 'S': estado = 2;
                break;
                case 'O': estado = 4;
                break;
                case 'N': estado = 1;
                break;
            }
            break;
            case 1: switch(simbolo){
                case 'S': estado = 2;
                break;
                case 'O': estado = 4;
                break;
                case 'N': estado = 4;
                break;
            }
            break;
            case 2:switch(simbolo){
                case 'S': estado = 4;
                break;
                case 'O': estado = 3;
                break;
                case 'N': estado = 3;
                break;
            }
            break;
            case 3:switch(simbolo){
                case 'S': estado = 4;
                break;
                case 'O': estado = 0;
                break;
                case 'N': estado = 4;
                break;
            }
            break;
            case 4: switch(simbolo){
                case 'S': estado = 4;
                break;
                case 'O': estado = 4;
                break;
                case 'N': estado = 4;
                break;
            }
            break;
        }
        i++;
    }
    if(estado == 2){
        return "Secuencia Válida";
    }else{
        return "Secuencia Inválida";
    }
}
    
    
}
