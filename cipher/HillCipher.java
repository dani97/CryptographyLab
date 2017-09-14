package cipher;
import java.util.Scanner;
class HillCipher {
  public int [][] keyMat = new int[3][3];
  public void setkeyMat(int [][] mat){
    this.keyMat = mat;
  }
  public int [] convertNumbers(String plain){
    plain = plain.toUpperCase();
    int [] plainMat = new int[plain.length()];
    char [] str = plain.toCharArray();
    for(int i=0;i<str.length;i++){
       plainMat[i]= str[i]-65;
    }
    return plainMat;
  } 
  public int[][] matmul(int[][] a,int[][] b){
    int [][] result = new int [3][1];
    
    for(int i=0;i<3;i++){
      for(int j=0;j<1;j++){
        result[i][j]=0;
        for(int k=0;k<3;k++){
          result[i][j] += a[i][k]*b[k][j];
          //System.out.println("check"+a[i][k]*b[k][j]);
        }
      }
    }
    // System.out.print("matmul input ");
    // for(int i=0;i<3;i++){
    //   for(int j=0;j<1;j++){
    //     System.out.print(b[i][j]);
    //   }
    //   System.out.println();
    // }
    // System.out.print("matmul output ");
    // for(int i=0;i<3;i++){
    //   for(int j=0;j<1;j++){
    //     System.out.print(result[i][j]);
    //   }
    //   System.out.println();
    // }
    return result;
  }
  public int [] hillCipher(String plain){
    int [] plainMat = convertNumbers(plain);
    int [][] value = new int[3][1];
    int [][] cipher = new int[3][1];
    int [] result = new int[plain.length()];
    for(int i=0;i<plainMat.length;i=i+3){
      for(int j=0;j<3;j++){
        try{
          value[j][0] = plainMat[i+j];
        }
        catch(ArrayIndexOutOfBoundsException e){
          
        }
        
      }
      cipher = matmul(keyMat,value);
      for(int j=0;j<3;j++){
        try{
          result[i+j] = cipher[j][0]%26;
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
      }
    }
     
    return result;
  }
  public static void main(String[] args) {
    HillCipher s = new HillCipher();
    int [][]mat = new int [3][3];
    Scanner sc = new Scanner(System.in);
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        mat[i][j] = sc.nextInt();
      }
    }
    s.setkeyMat(mat);
    int [] ans = s.hillCipher("retreatnow");
    for(int i:ans){
       System.out.println(i);
    }
  }
}
