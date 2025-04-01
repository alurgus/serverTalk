package server.server;

import server.client.Client;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class Server {
    private List<String>list;
    public static final String LOG_PATH = "src/server/log.txt";



    public boolean connectUser(Client client){

        if (!list.contains(client.getName())){
            list.add(client.getName());
            return true;
        } return  false;
    }

    public String getLog() {
        return readLog();
    }

    private void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
