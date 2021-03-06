package frameworkAgency;

public abstract class PersonAgency implements GeneralPerson {

	private String name;
	private String lastName;
	private GeneralCard card;
	private char[] taxCode = new char[16];
	private Credentials loginCredentials;

	public PersonAgency(String name, String lastName, char[] taxCode) {
		this.setLastName(lastName);
		this.setName(name);
		this.setTaxCode(taxCode);
		this.loginCredentials = new Credentials(name,this.getName()+Math.random(), this);
		this.setCard(this.getNewCard());
	}
	
	public PersonAgency(String name, String lastName, char[] taxCode, String userName) {
		this.setLastName(lastName);
		this.setName(name);
		this.setTaxCode(taxCode);
		this.loginCredentials = new Credentials(userName,this.getName()+Math.random(), this);
		this.setCard(this.getNewCard());
	}
	
	public PersonAgency(String name, String lastName, char[] taxCode, String userName, String password) {
		this.setLastName(lastName);
		this.setName(name);
		this.setTaxCode(taxCode);
		this.loginCredentials = new Credentials(userName,password, this);
		this.setCard(this.getNewCard());
	}
	
	protected abstract GeneralCard getNewCard();
	
	private void setCard(GeneralCard card) {
		this.card = card;
	}

	public GeneralCard getCard() {
		return card;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getLastName() {
		return lastName;
	}
	
	private void setTaxCode(char[] taxCode) {
		this.taxCode = taxCode;
	}

	@Override
	public char[] getTaxCode() {
		return taxCode;
	}
	
	public Credentials getLoginCredentials() {
		return loginCredentials;
	}

	@Override
	public String toString() {
		return addThing()+" Nome : "+this.getName()+" Cognome : "+this.getLastName()+" Codice Fiscale : "+String.valueOf(getTaxCode())+"\n-----\n";
	}
	
	protected abstract String addThing();

	public boolean isAdmin() {
		return false;
	}

	public boolean isEmployee() {
		return false;
	}
	
}