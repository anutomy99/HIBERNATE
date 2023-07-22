package org.jsp.usefood.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.usefood.dao.FoodDao;
import org.jsp.usefood.dao.UserDao;
import org.jsp.usefood.dto.FOrder;
import org.jsp.usefood.dto.User;

public class UserFoodController {
	static UserDao usrDao = new UserDao();
	static FoodDao foodDao=new FoodDao();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
      System.out.println("1.save User\n2.Verify User by email and password\n3.Save Food order\n4.Update user\n5.update food order\n6.Fetch food orders by user id\n7.fetch food order by user email password\n8.Delete food order ");
      int choice=s.nextInt();
      switch (choice) {
	case 1:
		addUser();
		break;
	case 2:
		verifyUsr();
		break;
	case 3:
		addFoodOrder();
	case 4:
		updateUsr();
	case 5:
		updatefoodOrder();
	case 6:
		fetchOrderByUserId();
	case 7:
		fetchOrderByUserEmailPassword();
	case 8:
		deleteOrder();
	default:
		break;
	}
      
	}
public static void addUser(){
	System.out.println("Enter name,gender,email,phone,password");
	String name=s.next();
	String gender=s.next();
	String email=s.next();
	long phone=s.nextLong();
	String password=s.next();
	User u=new User();
	u.setName(name);
	u.setGender(gender);
	u.setEmail(email);
	u.setPhone(phone);
	u.setPassword(password);
	u=usrDao.saveUser(u);
	System.out.println("User saved with id:"+u.getId());
}

public static void verifyUsr() {
	System.out.println("Enter email and password");
	String email=s.next();
	String password=s.next();
	User u=usrDao.verifyUser(email, password);
	if(u!=null) {
		System.out.println("Name:"+u.getName());
		System.out.println("Gender:"+u.getGender());
		System.out.println("Phone:"+u.getEmail());
		System.out.println("Email:"+u.getEmail());
	}else {
		System.err.println("Invalid email or password");
	}
}
public static void updateUsr() {
	System.out.println("Enter user id to update");
	int id=s.nextInt();
	System.out.println("Enter name,gender,email,phone,password");
	
	String name=s.next();
	String gender=s.next();
	String email=s.next();
	long phone=s.nextLong();
	String password=s.next();
	User u=new User();
	u.setId(id);
	u.setName(name);
	u.setGender(gender);
	u.setEmail(email);
	u.setPhone(phone);
	u.setPassword(password);
	u=usrDao.updateUser(u);
	System.out.println("User updated with id:"+u.getId());
	
}
public static void addFoodOrder() {
	System.out.println("Enter person id to order food");
	int id=s.nextInt();
	System.out.println("Enter item,cost,address");
	String item=s.next();
	int cost=s.nextInt();
	String address=s.next();

	FOrder o=new FOrder();
	o.setItem(item);
	o.setCost(cost);
	o.setAddress(address);
	o=foodDao.saveFoodOrder(o,id);
	if(o!=null)
	System.out.println("Order saved with id "+o.getId());
	else
		System.err.println("ERR");
	
}

public static void updatefoodOrder() {
	System.out.println("Enter order id to update order");
	int oid=s.nextInt();
	System.out.println("Enter item,cost,address");
	String item=s.next();
	int cost=s.nextInt();
	String address=s.next();
	FOrder o=new FOrder();
	o.setId(oid);
	o.setItem(item);
	o.setCost(cost);
	o.setAddress(address);
	o=foodDao.updateFoodOrder(o, oid);
	System.out.println("Order updated With id"+o.getId());
}
 public static void fetchOrderByUserId() {
	 System.out.println("Enter user id to fetch order details");
	 int id=s.nextInt();
	 List<FOrder> fo=foodDao.fetchOrderById(id);
	 if(fo.size()>0) {
		 for (FOrder f : fo) {
			System.out.println("Id:"+f.getId());
			System.out.println("Item:"+f.getItem());
			System.out.println("cost:"+f.getCost());
			System.out.println("Address:"+f.getAddress());
			System.out.println("Ordered time:"+f.getOrdered_time());
			System.out.println("Delivery time:"+f.getDelivered_time());
			System.out.println("---------------------------------------");

		}
	 }
 }
 
 public static void fetchOrderByUserEmailPassword() {
	 System.out.println("Enter user email,password to fetch order details");
	 String email=s.next();
	 String password=s.next();

	 List<FOrder> fo=foodDao.fetchOrderByEmailPassword(email, password);
	 if(fo.size()>0) {
		 for (FOrder f : fo) {
			System.out.println("Id:"+f.getId());
			System.out.println("Item:"+f.getItem());
			System.out.println("cost:"+f.getCost());
			System.out.println("Address:"+f.getAddress());
			System.out.println("Ordered time:"+f.getOrdered_time());
			System.out.println("Delivery time:"+f.getDelivered_time());
			System.out.println("---------------------------------------");

		}
	 }
 }
 public static void deleteOrder() {
	 System.out.println("Enter order id for delete");
	 int id=s.nextInt();
	 FOrder o=new FOrder();
	 o=foodDao.deleteFoodOrder(o, id);
	 if(o!=null)
			System.out.println("Order deleted with id "+o.getId());
			else
				System.err.println("ERR");
 }
}
