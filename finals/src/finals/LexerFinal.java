package finals;
import static finals.GooGooLang.prev;
import static finals.LexicalAnalyzer.tokenMap;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class LexerFinal {
    
   static JFrame frame;
   static JPanel panel1;
   static JPanel panel2;
   static JPanel panel3;
   static JPanel panel4;
   static JList list;
   static JList analyzer;
   static JList output;
   static JList errors;
   static JLabel label1;
   static JLabel label2;
   static JLabel label3;
   static JLabel label4;
   
   static JScrollPane scroll;
   static JScrollPane scroll2;
   static JScrollPane scroll3;
   static JScrollPane scroll4;
   
   static JButton editfile;
   static JButton refresh;
   static JButton runall;
   static JButton clear;
   
   static JTextArea jt;
   
   static DefaultListModel<String> inputmodel = new DefaultListModel<>();
   static DefaultListModel<String> analyzermodel = new DefaultListModel<>();
   static DefaultListModel<String> errormodel = new DefaultListModel<>();
   public static String inp[]= {};
   
   public static int linecount = 1;
   public static int commentflag = 0;
   public static int semicolonflag = 0;
   public static ArrayList<String> initialsplit = new ArrayList<>();
   public static ArrayList<String> forlexer = new ArrayList<>();
   public static HashMap<String, String> validvariables = new HashMap<>();
   public static HashMap<String, Integer> usedvariables = new HashMap<>();
   
   
 /*
 *    START OF GLOBAL  VARIABLE DECLARATIONS  
 * 
 */
   //Declare Global Dictionary for storing variables 
    public static Dictionary dictionary = new Hashtable();
   //Declare Global input counting variable
    public static int input_count = 0;
   //Declare Global variable counter
    public static int var_count=0;
   //Declare Global string data for output_code
   public static int prev=2147483647;
   
/*
 *    END OF GLOBAL  VARIABLE DECLARATIONS  
 * 
 */ 
   
   
   
 /*
 *    START OF Run Functions  
 * 
 */

   
      public static void var(String var_name, int var_value){
   
   //if(typechecking){
      dictionary.put(var_name, var_value); 
      System.out.println("Variable "+var_name+ " has value "+dictionary.get(var_name));
    //}else{ typchecking(); 
    
   }
   
   //prompt every input keyword
   public static String input_prompt(String msg){
       String input_data;
        input_data = JOptionPane.showInputDialog(null,msg);
        return input_data;
   }
   //input keyword
    public static void input(String var_name,String var_value) {
       
        String input_message = "\ninput integer value for variable "+var_name+":  ";
        jt.append(input_message+var_value);
     
        jt.setForeground(Color.PINK);
        jt.setBackground(Color.BLACK);
   }
         
    public static void output(String var_name){
    //if(typechecking){
    System.out.println("Variable "+var_name+ " has value "+dictionary.get(var_name));
    //}else{ typchecking(); 
    String add = "\nOutput variable "+var_name+" : "+dictionary.get(var_name).toString();
    jt.append(add);
   }
    
    
   //manipulate prev value for operations
   public static int get_prev(int cur,String op){
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
   
   
   
    //parenthesis
    public static int para(int para){
    
    return para;
    }

    //operations
    public static void operations(String var_name,String var_name2,String op){
      int cur = Integer.parseInt(dictionary.get(var_name).toString());
      System.out.println("prev : "+prev);  
      System.out.println(var_name+" : "+cur);  

        if(op.equals("=")){
               if(var_name2.equals("0_val")){
                    dictionary.put(var_name,prev);
                    System.out.println(var_name+" : "+prev); 
               }else{
                 if(check_var(var_name2).equals("number")){
                        dictionary.put(var_name,Integer.parseInt(var_name2));
                        System.out.println(var_name+" =  "+ dictionary.get(var_name)); 
                 }else{
                        dictionary.put(var_name,Integer.parseInt(dictionary.get(var_name2).toString()));
                        System.out.println(var_name+" =  "+ dictionary.get(var_name)); 
                 }
               }
               
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
    
    //Comment *removes* comments to not be processed
     public static String[] rm_comment(String[] arr, int index)
    {
 
        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
            || index >= arr.length) {
 
            return arr;
        }
 
        // Create another array of size one less
        String[] anotherArray = new String[arr.length - 1];
 
        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {
 
            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }
 
            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }
 
        // return the resultant array
        return anotherArray;
    }
    

       public static void run_input() throws IOException {                                     

        jt.setText("\\={ GooGooLang }=/\n\n");
        prev=2147483647;
        int cnt_back=0;
        int para_num=0;

        int cnt_line=0;
         //if(typechecking){
         
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        String linew = br.readLine();
        while (linew != null) {
          sb.append(linew).append("\n");
          linew = br.readLine();
        }

        String input_code = sb.toString();
         
        String string = input_code;
        
     
          //Split string line with ';'
        String[] statements = string.split("(?=;)");
        
        
        for (int lines = 0; lines<statements.length-1;lines++) {
            
            if(statements[lines].contains("/*")){
                int line = lines;
           
                 do {
                     statements = rm_comment(statements,lines);
                    line++;
                 } while(!statements[lines].contains("*/")&&line<statements.length-1);
                  statements = rm_comment(statements,lines);
            }
       }      
        String [] statement = statements;
        for (int line = 0; line<statement.length-1;line++) {
                
            
            //Var Keyword
             if(statement[line].contains("var")){
                //add 1 & print variable count   
                var_count+=1;
                System.out.println("variable# "+var_count);
                //remove whitespaces
                String no_blank = statement[line].replaceAll("\\s+", "");  
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
             if(statement[line].contains("input")){
                input_count+=1;    
                //add 1 annd print input count    
                System.out.println("input# "+input_count);

                //remove whitespaces
                String no_blank = statement[line].replaceAll("\\s+", "");  
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
             if(statement[line].contains("output")){
                //remove whitespaces
                String no_blank = statement[line].replaceAll("\\s+", "");  
                System.out.println(no_blank); 

                //Removes 'output', '=', and ';'
                String[] output_value = no_blank.split("output|=|;");
                 //calls output() to display variable value 
                 output(output_value[2]);
              }               
              
             //operations 

             
            if(!statement[line].contains("var")){ 
            if(statement[line].contains("+")||statement[line].contains("-")
                      ||statement[line].contains("*")||statement[line].contains("/")
                    ||statement[line].contains("=")){
  
                //remove whitespaces
                String no_blank = statement[line].replaceAll("\\s+", "");
                String no_semi = no_blank.replaceAll(";", "");
                System.out.println("\n"+no_semi); 

                //Split string line with '+,-,*,/,='
                String[]operations = no_semi.split("(?=\\+)|(?<=\\+)|"
                        + "(?=\\-)|(?<=\\-)|"
                        + "(?=\\*)|(?<=\\*)|"
                        + "(?=\\()|(?<=\\()|"
                        + "(?=\\))|(?<=\\))|"
                        + "(?=\\/)|(?<=\\/)|"
                        + "(?=\\=)|(?<=\\=)");
                     
                
                for (int n = 0; n<operations.length;n++) {
                 String op = operations[n];
                 System.out.println(operations.length);
          
                 
                 if(operations.length==3&&op.matches("=")){
                    System.out.println(operations.length+" : "+operations[n-1]+" : "+operations[n+1]+" : "+op);
                    operations(operations[n-1],operations[n+1],"=");
                 }  
                 
                    else if(operations[n].contains("(")){
                                
                          do {
                            
                          if(operations[n].equals("+")||operations[n].equals("-")||
                           operations[n].equals("*")||operations[n].equals("/")){ 
                               System.out.println("para op : "+op);
                        //Behind of op
                        if(cnt_back==0){
                            if(check_var(operations[n-1]).equals("number")){
                                if(prev==2147483647){
                                    prev=Integer.parseInt(operations[n-1]);
                                }else{
                                    get_prev(Integer.parseInt(operations[n-1]),operations[n]);
                                }
                            }else{
                                operations(operations[n-1],"0_val",operations[n]);
                            }
                        } cnt_back=+1;
                        //In front of op
                            if(check_var(operations[n+1]).equals("number")){
                                if(prev==2147483647){
                                    prev=Integer.parseInt(operations[n+1]);
                                }else{
                                   get_prev(Integer.parseInt(operations[n+1]),operations[n]);
                                }
                            }else{
                                    operations(operations[n+1],"0_val",operations[n]);
                            }
                            
                            //at the last item, assign value to variable      
                          }else if(operations[n].contains(")")){
                                operations(operations[0],"0_val","=");
                                 para(prev);
                                }  
                             n++;
                          } while(!operations[n].contains(")"));
                         
                          System.out.println("para : "+para(prev));
                    }
                    
                    else if(operations[n].contains("+")||operations[n].contains("-")||
                           operations[n].contains("*")||operations[n].contains("/")){
                        
                        System.out.println(para(prev));
                          
                        //Behind of op
                        if(cnt_back==0){
                            if(check_var(operations[n-1]).equals("number")){
                                if(prev==2147483647){
                                    prev=Integer.parseInt(operations[n-1]);
                                }else{
                                    get_prev(Integer.parseInt(operations[n-1]),op);
                                }
                            }else{
                                operations(operations[n-1],"0_val",op);
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
                                    operations(operations[n+1],"0_val",op);
                            }
                            
                      //at the last item, assign value to variable      
                    }else if(n==operations.length-1&&operations.length!=3){
                          operations(operations[0],"0_val","=");
                          }  
                   }   
           
            }
         }
       } 
        
                LexicalAnalyzer l = new LexicalAnalyzer();
        tokenMap.put("var", "Keyword");
        tokenMap.put("input", "Keyword");
        tokenMap.put("output", "Keyword");
        tokenMap.put("+", "Operator");
        tokenMap.put("-", "Operator");
        tokenMap.put("*", "Operator");
        tokenMap.put("/", "Operator");
        tokenMap.put("=", "Operator");
        tokenMap.put("/*", "Comment");
        tokenMap.put("*/", "Comment");
        tokenMap.put("(", "Parentheses");
        tokenMap.put(")", "Parentheses");
        tokenMap.put(";", "Symbol");
        l.anaylzer.setText("");
        l.tokenResult.clear();
        String myObj = input_code;
        System.out.println(myObj);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if (l.commentState == true) {
                l.identifyToken(data);
            } else {
                l.analyzer(data);
            }
        }
        myReader.close();
        for (String x : l.tokenResult) {
            l.anaylzer.append(x + "\n");
        }
    } 
  
   
/*
 *    END OF Run Functions  
 * 
 */ 
   
   
  
   
   
   
   
    //creates text file for input
    public static void createFile(){
        try{
          File myObj = new File("input.txt");
          if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
          }else{
            System.out.println("File already exists.");
          }
        }catch (IOException e){
          System.out.println("An error occurred.");
        }
    }
    
    //opens file to edit input
    public static void openFile(){
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("input.txt");
                Desktop.getDesktop().open(myFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void createGUI(){
        panel1 = new JPanel(new BorderLayout());
        panel1.setBounds(20,70,400,350);
        
        panel2 = new JPanel(new BorderLayout());
        panel2.setBounds(610,70,450,300);
        
        panel3 = new JPanel(new BorderLayout());
        panel3.setBounds(610,420,450,200);
        
        panel4 = new JPanel(new BorderLayout());
        panel4.setBounds(20,440,400,150);
        
        label1 = new JLabel();
        label1.setText("GooINPUT (from input.txt)");
        label1.setForeground(new Color(0xFFFFFF));
        label1.setFont(new Font("Courier New",Font.BOLD,17));
        label1.setBounds(20,5,300,100);
        
        label2 = new JLabel();
        label2.setText("GooANALYZER");
        label2.setForeground(new Color(0xFFFFFF));
        label2.setFont(new Font("Courier New",Font.BOLD,17));
        label2.setBounds(610,5,300,100);

        label3 = new JLabel();
        label3.setText("GooERRORS");
        label3.setForeground(new Color(0xFFFFFF));
        label3.setFont(new Font("Courier New",Font.BOLD,17));
        label3.setBounds(610,360,300,100);
        
        label4 = new JLabel();
        label4.setText("GooOUTPUT");
        label4.setForeground(new Color(0xFFFFFF));
        label4.setFont(new Font("Courier New",Font.BOLD,17));
        label4.setBounds(20,560,300,100);
        
        list = new JList(inputmodel);
        scroll = new JScrollPane(list);
        scroll.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFont(new Font("Courier New",Font.PLAIN,12));
        list.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        analyzer = new JList(analyzermodel);
        scroll2 = new JScrollPane(analyzer);
        scroll2.setViewportView(analyzer);
        analyzer.setLayoutOrientation(JList.VERTICAL);
        analyzer.setFont(new Font("Courier New",Font.BOLD,12));
        analyzer.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        errors = new JList(errormodel);
        scroll3 = new JScrollPane(errors);
        scroll3.setViewportView(errors);
        errors.setLayoutOrientation(JList.VERTICAL);
        errors.setFont(new Font("Courier New",Font.PLAIN,12));
        errors.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        editfile = new JButton();
        editfile.setText("EDIT INPUT FILE");
        editfile.setFocusable(false);
        editfile.setFont(new Font("Helvetica",Font.BOLD,12));
        editfile.setBounds(440,100,150,50);
        
        refresh = new JButton();
        refresh.setText("REFRESH INPUT");
        refresh.setFocusable(false);
        refresh.setFont(new Font("Helvetica",Font.BOLD,12));
        refresh.setBounds(440,160,150,50);
        
        runall = new JButton();
        runall.setText("RUN");
        runall.setFocusable(false);
        runall.setFont(new Font("Helvetica",Font.BOLD,12));
        runall.setBounds(440,310,150,50);
        
        clear = new JButton();
        clear.setText("CLEAR ALL");
        clear.setFocusable(false);
        clear.setFont(new Font("Helvetica",Font.BOLD,12));
        clear.setBounds(440,370,150,50);
        
        jt = new JTextArea(10,10);
        scroll4 = new JScrollPane(jt);
        
        frame = new JFrame();
        frame.setTitle("GooGooGnomes Lexical Analyzer");
        frame.setResizable(false);
        frame.setSize(1100,700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0x123456));
        frame.setVisible(true);
        
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        panel1.add(scroll);
        panel2.add(scroll2);
        panel3.add(scroll3);
        panel4.add(scroll4);
        
        frame.add(editfile);
        frame.add(refresh);
        frame.add(runall);
        frame.add(clear);
        
    }
     
    public static void main(String[] args) {
        
        createFile();
        readFile();
        createGUI();
        
        
        editfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }          
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputmodel.clear();
                readFile();
                list.setModel(inputmodel);
            }          
        });
        
        runall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialsplit.clear();
                validvariables.clear();
                forlexer.clear();
                analyzermodel.clear();
                errormodel.clear();
                
                processFile();
                hasSyntaxError();
                analyzeLexical();
                
                analyzer.setModel(analyzermodel);
                errors.setModel(errormodel);
                
                if(errormodel.isEmpty()){
                    try {
                        run_input();
                    } catch (IOException ex) {
                        Logger.getLogger(LexerFinal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }          
            
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzermodel.clear();
                errormodel.clear();
                
                analyzer.setModel(analyzermodel);
                errors.setModel(errormodel);
            }          
        });
    }
    
    //read file for initial input on gooINPUT
    public static void readFile(){
        int count = 1;
        try{
            BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
            String line = bf.readLine();

            while(line != null){
                if(!line.isEmpty()){
                    
                    inputmodel.addElement(String.valueOf(count) + " | " + line);
                    
                }
                line = bf.readLine();
                count++;
            }  
            bf.close(); 
        }catch(IOException e){
            e.printStackTrace();
        }  
    }
    
    //splits lines according to comment, space, =, and ;
    public static void initialSplit(String line){
        char c;
        char c_next;
        String temp = "";
        
        for(int i=0; i<line.length(); i++){
            c = line.charAt(i);
            
            if(i<line.length()-1){
                if(c == '/'){
                    c_next = line.charAt(i+1);
                    if(c_next == '*'){
                       if(!temp.isEmpty()){
                            if(commentflag != 1)
                                initialsplit.add(temp);
                            temp = "";
                        }
                        initialsplit.add("/*");
                        commentflag = 1;
                        i++;
                        continue;
                    }
                }
                
                if(c == '*'){
                    c_next = line.charAt(i+1);
                    if(c_next == '/'){
                        if(!temp.isEmpty()){
                            if(commentflag != 1)
                                initialsplit.add(temp);
                            temp = "";
                        }
                        temp="";
                        initialsplit.add("*/");
                        if(commentflag == 1){
                            commentflag = 0;
                        }
                        i++;
                        continue;
                    }
                }
            }
            
            if(c==' ' || c=='=' || c==';'){
                
                if(!temp.isEmpty()){   
                    if(commentflag != 1)
                        initialsplit.add(temp);
                    temp = "";
                }
                
                if(c != ' '){
                    if(commentflag != 1)
                        initialsplit.add(Character.toString(c));
                }
                continue;
            }
            
            if(i == line.length()-1){
                if(!temp.isEmpty()){
                    if(commentflag != 1)
                        initialsplit.add(temp);
                    temp = "";
                }
            }
            
            if(c != ' ')
                temp += c;
        }
    }
    
    //determine valid variables and declarations
    public static void processVarandDeclr(){
        String splitted[] = {};
        String possiblevariable = "";
        String declaration = "";
        int outflag = 0;
        int varflag = 0;
        
        //loop to process variables and declarations
        for(int i=0; i<initialsplit.size(); i++){
            String str = initialsplit.get(i);
            
            if(str.equals("var") && i<initialsplit.size()-1){
                
                String str_next = initialsplit.get(i+1);
                //variable condition
                if(str_next.matches("^\\w+$") && !str_next.matches("[0-9].*")){
                    
                    if(i+2 != initialsplit.size()){
                        String str_next2 = initialsplit.get(i+2);
                        
                        if(str_next2.equals("=")){
                            semicolonflag = 1;
                            possiblevariable = str_next;
                        }else{
                            errormodel.addElement("(line " + linecount + ") Missing variable declaration.");
                        }
                        
                    }
                }else{
                    errormodel.addElement("(line " + linecount + ") Missing variable declaration.");
                }
            }
            
            if(str.equals("var") && i==initialsplit.size()-1){
                varflag = 1;
            }
            
            if(semicolonflag == 1){
                int decflag = 0;
                if(str.equals(";")){

                    for(int j=0; j<initialsplit.size(); j++){
                        String dec = initialsplit.get(j);
                        
                        if(dec.equals("=")){
                            decflag = 1;
                            continue;
                        }
                       
                        if(decflag == 1){
                            
                            if(dec.equals(";"))
                                break;
                            
                            declaration += dec;
                        }
                    }
                    
                    if(declaration.isEmpty()){
                        errormodel.addElement("(line " + linecount + ") Missing variable declaration.");
                    }
                    
                    else if( declaration.matches(".*[^a-zA-Z0-9_+-/*()].*") ){
                        errormodel.addElement("(line " + linecount + ") Invalid variable declaration.");
                    }
                    
                    else if( declaration.matches(".*[.].*") ){
                        errormodel.addElement("(line " + linecount + ") Invalid variable declaration.");
                    }
                    
                    else{
                        int checkflag = 0;
                        for(String check : validvariables.keySet()){
                            
                            if(possiblevariable.equals(check)){
                                checkflag = 1;
                                break;
                            }
                            
                        }
                        
                        if(checkflag == 1){
                            errormodel.addElement("(line " + linecount + ") Invalid redeclaration of variable.");
                        }else{
                            validvariables.put(possiblevariable, declaration);
                            usedvariables.put(possiblevariable, 0);
                        }
                    }
                    semicolonflag = 0;
                    
                }
            }

        }
                
        //loop to split output parameters
        for(int i=0; i<initialsplit.size(); i++){
            
            String str = initialsplit.get(i);
            
            if(str.equals("output") && i<initialsplit.size()-1){
                String str_next = initialsplit.get(i+1);
                
                for(int j=0; j<initialsplit.size(); j++){
                    String out = initialsplit.get(j);
                    
                    if(out.equals("output")){
                        outflag = 1;
                        continue;
                    }
                    
                    if(outflag == 1){
                        if(out.equals(";"))
                            break;

                        if(out.matches(".*[+-/*()].*")){

                            splitted = out.split("((?=-|\\*|\\+|/|\\(|\\))|(?<=-|\\*|\\+|/|\\(|\\)))");
                            ArrayList<String> sp = new ArrayList<>(Arrays.asList(splitted));

                            initialsplit.remove(j);
                            initialsplit.addAll(j, sp);
                            
                        }
                    }
                    outflag = 0;
                }
            }
            
            if(str.equals("output") && i==initialsplit.size()-1){
                outflag = 1;
            }
        }
        
        //
        for(int i=0; i<initialsplit.size(); i++){
            
            String str = initialsplit.get(i);
            
            if(str.equals("=") && i<initialsplit.size()-1){
                String str_next = initialsplit.get(i+1);
                
                for(int j=0; j<initialsplit.size(); j++){
                    String out = initialsplit.get(j);
                    
                    if(out.equals("=")){
                        outflag = 1;
                        continue;
                    }
                    
                    if(outflag == 1){
                        if(out.equals(";"))
                            break;

                        if(out.matches(".*[+-/*()].*")){

                            splitted = out.split("((?=-|\\*|\\+|/|\\(|\\))|(?<=-|\\*|\\+|/|\\(|\\)))");
                            ArrayList<String> sp = new ArrayList<>(Arrays.asList(splitted));

                            initialsplit.remove(j);
                            initialsplit.addAll(j, sp);
                            
                        }
                    }
                    outflag = 0;
                }
            }
            
            if(str.equals("output") && i==initialsplit.size()-1){
                outflag = 1;
            }
        }
        
        if(semicolonflag == 1)
            errormodel.addElement("(line " + linecount + ") Missing semicolon.");
        if(outflag == 1)
            errormodel.addElement("(line " + linecount + ") Missing output declaration.");
        if(varflag == 1)
            errormodel.addElement("(line " + linecount + ") Missing variable declaration.");
        
        forlexer.addAll(initialsplit);
        initialsplit.clear();
    }

    //analyzes input for GooAnalyzer
    public static void analyzeLexical(){
        String type = "";
        int varflag = 0;
        
        for(String i : forlexer){
            
            if(i.equals("var") || i.equals("input") || i.equals("output")){
                analyzermodel.addElement(i + " | KEYWORD");
            }
            else if(i.equals("+") || i.equals("-") || i.equals("/") || 
                    i.equals("*") || i.equals("=") || i.equals("(") || 
                    i.equals(")") || i.equals(";") || i.equals("/*") ||
                    i.equals("*/")){
                
                switch(i){
                    case "+":
                        type = "ADD";
                        break;
                    case "-":
                        type = "SUB";
                        break;
                    case "/":
                        type = "DIV";
                        break;
                    case "*":
                        type = "MUL";
                        break;
                    case "=":
                        type = "EQUAL";
                        break;    
                    case "(":
                        type = "LPAREN";
                        break;    
                    case ")":
                        type = "RPAREN";
                        break;    
                    case ";":
                        type = "SEMICOLON";
                        break; 
                    case "/*":
                        type = "OPEN_COMMENT";
                        break;
                    case "*/":
                        type = "CLOSE_COMMENT";
                        break;       
                }
                analyzermodel.addElement(i + " | " + type);
            }
            else if(i.matches("[0-9]+")){
                analyzermodel.addElement(i + " | INT");
            }
            else{
                
                for(String key : validvariables.keySet()){
                    
                    if(i.equals(key)){
                        analyzermodel.addElement(i + " | VARIABLE");
                        usedvariables.put(i, usedvariables.get(i) + 1);
                        varflag = 1;
                        break;
                    }
                    
                }
                
                if(varflag == 1){
                    varflag = 0;
                    continue;
                }
                
                analyzermodel.addElement(i + " | INVALID");
                errormodel.addElement("Invalid input: " + i);
            }    
        }
        
        for(String key : usedvariables.keySet()){
            
            if(usedvariables.get(key)<2){
                errormodel.addElement("Variable " + key + " is never used.");
            }
            
        }
    }
    
    //process file
    public static void processFile(){
        try{
            linecount = 1;
            
            BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
            String line = bf.readLine();

            while(line != null){
                if(!line.isEmpty()){
                    
                    initialsplit.clear();
                    initialSplit(line + " ");
                    processVarandDeclr();
                    
                }
                line = bf.readLine();
                linecount++;
            }  
            
            bf.close();
            
            System.out.println(forlexer);
            System.out.println(validvariables);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //check file for syntax errors
    public static void hasSyntaxError(){
        
        if(commentflag == 1)
            errormodel.addElement("Unclosed comment statement.");

    }
}
