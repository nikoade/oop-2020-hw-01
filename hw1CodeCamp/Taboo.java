
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {

	private List<T> taboo;

	public Taboo(List<T> rules) {
		taboo = new ArrayList<>();
		if(rules.size() == 0) return;
		int i;
		for(i = 0; i < rules.size() - 1; ++i){
			if(rules.get(i) == null || rules.get(i + 1) == null){
				continue;
			}
			taboo.add(rules.get(i));
		}
		if(rules.get(i) != null)
			taboo.add(rules.get(i));
	}

	public Set<T> noFollow(T elem) {
		Set<T> result = new HashSet<>();
		for(int i = 0; i < taboo.size() - 1; ++i){
			if(taboo.get(i).equals(elem)){
				result.add(taboo.get(i + 1));
			}
		}

		return result;
	}

	public void reduce(List<T> list) {
		HashMap<T, Set<T> > noFollows = new HashMap<>();
		fillSet(noFollows);
		if(list.isEmpty()) return;
		for(int i = 0; i < list.size() - 1; ++i){
			T curr = list.get(i);
			T next = list.get(i + 1);
			if(noFollows.containsKey(curr) && noFollows.get(curr).contains(next)){
				list.remove(i + 1);
				i--;
			}
		}
	}

	/** --------------------private methods for decomposition--------------------------- **/
	private void fillSet(HashMap<T, Set<T> > noFollows){
		if(taboo.size() == 0) return;
		for(int i = 0; i < taboo.size() - 1; ++i){
			T curr = taboo.get(i);
			T next = taboo.get(i + 1);
			if(curr == null || next == null) continue;

			if(noFollows.containsKey(curr)){
				noFollows.get(curr).add(next);
			}
			else{
				Set<T> newSet = new HashSet<>();
				newSet.add(next);
				noFollows.put(curr, newSet);
			}
		}
	}
}
