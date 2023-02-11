package packages.interact;

import java.util.Scanner;

public class AskTeamToSearch {
    private String teamName;
    public AskTeamToSearch() {
        System.out.printf("Digite o nome do time a ser buscado: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        input.close();
        this.teamName=name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
