package pizza;

import java.util.ArrayList;

class SideMenu extends Food{
	
	SideMenu(String name,int price){
		super(2, name, price);
	}
	

}

class SideMenuControll{
	
	ArrayList<SideMenu> sdList = new ArrayList<SideMenu>();
//	int choice;

	
	SideMenuControll(){
		sdList.add(new SideMenu("소스", 500));
		sdList.add(new SideMenu("피클", 500));
		sdList.add(new SideMenu("콜라", 1500));
		sdList.add(new SideMenu("샐러드", 1500));
		sdList.add(new SideMenu("치킨윙", 1500));
		sdList.add(new SideMenu("스파게티", 1500));
		sdList.add(new SideMenu("치즈볼", 3000));
	}
	
	public SideMenu PickSideInfo(int choie) {
		return sdList.get(choie);
	}
	
	
}