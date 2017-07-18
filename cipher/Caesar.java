package cipher;

import java.util.Scanner;

public class Caesar {
	public static char[] cipher(String plain,int key){
		char [] text = plain.toCharArray();
		for(int i=0;i<text.length;i++){
			char c = text[i];
			if(Character.isUpperCase(c)){
				text[i] = (char) ((c-'A'+key)%26+'A');
			}
			if(Character.isLowerCase(c)){
				text[i] = (char) ((c-'a'+key)%26+'a');
			}
		}
		
		return text;
	}
	public static char[] decipher(char []  cipher,int key){
		char [] text = cipher;
		for(int i=0;i<text.length;i++){
			char c = text[i];
			if(Character.isUpperCase(c)){
				text[i] = (char) ((c-'A'-key+26)%26+'A');
			}
			if(Character.isLowerCase(c)){
				text[i] = (char) ((c-'a'-key+26)%26+'a');
			}
		}
		return text;
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		int key = sc.nextInt();
		sc.close();
		char[]c=cipher(text,key);
		System.out.println(c);
		System.out.println(decipher(c,key));
	}
}
