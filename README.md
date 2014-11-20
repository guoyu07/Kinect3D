Kinect3D
========

use KinectOrbit + SimpleOpenNI1.96 + Processing 2.21 to show kinect space

environment: win7 64bit, Kinect SDK 1.8(Kinect for Windows drivers v1.8)

the SimpleOpenNI.java in source has rewritten method **getLibraryPathWin()**.

the default processing libraries directory is 
```java
System.getProperty("user.home") + "/Documents/Processing/libraries"
```
or you can use jvm parameter **-Dprocessing.libraries="your libraries directory"**  to override the default path. 
