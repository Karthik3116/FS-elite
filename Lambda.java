
import java.util.*;


class Emp{
    int id ;
    String name;
    Emp(int id , String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return  "Emp " + id + " -> " + name +" ";
    }
}

class sortByid implements Comparator<Emp>{
    @Override
    public int compare(Emp one , Emp two){
        return one.id - two.id;
    }
}




public class Lambda {

    public static void main(String[] args) {
        List<Emp> data = new ArrayList<>();
        data.add(new Emp(3, "Charlie"));
        data.add(new Emp(2, "Bob"));
        data.add(new Emp(1, "David"));
        data.add(new Emp(1, "Alice"));

        data.sort((a,b) -> a.id - b.id == 0 ? a.name.compareTo(b.name) : a.id-b.id );
        // data.sort((a,b) -> a.id - b.id);

        for(Emp e : data){
            System.out.println(e);
        }
        
    }
    
}
