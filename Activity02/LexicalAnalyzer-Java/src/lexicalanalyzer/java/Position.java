public class Position {
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
