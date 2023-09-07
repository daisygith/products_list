package sdu.products_list.exception;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(int id){

    }

    public ElementNotFoundException (int id, String name){
        super();
    }
}
