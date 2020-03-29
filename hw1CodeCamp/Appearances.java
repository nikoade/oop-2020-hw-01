import java.util.*;

public class Appearances {

	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		if(a.isEmpty() || b.isEmpty()) return 0;
		int result = 0;
		HashMap<T, Integer> mapA = new HashMap<>();
		HashMap<T, Integer> mapB = new HashMap<>();
		fillMap(mapA, a);
		fillMap(mapB, b);
		for(Map.Entry<T, Integer> it : mapA.entrySet()){
			T key = it.getKey();
			int value = it.getValue();
			if(mapB.containsKey(key) && mapB.get(key) == value){
				result ++ ;
			}
		}
		return result;
	}

	/** --------------------private methods for decomposition--------------------------- **/
	private static <T> void fillMap(HashMap<T, Integer> map, Collection<T> collection){
		for (Iterator<T> it = collection.iterator(); it.hasNext();) {
			T curr = it.next();
			if(map.containsKey(curr)){
				map.put(curr, map.get(curr) + 1);
			}else{
				map.put(curr, 1);
			}
		}
	}
}
