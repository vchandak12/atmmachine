package atm;
import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf {
    atmp atm=new atmp();
    
    	
    Map<Double,String> ministmt=new HashMap<>();

	@Override
	public void viewBalance() {
		// TODO Auto-generated method stub
		 System.out.println("Available Balance is : "+atm.getBalance());

	}

	@Override
	public void withdrawAmount(double withdrawAmount) {
		// TODO Auto-generated method stub
		if(withdrawAmount%500==0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministmt.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please enter the amount in multipal of 500");
        }

    }
//	abc

	@Override
	public void depositAmount(double depositAmount) {
		// TODO Auto-generated method stub
		 ministmt.put(depositAmount," Amount Deposited");
	        System.out.println(depositAmount+" Deposited Successfully !!");
	        atm.setBalance(atm.getBalance()+depositAmount);
	        viewBalance();

		
	}

	@Override
	public void viewMiniStatement() {
		// TODO Auto-generated method stub
		for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }
	}

}
