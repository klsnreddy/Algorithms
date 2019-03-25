package media;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ReadImage {


  public static void main(String[] args) {
    InputStream is = null;
    try {
      URL url = new URL("http://www.mkyong.com/image/mypic.jpg");

      ByteArrayOutputStream bis = new ByteArrayOutputStream();
      is = url.openStream ();
      byte[] bytebuff = new byte[4096];
      int n;

      while ( (n = is.read(bytebuff)) > 0 ) {
        bis.write(bytebuff, 0, n);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != is) {
        try {
          is.close();
        } catch (Exception e) {

        }
      }
    }

  }
}
