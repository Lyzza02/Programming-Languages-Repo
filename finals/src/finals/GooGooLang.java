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
public class GooGooLang extends javax.swing.JFrame {

    /**
     * Creates new form GooGooLang
     */
    public GooGooLang() {
        initComponents();
    }


   //Declare Global Dictionary for storing variables 
   Dictionary dictionary = new Hashtable();
   //Declare Global input counting variable
   int input_count = 0;
   //Declare Global variable counter
   int var_count=0;
   //Declare Global string data for output_code
   StringBuilder output_data = new StringBuilder(""); 
   
  
   //prompt every input keyword
   public String input_prompt(String msg){
       String input_data;
        input_data = JOptionPane.showInputDialog(null,msg);
        return input_data;
   }

   
   public void var(String var_name, int var_value){
   
   //if(typechecking){
      dictionary.put(var_name, var_value); 
      System.out.println("Variable "+var_name+ " has value "+dictionary.get(var_name));
    //}else{ typchecking(); 
    
   }
  
   
   
   public void input(String var_name,String var_value) {
       
        String input_message = "\ninput integer value for variable "+var_name+":  ";
        output_data.append(input_message);
        String string = output_data.toString();
        output_code.append(string);
        
    
      
        output_code.setText("");
        output_data.append(var_value);
        string = output_data.toString();
        output_code.append(string);
     
        output_code.setHighlighter(null);
        output_code.setForeground(Color.PINK);
        output_code.setBackground(Color.BLACK);
  
   }
         
         
//>output(string output){
// - call typechecking();
// - print 
//}
//  sample: var age1 = 12;
//	  var age2 = 13;
//	  output age1 + age2;
//	  output_code "25"

    public void output(String var_name){
    //if(typechecking){
       System.out.println("Variable "+var_name+ " has value "+dictionary.get(var_name));
    //}else{ typchecking(); 
    String add = "\nOutput variable "+var_name+" : "+dictionary.get(var_name).toString();
    output_code.append(add);
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
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        run_btn.setText("RUN");
        run_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                run_btnMouseClicked(evt);
            }
        });

        jLabel1.setText("PUT SAMPLE CODE HERE");

        input_code.setColumns(20);
        input_code.setRows(5);
        input_code.setText("var in = 2;\nvar out;\nvar red;\ninput red;\ninput out;\nvar sum;\nsum = in + out;\noutput sum;");
        jScrollPane1.setViewportView(input_code);

        jTabbedPane3.addTab("GooInput", jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(run_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(run_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

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

        jButton2.setText("Clear Console");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jLabel2.setText("GOOGOOLANG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(442, 442, 442)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(202, 202, 202))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void run_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_run_btnMouseClicked
         output_code.setText("\\={ GooGooLang }=/\n\n");
        //if(typechecking){
        
        String string = input_code.getText();
        //Split string line with ';'
        String[] statements = string.split("(?=;)");
        
        
        for (int line = 0; line<statements.length;line++) {
             
            System.out.println(statements[line]);
             
             if(statements[line].contains("var")){
              //add 1 & print variable count   
              var_count+=1;
              System.out.println("variable# "+var_count);
              //remove whitespaces
              String no_blank = statements[line].replaceAll("\\s+", "");  
              System.out.println(no_blank); 
              //Removes 'var', '=', and ';'
              String[] var_value = no_blank.split("var|=|;");
                //calls var() by condition
                if(var_value[1].isBlank()==false)
                  var(var_value[1],Integer.parseInt(var_value[2]));
                else
                  var(var_value[2],0);     
             }
             
              if(statements[line].contains("input")){
              input_count+=1;    
              //add 1 annd print input count    
              System.out.println("input# "+input_count);
              
              //remove whitespaces
              String no_blank = statements[line].replaceAll("\\s+", "");  
              System.out.println(no_blank); 
              
              //Removes 'input', '=', and ';'
              String[] input_value = no_blank.split("input|=|;");
                
                 
                String string_input = (input_prompt("input integer value for variable "+input_value[2]+":  "));
                int int_input = Integer.parseInt(string_input);
                
             
                //calls input()
                input(input_value[2],string_input);
          
               
                 var(input_value[2],int_input);
                 
              } 
              
              if(statements[line].contains("output")){

              //remove whitespaces
              String no_blank = statements[line].replaceAll("\\s+", "");  
              System.out.println(no_blank); 
              
              //Removes 'output', '=', and ';'
              String[] output_value = no_blank.split("output|=|;");
                
               output(output_value[2]);
                 
              }  
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
             
        }
        
        //}












        // TODO add your handling code here:
    }//GEN-LAST:event_run_btnMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
output_code.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

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
    private javax.swing.JButton jButton2;
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
