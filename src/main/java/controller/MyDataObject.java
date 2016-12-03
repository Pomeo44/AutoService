package controller;

/**
 * Created by aantipin on 15/11/2016.
 */
public class MyDataObject {

    private String id;
    private String message;

    public MyDataObject(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public MyDataObject() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
