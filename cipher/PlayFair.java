package cipher;

public class PlayFair {
	String keyPhrase;
	char [][] keyTable;
	int filled;
	PlayFair(String key){
		key = key.toLowerCase();
		keyTable = new char[5][5];
		keyPhrase = key;
		filled = 0;
		int k=0;
		int alphabet = 0;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(k<key.length()){
					keyTable[i][j] = key.charAt(k++);
					filled++;
				}
				else{
					while(find((char)(alphabet+'a')))alphabet++;
					keyTable[i][j]=(char) (alphabet+'a');
					filled++;
				}
			}
		}
	}
	private boolean find(char c) {
		// TODO Auto-generated method stub
		if(c=='j')
			return true;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(i*5+j>=filled){
					return false;
				}
				if(keyTable[i][j]==c){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String [] args){
		PlayFair pf = new PlayFair("king");
		char [][] keyT = pf.keyTable;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(keyT[i][j]);
			}
			System.out.println();
		}
	}
}
