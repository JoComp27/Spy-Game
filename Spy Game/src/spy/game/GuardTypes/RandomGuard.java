/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy.game.GuardTypes;

import spy.game.Direction;
import spy.game.Guard;
import spy.game.Map;
import java.util.Random;

/**
 *
 * @author Administrateur
 */
public class RandomGuard extends Guard{

    
    public RandomGuard(int x, int y, Direction direction, int sightLength){
        this.position[0] = x;
        this.position[1] = y;
        this.direction = direction;
        this.sightLength = sightLength;
        
    }
    
    @Override
    public void getBehavior(Map map) {
        int[] nextPosition = new int[2];
        boolean[] possiblePositions = new boolean[4]; // Works Counter-Clockwise
        
        if(position[0]+1 == map.getXMax()){
            possiblePositions[0] = false;
        }
        else if(map.getMap()[this.position[0]+1][this.position[1]] == 'X'){ //Checks if -> is a wall or not
            possiblePositions[0] = false;
        }
        else{
            possiblePositions[0] = true;
        }
        
        if(position[1] == 0){
            possiblePositions[1] = false;
        }
        else if(map.getMap()[this.position[0]][this.position[1]-1] == 'X'){//Checks if ^ is a wall or not
            possiblePositions[1] = false;
        }
        else{
            possiblePositions[1] = true;
        }
     
        if(position[0] == 0){
            possiblePositions[0] = false;
        }
        else if(map.getMap()[this.position[0]-1][this.position[1]] == 'X'){//Checks if ^ is a wall or not
            possiblePositions[1] = false;
        }
        else{
            possiblePositions[1] = true;
        }
        
        if(position[1]+1 == map.getYMax()){
            possiblePositions[1] = false;
        }
        else if(map.getMap()[this.position[0]][this.position[1]+1] == 'X'){//Checks if ^ is a wall or not
            possiblePositions[1] = false;
        }
        else{
            possiblePositions[1] = true;
        }
        
        int numberOfDirections = 0;
        
        for(int i = 0; i < 4; i++){//Checks how many are walls and not walls
            if(possiblePositions[i]){
                numberOfDirections++;
            }
        }
        
        Random rand = new Random();
        
        int direction = rand.nextInt(numberOfDirections); //Finds a random number according to the number of available moves
        
        if(direction == 0){//First available move chosen
            if(possiblePositions[0]){
                nextPosition[0] = position[0]+1;
                nextPosition[1] = position[1];
                this.direction = Direction.RIGHT;
            }
            else if(possiblePositions[1]){
                nextPosition[0] = position[0];
                nextPosition[1] = position[1]-1;
                this.direction = Direction.UP;
            }
            else if(possiblePositions[2]){
                nextPosition[0] = position[0]-1;
                nextPosition[1] = position[1];
                this.direction = Direction.LEFT;
            }
            else{
                nextPosition[0] = position[0];
                nextPosition[1] = position[1]+1;
                this.direction = Direction.DOWN;
            }

        }
        else if(direction == 1){//Second available move chosen
            int counter = 0;
            if(possiblePositions[0]){
                counter++;
            }
           if(possiblePositions[1]){
               if(counter == 1){
               nextPosition[0] = position[0];
                nextPosition[1] = position[1]-1;
                this.direction = Direction.UP;
               }
               counter++;
           }
           if(possiblePositions[2] && counter != 2){
               if(counter == 1){
               nextPosition[0] = position[0]-1;
                nextPosition[1] = position[1];
                this.direction = Direction.LEFT;
               }
               counter++;
           }
           if(possiblePositions[3] && counter != 2){
               nextPosition[0] = position[0];
                nextPosition[1] = position[1]+1;
                this.direction = Direction.DOWN;
           }
        }
        else if(direction == 2){//Third available move chosen
            if(!possiblePositions[0]){
                nextPosition[0] = position[0]-1;
                nextPosition[1] = position[1];
                this.direction = Direction.LEFT;
            }
            else if(!possiblePositions[1]){
                nextPosition[0] = position[0]-1;
                nextPosition[1] = position[1];
                this.direction = Direction.LEFT;
            }
            else if(!possiblePositions[2]){
                nextPosition[0] = position[0]-1;
                nextPosition[1] = position[1];
                this.direction = Direction.LEFT;
            }
            else{
                nextPosition[0] = position[0];
            nextPosition[1] = position[1]+1;
            this.direction = Direction.DOWN;
            }
        }
        else{//Last available move chosen
            nextPosition[0] = position[0];
            nextPosition[1] = position[1]+1;
            this.direction = Direction.DOWN;
        }
        
        this.position = nextPosition;
        
    }
    
}
