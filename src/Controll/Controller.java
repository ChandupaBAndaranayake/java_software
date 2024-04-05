package Controll;

import java.util.Vector;

import Model.Employee;

public interface Controller {
	public void Create();
	public void Update();
	public Vector<Vector<Object>> Read();
	public void Delete();	
}
