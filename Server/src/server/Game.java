package server;

import java.util.*;

public class Game {
    int userID_A, userID_B;
    HandStatus handA, handB;
    int whoPlays;
    int timesPlayed;

    public Game(int userID_A, int userID_B) {
        this.userID_A = userID_A;
        this.userID_B = userID_B;
        this.whoPlays = userID_A; 
        this.timesPlayed = 0;
    }
    
    //RETURN THE RESULT OF THE BATTLE A X B
    private Result check(){
        Result ret = Result.DRAW;
        
        if (handA == HandStatus.ROCK){
            if (handB == HandStatus.ROCK)
                ret = Result.DRAW;
            if (handB == HandStatus.PAPER)
                ret = Result.WIN_B;
            if (handB == HandStatus.SPOCK)
                ret = Result.WIN_B;
            if (handB == HandStatus.LIZARD)
                ret = Result.WIN_A;
            if (handB == HandStatus.SCISSORS)
                ret = Result.WIN_A;
        }
        
        if (handA == HandStatus.PAPER){
            if (handB == HandStatus.PAPER)
                ret = Result.DRAW;
            if (handB == HandStatus.SCISSORS)
                ret = Result.WIN_B;
            if (handB == HandStatus.LIZARD)
                ret = Result.WIN_B;
            if (handB == HandStatus.ROCK)
                ret = Result.WIN_A;
            if (handB == HandStatus.SPOCK)
                ret = Result.WIN_A;
        }
        
        if (handA == HandStatus.SCISSORS){
            if (handB == HandStatus.SCISSORS)
                ret = Result.DRAW;
            if (handB == HandStatus.SPOCK)
                ret = Result.WIN_B;
            if (handB == HandStatus.ROCK)
                ret = Result.WIN_B;
            if (handB == HandStatus.LIZARD)
                ret = Result.WIN_A;
            if (handB == HandStatus.PAPER)
                ret = Result.WIN_A;
        }
        
        if (handA == HandStatus.LIZARD){
            if (handB == HandStatus.LIZARD)
                ret = Result.DRAW;
            if (handB == HandStatus.SCISSORS)
                ret = Result.WIN_B;
            if (handB == HandStatus.ROCK)
                ret = Result.WIN_B;
            if (handB == HandStatus.PAPER)
                ret = Result.WIN_A;
            if (handB == HandStatus.SPOCK)
                ret = Result.WIN_A;
        }
        
        if (handA == HandStatus.SPOCK){
            if (handB == HandStatus.SPOCK)
                ret = Result.DRAW;
            if (handB == HandStatus.PAPER)
                ret = Result.WIN_B;
            if (handB == HandStatus.LIZARD)
                ret = Result.WIN_B;
            if (handB == HandStatus.ROCK)
                ret = Result.WIN_A;
            if (handB == HandStatus.SCISSORS)
                ret = Result.WIN_A;
        }
        return ret;
    }
    
  
    //A PLAYER MAKES A PLAY, CHECKS IF 
    //error messages:
    // 0: no error / draw
    //-1: invalid player
    // playerID: winner
    public int makePlay(int userID, HandStatus hand){
        if (userID != whoPlays){
            return -1;
        }
        if (userID == userID_A){
            handA = hand;
        }else{
            handB = hand;
        }
        timesPlayed++;
        if ((timesPlayed % 2) == 0){
            Result play = check();
            if (play == Result.WIN_A)
                return userID_A;
            if (play == Result.WIN_B)
                return userID_B;
            if (play == Result.DRAW)
                return 0; 
        }else{
            whoPlays = userID_B;
            System.out.println("Game.makePlay: waiting for userB");
        }
            
        return 0;
    }
    
}
