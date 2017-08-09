package server;


public class Main {
    public static void main(String[] args) throws Exception  {
        Game teste = new Game(12, 34);

        System.out.println(teste.makePlay(12, HandStatus.ROCK));
        System.out.println(teste.makePlay(34, HandStatus.LIZARD));

        Server gameServer = new Server();
        gameServer.ServerStart();
        

    }
}
