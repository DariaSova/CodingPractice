import java.util.Stack;

public class UnixPath {
	    public static String simplifyPath(String path) {
	        char[] chars = path.toCharArray();
	        int len = chars.length;
	        Stack<String> hm = new Stack<String>();
	        
	        int i = 0;
	        int backsl =0;
	        int dot=0;
	      
	     while(i<len){
	        String temp="";
	        while(backsl<2 && i<len){
	        	if(chars[i]=='/')
	        		backsl++;
	        	else {
	        		temp+=chars[i];
	        		dot++;
	        	}
	        	i++;
	        }
	        
	        if(temp.length()==1&&dot==1){
	        	
	        }
	         else if(temp.length()==2&&dot==2){
	        	 if(!hm.isEmpty())
	        		 hm.pop();
	         }else{
	        	 hm.add(temp);
	         }
	        
	      }
	            
	        

	        
	        //now build a new string
	        String result ="";
	        
	        if(hm.isEmpty())
	            return "/";
	        while(!hm.isEmpty()){
	            result= "/"+hm.pop()+result;
	            //result+=hm.pop();
	        }
	        
	        
	        
	        return result;
	    }
	    
	    public static void main(String[] args){
	    	System.out.println(simplifyPath("/.."));
	    	System.out.println(simplifyPath("/"));
	    	System.out.println(simplifyPath("/..hidden"));
	    	System.out.println(simplifyPath("///"));
	    }
	}
