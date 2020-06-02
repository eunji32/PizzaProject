package pizza;

class Pizza extends Food{
	private String size;
	private String edge = "basic";


	Pizza(String name, String size, int price, String edge){	
		super(1, name, price); //피자 카테고리는 1
		this.size = size;
		this.edge = edge;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getEdge() {
		return edge;
	}

	public void setEdge(String edge) {
		this.edge = edge;
	}

}
