package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

@TeleOp

public class testtwo extends LinearOpMode{

    private DcMotor topRightMotor;
    private DcMotor topLeftMotor;
    private DcMotor bottomRightMotor;
    private DcMotor bottomLeftMotor;
    private Servo weirdArm;

    double horizontal;
    double vertical;

    double horizontalUsed;
    double verticalUsed;

    @Override

    public void runOpMode(){
        bottomRightMotor = hardwareMap.dcMotor.get("bottomrightmotor");
        bottomLeftMotor = hardwareMap.dcMotor.get("bottomleftmotor");
        topRightMotor = hardwareMap.dcMotor.get("toprightmotor");
        topLeftMotor = hardwareMap.dcMotor.get("topleftmotor");
        weirdArm = hardwareMap.servo.get("W_A");


        topRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        bottomRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        bottomLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        topRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        topLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bottomRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();


        while(opModeIsActive()){

            double robotSpin = Math.abs(gamepad1.right_stick_x);

            horizontal = -gamepad1.left_stick_x;
            vertical = gamepad1.left_stick_y;

            verticalUsed = vertical*Math.cos(-Math.PI/4) + horizontal*Math.sin(-Math.PI/4);
            horizontalUsed = horizontal*Math.cos(-Math.PI/4) - vertical*Math.sin(-Math.PI/4);


            bottomLeftMotor.setPower(verticalUsed);
            topRightMotor.setPower(verticalUsed);

            topLeftMotor.setPower(horizontalUsed);
            bottomRightMotor.setPower(horizontalUsed);

            if(gamepad1.right_stick_x >= 0.1){
                topRightMotor.setPower(-robotSpin);
                bottomRightMotor.setPower(-robotSpin);

                topLeftMotor.setPower(robotSpin);
                bottomLeftMotor.setPower(robotSpin);
            } else if(gamepad1.right_stick_x <= -0.1){
                topRightMotor.setPower(robotSpin);
                bottomRightMotor.setPower(robotSpin);

                topLeftMotor.setPower(-robotSpin);
                bottomLeftMotor.setPower(-robotSpin);
            }

            if(gamepad1.right_bumper){

                weirdArm.setPosition(1);

            }else if (gamepad1.left_bumper){

                weirdArm.setPosition(0);

            }
            telemetry.addData("robotSpin", "%.2f", robotSpin);
            telemetry.addData("horizontal", "%.2f", horizontalUsed);
            telemetry.addData("vertical", "%.2f", verticalUsed);


            }
        }

    }

