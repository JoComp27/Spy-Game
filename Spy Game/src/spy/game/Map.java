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
    private Player player;
    private Guard[] guardList;
    
    public Map(int xMax, int yMax, char[][] map, char[][] map1){
        this.map = map;
        this.mapNoGuards = map1;
        this.xMax = xMax;
        this.yMax = yMax;
    }
    
    public Map(int xMax, int yMax, char[][] map, char[][] map1,int numOfGuards, Guard[] guardList, Player player){
        this.map = map;
        this.mapNoGuards = map1;
        this.xMax = xMax;
        this.yMax = yMax;
        this.numOfGuards = numOfGuards;
        this.guardList = guardList;
        this.player = player;
    }
    
    public void playerGoUp(){
        player.GoUp(this);
    }
    
    public void playerGoDown(){
        player.GoDown(this);
    }
    
    public void playerGoLeft(){
        player.GoLeft(this);
    }
    
    public void playerGoRight(){
        player.GoRight(this);
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
            for(int j = 0; j < yMax; j++){
                map[i][j] = mapNoGuards[i][j];
            }
        }
        
        for(int g = 0; g < numOfGuards; g++){    //Set guards
            if(mapNoGuards[guardList[g].getX()][guardList[g].getY()] == 'X'){
                System.out.println("Guard " + g + " is on a wall : Not Supposed to Happen");
            }
            else{
                map[guardList[g].getX()][guardList[g].getY()] = 'G';
            }
            
            if(guardList[g].getDirection()== Direction.LEFT){   //Sets Up vision of guards
                for(int i = 1; i <= guardList[g].getSightLength(); i++){
                    try{
                    if(map[guardList[g].getX()][guardList[g].getY()-i] == 'G' || map[guardList[g].getX()][guardList[g].getY()-i] == 'X' ){
                        break;
                    }
                    else{
                        map[guardList[g].getX()][guardList[g].getY()-i] = 'V';
                    }
                    }catch(ArrayIndexOutOfBoundsException ex){
                        break;
                    }
                }
            }
            
            else if(guardList[g].getDirection()== Direction.RIGHT){
                for(int i = 1; i <= guardList[g].getSightLength(); i++){
                    try{
                    if(map[guardList[g].getX()][guardList[g].getY()+i] == 'G' || map[guardList[g].getX()][guardList[g].getY()+i] == 'X' ){
                        break;
                    }
                    else{
                        map[guardList[g].getX()][guardList[g].getY()+i] = 'V';
                    }
                    }catch(ArrayIndexOutOfBoundsException ex){
                        break;
                    }
                }
            }
            
            else if(guardList[g].getDirection()== Direction.UP){
                for(int i = 1; i <= guardList[g].getSightLength(); i++){
                    try{
                    if(map[guardList[g].getX()-i][guardList[g].getY()] == 'G' || map[guardList[g].getX()-i][guardList[g].getY()] == 'X' ){
                        break;
                    }
                    else{
                        map[guardList[g].getX()-i][guardList[g].getY()] = 'V';
                    }
                    }catch(ArrayIndexOutOfBoundsException ex){
                        break;
                    }
                }
            }
            
            else {
                for(int i = 1; i <= guardList[g].getSightLength(); i++){
                    try{
                    if(map[guardList[g].getX()+i][guardList[g].getY()] == 'G' || map[guardList[g].getX()+i][guardList[g].getY()] == 'X' ){
                        break;
                    }
                    else{
                        map[guardList[g].getX()+i][guardList[g].getY()] = 'V';
                    }
                    }catch(ArrayIndexOutOfBoundsException ex){
                        break;
                    }
                }
            }
            
        }
        
        if(map[player.getX()][player.getY()] == 'X'){
            System.out.println("Player is currently in a wall!!");
        }
        else{
            map[player.getX()][player.getY()] = 'P';
        }
        
        
        for(int i = 0; i < yMax; i++){
            for(int j = 0; j < xMax; j++){
                System.out.print(map[j][i]);
            }
            System.out.println();
        }    
    }

    
}
