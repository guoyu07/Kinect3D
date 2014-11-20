Kinect3D
========

Use KinectOrbit + SimpleOpenNI1.96 + Processing 2.21 to show kinect space.

Environment: win7 64bit, Kinect SDK 1.8(Kinect for Windows drivers v1.8)

The SimpleOpenNI.java in source has rewritten method **getLibraryPathWin()**.

The default processing libraries directory is 
```java
System.getProperty("user.home") + "/Documents/Processing/libraries"
```
or you can use jvm parameter **-Dprocessing.libraries="your libraries directory"**  to override the default path. 
