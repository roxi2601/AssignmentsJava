package Assignment1master.model.Temperature;

import Assignment1master.model.radiator.Radiator;
import Assignment1master.model.thermometer.Thermometer;

public class Temperature
{
    private double temperature1;
    private double temperature2;
    private double time;


    public Temperature(Radiator radiator, double t1, double t2){

        Thermometer thermometer1 = new Thermometer(1,"t1",t1);
        Thermometer thermometer2 = new Thermometer(7,"t2",t2);
        temperature1 = thermometer1.temperature(t1,radiator.getPower(),1,0,1);
        temperature2 = thermometer2.temperature(t2,radiator.getPower(),7,0,1);
    }
    public void setTime(double time){this.time =time;}

    public double getTime(){return time;}
    public double getTemperature1(){return temperature1;}
    public double getTemperature2(){return temperature2;}

    public String toString(){return temperature1+"  "+temperature2;}

}

