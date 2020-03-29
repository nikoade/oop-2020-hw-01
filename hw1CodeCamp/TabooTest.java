// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TabooTest {

    /** noFollow tests **/
    @Test
    public void noFollowTest1(){
        List<String> listString = new ArrayList<>(Arrays.asList("London", "Tokyo", "London", "Tbilisi"));
        Taboo<String> tb = new Taboo<>(listString);

        Set<String> expected = new HashSet<>();
        expected.add("Tokyo");
        expected.add("Tbilisi");
        assertEquals(expected, tb.noFollow("London"));

    }

    @Test
    public void noFollowTest2(){
        List<String> listString = new ArrayList<>(Arrays.asList());
        Taboo<String> tb = new Taboo<>(listString);

        Set<String> expected = new HashSet<>();
        assertEquals(expected, tb.noFollow("London"));
    }

    @Test
    public void noFollowTest3(){
        List<Integer> listInteger = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 1));
        Taboo<Integer> tb = new Taboo<>(listInteger);

        Set<Integer> expected = new HashSet<>();
        expected.add(2);
        expected.add(3);
        assertEquals(expected, tb.noFollow(1));

    }

    @Test
    public void noFollowTest4(){
        List<Character> listCharacter = new ArrayList<>(Arrays.asList(' ', 'a', 'c', 'a', 'b'));
        Taboo<Character> tb = new Taboo<>(listCharacter);

        Set<Character> expected = new HashSet<>();
        expected.add('c');
        expected.add('b');
        assertEquals(expected, tb.noFollow('a'));

    }

    @Test
    public void noFollowTest5(){
        List<String> listString = new ArrayList<>(Arrays.asList("asd", "", "asd", "j", "j", "", ""));
        Taboo<String> tb = new Taboo<>(listString);

        Set<String> expected = new HashSet<>();
        expected.add("asd");
        expected.add("");
        assertEquals(expected, tb.noFollow(""));

    }


    /** reduce tests **/
    @Test
    public void reduceTest1(){
        List<String> listString = new ArrayList<>(Arrays.asList("asd", "", "asd", "j", "j", "", ""));
        Taboo<String> tb = new Taboo<>(listString);

        List<String> expected = new ArrayList<>(Arrays.asList("j", "b", "b"));
        List<String> forChange = new ArrayList<>(Arrays.asList("j", "j", "", "b", "b"));

        tb.reduce(forChange);
        assertEquals(expected, forChange);
    }

    @Test
    public void reduceTest2() {
        List<String> listString = new ArrayList<>(Arrays.asList(null, null, "aa", "bb", "ja", "ja", "bb"));
        Taboo<String> tb = new Taboo<>(listString);

        List<String> expected = new ArrayList<>(Arrays.asList("aa"));
        List<String> forChange = new ArrayList<>(Arrays.asList("aa", "bb", "bb"));

        tb.reduce(forChange);
        assertEquals(expected, forChange);

    }

    @Test
    public void reduceTest3(){
        List<Integer> listString = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Taboo<Integer> tb = new Taboo<>(listString);

        List<Integer> expected = new ArrayList<>(Arrays.asList(1,3,5,7,9));
        List<Integer> forChange = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        tb.reduce(forChange);
        assertEquals(expected, forChange);
    }

    @Test
    public void reduceTest4(){
        List<String> listString = new ArrayList<>(Arrays.asList("aa", null, "aa", "bb", "ja", "ja", "bb"));
        Taboo<String> tb = new Taboo<>(listString);

        List<String> expected = new ArrayList<>(Arrays.asList("aa", "aa"));
        List<String> forChange = new ArrayList<>(Arrays.asList("aa", "aa", "bb"));

        tb.reduce(forChange);
        assertEquals(expected, forChange);
    }

    @Test
    public void reduceTest5(){
        List<String> listString = new ArrayList<>(Arrays.asList(null, null));
        Taboo<String> tb = new Taboo<>(listString);

        List<String> expected = new ArrayList<>(Arrays.asList("a", "a", "a", "a", "a", "a"));
        List<String> forChange = new ArrayList<>(Arrays.asList("a", "a", "a", "a", "a", "a"));

        tb.reduce(forChange);
        assertEquals(expected, forChange);
    }
}
