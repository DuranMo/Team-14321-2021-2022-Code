package org.firstinspires.ftc.teamcode;

public class CarouselSpin {

    Hardware_Map CS;

    public CarouselSpin(Hardware_Map A){

        CS = A;

    }

    public void spin(double value){
        CS.spinnyThing.setPower(value);

    }

}
