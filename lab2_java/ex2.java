class BankAccount{
	String accountNumber;
	double balance;
	
	public BankAccount(String accountNumber, double balance) {
        	this.accountNumber = accountNumber;
        	this.balance = balance;
   	}


	public void setAccountNumber(String newAccountNumber){
		accountNumber = newAccountNumber;
	}
	public void setBalence(double newBalence){
		balance = newBalence;
	}
	public String getAccountNumber(){
		return accountNumber;
	}
	public double getBalance(){
		return balance;
	}

	public boolean deposit(double amount){
		this.balance+=amount;
		return true;
	}

	public boolean withdraw(double amount){
		if(amount > this.balance || amount < 0){
			return false;
		}
		this.balance -= amount;
		return true;
	}

	
	
    public static void main(String[] args) {
        BankAccount account = new BankAccount("A001", 1000);

        System.out.println("Initial balance: " + account.getBalance());

        account.deposit(500);
       	System.out.println("After deposit: " + account.getBalance());

        if (account.withdraw(300)) {
            	System.out.println("Withdrawal successful");
        } else {
            	System.out.println("Withdrawal failed");
        }

        if (account.withdraw(2000)) {
            	System.out.println("Withdrawal successful");
        } else {
            System.out.println("Withdrawal failed: insufficient balance");
        }

        	System.out.println("Final balance: " + account.getBalance());
    	}
	
}




