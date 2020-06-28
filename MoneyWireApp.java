
public class MoneyWireApp {

	public static void main(String[] args) {
		Solver.solve();
	}
}

class Solver{
	static void solve() {
		
		
		outer:
		for( int a1 = 100; a1 <= 5000; a1++) {
			
			for( int a2 = 100; a2 <= 5000; a2++) {
				
				Bank.JuridicPersonClient.money = 1_000_000;
				Bank.PhysicalPersonClient.money = 100;
				Bank.BankScore.money = 0;
				
				int t1 = 40_050 / a1;
				for( int i = 1; i <= t1; i++){
					Bank.transferFromJuridicToPhysical(a1);
				}
				int t2 = (40_050 - Bank.PhysicalPersonClient.money) / a2;
				for( int i = 1; i <= t2; i++) {
					Bank.transferFromJuridicToPhysical(a2);
				}
				
				if (
					Bank.JuridicPersonClient.money == 959_950 &&
					Bank.PhysicalPersonClient.money == (39_640 + 100) &&
					Bank.BankScore.money == 410
				) {
					Bank.showMoney();
					System.out.println( "----------SOLUTION------------" );
					System.out.println( "transfer " + t1 + " times x " + a1 + " money + " + t2 + " times x " + a2 + " money" );
					System.out.println( "------------------------------" );
					break outer;
				}	
				
			}
	
		} 
	}
}

class Bank {

    static int money = 0;

    static class PhysicalPersonClient {
        static int money = 100;
    }
    static class JuridicPersonClient {
        static int money = 1_000_000;
    }
    static class BankScore {
        static int money = 0;
    }
    

    static void transferFromJuridicToPhysical(int amount){
    	
    	if( JuridicPersonClient.money < amount) {
    		System.out.println( "There is no money left on the account to transfer!!! On the account are " + JuridicPersonClient.money + " $");
    	}
    	
    	if( amount >= 100 && amount <= 5000) {
    		JuridicPersonClient.money -= amount;
    		
    		if( amount > 500) {
        		int procents = amount / 100 * 1;
        		BankScore.money += procents;
        		amount -= procents;
        	} else if( amount <= 500) {
        		BankScore.money += 10;
        		amount -= 10;
        	}
    		
        	PhysicalPersonClient.money += amount ;
    	} else if( amount < 100) {
    		System.out.println( "Too small amount to transfer. Transfer more then 99 $!!! ");
    	} else if( amount > 5000) {
    		System.out.println( "Too much amount to transfer. Transfer less then 5001 $!!! ");
    	} 
    	
       }
    
    static void showMoney() {
    	System.out.println( "##########################" );
    	System.out.println( "Physical Person Money: " + PhysicalPersonClient.money + " $");
    	System.out.println( "Juridic Person Money: " + JuridicPersonClient.money + " $");
    	System.out.println( "Bank Money: " + BankScore.money + " $");
    	System.out.println( "##########################" );
    }
    
    
}
