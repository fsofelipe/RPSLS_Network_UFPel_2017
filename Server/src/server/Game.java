package server;

import java.util.*;

public class Game {
    private ArrayList<Integer> connectedUsers = new ArrayList <Integer>();
    private Hashtable <Integer, HandStatus> hands = new Hashtable <Integer, HandStatus>();
    private int numPlayers;
    ArrayList <Integer> winners = new ArrayList <Integer>();
    
    public Game(ArrayList<Integer> connectedUsers, int numPlayers){
        this.numPlayers = numPlayers;
        
        if (numPlayers == connectedUsers.size()){
            this.connectedUsers = connectedUsers;
        }else{
            System.out.println("ERRO QUANTIDADE DE JOGADORES INCORRETA");
        }
        
    }
    //RETURN THE RESULT OF THE BATTLE A X B
    private Result check(HandStatus a, HandStatus b){
        Result ret = Result.DRAW;
        
        if (a == HandStatus.ROCK){
            if (b == HandStatus.ROCK)
                ret = Result.DRAW;
            if (b == HandStatus.PAPER)
                ret = Result.LOSE;
            if (b == HandStatus.SPOCK)
                ret = Result.LOSE;
            if (b == HandStatus.LIZARD)
                ret = Result.WIN;
            if (b == HandStatus.SCISSORS)
                ret = Result.WIN;
        }
        
        if (a == HandStatus.PAPER){
            if (b == HandStatus.PAPER)
                ret = Result.DRAW;
            if (b == HandStatus.SCISSORS)
                ret = Result.LOSE;
            if (b == HandStatus.LIZARD)
                ret = Result.LOSE;
            if (b == HandStatus.ROCK)
                ret = Result.WIN;
            if (b == HandStatus.SPOCK)
                ret = Result.WIN;
        }
        
        if (a == HandStatus.SCISSORS){
            if (b == HandStatus.SCISSORS)
                ret = Result.DRAW;
            if (b == HandStatus.SPOCK)
                ret = Result.LOSE;
            if (b == HandStatus.ROCK)
                ret = Result.LOSE;
            if (b == HandStatus.LIZARD)
                ret = Result.WIN;
            if (b == HandStatus.PAPER)
                ret = Result.WIN;
        }
        
        if (a == HandStatus.LIZARD){
            if (b == HandStatus.LIZARD)
                ret = Result.DRAW;
            if (b == HandStatus.SCISSORS)
                ret = Result.LOSE;
            if (b == HandStatus.ROCK)
                ret = Result.LOSE;
            if (b == HandStatus.PAPER)
                ret = Result.WIN;
            if (b == HandStatus.SPOCK)
                ret = Result.WIN;
        }
        
        if (a == HandStatus.SPOCK){
            if (b == HandStatus.SPOCK)
                ret = Result.DRAW;
            if (b == HandStatus.PAPER)
                ret = Result.LOSE;
            if (b == HandStatus.LIZARD)
                ret = Result.LOSE;
            if (b == HandStatus.ROCK)
                ret = Result.WIN;
            if (b == HandStatus.SCISSORS)
                ret = Result.WIN;
        }
        return ret;
    }
    
    private void allPlayed(){
        winners.clear();
        
        for (int userA : connectedUsers){
            System.out.println(userA);
            
            for(int userB : connectedUsers){
                if (userA != userB){
                    Result game = check(hands.get(userA), hands.get(userB));
 
                }
            }
            
        }
        

        //numPlayers = winners.size();
        
    }
    
    //A PLAYER MAKES A PLAY, CHECKS IF 
    public void makePlay(int playerID, HandStatus hand){
        if (hands.containsKey(playerID) == true){
            hands.remove(playerID);
        }
        hands.put(playerID, hand);
        
        if (hands.size() == numPlayers)
            allPlayed();
            
        
    }
    
    public void checkHands(){
        System.out.println("Hands: " + hands.toString());
        System.out.println("Winners: " + winners.toString());
    }
}
