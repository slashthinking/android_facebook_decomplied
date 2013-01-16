package com.facebook.feed.util;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.orca.common.http.OrcaHttpClient;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

class DefaultFeedStoryImpressionLogger$1 extends AsyncTask<String, Void, Void>
{
  protected Void a(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    int j = 0;
    while (true)
      if (j < i)
      {
        String str = paramArrayOfString[j];
        try
        {
          URL localURL1 = new URL(str);
          localURL2 = localURL1;
        }
        catch (URISyntaxException localURISyntaxException)
        {
          try
          {
            label30: localURI = new URI(localURL2.getProtocol(), localURL2.getAuthority(), localURL2.getPath(), localURL2.getQuery(), localURL2.getRef());
          }
          catch (URISyntaxException localURISyntaxException)
          {
            try
            {
              URL localURL2;
              URI localURI;
              HttpResponse localHttpResponse2 = DefaultFeedStoryImpressionLogger.a(this.a).execute(new HttpGet(localURI));
              localHttpResponse1 = localHttpResponse2;
              if (localHttpResponse1 == null)
                Log.e("SS_IMPRESSION_FAIL", "Failed to log impression to URL " + str);
              while (true)
              {
                j++;
                break;
                localMalformedURLException = localMalformedURLException;
                Log.e("SS_URL_PARSE_FAIL", "Failed to parse malformed URL: " + str, localMalformedURLException);
                localURL2 = null;
                break label30;
                localURISyntaxException = localURISyntaxException;
                Log.e("SS_URL_PARSE_FAIL", "Failed to parse URL: " + str);
              }
            }
            catch (IOException localIOException)
            {
              while (true)
                HttpResponse localHttpResponse1 = null;
            }
          }
        }
      }
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.DefaultFeedStoryImpressionLogger.1
 * JD-Core Version:    0.6.0
 */