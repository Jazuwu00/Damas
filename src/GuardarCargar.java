import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.Iterator;

public class GuardarCargar{
   static void save(int[][] tableroFichas, boolean siguesuturno){
        JSONObject estadoPartida = new JSONObject();
        estadoPartida.put("Turno",siguesuturno);

       JSONArray tabler = new JSONArray();
       for(int i = 0; i < tableroFichas.length; i++){
           for(int j = 0; j < tableroFichas.length; j++){
               tabler.add(tableroFichas[i][j]);
           }
       }
        estadoPartida.put("Tablero",tabler);

        try (FileWriter file = new FileWriter("test.json")) {
            file.write(estadoPartida.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(estadoPartida);

    }

    static  load(){
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader("test.json");
            JSONObject partida = (JSONObject) parser.parse(reader);
            System.out.println(partida);

            boolean siguesuturno = (boolean) partida.get("Turno");
            System.out.println(siguesuturno);

            JSONArray tablero = (JSONArray) partida.get("Tablero");
            Iterator<Object> iterator = tablero.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

    }
}

