/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.s3demo;

/**
 *
 * @author lenovo
 */
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import java.io.File;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;


public class UploadFolder {
public static void main(String args[]){
    
    TransferManager xfer=new TransferManager();
    String dir_path="";
    String folder_name="";
    String bucket_name="";
    boolean  recursive=false;
    MultipleFileUpload xfr=xfer.uploadDirectory(bucket_name, folder_name, new File(dir_path), recursive);
    try{
        xfr.waitForCompletion();
    }catch(AmazonServiceException e){
        System.err.println("Amazon Service error "+e.getMessage());
        
    }
    catch(AmazonClientException e){
        System.err.println("Amazon client error "+e.getMessage());
        
    }
    catch(InterruptedException e){
        System.err.println("Transfer Interrupted "+e.getMessage());
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
    
    
    
    
}
