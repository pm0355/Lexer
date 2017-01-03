import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
public static List<String> arr = new ArrayList<String>();
public static  List<String> token = new ArrayList<String>();
public static  List<String> ops = new ArrayList<String>();
   public static boolean varTest(String s){
    	if (s.equals("program"))
            return false;
        if (s.equals("begin"))
            return false;
        if (s.equals("End"))
            return false;
                if (s.equals("end"))
            return false;
        if (s.equals("Read"))
            return false;
        if (s.equals("Write"))
            return false;
        if (s.equals("If"))
            return false;
        if (s.equals("Else"))
            return false;
        if (s.equals("Then"))
            return false;
        else
            return true;
    }
public static boolean nameTest(String s){
    	return s.matches("[a-zA-Z0-9]+");
    }
public static boolean opTest(String s){
    	return s.matches("[+-=/*!$^&,]+");
    }
	public static void main(String[] args) {
		try {
			File file = new File("C:/Users/Paul/Desktop/test.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
                        String op_pattern = "[+-=/*!$^&,()<>]+";
                        String var_pattern = "[a-zA-Z0-9]+";
                        Pattern p;
                        Matcher m;
			while ((line = bufferedReader.readLine()) != null) {
                               //arr.add(line);
                                p = Pattern.compile(op_pattern);
                                m = p.matcher(line);
                                while (m.find())
                                ops.add( line.substring(m.start(),m.end()) );
                                p = Pattern.compile(var_pattern);
                                m = p.matcher(line);
                                while (m.find())
                                arr.add( line.substring(m.start(),m.end()) );
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
           String[] holder;    
           int k=0;
          
           
            
           for(int i =0; i<arr.size();i++)
           {
                holder=(arr.get(i).split(" "));
              
               for(int j=0; j<holder.length;j++){
               if((holder[j]).equals("program")){
                token.add("<program>");
        	token.add("<stmt_list>");
      }
            if((holder[j]).equals("Read")){
                token.add("<stmt>");
        	token.add("<read>");
                token.add("<expr>");
                token.add("<var_list>");
      }
            if((holder[j]).equals("Write")){
                token.add("<stmt>");
        	token.add("<write>");
                token.add("<expr>");
                token.add("<var_list>");
      }
            if((holder[j]).equals("If")){
                token.add("<if_stmt>");
      }
            if((holder[j]).equals("Else")){
                token.add("<if_stmt>");
      }
            if((holder[j]).equals("Then")){
                token.add("<if_stmt>");
      }
                   if((holder[j]).equals("else")){
                token.add("<if_stmt>");
      }
            if((holder[j]).equals("then")){
                token.add("<if_stmt>");
      }
            if((varTest(holder[j])==true)&&(nameTest(holder[j])==true)){
            token.add("<var>");
            }
           }     
           }
        for(k=0;k<token.size();k++){
            if(token.get(0)!="<program>"){
                System.out.println("Error, illegal language catch, -1");
                break;
            }
            if(token.get(0).equals("<program>")){
            System.out.println(token.get(k));
           
            
            }
        }
        if(token.get(0).equals("<program>")){
         for(int f=0;f<ops.size();f++)
                System.out.println(ops.get(f));}
        }
}



