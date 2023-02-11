package packages.model;

import java.util.Objects;

public class TeamData {
    private String teamId;
    private String leagueId;
    private String name;
    private String logo;
    private String foundingDate;
    private String address;
    private String area;
    private String venue;
    private String capacity;
    private String coach;
    private String website;

    public TeamData() {
    }

    public TeamData(String teamId, String leagueId, String name, String logo, String foundingDate, String address, String area, String venue, String capacity, String coach, String website) {
        this.teamId = teamId;
        this.leagueId = leagueId;
        this.name = name;
        this.logo = logo;
        this.foundingDate = foundingDate;
        this.address = address;
        this.area = area;
        this.venue = venue;
        this.capacity = capacity;
        this.coach = coach;
        this.website = website;
    }

    public TeamData(String name) {
        this.name = name;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
