package Pizza;

import java.util.ArrayList;

class PizzaPickControl {
	ArrayList<Pizza> pzList = new ArrayList<Pizza>(); //피자의 정보를 입력
	
	//피자 생성먼저하기
	public void makePizzaList() {
		
	}
	
	
	
	//피자 선택시 피자의 정보를 장바구니에 전달 다음 장바구니 컨트롤에서 이용할 메소드
	public Pizza PickPizzaInfo(int choice) {
		return pzList.get(choice);
	}

	//피자들의 정보를 전달. //뷰에서 이용할 메서드
	public ArrayList<Pizza> PizzaInfo(){
		return pzList;
	}
	
	
}
