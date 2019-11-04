import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;



public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> childrenList = new ArrayList<String>();
		
		childrenList.add("Eason");
		childrenList.add("Tom");
		childrenList.add("Mike");
		childrenList.add("Jack");
		
		for(int i=0; i<childrenList.size();i++){
			System.out.println(childrenList.get(i));
		}
		
		Map<String, Integer> scoreMap = new HashMap<>();
		scoreMap.put("Eason", 100);
		scoreMap.put("Tom",90);
		scoreMap.put("Mike", 88);
		
		for(String one:scoreMap.keySet()){
			System.out.println(one+" score:"+scoreMap.get(one));
		}

	}

}
