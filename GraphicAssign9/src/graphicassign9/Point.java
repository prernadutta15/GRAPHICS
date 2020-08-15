/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicassign9;

/**
 *
 * @author Prerna Dutta
 */
public class Point {
    float x;
    float y;
    int[] bitcode=new int[4];
    Point(){}
    Point(float x,float y){
        this.x=x;
        this.y=y;
    }
    public void assignbitcode(Point min,Point max){
       if(y>max.y)
           bitcode[0]=1;
       else
           bitcode[0]=0;
       if(y<min.y)
           bitcode[1]=1;
       else
           bitcode[1]=0;
       if(x<min.x)
           bitcode[2]=1;
       else
           bitcode[2]=0;
       if(x>max.x)
           bitcode[3]=1;
       else
           bitcode[3]=0;
    }
    public void clip(float m,float c,int option,Point min,Point max){
       switch(option){
           case 1:
               x=(max.y-c)/m;
               y=max.y;
               this.assignbitcode(min, max);
               break;
           case 2:
               x=(min.y-c)/m;
               y=min.y;
               this.assignbitcode(min, max);
               break;
           case 3:
               y=m*min.x+c;
               x=min.x;
               this.assignbitcode(min, max);
               break;
           case 4:
               y=m*max.x+c;
               x=max.x;
               this.assignbitcode(min, max);
               break;
       }
    }
    public boolean checkZero(){
        if(bitcode[0]==0&&bitcode[1]==0&&bitcode[2]==0&&bitcode[3]==0)
            return true;
        return false;
    }
    public static boolean TrivialRejection(Point p,Point q){
        for(int i=0;i<4;i++){
            if(p.bitcode[i]==1&&q.bitcode[i]==1)
                return true;
        }
        return false;
    }
    public static boolean TrivialAcceptance(Point p,Point q){
        for(int i=0;i<4;i++){
            if(p.bitcode[i]==0&&q.bitcode[i]==0)
                continue;
            else
                return false;
        }
        return true;
    }
}
