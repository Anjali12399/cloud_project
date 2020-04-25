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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.io.IOException;
import com.amazonaws.auth.*;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
//import com.aws.s3.constants.CommonConstants;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class DownloadFile {

	
	
	public static void main(String[] args) throws IOException {
		
		CommonService1 commonService = new CommonService1();	
		// credentials object identifying user for authentication
		// user must have AWSConnector and AmazonS3FullAccess for
		// this example to work
		AWSCredentials credentials = new BasicAWSCredentials(CommonConstants1.ACCESS_KEY_ID,CommonConstants1.ACCESS_SEC_KEY);

		/*
		AmazonS3 s3client;
            s3client = AmazonS3ClientBuilder
                    .standard()
                    .withCredentials(new AWSStaticredentialsProvider(credentials))
                    .withRegion(Regions.AP_SOUTH_1)
                    .build();
*/
                AmazonS3 s3client= new AmazonS3Client(credentials);
		// create bucket - name must be unique for all S3 users
		String bucketName = CommonConstants1.BUCKET_NAME;
		//s3client.createBucket(bucketName);
                //System.out.println("bucket created");

		

		// create folder into bucket
		String folderName = CommonConstants1.FOLDER_NAME;

		// upload file to folder and set it to public
		String fileName = folderName + CommonConstants1.SUFFIX + CommonConstants1.FILE_NAME;
	
                S3Object fullObject;
               
                fullObject = s3client.getObject(new GetObjectRequest(bucketName,fileName));
               S3ObjectInputStream  inputStream = fullObject.getObjectContent();
               FileUtils.copyInputStreamToFile(inputStream,new File("C:\\Users\\lenovo\\Desktop\\s3 downloads\\"+CommonConstants1.FILE_NAME+".txt"));
                
                System.out.println("Downloading file done");
                
                

		System.out.println("Execution Completed");

		commonService.getObj(s3client);

		//CommonService.deleteFolder(bucketName, folderName, s3client);

		// deletes bucket
		//s3client.deleteBucket(bucketName);
	}



}



