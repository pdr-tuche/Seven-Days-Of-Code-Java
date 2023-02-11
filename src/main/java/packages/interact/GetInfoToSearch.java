package packages.interact;

import packages.model.TeamData;

import java.util.Scanner;

public class GetInfoToSearch {
    private String team;

    public GetInfoToSearch() {
        Scanner input = new Scanner(System.in);
        System.out.printf("digite o nome do time a ser procurado: ");
        String teamName = input.nextLine();
        input.close();
        this.team = teamName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
