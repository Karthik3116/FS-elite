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

public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Emp> data = new PriorityQueue<>((a,b) -> a.id - b.id == 0 ? a.name.compareTo(b.name) : Integer.compare(a.id,b.id)); // Min-Heap

        data.add(new Emp(3, "Charlie"));
        data.add(new Emp(2, "Bob"));
        data.add(new Emp(1, "David"));
        data.add(new Emp(1, "Alice"));

        System.out.println("PriorityQueue: " + data); // Elements are NOT sorted in output, but will be dequeued in order.

        // Removing elements (always smallest first)
        while (!data.isEmpty()) {
            System.out.println(data.poll()); // 1, 5, 10, 20
        }
    }
}



