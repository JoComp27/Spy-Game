/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy.game;

/**
 *
 * @author Administrateur
 */
public class Map {
    private int xMax;
    private int yMax;
    private char[][] map;
    private char[][] mapNoGuards;
    private int numOfGuards;
    Guard[] guardList;
    
    public Map(int xMax, int yMax, char[][] map){
        this.map = map;
        this.mapNoGuards = map;
        this.xMax = xMax;
        this.yMax = yMax;
    }
    
    public Map(int xMax, int yMax, char[][] map, int numOfGuards, Guard[] guardList){
        this.map = map;
        this.mapNoGuards = map;
        this.xMax = xMax;
        this.yMax = yMax;
        this.numOfGuards = numOfGuards;
        this.guardList = guardList;
    }
    
    public Guard[] getGuardList(){
        return guardList;
    }
    
    public int getNumOfGuards(){
        return numOfGuards;
    }
    
    public int getXMax(){
        return xMax;
    }
    
    public int getYMax(){
        return yMax;
    }
    
    public void setMap(char[][] map){
        this.map = map;
    }
    
    public char[][] getMap(){
        return this.map;
    }
    
    public void RenderMap(){
        
        for(int i = 0; i < xMax;  i++){                     //Reinitialisation of the map
            for(int j = 0; i < yMax; j++){
                map[i][j] = mapNoGuards[i][j];
            }
        }
        
        for(int g = 0; g < numOfGuards; g++){    //Set guards
            if(mapNoGuards[guardList[g].getX()][guardList[g].getY()] == 'X'){
                System.out.println("Guard " + g + " is on a wall");
            }
            else{
                map[guardList[g].getX()][guardList[g].getY()] = 'G';
            }
            
            if(guardList[g].getDirection()== Direction.LEFT){   //Sets Up vision of guards
                for(int i = 1; i <= guardList[g].getSightLength(); i++){
                    if(map[guardList[g].getX()-i][guardList[g].getY()] == 'G' || map[guardList[g].getX()-i][guardList[g].getY()] == 'X' ){
                        break;
                    }
                    else{
                        map[guardList[g].getX()-i][guardList[g].getY()] = 'V';
                    }
                }
            }
            
            else if(guardList[g].getDirection()== Direction.RIGHT){
                for(int i = 1; i <= guardList[g].getSightLength(); i++){
                    if(map[guardList[g].getX()+i][guardList[g].getY()] == 'G' || map[guardList[g].getX()+i][guardList[g].getY()] == 'X' ){
                        break;
                    }
                    else{
                        map[guardList[g].getX()+i][guardList[g].getY()] = 'V';
                    }
                }
            }
            
            else if(guardList[g].getDirection()== Direction.UP){
                for(int i = 1; i <= guardList[g].getSightLength(); i++){
                    if(map[guardList[g].getX()][guardList[g].getY()-i] == 'G' || map[guardList[g].getX()][guardList[g].getY()-i] == 'X' ){
                        break;
                    }
                    else{
                        map[guardList[g].getX()][guardList[g].getY()-i] = 'V';
                    }
                }
            }
            
            else {
                for(int i = 1; i <= guardList[g].getSightLength(); i++){
                    if(map[guardList[g].getX()][guardList[g].getY()+i] == 'G' || map[guardList[g].getX()][guardList[g].getY()+i] == 'X' ){
                        break;
                    }
                    else{
                        map[guardList[g].getX()][guardList[g].getY()+i] = 'V';
                    }
                }
            }
            
        }
        
        
        for(int i = 0; i < xMax; i++){
            for(int j = 0; j < yMax; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }    
    }

    
}
