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
	private static final int IMG_WIDTH = 800;
	private static final int IMG_HEIGHT = 600;
	private VisionThread visionThread;
	private double centerX = 0.0;
	private double centerY = 0.0;
	
	private final Object imgLock = new Object();
	
	private AxisCamera camera;
	
	public VisionStreamer(String cameraName, String host) {
	    camera = new AxisCamera(cameraName, host);
	    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
	    
	    visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
	        if (pipeline.filterContoursOutput().size() == 2) {
	            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
	            synchronized (imgLock) {
	                centerX = r.x + (r.width / 2);
	                centerY = r.y + (r.height / 2);
	            }
	        }
	    });
	    visionThread.start();
	}
	
	
	/*alternative to implementing a thread 
	 * public void processCurrentImage() {
		GripPipeline.process();
	}*/
	
	public double getTapeCenterX(){
		return centerX;
	}
	public double getCenterXfromCameraCenterX(){
		return ((IMG_WIDTH/2)-centerX);
	}
	public double getTapeCenterY(){
		return centerY;
	}
	public double getCenterYfromCameraCenterY(){
		return ((IMG_HEIGHT/2)-centerY);
	}
	public double getIMG_WIDTH(){
		return IMG_WIDTH;
	}
	public double getIMG_HEIGHT(){
		return IMG_HEIGHT;
	}
	
	
	    
	@Override
	protected void initDefaultCommand() {
		//TODO Auto-generated method stuff
	}
}