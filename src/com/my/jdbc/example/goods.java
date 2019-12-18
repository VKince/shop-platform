package com.my.jdbc.example;

public class goods {
	private String id;
	private String name;
	private String size;
	private String design;
	private String price;
	public goods(String id, String name, String size, String design, String price) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.design = design;
		this.price = price;
	}
	public goods() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getsize() {
		return size;
	}
	public void setsize(String size) {
		this.size = size;
	}
	public String getdesign() {
		return design;
	}
	public void setdesign(String design) {
		this.design = design;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", size=" + size + ", design=" + design + ", price="
				+ price + "]";
	}
	@Override
    public boolean equals(Object o)
    {
		
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof goods))
        {
            return false;
        }
        goods pn = (goods)o;
        System.out.println(pn.name+" "+name+" "+pn.id+
        		" "+id);
        System.out.println(pn.name.equals(name));
        return pn.name.equals(name)&&pn.id.equals(id);
    }

    @Override
    public int hashCode()
    {
        return Integer.parseInt(id);
    }
}
