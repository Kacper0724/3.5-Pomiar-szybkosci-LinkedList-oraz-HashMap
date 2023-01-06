import java.util.*;

public class Application {
    public static void main(String[] args){
        List<Book> linkedList = new LinkedList<>();
        for(int i = 0; i < 600000; i++) {
            linkedList.add(new Book("n", "n"));
        }
        System.out.println("Quanity of elements in the collection: " + linkedList.size());

        long begin = System.nanoTime();
        linkedList.remove(0);
        long end = System.nanoTime();

        System.out.println("\nSearch and remove first object: " + (end - begin) + "ns");

        begin = System.nanoTime();
        linkedList.remove(linkedList.size()-1);
        end = System.nanoTime();

        System.out.println("\nSearch and remove last object: " + (end - begin) + "ns");

        begin = System.nanoTime();
        linkedList.add(0, new Book("nn", "nn"));
        end = System.nanoTime();

        System.out.println("\nAdd object on the first index: " + (end - begin) + "ns");

        begin = System.nanoTime();
        linkedList.add(linkedList.size()-1, new Book("nnnn", "nnnn"));
        end = System.nanoTime();

        System.out.println("\nAdd object on the last index: " + (end - begin) + "ns");

        //HashMap
        System.out.println("\n-----HASHMAP-----");

        Map<Integer, Book> hashmap = new HashMap<>();
        for(int i = 0; i < 500000; i++) {
            hashmap.put(i, new Book("nnnnn", "nnnnn"));
        }
        System.out.println("\nQuanity of elements in the map: " + hashmap.size());

        begin = System.nanoTime();
        hashmap.get(150000);
        end = System.nanoTime();

        System.out.println("\nSearch key number 150000: " + (end - begin) + "ns");

        begin = System.nanoTime();
        hashmap.put(150000, new Book("nnnnnn", "nnnnnn"));
        end = System.nanoTime();

        System.out.println("\nAdd key number 150000: " + (end - begin) + "ns");

        begin = System.nanoTime();
        hashmap.remove(150000);
        end = System.nanoTime();

        System.out.println("\nRemove key number 150000: " + (end - begin) + "ns");
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean equals(Object o) {
        Book e = (Book) o;
        return (title.equals(e.getTitle())) &&
                (author.equals(e.getAuthor()));
    }

    public int hashCode() {
        return Objects.hash(title, author);
    }
}