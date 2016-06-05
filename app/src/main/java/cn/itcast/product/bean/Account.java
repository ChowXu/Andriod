package cn.itcast.product.bean;

public class Account {
	private Long id;			
	private String name;
	private Integer balance;
	private String desc;
	private String pic;


	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}



	public String getDesc() {
		return desc;
	}
	public void setDesc(String name) {
		this.desc = name;
	}


	public String getPic() {
		return pic;
	}
	public void setPic(String name) {
		this.pic = name;
	}


	public Account(Long id, String name, Integer balance ,String desc,String pic) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.desc = desc;
		this.pic = pic;
	}
	public Account(String name, Integer balance,String desc, String pic ) {
		super();
		this.desc = desc;
		this.name = name;
		this.balance = balance;
		this.pic = pic;
	}
	public Account() {
		super();
	}
	public String toString() {
		return "[id ∫≈: " + id + ", ≤À√˚: " + name + ", º€∏Ò: " + balance +",√Ë ˆ:" + desc +  "]" ;
	}
}
