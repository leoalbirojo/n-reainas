import java.util.Random;


public class ReinasTemple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int reinas;
		reinas=Integer.parseInt(args[0]);
		String[][] board=generateQueen(reinas);
		recBoard(board, reinas);
		
		
		
		
		
		
		
	}
	
	
	public static String[][] generateQueen(int queen){
		String tablero[][] = null;
		int j=0;
		Random rnd = new Random();
		for(int i=0;i<queen;i++){
			
			j=(int) (rnd.nextDouble()*queen);
				tablero[i][j]="X";	
			}
		return tablero;
			
		}
	
	public static void recBoard(String[][] board, int queen){
		
		int before;
		int after;
		boolean flag;
		int temp=0;
		String[][] boardTemp;
		Random rd=new Random();
		int je;
		
			for(int i=0;i<queen;i++){
				for(int j=0;j<j;j++){
					if (board[i][j]=="X"){
						je=(int)rd.nextInt()*queen;
                        //cuento numero de jaques antes de mover la reina seleccionada
						before=countHack(i, j, board, j);
						//muevo la reina
						boardTemp=move(i,j,board,queen,je);
						//cuento numero de jaques despues de mover la reina seleccionada
						after=countHack(i, je, boardTemp, queen);
						//evaluo segun la funcion de probabilidad si ejecuto el movimiento o me quedo
						//en el estado anterior
						flag=evalColina(before,after);
						if (flag){
							board=boardTemp;	
						}
						else{
							//dejar quieto
						}
						
						
						
					}	
					}	
			}
		
		
		
		
		
		
	}
	
	  private boolean evalTemplate(double temperatura, double deltaE) {
          return (deltaE > 0.0)
                          || (new Random().nextDouble() <= prob(
                                          temperatura, deltaE));
  }
  

  private double prob(double temperatura, double deltaE) {
          return Math.exp(deltaE / temperatura);
  }
	
	
	private static boolean evalColina(int before, int after) {
		//si estoy peor que antes retorno falso
		if(before<after){return false;}
		else{
			// sino retorno true para validar el movimiento
		return true;}
	}


	private static String[][] move(int i, int j, String[][] b, int n, int je) {
		
		
		b[i][j]="A";
		b[i][je]="X";
		return b;
		
		
		
	}


	public static int countHack(int rqueen, int cqueen, String[][] b, int n){
		int count=0;
		
		//verificar verticales
		for(int i =0; i<n;i++){
			if(b[i][cqueen]=="X"&&i!=rqueen){
				count+=1;
			}
			}
			
		//verificar horizontales
		for(int i =0; i<n;i++){
			if(b[rqueen][i]=="X" && i!=cqueen){
				count+=1;
			}
			}
		
		//verificar diagonales \
		int i=1;
		while(rqueen-i>=0 && cqueen-i>=0){
			
			if(b[rqueen-i][cqueen-i]=="X"){
				count+=1;
				}
			i=+1;
		}
		int j=1;
		while(rqueen+j<n && cqueen+j<n){
			
			if(b[rqueen+j][cqueen+j]=="X"){
				count+=1;
				}
			j=+1;
		}
		//verificar diagonales /
		int h=1;
		while(rqueen-h>=0 && cqueen+h<n){
			
			if(b[rqueen-i][cqueen-i]=="X"){
				count+=1;
				}
			h=+1;
		}
		int k=1;
		while(rqueen+k!=n && cqueen-k>=0){
			
			if(b[rqueen+j][cqueen+j]=="X"){
				count+=1;
				}
			k=+1;
		}
		
		return count;
		}
		
		

	

}
