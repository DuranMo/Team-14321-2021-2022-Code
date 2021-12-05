package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Pipeline.AutomatonsPipeline;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name="AutonomousCode")
public class AutonomousRobot extends LinearOpMode{
    OpenCvCamera logitechCamera;
    AutomatonsPipeline pipeline;
    MecanumDrive MD;
    CarouselSpin Carousel;

    @Override
    public void runOpMode(){

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        logitechCamera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        logitechCamera.setPipeline(pipeline);

        Hardware_Map AT = new Hardware_Map(hardwareMap);

        MD = new MecanumDrive(AT);
        Carousel = new CarouselSpin(AT);



        waitForStart();

        while(opModeIsActive()){

            telemetry.addData("Position of Duck", pipeline.getDuckPosition());
            telemetry.update();

            int positionOfDuck = pipeline.getDuckPosition();

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
