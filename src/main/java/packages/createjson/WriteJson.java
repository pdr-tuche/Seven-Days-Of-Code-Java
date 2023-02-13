package packages.createjson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import packages.model.TeamData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteJson {
    private JSONObject jsonObject;

    public WriteJson(TeamData team) throws JSONException {
        JSONObject aux = new JSONObject();
        aux.putOpt("name",team.getName());
        aux.putOpt("logo",team.getLogo());

        this.jsonObject = aux;
        createFile();
    }

    public WriteJson(List<TeamData> teams) throws JSONException {
        List<JSONObject> list = new ArrayList<>();
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();

        for (int i = 0; i < teams.size(); i++) {
            JSONObject aux = new JSONObject();
            aux.put("name", teams.get(i).getName());
            aux.put("logo", teams.get(i).getLogo());

            list.add(aux);
        }
        for (int i = 0; i < list.size(); i++) {
            arr.put(i, list.get(i));
        }
        obj.put("teams", arr);
        this.jsonObject = obj;
        createFile();
    }

    public void createFile(){
        FileWriter writeFile;
        try{
            writeFile = new FileWriter("src/main/resources/team.json");
            writeFile.write(jsonObject.toString());
            writeFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
