/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy.game.Maps;

import spy.game.Direction;
import spy.game.Guard;
import spy.game.GuardTypes.HorizontalGuard;
import spy.game.GuardTypes.TurnLeftGuard;
import spy.game.GuardTypes.TurnRightGuard;
import spy.game.GuardTypes.VerticalGuard;
import spy.game.Map;
import spy.game.Player;

/**
 *
 * @author Administrateur
 */
public class Map1{

    Map map;
    
    public Map1() {
        int x = 10;
        int y = 10;
        char[][] a = new char[y][x];
        char[][] b = new char[y][x];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(j == 0 || j == 9 || i == 0 || i == 9){
                    a[i][j] = 'X';
                    b[i][j] = 'X';
                }
                else{
                    a[i][j] = ' ';
                    b[i][j] = ' ';
                }
            }
        }
        
        int numOfGuards = 4;
        
       Guard[] guardArray = new Guard[numOfGuards];
       guardArray[0] = new VerticalGuard(2, 2, Direction.DOWN,2);
       guardArray[1] = new HorizontalGuard(3,3,Direction.RIGHT,2);
       guardArray[2] = new TurnRightGuard(4, 4, Direction.RIGHT, 2);
       guardArray[3] = new TurnLeftGuard(6,6,Direction.LEFT, 2);

       int[] p = new int[2];
       p[0] = 7;
       p[1] = 7;
       
       Player player = new Player(p) ;
       
        this.map = new Map(x, y, a, b, numOfGuards, guardArray, player);
    }
    
    public Map getMap(){
        return map;
    }

    
}
