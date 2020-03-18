package Assignement2.shared.transferobjects;

import java.io.Serializable;

public class Message implements Serializable {

    private Object arg;

    public Message(Object arg) {

        this.arg = arg;
    }


    public Object getArg() {
        return arg;
    }
}
