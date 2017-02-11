import java.util.*;

public class BracketsPerm {
	
	
	static void perm(char[] str, int op, int cl, ArrayList<String> res, int index){
		//if(op <0 || cl<0)
		//	return;
		
		if(op==0 && cl==0){
			res.add(String.valueOf(str));
		}else {
			if(op>0) {
				str[index] = '(';
				perm(str, op-1, cl, res, index+1);
			}
			
			if(cl >op){
				str[index] = ')';
				perm(str, op, cl-1, res, index+1);
			}
		}
		
	}
	
	public static void main(String [] args){
		ArrayList<String> res = new ArrayList<String>();
		int n = 3;
		char[] chars = new char [n*2];
		perm(chars, n, n, res, 0);
		
		System.out.println(res);
	}

}
