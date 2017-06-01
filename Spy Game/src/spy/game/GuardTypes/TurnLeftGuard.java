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
public class TurnLeftGuard extends Guard{
    
    public TurnLeftGuard(int x, int y, Direction direction, int sightLenght){
        this.position[1] = x;
        this.position[0] = y;
        this.direction = direction;
        this.sightLength = sightLenght;
        
    }
    
    public int getNumber(){
        return 1;
    }
    
    @Override
    public void getBehavior(Map map) {
          if(this.direction == Direction.DOWN){
        if(map.getMap()[position[1]+1][position[0]] == 'X'){
        position[0] += 1;
    }
        else{
            position[1] += 1;
            this.direction = Direction.RIGHT;
        }
        }
        else if(this.direction == Direction.LEFT){
            if(map.getMap()[position[1]][position[0]+1] == 'X'){
        position[1] -= 1;
    }
        else{
            position[0] += 1;
            this.direction = Direction.DOWN;
        }
        }
        else if(this.direction == Direction.UP){
            if(map.getMap()[position[1]-1][position[0]] == 'X'){
        position[0] -= 1;
    }
        else{
            position[1] -= 1;
            this.direction = Direction.LEFT;
        }
        }
        else{
            if(map.getMap()[position[1]][position[0]-1] == 'X'){
        position[1] += 1;
    }
        else{
            position[0] -= 1;
            this.direction = Direction.UP;
        }
        }
    }
    }
    

