package a1_22BI13012;

public class Test_A1 {
	public static void main(String[] args) {
		PostgradStudent VuAnh = new PostgradStudent(100000001, "VuAnh", "0989675548", "IA20", (float) 3.2);
		
		VuAnh.repOK();
		System.out.print(VuAnh);
		
		System.out.print("\n");
		
		UndergradStudent DinhVuAnh = new UndergradStudent(1000000, "VuAnh", "0989675548", "Ia20 Ciputra");
		
		System.out.print(DinhVuAnh);
		
		
	}
}
