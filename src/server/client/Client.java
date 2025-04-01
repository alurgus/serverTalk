package server.client;

import server.server.Server;

public class Client {
    private Server server;
    private boolean connected;
    private String name;
    private ClientView view;

    public Client(ClientView view, Server server) {
        this.view = view;
        this.server = server;
    }

    private void connectToServer() {
        if (server.connectUser(this)){
            view.showMessage("Вы успешно подключились!\n");
            view.getPanel().setVisible(false);
            connected = true;
            name = view.getText().toString();
            String log = server.getLog();
            if (log != null){
                view.showMessage(log);
            }
        } else {
            view.showMessage("Подключение не удалось");
        }
    }
    public String getName() {
        return name;
    }

}
