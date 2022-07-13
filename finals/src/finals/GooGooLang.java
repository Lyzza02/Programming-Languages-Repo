/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finals;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
/**
 *
 * @author 10017
 */
@SuppressWarnings("unchecked")
public class GooGooLang extends javax.swing.JFrame {

    /**
     * Creates new form GooGooLang
     */
    public GooGooLang() {
        initComponents();
    }
/*
 *    START OF GLOBAL  VARIABLE DECLARATIONS  
 * 
 */
   //Declare Global Dictionary for storing variables 
   Dictionary dictionary = new Hashtable();
   //Declare Global input counting variable
   int input_count = 0;
   //Declare Global variable counter
   int var_count=0;
   //Declare Global string data for output_code
   public static int prev=2147483647;
   
/*
 *    END OF GLOBAL  VARIABLE DECLARATIONS  
 * 
 */   

   public void var(String var_name, int var_value){
   
   //if(typechecking){
      dictionary.put(var_name, var_value); 
      System.out.println("Variable "+var_name+ " has value "+dictionary.get(var_name));
    //}else{ typchecking(); 
    
   }
   
   //prompt every input keyword
   public String input_prompt(String msg){
       String input_data;
        input_data = JOptionPane.showInputDialog(null,msg);
        return input_data;
   }
   //input keyword
    public void input(String var_name,String var_value) {
       
        String input_message = "\ninput integer value for variable "+var_name+":  ";
        output_code.append(input_message+var_value);
     
        output_code.setForeground(Color.PINK);
        output_code.setBackground(Color.BLACK);
   }
    
    //Checking if the parenthesis is balance or not
    public static Boolean balanceParenthesis(String word){
        Stack<String> stack = new Stack<>();
        for(int i=0; i < word.length(); i++){
            if (word.charAt(i) == '('){
                stack.push("(");
            } else if (word.charAt(i) == ')'){
                ////checking the contents of a stack
                if (stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                }
            } 
        }
        
        //checking the contents of a stack
        if (stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
         
    public void output(String var_name){
    //if(typechecking){
    System.out.println("Variable "+var_name+ " has value "+dictionary.get(var_name));
    //}else{ typchecking(); 
    String add = "\nOutput variable "+var_name+" : "+dictionary.get(var_name).toString();
    output_code.append(add);
   }
    
    
   //manipulate prev value for operations
   public int get_prev(int cur,String op){
       if(prev==2147483647)
           prev=cur;
       else {
           switch (op){
               case "+":
                   return prev=prev+cur;
                   
               case "-":
                   return prev=prev-cur;
                   
               case "*":
                   return prev=prev*cur;
                   
               case "/":
                   return prev=prev/cur;
           }
       }
   return prev;
   }
    //operations
    public void operations(String var_name,String op){
      int cur = Integer.parseInt(dictionary.get(var_name).toString());
      System.out.println("prev : "+prev);  
      System.out.println(var_name+" : "+cur);  

        if(op.equals("=")){
               System.out.println(var_name+" : "+prev);  
               dictionary.put(var_name,prev);

           }else{   
                if(prev==2147483647){
                    prev =  cur;  
                }else{
                    get_prev(cur,op);
                } 
           }      
       }
    
    public static String check_var(String text) {
        try {
            Integer.parseInt(text);
            return "number";
          } catch (NumberFormatException e) {
            return text;
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        run_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        input_code = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        output_code = new javax.swing.JTextArea();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(135, 67, 86));

        jPanel1.setBackground(new java.awt.Color(246, 137, 137));

        run_btn.setText("RUN");
        run_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                run_btnMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PUT SAMPLE CODE HERE");

        input_code.setColumns(20);
        input_code.setRows(5);
        input_code.setText("var a = 2;\nvar c = 2;\nvar b = 2;\nvar math; \nmath = a + b + c;\noutput math;");
        jScrollPane1.setViewportView(input_code);

        jTabbedPane3.addTab("GooInput", jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(run_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(run_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel2.setBackground(new java.awt.Color(246, 137, 137));

        jButton1.setText("Open Lexial Analyzer");

        output_code.setEditable(false);
        output_code.setBackground(new java.awt.Color(0, 0, 0));
        output_code.setColumns(20);
        output_code.setForeground(new java.awt.Color(255, 255, 255));
        output_code.setRows(5);
        jScrollPane2.setViewportView(output_code);

        jTabbedPane1.addTab("GooOutput", jScrollPane2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jTabbedPane2.addTab("GooErrors", jScrollPane3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jTabbedPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jLabel2.setBackground(new java.awt.Color(222, 182, 171));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 32)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GooGooGnomes");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void run_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_run_btnMouseClicked
 output_code.setText("\\={ GooGooLang }=/\n\n");
 prev=2147483647;
 int cnt_back=0;
         //if(typechecking){
       
        String string = input_code.getText();
        
        //Split string line with ';'
        String[] statements = string.split("(?=;)");
        
        for (int line = 0; line<statements.length;line++) {
            
            
            System.out.println(statements[line]);
             
            //Var Keyword
             if(statements[line].contains("var")){
                //add 1 & print variable count   
                var_count+=1;
                System.out.println("variable# "+var_count);
                //remove whitespaces
                String no_blank = statements[line].replaceAll("\\s+", "");  
                String no_semi = no_blank.replaceAll(";", "");
                
                System.out.println(no_blank); 
                //Removes 'var', '=', and ';'
                String[] var_value = no_semi.split("var|=|;");
                //calls var() by condition
                if(var_value.length>2)
                  var(var_value[1],Integer.parseInt(var_value[2]));
                else
                  var(var_value[1],0);
             }
             
             //Input Keyword
              if(statements[line].contains("input")){
                input_count+=1;    
                //add 1 annd print input count    
                System.out.println("input# "+input_count);

                //remove whitespaces
                String no_blank = statements[line].replaceAll("\\s+", "");  
                System.out.println(no_blank); 

                //Removes 'input', '=', and ';'
                String[] input_value = no_blank.split("input|=|;");
                
                //input string for input() -->to show in console
                String string_input = (input_prompt("input integer value for variable "+input_value[2]+":  "));
                //input int for var() --> for operations/other functions
                int int_input = Integer.parseInt(string_input);
                
                //calls input()
                //input_value[2] --> variable name
                input(input_value[2],string_input);
                 //calls var() to store input value
                 var(input_value[2],int_input);
              } 
              
              //output keyword
              if(statements[line].contains("output")){
                //remove whitespaces
                String no_blank = statements[line].replaceAll("\\s+", "");  
                System.out.println(no_blank); 

                //Removes 'output', '=', and ';'
                String[] output_value = no_blank.split("output|=|;");
                 //calls output() to display variable value 
                 output(output_value[2]);
              }               
              
              //operations 
              if(statements[line].contains("+")||statements[line].contains("-")
                      ||statements[line].contains("*")||statements[line].contains("/")){
  
                //remove whitespaces
                String no_blank = statements[line].replaceAll("\\s+", "");
                String no_semi = no_blank.replaceAll(";", "");
                System.out.println("\n"+no_semi); 

                //Split string line with '+,-,*,/,='
                String[]operations = no_semi.split("(?=\\+)|(?<=\\+)|"
                        + "(?=\\-)|(?<=\\-)|"
                        + "(?=\\*)|(?<=\\*)|"
                        + "(?=\\/)|(?<=\\/)|"
                        + "(?=\\=)|(?<=\\=)");
 
                for(int n = 0; n < operations.length;n++){
                //paranthesis    
             
                //process operation per character split 
                    if(operations[n].contains("+")||operations[n].contains("-")||
                            operations[n].contains("*")||operations[n].contains("/")){
                       String op = operations[n];
                        //Behind of op
                        if(cnt_back==0){
                            if(check_var(operations[n-1]).equals("number")){
                                if(prev==2147483647){
                                    prev=Integer.parseInt(operations[n-1]);
                                }else{
                                    get_prev(Integer.parseInt(operations[n-1]),op);
                                }
                            }else{
                                operations(operations[n-1],op);
                            }
                        } cnt_back=+1;
                        //In front of op
                            if(check_var(operations[n+1]).equals("number")){
                                if(prev==2147483647){
                                    prev=Integer.parseInt(operations[n+1]);
                                }else{
                                   get_prev(Integer.parseInt(operations[n+1]),op);
                                }
                            }else{
                                    operations(operations[n+1],op);
                            }
                            
                      //at the last item, assign value to variable      
                    }else if(n==operations.length-1){   
                          operations(operations[0],"=");
                    }            
               }  
              }         
        }
       //} 
    }//GEN-LAST:event_run_btnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GooGooLang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GooGooLang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GooGooLang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GooGooLang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GooGooLang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea input_code;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea output_code;
    private javax.swing.JButton run_btn;
    // End of variables declaration//GEN-END:variables
}
