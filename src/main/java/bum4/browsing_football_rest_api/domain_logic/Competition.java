package bum4.browsing_football_rest_api.domain_logic;

public class Competition {
    public int id;
    public Area area;
    public String name;
    public String code;
    public String plan;
    public Season currentSeason;
    public String emblemUrl;
    public String lastUpdated;
    public int numberOfAvailableSeasons;



    @Override
    public String toString() {
        return "Competition{" +
                "ild=" + id +
                ", area=" + area +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", plan='" + plan + '\'' +
                ", currentSeason=" + currentSeason +
                ", emblemUrl='" + emblemUrl + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", numberOfAvailableSeasons=" + numberOfAvailableSeasons +

                '}';
    }

    public class Area{
        public int id;
        public String name;
        public String countryCode;

        @Override
        public String toString() {
            return "Area{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", countryCode='" + countryCode + '\'' +
                    '}';
        }
    }
    public class Season{
        public int id;
        public String startDate;
        public String endDate;
        public int currentMatchday;
        public Object winner;

        @Override
        public String toString() {
            return "Season{" +
                    "id=" + id +
                    ", startDate='" + startDate + '\'' +
                    ", endDate='" + endDate + '\'' +
                    ", currentMatchday=" + currentMatchday +
                    ", winner=" + winner +
                    '}';
        }}

}







