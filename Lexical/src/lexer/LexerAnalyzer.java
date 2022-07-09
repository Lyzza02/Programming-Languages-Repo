
package lexer;



public class LexerAnalyzer{
//#######################################
//# CONSTANTS
//#######################################

char [] DIGITS = {'0','1','2','3','4','5','6','7','8','9'};

//#######################################
//# ERRORS
//#######################################



//#######################################
//# POSITION
//#######################################
class Position {
   private int idx;
   private int ln;
   private int col;
   private int fn;
   private String ftxt;
   
   Position(int idx, int ln, int col, int fn, String ftxt){
       this.idx = idx;
       this.ln = ln;
       this.col = col;
       this.fn = fn;
       this.ftxt = ftxt;
   }

   
    public int getidx(){
        return this.idx;
    }
    public int getln(){
        return this.ln;
    }
    public int getcol(){
        return this.col;
    }public int getfn(){
        return this.fn;
    }
    public String getftxt(){
        return this.ftxt;
    }
    
    
    
   
   public Position move(String current_char){
       Position p = new Position(this.idx, this.ln, this.col, this.fn, this.ftxt);
       this.idx += 1;
       this.col += 1;
       
       if(current_char.equals('\n')){
           this.ln += 1;
           this.col = 0;
       }
     
       return p;
   }
   
   public Position copy(){
       Position p = new Position(this.idx, this.ln, this.col, this.fn, this.ftxt);
       return p;
   }
    }

//#######################################
//# TOKENS
//#######################################
 class Token {
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

//#######################################
//# LEXER
//#######################################
class Lexer{
    Position p = new Position();
   
    
    public Lexer(this, fn, text):
        self.fn = fn
        self.text = text
        self.pos = Position(-1, 0, -1, fn, text)
        self.current_char = None
        self.advance()
    
    def advance(self):
        self.pos.advance(self.current_char)
        self.current_char = self.text[self.pos.idx] if self.pos.idx < len(self.text) else None

    def make_tokens(self):
        tokens = []

        while self.current_char != None:
            if self.current_char in ' \t':
                self.advance()
            elif self.current_char in DIGITS:
                tokens.append(self.make_number())
            elif self.current_char == '+':
                tokens.append(Token(TT_PLUS))
                self.advance()
            elif self.current_char == '-':
                tokens.append(Token(TT_MINUS))
                self.advance()
            elif self.current_char == '*':
                tokens.append(Token(TT_MUL))
                self.advance()
            elif self.current_char == '/':
                tokens.append(Token(TT_DIV))
                self.advance()
            elif self.current_char == '(':
                tokens.append(Token(TT_LPAREN))
                self.advance()
            elif self.current_char == ')':
                tokens.append(Token(TT_RPAREN))
                self.advance()
            else:
                pos_start = self.pos.copy()
                char = self.current_char
                self.advance()
                return [], IllegalCharError(pos_start, self.pos, "'" + char + "'")

        return tokens, None

    def make_number(self):
        num_str = ''
        dot_count = 0

        while self.current_char != None and self.current_char in DIGITS + '.':
            if self.current_char == '.':
                if dot_count == 1: break
                dot_count += 1
                num_str += '.'
            else:
                num_str += self.current_char
            self.advance()

        if dot_count == 0:
            return Token(TT_INT, int(num_str))
        else:
            return Token(TT_FLOAT, float(num_str))
            
            
            

            
}
//#######################################
//# RUN
//#######################################
public void Run (String fn, String text){ 
        
  Lexer lexer = new Lexer(fn, text);  
//  token, error = lexer.make_tokens();   
//  return (token, error);

}


}