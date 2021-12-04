package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware_Map {

    public DcMotor topRightMotor;
    public DcMotor topLeftMotor;
    public DcMotor bottomRightMotor;
    public DcMotor bottomLeftMotor;
    public Servo spinnyThing;

    private HardwareMap hardwareMap = null;
    public ElapsedTime runTime = new ElapsedTime();

public Hardware_Map (HardwareMap HARDWARE_MAP){

    hardwareMap = HARDWARE_MAP;

    topLeftMotor = hardwareMap.get(DcMotor.class, "topLeftMotor");
    topRightMotor = hardwareMap.get(DcMotor.class, "topRightMotor");
    bottomLeftMotor = hardwareMap.get(DcMotor.class, "bottomLeftMotor");
    bottomLeftMotor = hardwareMap.get(DcMotor.class, "bottomRightMotor");

    spinnyThing = hardwareMap.get(Servo.class, "spinnyThing");

    topRightMotor.setDirection(DcMotor.Direction.REVERSE);
    bottomRightMotor.setDirection(DcMotor.Direction.REVERSE);

    topLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    topRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    bottomLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    bottomRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    topLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    topRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    bottomLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    bottomRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    topLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    topRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    bottomLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    bottomRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    topRightMotor.setPower(0);
    topLeftMotor.setPower(0);
    bottomRightMotor.setPower(0);
    bottomLeftMotor.setPower(0);
}




}
