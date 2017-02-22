package org.usfirst.frc.team178.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team178.robot.GripPipeline;
import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class VisionStreamer extends Subsystem {
	
	//actual values to be determined after final physical setup implemented
	private static final int IMG_HEIGHT = 800;
	private static final int IMG_WIDTH = 600;
	private VisionThread visionThread;
	private double[] centerX = {0.0, 0.0};
	private double[] centerY = {0.0, 0.0};
	private double[] rectWidth = {0.0, 0.0};
	private double[] rectHeight = {0.0, 0.0};
	
	private final Object imgLock = new Object();
	
	private AxisCamera camera;
	
	public VisionStreamer(String cameraName, String host) {
	    camera = new AxisCamera(cameraName, host);
	    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
	    
	    visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
        	//System.out.println("rectangle count: " + pipeline.filterContoursOutput().size());
	        if (pipeline.filterContoursOutput().size()>=2) {
	        	for (int i = 0; i < 2; i++) {
	            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(i));
	            synchronized (imgLock) {
	                centerX[i] = r.x + (r.width / 2);
	                centerY[i] = r.y + (r.height / 2);
	                rectWidth[i] = r.width;
	                rectHeight[i] = r.height;
	            	}
	        	}
	        }
	        else {
	        	centerX[0] = 1000; //out of range = 1000
	        	centerY[0] = 1000;
	        	centerX[1] = 1000;
	        	centerY[1] = 1000;
	        }
	    });
	    visionThread.start();
	}
	
	
	/*alternative to implementing a thread 
	 * public void processCurrentImage() {
		GripPipeline.process();
	}*/
	
	public double getBlendedCenterX(){
		return ((centerX[0]+centerX[1])/2);
	}
	public double getCenterXfromCameraCenterX(){
		return ((IMG_WIDTH/2) - getBlendedCenterX());
	}
	public double getBlendedCenterY(){
		return ((centerY[0]+centerY[1])/2);
	}
	public double getCenterYfromCameraCenterY(){
		return ((IMG_HEIGHT/2) - getBlendedCenterY());
	}
	public double getIMG_WIDTH(){
		return IMG_WIDTH;
	}
	public double getIMG_HEIGHT(){
		return IMG_HEIGHT;
	}
	public double getBoilerWidth(){
		return ((Math.abs(centerX[1]-centerX[0]))+(rectWidth[1]/2)+(rectWidth[0]/2));
	}
	public double getBoilerHeight(){
		return ((rectHeight[0]+rectHeight[1])/2);
	}
	public double getAirshipWidth(){
		return ((rectWidth[0]+rectWidth[1])/2);
	}
	public double getAirshipHeight(){
		return ((Math.abs(centerY[1]-centerY[0]))+(rectHeight[1]/2)+(rectHeight[0]/2));
	}
	
	
	    
	@Override
	protected void initDefaultCommand() {
		//TODO Auto-generated method stuff
	}
}

