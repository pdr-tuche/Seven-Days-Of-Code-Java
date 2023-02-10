package packages.jsonparser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import packages.model.JsonModel;

public class MyJsonParser {

    private JsonModel jsonModel;

    public MyJsonParser() {
    }

    public MyJsonParser(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        this.jsonModel = mapper.readValue(json, JsonModel.class);
    }

    public JsonModel getJsonModel() {
        return jsonModel;
    }

    public void setJsonModel(JsonModel jsonModel) {
        this.jsonModel = jsonModel;
    }
}
