package packages.createjson;

import org.json.JSONException;
import org.json.JSONObject;
import packages.model.TeamData;

import java.io.FileWriter;
import java.io.IOException;

public class WriteJson {
    private JSONObject jsonObject;

    public WriteJson(TeamData team) throws JSONException {
        JSONObject aux = new JSONObject();
        aux.putOpt("name",team.getName());
        aux.putOpt("logo",team.getLogo());

        this.jsonObject = aux;
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
