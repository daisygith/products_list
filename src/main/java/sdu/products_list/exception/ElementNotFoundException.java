package sdu.products_list.exception;

public class ElementNotFoundException extends RuntimeException{ // błąd runtime

    public ElementNotFoundException(int id){
        super("Could not find element: " + id);
    }

    public ElementNotFoundException (int id, String name){
        super("Could not find element: " + id  + ", group: " + name);//przyjmuje message
    }
}
