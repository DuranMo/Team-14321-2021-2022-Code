package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;
import java.util.List;

public class AutomatonsPipeline extends OpenCvPipeline {

    Mat HSVMat = new Mat(); // Matrix used to convert pixel RGB values to HSV values
    Mat contoursOnFrameMat = new Mat();

    List<MatOfPoint> contoursList = new ArrayList<>();

    int numContours = 0;

    public Scalar lowerHSV = new Scalar(19, 89, 172); // lower duck color
    public Scalar upperHSV = new Scalar(59, 250, 250); // higher duck color
    // change these based on lighting; make more lenient during competition because of random lighting

    public double threshold = 100; // y axis pixel line (where we stop looking above)

    public double blurConstant = 1; // determines how blurry the image will become (kernel size)
    // change if noise (image flickering) hurts data

    public double dilationConstant = 2; //scaling up the pixels to make them more detectable

    int duckPosition = 0; // position of duck that will be utilized later for autonomous

    Telemetry telemetryOpenCV = null;

    public AutomatonsPipeline(Telemetry opModeTelemetry){

        telemetryOpenCV = opModeTelemetry;

    }

    public int getDuckPosition(){
        return duckPosition;
    }

    @Override

    public Mat processFrame(Mat input){

        contoursList.clear();
        Imgproc.cvtColor(input, HSVMat, Imgproc.COLOR_RGB2HSV_FULL); // converts it from RGB to HSV


        Core.inRange(HSVMat, lowerHSV, upperHSV, HSVMat); // Filters out all the colors that we do not want, and finally goes back to the HSVMat

        Size kernelSize = new Size(blurConstant, blurConstant);

        Imgproc.GaussianBlur(HSVMat, HSVMat, kernelSize, 0); // Gets rid of the grain and also blurs the image

        Size kernelSize2 = new Size(2 * dilationConstant + 1, 2 * dilationConstant + 1);

        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, kernelSize2);

        Imgproc.dilate(HSVMat, HSVMat, kernel);

        Imgproc.findContours(HSVMat,  contoursList, new Mat(), Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
        // finds contours in HSVMat and puts them onto a list

        numContours = contoursList.size();

        input.copyTo(contoursOnFrameMat); // input and contoursOnFrameMat become identical

        for(MatOfPoint contour : contoursList){

            Rect rect = Imgproc.boundingRect(contour);

            if(rect.y >= threshold){
                Imgproc.rectangle(contoursOnFrameMat, rect.tl(), rect.br(), new Scalar (255, 0, 0), 2);
                Imgproc.putText(contoursOnFrameMat, String.valueOf(rect.x), rect.tl(), 0, 0.5, new Scalar (255, 255, 255));

                if(rect.x >= 150){

                    duckPosition = 2;

                }else if(rect.x <= 75){

                    duckPosition = 0;

                }else if(rect.x < 150 && rect.x > 75){

                    duckPosition = 1;

                }
            }

        }

        return input; // returns new HSV input image
    }

}
