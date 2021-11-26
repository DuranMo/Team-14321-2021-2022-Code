package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;

@Autonomous(name="AutonomousCode")
public class AutonomousRobot extends LinearOpMode{
    OpenCvCamera logitechCamera;
    AutomatonsPipeline pipeline;

    @Override
    public void runOpMode(){

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        logitechCamera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        logitechCamera.setPipeline(pipeline);

        MecanumDrive MD = new MecanumDrive();

        Hardware_Map AT = new Hardware_Map();




        waitForStart();

        while(opModeIsActive()){

            telemetry.addData("Position of Duck", pipeline.getDuckPosition());
            telemetry.update();

            int positionOfDuck = pipeline.duckPosition;

            switch(positionOfDuck){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }



        }
    }

}
