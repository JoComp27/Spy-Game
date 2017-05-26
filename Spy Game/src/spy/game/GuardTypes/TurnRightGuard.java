/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy.game.GuardTypes;

import spy.game.Direction;
import spy.game.Guard;
import spy.game.Map;

/**
 *
 * @author Administrateur
 */
public class TurnRightGuard extends Guard{

    public TurnRightGuard(int x, int y, Direction direction, int sightLenght){
        this.position[0] = x;
        this.position[1] = y;
        this.direction = direction;
        this.sightLength = sightLenght;
        
    }
    
    @Override
    public void getBehavior(Map map) {//Caution *** Inherant problem with AI : will get stuck in corners ***
 //If character isnt on a corner
        if(this.direction == Direction.DOWN){
        if(map.getMap()[position[0]-1][position[1]] == 'X'){
        position[1] += 1;
    }
        else{
            position[0] -= 1;
            this.direction = Direction.LEFT;
        }
        }
        else if(this.direction == Direction.LEFT){
            if(map.getMap()[position[0]][position[1]-1] == 'X'){
        position[0] -= 1;
    }
        else{
            position[1] -= 1;
            this.direction = Direction.UP;
        }
        }
        else if(this.direction == Direction.UP){
            if(map.getMap()[position[0]+1][position[1]] == 'X'){
        position[1] += 1;
    }
        else{
            position[0] += 1;
            this.direction = Direction.RIGHT;
        }
        }
        else{
            if(map.getMap()[position[0]][position[1]+1] == 'X'){
        position[0] += 1;
    }
        else{
            position[1] += 1;
            this.direction = Direction.DOWN;
        }
        }
    }
    
}
