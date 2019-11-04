package modelstudy;

public class Singleton {
	public static void main(String[] args){
		Single s1 = Single.getSingle();
		Single s2 = Single.getSingle();
		System.out.println(s1);
		System.out.println(s2);
		
	}

}


class Single{
	
	private static Single onlyone = new Single();
	
	
	private Single(){}
	
	
	public static Single getSingle(){
		return  onlyone;
	}
	
}