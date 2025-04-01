package server.client;

import javax.swing.*;

public interface ClientView {


    void showMessage(String text);

    JPanel getPanel();

    JTextField getText();
}
