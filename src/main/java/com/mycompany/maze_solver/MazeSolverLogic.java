/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author aakash
 */
public class MazeSolverLogic extends JFrame{
    // 0-> from which we can traverse
    // 1-> obstacle
    // -1-> destination
    private int [][] maze = 
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,-1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
    };
    public List<Integer> path = new ArrayList<>();
    
    public MazeSolverLogic(){
        setTitle("Maze Solver");
        setSize(600,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze,1,1,path);
        setResizable(false);
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(80,80); // shifting of origin of grid
        for(int i= 0;i<maze.length;i++) {
            for(int j=0;j<maze[0].length;j++){
                Color color;
                switch(maze[i][j]){
                    case 1: color = Color.black;
                    break;
                    case -1: color = Color.red;
                    break;
                    default: color = Color.white;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.red);
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i = 0;i<path.size();i = i+2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);
            g.setColor(Color.ORANGE);
            g.fillRect(30*pathx,30*pathy,29,29);
            
        }
    }
    public static void main(String[] args) {
        MazeSolverLogic view = new MazeSolverLogic();
        view.setVisible(true);
    }
}
