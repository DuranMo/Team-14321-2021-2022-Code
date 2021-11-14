package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;

import static org.firstinspires.ftc.teamcode.Hardware_Map.bottomLeftMotor;
import static org.firstinspires.ftc.teamcode.Hardware_Map.bottomRightMotor;
import static org.firstinspires.ftc.teamcode.Hardware_Map.topLeftMotor;
import static org.firstinspires.ftc.teamcode.Hardware_Map.topRightMotor;

public class MecanumDrive{

    static final double MOTOR_TICK_COUNTS = 537.7;
    static final double TICKS_PER_INCH = MOTOR_TICK_COUNTS/12.3622;

    public void driverEncoders(double specifyPower, double specifyDistance) throws InterruptedException {
        double distanceToTravel = TICKS_PER_INCH * specifyDistance;
        double wantedEncoderPosition = topLeftMotor.getCurrentPosition() + distanceToTravel;


        if(specifyPower>0){
            topLeftMotor.setPower(specifyPower);
            bottomLeftMotor.setPower(specifyPower);
            topRightMotor.setPower(specifyPower);
            bottomRightMotor.setPower(specifyPower);

            while(topLeftMotor.getCurrentPosition() < wantedEncoderPosition){

            }

        } else{
            topLeftMotor.setPower(-specifyPower);
            bottomLeftMotor.setPower(-specifyPower);
            topRightMotor.setPower(-specifyPower);
            bottomRightMotor.setPower(-specifyPower);

            while(topLeftMotor.getCurrentPosition() > wantedEncoderPosition){

            }


        }

    }

    public void StrafingEncoders(double specifyPower, double specifyDistance) throws InterruptedException {
        double distanceToTravel = TICKS_PER_INCH * specifyDistance;
        double wantedEncoderPosition = topLeftMotor.getCurrentPosition() + distanceToTravel;


        if(specifyPower>0){
            topLeftMotor.setPower(specifyPower);
            bottomLeftMotor.setPower(-specifyPower);
            topRightMotor.setPower(-specifyPower);
            bottomRightMotor.setPower(specifyPower);

            while(topLeftMotor.getCurrentPosition() < wantedEncoderPosition){

            }

        } else{
            topLeftMotor.setPower(specifyPower);
            bottomLeftMotor.setPower(-specifyPower);
            topRightMotor.setPower(-specifyPower);
            bottomRightMotor.setPower(specifyPower);

            while(topLeftMotor.getCurrentPosition() > wantedEncoderPosition){

            }


        }

    }

    public void rotateEncoders(double specifyPower, double specifyDistance) throws InterruptedException {
        double distanceNeededToTravel = TICKS_PER_INCH * specifyDistance;
        double encoderPositionWanted = topLeftMotor.getCurrentPosition() + distanceNeededToTravel;

        if(specifyPower>0){
            topLeftMotor.setPower(specifyPower);
            topRightMotor.setPower(-specifyPower);
            bottomRightMotor.setPower(-specifyPower);
            bottomLeftMotor.setPower(specifyPower);

            while(topLeftMotor.getCurrentPosition()>encoderPositionWanted){

            }
        }
        else{
            topLeftMotor.setPower(specifyPower);
            topRightMotor.setPower(-specifyPower);
            bottomRightMotor.setPower(-specifyPower);
            bottomLeftMotor.setPower(specifyPower);

            while(topLeftMotor.getCurrentPosition()>encoderPositionWanted){

            }
        }
    }





}
