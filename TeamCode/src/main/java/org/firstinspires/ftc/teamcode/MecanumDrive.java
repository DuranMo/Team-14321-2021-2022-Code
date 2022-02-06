package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class MecanumDrive{

    static final double MOTOR_TICK_COUNTS = 537.7;
    static final double TICKS_PER_INCH = MOTOR_TICK_COUNTS/12.3622;
    Hardware_Map MDM;

    public MecanumDrive(Hardware_Map A){

        MDM = A;
    }




    public void driverEncoders(double specifyPower, double specifyDistance) {
            double distanceToTravel = TICKS_PER_INCH * specifyDistance;
            double wantedEncoderPosition = MDM.topLeftMotor.getCurrentPosition() + distanceToTravel;


            if(specifyPower>0){
                MDM.topLeftMotor.setPower(specifyPower);
                MDM.bottomLeftMotor.setPower(specifyPower);
                MDM.topRightMotor.setPower(specifyPower);
                MDM.bottomRightMotor.setPower(specifyPower);

                while(MDM.topLeftMotor.getCurrentPosition() < wantedEncoderPosition){

                }

            } else{
                MDM.topLeftMotor.setPower(-specifyPower);
                MDM.bottomLeftMotor.setPower(-specifyPower);
                MDM.topRightMotor.setPower(-specifyPower);
                MDM.bottomRightMotor.setPower(-specifyPower);

                while(MDM.topLeftMotor.getCurrentPosition() > wantedEncoderPosition){

                }


            }

        }

        public void StrafingEncoders(double specifyPower, double specifyDistance){
            double distanceToTravel = TICKS_PER_INCH * specifyDistance;
            double wantedEncoderPosition = MDM.topLeftMotor.getCurrentPosition() + distanceToTravel;


            if(specifyPower>0){
                MDM.topLeftMotor.setPower(specifyPower);
                MDM.bottomLeftMotor.setPower(-specifyPower);
                MDM.topRightMotor.setPower(-specifyPower);
                MDM.bottomRightMotor.setPower(specifyPower);

                while(MDM.topLeftMotor.getCurrentPosition() < wantedEncoderPosition){

                }

            } else{
                MDM.topLeftMotor.setPower(specifyPower);
                MDM.bottomLeftMotor.setPower(-specifyPower);
                MDM.topRightMotor.setPower(-specifyPower);
                MDM.bottomRightMotor.setPower(specifyPower);

                while(MDM.topLeftMotor.getCurrentPosition() > wantedEncoderPosition){

                }


            }

        }

        public void rotateEncoders(double specifyPower, double specifyDistance){
            double distanceNeededToTravel = TICKS_PER_INCH * specifyDistance;
            double encoderPositionWanted = MDM.topLeftMotor.getCurrentPosition() + distanceNeededToTravel;

            if(specifyPower>0){
                MDM.topLeftMotor.setPower(specifyPower);
                MDM.topRightMotor.setPower(-specifyPower);
                MDM.bottomRightMotor.setPower(-specifyPower);
                MDM.bottomLeftMotor.setPower(specifyPower);

                while(MDM.topLeftMotor.getCurrentPosition()>encoderPositionWanted){

                }
            }
            else{
                MDM.topLeftMotor.setPower(specifyPower);
                MDM.topRightMotor.setPower(-specifyPower);
                MDM.bottomRightMotor.setPower(-specifyPower);
                MDM.bottomLeftMotor.setPower(specifyPower);

                while(MDM.topLeftMotor.getCurrentPosition()>encoderPositionWanted){

                }
            }


    }







}
