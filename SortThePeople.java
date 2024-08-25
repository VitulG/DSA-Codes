import java.util.Arrays;
import java.util.Comparator;

public class SortThePeople {

    static class Person {
        String name;
        int height;

        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    static class SortPeoples implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            return p2.height - p1.height;
        }
        
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        Person[] peoples = new Person[names.length];

        for(int i=0; i<names.length; i++) {
            peoples[i] = new Person(names[i], heights[i]);
        }
        Arrays.sort(peoples, new SortPeoples());

        String[] ans = new String[names.length];
        int idx = -1;

        for(Person person : peoples) {
            ans[++idx] = person.name;
        }
        return ans;

    }

    public static void main(String[] args) {
        String[] names = sortPeople(new String[]{"Vitul","Rahul","Aman"}, new int[]{164,180,160});

        for(String name : names) {
            System.out.print(name+" ");
        }

    }
}