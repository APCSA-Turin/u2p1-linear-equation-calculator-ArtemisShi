package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
private int x1;
private int x2;
private int y1;
private int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
int pH = coord1.indexOf("(");
int pH2 = coord1.indexOf(",");
x1= Integer.parseInt(coord1.substring(pH+1,pH2)); // puts all digits in between ( and , as x1
pH=pH2;
pH2= coord1.indexOf(")");
y1= Integer.parseInt(coord1.substring(pH+1,pH2));// puts all digits in between , and ) as y1

pH = coord2.indexOf("(");
pH2 = coord2.indexOf(",");
x2= Integer.parseInt(coord2.substring(pH+1,pH2));
pH=pH2;
pH2= coord2.indexOf(")");
y2= Integer.parseInt(coord2.substring(pH+1,pH2));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX1){x1=newX1;}
    public void setY1(int newY1){y1=newY1;}
    public void setX2(int newX2){x2=newX2;}
    public void setY2(int newY2){y2=newY2;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double dis=Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)); // distance formula = square root of (y1-y2)^2 plus (x1-x2)^2
        return roundedToHundredth(dis);
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
if(x1==x2){
    return -999.99; // we are only doing linear equations so if the two x values are the same then that means the line is vertical ie. undefined slope and no y intercept
}
        double yint =  (double)y1-(slope()*x1); // y=mx+b == y-mx=b == y(1or2)-(slope)x(1or2)=b(y int)

        return roundedToHundredth(yint);
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if(x1==x2){
            return -999.99;// we are only doing linear equations so if the two x values are the same then that means the line is vertical ie. undefined slope and no y intercept
        }
       double slope= ((double)(y1-y2)/(x1-x2)); // slope = y/x
        return roundedToHundredth(slope); // roundedToHundredth(slope)
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if(x1==x2){
            return "undefined";
        }
        if(yInt()==0.0){
            return "y="+slope()+"x";
        }
        if(slope()==0.0){
            return "y="+yInt();
        }
        if(yInt()<0){
            return "y="+slope()+"x"+yInt();
        }
        return "y="+slope()+"x+"+yInt(); // y=mx+b
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        x *=100; // ex: 123.32424*100 = 12332.424 : 754.345165*100 = 75434.5165
        if(x<0){
            x-=0.5; // for negatives
        }
if (x>=0){
        x +=0.5; //ex: 12332.424 +0.5 = 12332.924 : 75434.5165+0.5 = 75435.0165
}
        int xx = (int) x; //ex: 12332 : 75435
        x = (double)xx/100; //ex: 12332=12332.0/100= 123.32 : 75435=75435.0/100= 754.35
        return x;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")"; 
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " +yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}