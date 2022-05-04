#include <bits/stdc++.h>
#include <time.h>
#include <windows.h>
#include <iterator>
#include <regex>
#include <fstream>
#include <stdlib.h>
#include <string.h>
#include <string>
#include <ctype.h>
#define deb(x) cout << #x << " = " << x << endl

using namespace std;

bool isPunctuator(char ch)					//check if the given character is a punctuator or not
{
    if (ch == ' ' || ch == '+' || ch == '-' || ch == '*' ||
        ch == '/' || ch == ',' || ch == ';' || ch == '>' ||
        ch == '<' || ch == '=' || ch == '(' || ch == ')' ||
        ch == '[' || ch == ']' || ch == '{' || ch == '}' ||
        ch == '&' || ch == '|')
        {
            return true;
        }
    return false;
}

bool validIdentifier(char* str)						//check if the given identifier is valid or not
{
    if (str[0] == '0' || str[0] == '1' || str[0] == '2' ||
        str[0] == '3' || str[0] == '4' || str[0] == '5' ||
        str[0] == '6' || str[0] == '7' || str[0] == '8' ||
        str[0] == '9' || isPunctuator(str[0]) == true)
        {
            return false;
        }									//if first character of string is a digit or a special character, identifier is not valid
    int i,len = strlen(str);
    if (len == 1)
    {
        return true;
    }										//if length is one, validation is already completed, hence return true
    else
    {
    for (i = 1 ; i < len ; i++)						//identifier cannot contain special characters
    {
        if (isPunctuator(str[i]) == true)
        {
            return false;
        }
    }
    }
    return true;
}

bool isNumber(char* str)							//check if the given substring is a number or not
{
    int i, len = strlen(str),numOfDecimal = 0;
    if (len == 0)
    {
        return false;
    }
    for (i = 0 ; i < len ; i++)
    {
        if (numOfDecimal > 1 && str[i] == '.')
        {
            return false;
        } else if (numOfDecimal <= 1)
        {
            numOfDecimal++;
        }
        if (str[i] != '0' && str[i] != '1' && str[i] != '2'
            && str[i] != '3' && str[i] != '4' && str[i] != '5'
            && str[i] != '6' && str[i] != '7' && str[i] != '8'
            && str[i] != '9' || (str[i] == '-' && i > 0))
            {
                return false;
            }
    }
    return true;
}

bool isOperator(char ch)							//check if the given character is an operator or not
{
    if (ch == '+' || ch == '-' || ch == '*' ||
        ch == '/' || ch == '>' || ch == '<' ||
        ch == '=' || ch == '|' || ch == '&')
    {
       return true;
    }
    return false;
}

bool isKeyword(char *str)						//check if the given substring is a keyword or not
{
    if (!strcmp(str, "if") || !strcmp(str, "else") ||
        !strcmp(str, "while") || !strcmp(str, "do") ||
        !strcmp(str, "break") ||  !strcmp(str, "continue")
        || !strcmp(str, "int") || !strcmp(str, "double")
        || !strcmp(str, "float") || !strcmp(str, "return")
        || !strcmp(str, "char") || !strcmp(str, "case")
        || !strcmp(str, "long") || !strcmp(str, "short")
        || !strcmp(str, "typedef") || !strcmp(str, "switch")
        || !strcmp(str, "unsigned") || !strcmp(str, "void")
        || !strcmp(str, "static") || !strcmp(str, "struct")
        || !strcmp(str, "sizeof") || !strcmp(str,"long")
        || !strcmp(str, "volatile") || !strcmp(str, "typedef")
        || !strcmp(str, "enum") || !strcmp(str, "const")
        || !strcmp(str, "union") || !strcmp(str, "extern")
        || !strcmp(str,"bool"))
        {
            return true;
        }
    else
    {
       return false;
    }
}

char* subString(char* realStr, int l, int r)				//extract the required substring from the main string
{
    int i;

    char* str = (char*) malloc(sizeof(char) * (r - l + 2));

    for (i = l; i <= r; i++)
    {
        str[i - l] = realStr[i];
        str[r - l + 1] = '\0';
    }
    return str;
}

void parse(char* str)						//parse the expression
{
    int left = 0, right = 0;
    int len = strlen(str);
    while (right <= len && left <= right) {
        if (isPunctuator(str[right]) == false)			//if character is a digit or an alphabet
            {
                right++;
            }

        if (isPunctuator(str[right]) == true && left == right)		//if character is a punctuator
            {
            if (isOperator(str[right]) == true)
            {
                cout<< str[right] <<" IS AN OPERATOR\n";
                string s(1,str[right]);
            }
            right++;
            left = right;
            } else if (isPunctuator(str[right]) == true && left != right
                   || (right == len && left != right)) 			//check if parsed substring is a keyword or identifier or number
            {
            char* sub = subString(str, left, right - 1);   //extract substring

            
             if (isKeyword(sub) == true)
                        {
                            cout<< sub <<" IS A KEYWORD\n";
                        }

            else if (isNumber(sub) == true)
                        {
                            cout<< sub <<" IS A NUMBER\n";

                        }
            else if (validIdentifier(sub) == true
                     && isPunctuator(str[right - 1]) == false)
                     {
                         cout<< sub <<" IS A VALID IDENTIFIER\n";
                     }
            else if (validIdentifier(sub) == false
                     && isPunctuator(str[right - 1]) == false)
                     {
                         cout<< sub <<" IS NOT A VALID IDENTIFIER\n";
                     }

            left = right;
            }
    }
    return;
}


 map<string, string> my_map{
      {"\\;|\\{|\\}|\\(|\\)|\\,|\\#", "Special Symbol"},
      {"alignas|decltype|namespace|struct|alignof|default|new|switch|and|"
       "delete|noexcept|template|and_eq|not|this|asm|double|do|not_eq|"
       "thread_local|auto|dynamic_cast|nullptr|throw|bitand|else|operator|"
       "true|bitor|enum|or|try|bool|explicit|or_eq|typedef|break|export|"
       "private|tpeid|case|extern|protected|typename|catch|false|pblic|"
       "union|char|float|register|unsigned|char16_t|for|reinterpret_cast|"
       "using|char32_t|friend|return|virtual|class|goto|short|void|compl|"
       "if|signed|volatile|const|inline|sizeof|wchar_t|constexpr|int|"
       "static|while|const_cast|long|static_assert|xor|continue|mutable|"
       "static_cast|xor_eq",
       "Keywords"},
      {"\\include|define", "Pre-Processor Directive"},
      {"\\math.h|\\iostream|\\stdio|\\string", "Library"},
        {"([+-]?[0-9][.]?[0-9]+[f]?)|"
       "([+-]?[0-9][.]?[0-9]+)|"
       "([0-9]+[.]?[0-9]+[f]?)|"
       "([0-9][.]?[0-9]+)|"
       "([0-9]+)","Constant"},
      {"([+-]?[0-9]+)|"
       "([+-]?[0-9][.]?[0-9]+[f]?)|"
       "([+-]?[0-9][.]?[0-9]+)|"
       "([0-9]+[.]?[0-9]+[f]?)|"
       "([0-9][.]?[0-9]+)|"
       "([0-9]+)","Constant"},
         {"\\-|\\/|\\=|\\*|\\+|\\>>|\\<<|<|>", "Operator"},
          {"[a-z]+", "Identifier"},
      {"[ ]", ""},
  };


map<size_t, pair<string, string>> Match_Language(
    map<string, string> my_map, string str) {
  map<size_t, pair<string, string>> lang_matches;

  for (auto i = my_map.begin(); i != my_map.end(); ++i) {
    regex compare(i->first);
    auto words_begin = sregex_iterator(str.begin(), str.end(), compare);
    auto words_end = sregex_iterator();
    // MAKING PAIRS OF [STRING OF REGEX 'compare' : 'pattern']
    for (auto it = words_begin; it != words_end; ++it)
      lang_matches[it->position()] = make_pair(it->str(), i->second);
  }
  return lang_matches;
}

string tell_Lexeme(string op) {
  //cout << prev;
  if (op == "*")
    return "MUL";
  else if (op == "+")
    return "ADD";
  else if (op == "/")
    return "DIV";
  else if (op == "-")
    return "SUB";
  else if (op == "=")
    return "EQUALS";
  else if (op == ">>")
    return "INS";
  else if (op == "<<")
    return "EXTR";
  else if (op == ">")
    return "RSHFT";
  else if (op == "<")
    return "LSHFT";
  else
    return EXIT_SUCCESS;
}

int main() {

  cout << "\n [1.]  Sir Hadji Version.2\n\n" ;

    ifstream file("prog.txt");
    string x;
    string code = "";

    while(getline(file,x)){
        code+=x;
    }

    int n = code.length();
    char ch[n + 1];

    strcpy(ch, code.c_str());
    parse(ch);
  
  
  cout << "\n\n\n[2.]  Token Table Ver.\n\n" ;
  ofstream fout;
  cout << endl << endl << endl;
  cout.fill(' ');
  cout.width(100);
  fout.open("OutputFile");
  char c;
  string filename="prog.txt";

  
  fstream fin("prog.txt", fstream::in);
  string str;
  // Fetching Source Code in String type 'str'
   if (fin.is_open()) {
    while (fin >> noskipws >> c) str = str + c;

    // Making a map which which will define the regex in source code to its
    // pattern in my language.
    
    map<string, string> pattern = my_map;

    /*DECLARING MAP 'lang_matches' from 'my_map' map which will pair up
    the my_map from the ['Source Code':'Defined Pattern' via a Regex
    named 'compare'. */
    map<size_t, pair<string, string>> lang_matches =
        Match_Language(my_map, str);

    // Writing matches in File ignoring 'spaces' and '\n'.
    int count = 1;
    cout << "\t\t\t\t-----------------------------------------------------"
            "-----"
            "---------------------------------------- \n";
    cout.width(40);
    cout << "\t        NUMBER" << setw(10) << "              TOKEN "
         << " "
         << "            " << setw(20) << " PATTERN \n";
    cout.fill(' ');
    cout.width(40);

    cout << "\t\t\t\t-----------------------------------------------------"
            "-----"
            "---------------------------------------- \n\n\n";
    for (auto match = lang_matches.begin(); match != lang_matches.end();
         ++match) {          

      if (!(match->second.first == " ") && !(match->second.first == "//")) {
         if ( match->second.second == "Constant") {
          cout.width(40);
          if (count < 10) {
            string double_digits = to_string(count);
            double_digits = "0" + double_digits;
            cout << "\t Token   No :" << double_digits << "  |   "
                 << setw(10) << match->second.first << " "
                 << " ------->  |" << setw(25) << match->second.second
                 << setw(18) << endl;
            fout << "\t Token   No :" << double_digits << "  |   "
                 << setw(10) << match->second.first << " "
                 << " ------->  |" << setw(25) << match->second.second
                 << setw(18) << endl;
          } else {
            cout << "\t Token   No :" << count << "  |   " << setw(10)
                 << match->second.first << " "
                 << " ------->  |" << setw(25) << match->second.second
                 << setw(18) << endl;
            fout << "\t Token   No :" << count << "  |   " << setw(10)
                 << match->second.first << " "
                 << " ------->  |" << setw(25) << match->second.second
                 << setw(18) << endl;
          }
          count++;
        }

        else {
        
          if (match->second.second == "Operator" ) {
            cout.width(40);

            string op = tell_Lexeme(match->second.first);
            if (count < 10) {
              string double_digits = to_string(count);
              double_digits = "0" + double_digits;
              cout << "\t Token   No :" << double_digits << "  |   "
                   << setw(10) << match->second.first << " "
                   << " ------->  |" << setw(25) << match->second.second
                   << " , " << op << "    " << endl;
              fout << "\t Token   No :" << double_digits << "  |   "
                   << setw(10) << match->second.first << " "
                   << " ------->  |" << setw(25) << match->second.second
                   << " , " << op << "    " << endl;
              count++;
            } else {
              cout << "\t Token   No :" << count << "  |   " << setw(10)
                   << match->second.first << " "
                   << " ------->  |" << setw(25) << match->second.second
                   << " , " << op << "    " << endl;
              fout << "\t Token   No :" << count << "  |   " << setw(10)
                   << match->second.first << " "
                   << " ------->  |" << setw(25) << match->second.second
                   << " , " << op << "    " << endl;

              count++;
            }

          } else {
            cout.width(40);
            if (count < 10) {
              string double_digits = to_string(count);
              double_digits = "0" + double_digits;
              cout << "\t Token   No :" << double_digits << "  |   "
                   << setw(10) << match->second.first << " "
                   << " ------->  |" << setw(25) << match->second.second
                   << "    " << endl;
              fout << "\t Token   No :" << double_digits << "  |   "
                   << setw(10) << match->second.first << " "
                   << " ------->  |" << setw(25) << match->second.second
                   << "    " << endl;
              count++;
            } else {
              cout << "\t Token   No :" << count << "  |   " << setw(10)
                   << match->second.first << " "
                   << " ------->  |" << setw(25) << match->second.second
                   << "    " << endl;
              fout << "\t Token   No :" << count << "  |   " << setw(10)
                   << match->second.first << " "
                   << " ------->  |" << setw(25) << match->second.second
                   << "    " << endl;
              count++;
            }
          }
        }
      }
    }
  }

  cout << "\n\n[2.]  Original Ver.\n\n" ;
  system("g++ -o lexical lexical.cpp&lexical.exe");
  return 0;
}