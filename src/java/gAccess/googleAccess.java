/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gAccess;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class googleAccess {
  private static String CLIENT_ID = "1057212581093-1v1och7f60nteqq5irs9s4bcu1ticeph.apps.googleusercontent.com";
  private static String CLIENT_SECRET = "q_XJEx_YukYrn18pJGWD8BtL";

  private static String REDIRECT_URI = "http://hellopratixadrive.appspot.com/hellodevanshi";
    private static Drive getDriveService(String code){
        Drive service=null;
      try {
          
          HttpTransport httpTransport = new NetHttpTransport();
      JsonFactory jsonFactory = new JacksonFactory();
     
      GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
          httpTransport, jsonFactory, CLIENT_ID, CLIENT_SECRET, Arrays.asList(DriveScopes.DRIVE))
          .setAccessType("offline")
          .setApprovalPrompt("auto").build();
      
     
      
      GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
      GoogleCredential credential = new GoogleCredential().setFromTokenResponse(response);
      
      
      
      //Create a new authorized API client
     service = new Drive.Builder(httpTransport, jsonFactory, credential).build();
          
      } catch (IOException ex) {
          Logger.getLogger(googleAccess.class.getName()).log(Level.SEVERE, null, ex);
      }
      return service;
    }
     public static ArrayList<File> retrieveAllFiles(String AccessCode) throws IOException {
    	//JOptionPane.showMessageDialog(null, "hello");
    
        ArrayList<File> result = new ArrayList<File>();
        Drive.Files.List request = getDriveService(AccessCode).files().list();

        do {
          try {
            FileList files = request.execute();

            result.addAll(files.getItems());
            request.setPageToken(files.getNextPageToken());
          } catch (IOException e) {
            System.out.println("An error occurred: " + e);
            request.setPageToken(null);
          }
        } while (request.getPageToken() != null &&
                 request.getPageToken().length() > 0);

        return result;
      } 
}
