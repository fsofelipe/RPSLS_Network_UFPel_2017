package server;

public class User {
    private int id;
    private String name;
    private int gamesPlayed;
    private int wins;
    
    
    public User(int id, String name, int gamesPlayed, int wins) {
        this.id = id;
        this.name = name;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        System.out.println(this.name);

    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
