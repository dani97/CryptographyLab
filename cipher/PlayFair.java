package cipher;

public class PlayFair {
	String keyPhrase;
	char [][] keyTable;
	int filled;
	boolean set[];
	PlayFair(String key){
		key = key.toLowerCase();
		keyTable = new char[5][5];
		keyPhrase = key;
		filled = 0;
		int k=0;
		int alphabet = 0;
		this.set = new boolean[26];
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(k<key.length()){
					while(k<key.length()&&find((char)key.charAt(k)))
					{
						k++;
					}
					if(k<key.length()){
						keyTable[i][j] = key.charAt(k);
						set[key.charAt(k)-'a']=true;
						k++;
					}
					else{
						while(find((char)(alphabet+'a')))alphabet++;
						keyTable[i][j]=(char) (alphabet+'a');
						set[alphabet]=true;
					}
				}
				else{
					while(find((char)(alphabet+'a')))alphabet++;
					keyTable[i][j]=(char) (alphabet+'a');
					filled++;
					set[alphabet]=true;
				}
			}
		}
	}
	private boolean find(char c) {
		// TODO Auto-generated method stub
		if(c=='j')
			return true;
		return set[c-'a'];
	}
	public String cipher(String plain){
		plain = removeSpace(plain);
		int i = 0,j=0;
		char [] cipher = new char[2*plain.length()];
		while(i+1<plain.length()){
			
			if(plain.charAt(i)!=plain.charAt(i+1)){
				int i1row = findRow(plain.charAt(i));
				int i2row = findRow(plain.charAt(i+1));
				int i1col = findCol(plain.charAt(i));
				int i2col = findCol(plain.charAt(i+1));
				if(i1row == i2row){
					cipher[j++] = keyTable[i1row][(i1col+1)%5];
					cipher[j++]= keyTable[i2row][(i2col+1)%5];
				}
				else if(i1col==i2col){
					cipher[j++] = keyTable[(i1row+1)%5][i1col];
					cipher[j++] = keyTable[(i2row+1)%5][i2col];
					
				}
				else{
					cipher[j++] = keyTable[i1row][i2col];
					cipher[j++] = keyTable[i2row][i1col];
				}
				i+=2;
			}
			else{
				int i1row = findRow(plain.charAt(i));
				int i2row = findRow('x');
				int i1col = findCol(plain.charAt(i));
				int i2col = findCol('x');
				System.out.println(i1row+" "+i2row+" "+i1col+" "+i2col);
				if(i1row == i2row){
					cipher[j++] = keyTable[i1row][(i1col+1)%5];
					cipher[j++]= keyTable[i2row][(i2col+1)%5];
				}
				else if(i1col==i2col){
					cipher[j++] = keyTable[(i1row+1)%5][i1col];
					cipher[j++] = keyTable[(i2row+1)%5][i2col];
					
				}
				else{
					cipher[j++] = keyTable[i1row][i2col];
					cipher[j++] = keyTable[i2row][i1col];
		
				}
				i+=1;
			}
			if(i+1==plain.length()){
				int i1row = findRow(plain.charAt(i));
				int i2row = findRow('x');
				int i1col = findCol(plain.charAt(i));
				int i2col = findCol('x');
				
				if(i1row == i2row){
					cipher[j++] = keyTable[i1row][(i1col+1)%5];
					cipher[j++]= keyTable[i2row][(i2col+1)%5];
				}
				else if(i1col==i2col){
					cipher[j++] = keyTable[(i1row+1)%5][i1col];
					cipher[j++] = keyTable[(i2row+1)%5][i2col];
					
				}
				else{
					cipher[j++] = keyTable[i1row][i2col];
					cipher[j++] = keyTable[i2row][i1col];
					
				}
				i+=1;
			}
		}
		
		return new String(cipher);
		
	}
	private int findCol(char c) {
		if(c=='j')
			c='i';
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(keyTable[i][j]==c)
					return j;
		return -1;
	}
	private int  findRow(char c) {
		if(c=='j')
			c='i';
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(keyTable[i][j]==c)
					return i;
		return -1;
	}
	private String removeSpace(String plain) {
		// TODO Auto-generated method stub
		StringBuilder plainT = new StringBuilder(plain.length());
		for(int i=0;i<plain.length();i++){
			if(plain.charAt(i)!=' ')
			plainT.append(plain.charAt(i));
		}
		return plainT.toString();
	}
	public static void main(String [] args){
		PlayFair pf = new PlayFair("kingi");
		char [][] keyT = pf.keyTable;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(keyT[i][j]);
			}
			System.out.println();
		}
		System.out.println(pf.cipher("helo world"));
	}
}

