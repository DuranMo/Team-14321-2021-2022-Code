package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="AutonomousCode")
public class AutonomousRobot extends LinearOpMode{



    @Override
    public void runOpMode() throws InterruptedException {

        MecanumDrive MD = new MecanumDrive();

        Hardware_Map.initDevices(hardwareMap);


        waitForStart(); {


        }
    }

}
