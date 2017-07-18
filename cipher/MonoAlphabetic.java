package cipher;

import java.util.Scanner;

public class MonoAlphabetic {
	private int[] charMap;
	MonoAlphabetic(){
		this.charMap = new int[26];
		createKeys();
	}
	public  void createKeys(){
		charMap[0]=25;
		charMap[1]=24;
		charMap[2]=23;
		charMap[3]=22;
		charMap[4]=21;
		charMap[5]=20;
		charMap[6]=19;
		charMap[7]=17;
		charMap[8]=18;
		charMap[9]=16;
		charMap[10]=15;
		charMap[11]=14;
		charMap[12]=13;
		charMap[13]=12;
		charMap[14]=11;
		charMap[15]=1;
		charMap[16]=2;
		charMap[17]=3;
		charMap[18]=4;
		charMap[19]=5;
		charMap[20]=6;
		charMap[21]=7;
		charMap[22]=8;
		charMap[23]=9;
		charMap[24]=10;
		charMap[25]=0;

	}
	
	public String cipher(String text){
		char []c=text.toCharArray();
		for(int i=0;i<text.length();i++){
			if(Character.isUpperCase(c[i])){
				c[i] = (char)((char)charMap[c[i]-'A']+'A');
			}
			if(Character.isLowerCase(c[i])){
				c[i] = (char)((char)charMap[c[i]-'a']+'a');
			}
		}
		return new String(c);
	}
	
	public String decipher(String cipher){
		char [] c = cipher.toCharArray();
		for(int i=0;i<c.length;i++){
			if(Character.isUpperCase(c[i])){
				int index = find(c[i]-'A');
				if(index!=-1){
					c[i] = (char) (index+'A');
				}
			}
			if(Character.isLowerCase(c[i])){
				int index = find(c[i]-'a');
				if(index!=-1){
					c[i] = (char) (index+'a');
				}
			}
		}
		return new String(c);
	}
	private int find(int j) {
		// TODO Auto-generated method stub
		for(int i=0;i<charMap.length;i++){
			if(charMap[i]==j){
				return i;
			}
		}
		return -1;
	}
	public static void main(String [] args){
		Scanner sc= new Scanner(System.in);
		String plain = sc.nextLine();
		sc.close();
		MonoAlphabetic ma = new MonoAlphabetic();
		String cipher = ma.cipher(plain);
		System.out.println(cipher);
		String decoded = ma.decipher(cipher);
		System.out.println(decoded);
	}
}
