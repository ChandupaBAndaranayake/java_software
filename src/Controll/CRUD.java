package Controll;

import java.util.Vector;

public interface CRUD {
	public void create();
	public void remove();
	public void update();
	public Vector<Vector<Object>> Read();
}
