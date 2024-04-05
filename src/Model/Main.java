package Model;

import java.sql.Connection;
import java.util.Map;

import Controll.CustomerController;
import Controll.Vehicle_Controller;


public class Main {

	public static void main(String[] args) {
		MydbConnection bd = new MydbConnection();
		Connection con = MydbConnection.getConnection();
	
		Vehicle vehi = new Vehicle_Controller();
		Customer cusi = new CustomerController();
		Transaction trans = new Transaction();
		
		Map<String,String> hashmap = vehi.getVehicle_available();
		for(String str:hashmap.keySet()) {
			System.out.println(str + " " + hashmap.get(str));
		}
		
		

	}

}
