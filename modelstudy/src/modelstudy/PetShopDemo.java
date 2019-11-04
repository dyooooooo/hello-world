package modelstudy;

public class PetShopDemo {
	public static void main(String[] args){
		PetShop ps = new PetShop(5);
		
		ps.add(new Cat("catty","white",3));
		ps.add(new Dog("Tom","Brey",5));
		ps.add(new Cat("kimmy","yellow",3));
		ps.add(new Dog("dimmy","golden",2));
		ps.add(new Cat("lichy","black",3));
		
		print(ps.search("white"));
		print(ps.getAll());
		
		
	}
	
	
	public static void print(Pet p[]){
		for(int i =0; i<p.length;i++){
			if(p[i]!=null){
				System.out.println(p[i].toString()+"[ pet name is " + p[i].getPetName()+", pet color is "+p[i].getPetColor()+" ]");
			}
		}
	}
}

class PetShop{
	
	private Pet[] pets;
	
	private int foot;
	
	public PetShop(int len){
		if(len>0){
			this.pets = new Pet[len];
		}else{
			this.pets = new Pet[1];
		}
		
		this.foot=0;
	}
	
	public boolean add(Pet pet){
		if(this.foot<this.pets.length){
			this.pets[this.foot]=pet;
			this.foot++;
			return true;
		}else{
			return false;
		}
	}
	
	public Pet[] search(String keywork){
		Pet p[] = null;
		
		int count=0;
		for(int i=0; i<this.foot;i++){
			if(this.pets[i].getPetName().indexOf(keywork)!=-1 || this.pets[i].getPetColor().indexOf(keywork)!=-1){
				count ++;
			}
		}
		
		p = new Pet[count];
		
		int f = 0;
		
		for(int i=0; i<this.foot;i++){
			if(this.pets[i].getPetName().indexOf(keywork)!=-1 || this.pets[i].getPetColor().indexOf(keywork)!=-1){
				p[f]=this.pets[i];
				f ++;
			}
		}
		
		return p;
		
	}
	
	public Pet[] getAll(){	
		return this.pets;
	}
	
}

interface Pet{
	String getPetName();
	String getPetColor();
	int getPetAge();
}

class Cat implements Pet{
	private String petName;
	private String petColor;
	private int petAge;
	
	public Cat(String name,String color,int age){
		this.setPetAge(age);
		this.setPetColor(color);
		this.setPetName(name);
	}
	@Override
	public String getPetName() {
		// TODO Auto-generated method stub
		return this.petName;
	}
	@Override
	public String getPetColor() {
		// TODO Auto-generated method stub
		return this.petColor;
	}
	@Override
	public int getPetAge() {
		// TODO Auto-generated method stub
		return this.petAge;
	}
	
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public void setPetColor(String petColor) {
		this.petColor = petColor;
	}
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	
}



class Dog implements Pet{
	private String petName;
	private String petColor;
	private int petAge;
	
	public Dog(String name,String color,int age){
		this.setPetAge(age);
		this.setPetColor(color);
		this.setPetName(name);
	}
	@Override
	public String getPetName() {
		// TODO Auto-generated method stub
		return this.petName;
	}
	@Override
	public String getPetColor() {
		// TODO Auto-generated method stub
		return this.petColor;
	}
	@Override
	public int getPetAge() {
		// TODO Auto-generated method stub
		return this.petAge;
	}
	
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public void setPetColor(String petColor) {
		this.petColor = petColor;
	}
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	
}