package Assignment2.client.views;

import Assignment2.client.core.ViewHandler;
import Assignment2.client.core.ViewModelFactory;

import java.io.IOException;

public interface ViewController {
    void init(ViewHandler vh, ViewModelFactory vmf) throws IOException;
}
