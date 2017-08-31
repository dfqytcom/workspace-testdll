package com.utry.javaCallDLL;
import java.io.File;
import java.io.IOException;

public class AlgorithmDLL {
	
	
	static
	{
		System.loadLibrary("test-lib0");
	}
	
	public native float[] DPM(String testImagePath,String modelPath);
	public native int   DPMbool(String testImagePath,String modelPath);
	 
	public static void main(String[] args) throws Exception {
		AlgorithmDLL ad = new AlgorithmDLL();
		
		String modelPath="person_final.txt";
		//String jpgPath="01.jpg";
		float resultAll[]=new float[7];
		int resultAllbool=0;
		
        File file = new File("\\temp-\\");
        File [] files = file.listFiles();
        for(int k=0;k<10;k++)
        {
        	for (int i = 0; i < files.length; i++)
        	{ 
        		File file1 = files[i];
        		String jpgPath="\\temp-\\"+file1.getName();  
        		
        		System.out.println(jpgPath);
        		long startTime = System.currentTimeMillis();
        		//resultAll=ad.DPM(jpgPath,modelPath);   		       		
        		//for(int j=0;j<7;j++) System.out.print("resultAll:  "+resultAll[j]);
        		
        		resultAllbool=ad.DPMbool(jpgPath,modelPath); 
        		System.out.println("resultAllbool:  "+resultAllbool);
        		
        		//to watch the result. using the relay.
        		  try {  
                      Thread.sleep(1);  
                  } catch (InterruptedException e) {  
                      // TODO Auto-generated catch block  
                      e.printStackTrace();  
                  }  
              
        		
        		long finishTime = System.currentTimeMillis();
        		System.out.print("   Total time:"+(finishTime-startTime)/1000F);
        		System.out.println("s");
        	}
        }
	}

}