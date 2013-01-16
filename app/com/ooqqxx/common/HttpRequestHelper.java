package com.ooqqxx.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestHelper
{
  private static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[4096];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1)
        return;
      paramOutputStream.write(arrayOfByte, 0, i);
      paramOutputStream.flush();
    }
  }

  public static boolean getFileByUrl(String paramString1, String paramString2, boolean paramBoolean)
  {
    HttpURLConnection localHttpURLConnection = null;
    try
    {
      localHttpURLConnection = setupConnection(paramString1, paramBoolean);
      localHttpURLConnection.connect();
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString2);
      copyStream(localInputStream, localFileOutputStream);
      localInputStream.close();
      localFileOutputStream.close();
      if (localHttpURLConnection != null)
        localHttpURLConnection.disconnect();
      i = 1;
      return i;
    }
    catch (Exception localException)
    {
      while (true)
      {
        File localFile = new File(paramString2);
        if (localFile.exists())
          localFile.delete();
        if (localHttpURLConnection != null)
          localHttpURLConnection.disconnect();
        int i = 0;
      }
    }
    finally
    {
      if (localHttpURLConnection != null)
        localHttpURLConnection.disconnect();
    }
    throw localObject;
  }

  public static String getStringByUrl(String paramString, boolean paramBoolean)
  {
    HttpURLConnection localHttpURLConnection = null;
    Object localObject1 = null;
    try
    {
      localHttpURLConnection = setupConnection(paramString, paramBoolean);
      localHttpURLConnection.connect();
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      byte[] arrayOfByte = new byte[512];
      while (true)
      {
        int i = localInputStream.read(arrayOfByte, 0, 512);
        if (i == -1)
        {
          localInputStream.close();
          localHttpURLConnection.disconnect();
          return localObject1;
        }
        if (localObject1 == null)
          localObject1 = "";
        String str = localObject1 + new String(arrayOfByte, 0, i, "UTF-8");
        localObject1 = str;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        if (localHttpURLConnection == null)
          continue;
        localHttpURLConnection.disconnect();
      }
    }
    finally
    {
      if (localHttpURLConnection != null)
        localHttpURLConnection.disconnect();
    }
    throw localObject2;
  }

  private static HttpURLConnection setupConnection(String paramString, boolean paramBoolean)
    throws Exception
  {
    HttpURLConnection localHttpURLConnection;
    if (paramBoolean)
    {
      String str1 = paramString.replace("http://", "");
      String str2 = "http://10.0.0.172" + str1.substring(str1.indexOf("/"));
      String str3 = str1.substring(0, str1.indexOf("/"));
      localHttpURLConnection = (HttpURLConnection)new URL(str2).openConnection();
      localHttpURLConnection.setRequestProperty("X-Online-Host", str3);
      localHttpURLConnection.setDoInput(true);
    }
    while (true)
    {
      localHttpURLConnection.setConnectTimeout(300000);
      localHttpURLConnection.setReadTimeout(600000);
      return localHttpURLConnection;
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.ooqqxx.common.HttpRequestHelper
 * JD-Core Version:    0.6.0
 */