/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.s3demo;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import static com.amazonaws.services.devicefarm.model.ArtifactCategory.LOG;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class ListFiles {
    static String bucket_name="bucket8793";
    public static void main(String args[]){
        
		AWSCredentials credentials = new BasicAWSCredentials(CommonConstants1.ACCESS_KEY_ID,CommonConstants1.ACCESS_SEC_KEY);


                AmazonS3 s3client= new AmazonS3Client(credentials);
                List<Bucket> buckets = s3client.listBuckets();
                   for(Bucket bucket : buckets) {
                   System.out.println(bucket.getName());
}
                   
                   ObjectListing ol = s3client.listObjects(bucket_name);
                   List<S3ObjectSummary> objects= ol.getObjectSummaries();
                   for(S3ObjectSummary os : objects){
                       System.out.println("* "+os.getKey());
                   }
                   
                   
        
    }
    
    
    
}
