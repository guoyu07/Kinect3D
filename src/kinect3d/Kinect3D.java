package kinect3d;

import java.net.URL;

import kinectOrbit.KinectOrbit;
import processing.core.PApplet;
import processing.core.PVector;
import SimpleOpenNI.SimpleOpenNI;

public class Kinect3D extends PApplet {

	private static final long serialVersionUID = 5321512969228252138L;

	KinectOrbit myOrbit;
	SimpleOpenNI kinect;
	
	
	public void setup() {
		size(800, 600, OPENGL);
		myOrbit = new KinectOrbit(this, 0);
		kinect = new SimpleOpenNI(this);
		//启用深度图
		kinect.enableDepth();
	}

	public void draw() {
		kinect.update();
		background(0);
		
		myOrbit.pushOrbit(this);
		drawPointCloud();
		//绘制Kinect摄像机和视锥
		kinect.drawCamFrustum();
		
		myOrbit.popOrbit(this);
	}
	
	private void drawPointCloud(){
		//绘制深度图的3D点
		int[] depthMap = kinect.depthMap();
		int steps = 2;//为了加快绘图速度，以三点为间隔
		int index;
		
		PVector realWorldPoint;
		stroke(255);
		for(int y = 0; y < kinect.depthHeight(); y += steps){
			for(int x = 0; x < kinect.depthWidth(); x += steps){
				stroke(kinect.depthImage().get(x, y));
				
				index = x + y * kinect.depthWidth();
				if(depthMap[index] > 0){
					realWorldPoint = kinect.depthMapRealWorld()[index];
					point(realWorldPoint.x, realWorldPoint.y, realWorldPoint.z);
				}
			}
		}
	}
}
