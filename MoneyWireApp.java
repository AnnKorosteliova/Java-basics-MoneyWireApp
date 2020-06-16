
public class MoneyWireApp {

	public static void main(String[] args) {
		Bank.transferFromJuridicToPhysical(5000);
		Bank.transferFromJuridicToPhysical(5000);
		Bank.transferFromJuridicToPhysical(5000);
		Bank.transferFromJuridicToPhysical(5000);
		Bank.transferFromJuridicToPhysical(5000);
		Bank.transferFromJuridicToPhysical(5000);
		Bank.transferFromJuridicToPhysical(5000);
		Bank.transferFromJuridicToPhysical(3900);
		Bank.transferFromJuridicToPhysical(1050);
		Bank.showMoney();		
	}
}

class Bank {

    static int money = 0;

    static class PhysicalPersonClient {
        static int money = 100;
    }
    static class JuridicPersonClient {
        static int money = 1000000;
    }
    static class BankScore {
        static int money = 0;
    }
    

    static void transferFromJuridicToPhysical(int amount){
    	
    	if( amount >= 100 && amount <= 5000) {
    		JuridicPersonClient.money = JuridicPersonClient.money - amount;
    		
    		if( amount > 500) {
        		int procents = amount / 100 * 1;
        		BankScore.money = BankScore.money + procents;
        		amount = amount - procents;
        	} else if( amount <= 500) {
        		BankScore.money = BankScore.money + 10;
        		amount = amount - 10;
        	}
    		
        	PhysicalPersonClient.money = PhysicalPersonClient.money + amount ;
    	} else if( amount < 100) {
    		System.out.println( "Too small amount to transfer. Transfer more then 99 $!!! ");
    	} else if( amount > 5000) {
    		System.out.println( "Too much amount to transfer. Transfer less then 5001 $!!! ");
    	} 
    	if( JuridicPersonClient.money < amount) {
    		System.out.println( "There is no money left on the account to transfer!!! On the account are " + JuridicPersonClient.money + " $");
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
