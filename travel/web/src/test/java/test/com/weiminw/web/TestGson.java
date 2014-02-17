package test.com.weiminw.web;

import com.google.gson.Gson;

public class TestGson {
	private int a = 1 ;

	public int getA() {
		return 2;
	}

	public void setA(int a) {
		this.a = a;
	}
	public static void main(String[] args) {
		Gson gson = new Gson();
		System.out.println(gson.toJson(new TestGson()));;
	}
}
