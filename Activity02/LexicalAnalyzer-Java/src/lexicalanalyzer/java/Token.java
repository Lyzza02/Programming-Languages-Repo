/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer.java;

/**
 *
 * @author Admin
 */
public class Token {
    private final String TT_INT = "INT";
    private final String TT_FLOAT = "FLOAT";
    private final String TT_PLUS = "PLUS";
    private final String TT_MUL = "MINUS";
    private final String TT_DIV = "DIV";
    private final String TT_LPAREN  = "LPAREN";
    private final String TT_RPAREN  = "RPAREN";
    
    
    private String type;
    private String value;
    
    Token(String type_, String value){
        this.type = type_;
        this.value = null;
    }
    
    public String return_ (){
        Token t = new Token (this.type, this.value);
        if (this.value == null){
            return this.type+":"+this.value;
        } 
        
        return this.type;
    }
}