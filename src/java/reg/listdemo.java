package reg;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
//import com.google.api.client.util.DateTime;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//import javax.swing.JOptionPane;


public class listdemo {

  private static String CLIENT_ID = "<put your client id provided by google>.apps.googleusercontent.com";
  private static String CLIENT_SECRET = "<put your client secret>";

  private static String REDIRECT_URI = "http://hellopratixadrive.appspot.com/hellodevanshi";
  
  
  public static void main(String[] args) throws IOException {
      int i;
    HttpTransport httpTransport = new NetHttpTransport();
    JsonFactory jsonFactory = new JacksonFactory();
   
    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
        httpTransport, jsonFactory, CLIENT_ID, CLIENT_SECRET, Arrays.asList(DriveScopes.DRIVE))
        .setAccessType("offline")
        .setApprovalPrompt("auto").build();
    
    String url = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI).build();
    System.out.println("Please open the following URL in your browser then type the authorization code:");
    System.out.println("  " + url);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String code = br.readLine();
    
    GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
    GoogleCredential credential = new GoogleCredential().setFromTokenResponse(response);
    
    //Create a new authorized API client
    Drive service = new Drive.Builder(httpTransport, jsonFactory, credential).build();
    List<File> abcd=listdemo.retrieveAllFiles(service);
    for(i=0;i<=2;i++){
    File f1 =abcd.get(i);
    String id=f1.getId();
    String title=f1.getTitle();
    String extension=f1.getFileExtension();
    long size=f1.getFileSize();
    DateTime create_date=f1.getCreatedDate();
    DateTime modify_date=f1.getModifiedDate();
    System.out.println(id);
    System.out.println(title);
    

    //String title=f1.getTitle();
    com.google.api.services.drive.model.File file=service.files().get(id).execute();
   
   	        InputStream is=listdemo.downloadFile(service, file);
    
    OutputStream os = new FileOutputStream("E:\\" +title+ "." +extension);
               
               byte[] buffer = new byte[1024];
               int bytesRead;
               //read from is to buffer
               while((bytesRead = is.read(buffer)) !=-1){
                   os.write(buffer, 0, bytesRead);
               }
               is.close();
               //flush OutputStream to write any buffered data to file
               os.flush();
               os.close();
    }
   	     listdemo.uploadFile(service);
    
    
  }
    private static List<File> retrieveAllFiles(Drive service) throws IOException {
    	//JOptionPane.showMessageDialog(null, "hello");
        List<File> result = new ArrayList<File>();
        Files.List request = service.files().list();

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
    private static InputStream downloadFile(Drive service, File file) {
        if (file.getDownloadUrl() != null && file.getDownloadUrl().length() > 0) {
          try {
            HttpResponse resp =
                service.getRequestFactory().buildGetRequest(new GenericUrl(file.getDownloadUrl()))
                    .execute();
            return resp.getContent();
          } catch (IOException e) {
            // An error occurred.
            e.printStackTrace();
            return null;
          }
        } else {
          // The file doesn't have any content stored on Drive.
          return null;
        }
      }
    private static void uploadFile(Drive service){
    	File body = new File();
        body.setTitle("image4");
        body.setDescription("A test document");
        body.setMimeType("image/png");
        
        java.io.File fileContent = new java.io.File("E:\\image1.png");
        FileContent mediaContent = new FileContent("image/png", fileContent);

        try {
			File file1 = service.files().insert(body, mediaContent).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
