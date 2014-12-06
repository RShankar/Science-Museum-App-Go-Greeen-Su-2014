/**
*  Collects data from the accelerometer and saves a tsv file
*  to external storage on the device.  REQUIRES PERMISSION:
*  WRITE_EXTERNAL_STORAGE. @See Android->Sketch Permissions
*
*  Author: Victor E. Gallego
*  Florida Atlantic University
**/

import ketai.sensors.*;
import android.os.Environment;
          
PVector accelerometer;
Table tsv;
int counter;

void setup(){
  // get the accelerometer sensor
  KetaiSensor sensor;
  sensor = new KetaiSensor(this);
  sensor.start();
  
  // create a vector to store x, y, z values
  accelerometer = new PVector();
  
  // set the app orientation
  orientation(PORTRAIT);
  // place the text in the center
  textAlign(CENTER, CENTER);
  textSize(32);
  
  // make a new table
  tsv = new Table();
  // make the header columns for the table
  tsv.addColumn("counter");
  tsv.addColumn("x");
  tsv.addColumn("y");
  tsv.addColumn("z");
  
  // files are saved here
  println(Environment.getExternalStorageDirectory()
            .getAbsolutePath());
     
}


/** The draw loop happens 60 times per second **/
void draw(){
  
  // background color corresponds to the color TRUE BLUE
  background(0, 52, 102);
  
  // increment the counter
  counter++;
  
  // show accelerometer values on screen
  showAccelerometerValues(accelerometer.x,
                            accelerometer.y,
                              accelerometer.z);
  
  // add the accelerometer values to the table
  TableRow row  = tsv.addRow();
  row.setInt("counter", counter);
  row.setFloat("x", accelerometer.x);
  row.setFloat("y", accelerometer.y);
  row.setFloat("z", accelerometer.z);
    
    
}

/**  Shows the values of the acceleromter on the screen
*    params:
*    x - accelerometer x value
*    y - accelerometer y value
*    z - accelerometer z value
**/
void showAccelerometerValues(float x,float y,float z){

  text("Accelerometer: \n"+
        "x: "+ nfp(x, 2, 3)+"\n"+
        "y: "+ nfp(y, 2, 3)+"\n"+
        "z: "+ nfp(z, 2, 3)+"\n",
        20, 0, width, height);
}

/** 
*  This event happens when the menu button is pressed
**/
void keyPressed(){
  
  saveFile("my_acc_data", tsv);
  
  exit();
}

/**
*  Saves a file to external storage in 
*  tsv (tab separated values) format
*  params:
*  name - name of the file
*  table - the table to save
**/
void saveFile(String name, Table table){
  
  String directory;
  
  try{
    
    directory = new String(Environment
           .getExternalStorageDirectory()
            .getAbsolutePath());
    table.save(new File(directory+"/"+name+".tsv"), "tsv");
    
    println("File write successful");
    
  }catch(IOException iox){
    println("Failed to write file: "+iox.getMessage());
  } 
}

/** 
*  The accelerometer event happens the values in the
*  hardware change, may update faster than draw loop
**/
void onAccelerometerEvent(float x, float y, float z){

  accelerometer.set(x,y,z);
}
