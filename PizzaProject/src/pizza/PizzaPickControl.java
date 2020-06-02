package pizza;

import java.util.ArrayList;

class PizzaPickControl {
	ArrayList<Pizza> pzList = new ArrayList<Pizza>(); //피자의 정보를 입력
	
	int choice;
	PizzaPickControl(){
		pzList.add(new Pizza("토핑탑텐", "Medium", 28000, "basic"));
		pzList.add(new Pizza("미트미트미트", "Medium", 28000, "basic"));
		pzList.add(new Pizza("뉴욕&치즈스트립스테이크", "Medium", 29000, "basic"));
		pzList.add(new Pizza("블랙타이거 쉬림프", "Medium", 28000, "basic"));
	}


	
	//피자 선택시 피자의 정보를 장바구니에 전달 다음 장바구니 컨트롤에서 이용할 메소드
	public Pizza PickPizzaInfo() {
		return pzList.get(choice);
	}

	//피자들의 정보를 전달. //뷰에서 이용할 메서드
	public ArrayList<Pizza> PizzaInfo(){
		return pzList;
	}
	
	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}
	
}
