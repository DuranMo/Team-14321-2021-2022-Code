package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

@TeleOp(name = "14321 Teleop" , group = "Main")

public class driveRobot extends LinearOpMode{




    double horizontal;
    double vertical;
    double horizontalUsed;
    double verticalUsed;


    boolean maxJoe = true;
    boolean maxJoe1 = true;
    boolean maxJoe2 = true;
    boolean maxJoe3 = true;

    Servo leftClaw;
    Servo rightClaw;
    double clawHome = 0.0;
    double upperClaw = 0.5;
    double lowerClaw = -0.5;
    double clawPosition = clawHome;

    DcMotor clawMotor;
    double clawAscent = 1;
    double clawDescent = -1;




    @Override

    public void runOpMode(){

        Hardware_Map Hardware_Map = new Hardware_Map(hardwareMap);



        waitForStart();


        while(opModeIsActive()){



            if(gamepad2.left_bumper && maxJoe) {

                maxJoe = false;
                clawMotor.setPower(clawAscent);
                sleep(500);
                clawMotor.setPower(0);


            }
            if(gamepad2.right_bumper && maxJoe1){
                maxJoe1 = false;
                clawMotor.setPower(clawDescent);
                sleep(500);
                clawMotor.setPower(0);
            }

            if(gamepad2.a && maxJoe2){

                clawPosition += 0.01;
                Range.clip(clawPosition, lowerClaw, upperClaw);

                rightClaw.setPosition(clawPosition);
                leftClaw.setPosition(clawPosition);
            }else if(gamepad2.y && maxJoe2){

                clawPosition -= 0.01;
                Range.clip(clawPosition, lowerClaw, upperClaw);

                rightClaw.setPosition(clawPosition);
                leftClaw.setPosition(clawPosition);
            }

            double robotSpin = Math.abs(gamepad1.right_stick_x);

            if(gamepad1.right_stick_x >= 0.1){
                Hardware_Map.topRightMotor.setPower(-robotSpin);
                Hardware_Map.bottomRightMotor.setPower(-robotSpin);

                Hardware_Map.topLeftMotor.setPower(robotSpin);
                Hardware_Map.bottomLeftMotor.setPower(robotSpin);
            } else if(gamepad1.right_stick_x <= -0.1){
                Hardware_Map.topRightMotor.setPower(robotSpin);
                Hardware_Map.bottomRightMotor.setPower(robotSpin);

                Hardware_Map.topLeftMotor.setPower(-robotSpin);
                Hardware_Map.bottomLeftMotor.setPower(-robotSpin);
            } else {
                horizontal = -gamepad1.left_stick_x;
                vertical = gamepad1.left_stick_y;

                verticalUsed = vertical*Math.cos(-Math.PI/4) + horizontal*Math.sin(-Math.PI/4);
                horizontalUsed = horizontal*Math.cos(-Math.PI/4) - vertical*Math.sin(-Math.PI/4);


                Hardware_Map.bottomLeftMotor.setPower(verticalUsed);
                Hardware_Map.topRightMotor.setPower(verticalUsed);

                Hardware_Map.topLeftMotor.setPower(horizontalUsed);
                Hardware_Map.bottomRightMotor.setPower(horizontalUsed);
            }
            telemetry.addData("robotSpin", "%.2f", robotSpin);
            telemetry.addData("horizontal", "%.2f", horizontalUsed);
            telemetry.addData("vertical", "%.2f", verticalUsed);
        }

    }
}
