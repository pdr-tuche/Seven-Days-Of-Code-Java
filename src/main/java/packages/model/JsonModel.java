package packages.model;

import java.util.List;

public class JsonModel {
    private String code;
    private String message;
    private List<TeamData> data;

    public JsonModel() {
    }

    public JsonModel(String code, String message, List<TeamData> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public TeamData getSpecificData(int index) {
        return data.get(index);
    }

    public TeamData getTeamData(String name) {
        TeamData team = new TeamData();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().contains(name)) {
                team = data.get(i);
                break;
            }
        }
        return team;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TeamData> getData() {
        return data;
    }

    public void setData(List<TeamData> data) {
        this.data = data;
    }
}
