package com.facebook.orca.common.http;

import java.io.IOException;
import org.apache.http.client.HttpResponseException;

public class ProtocolExceptions
{
  public static boolean a(Throwable paramThrowable)
  {
    HttpResponseException localHttpResponseException = e(paramThrowable);
    if ((localHttpResponseException != null) && (localHttpResponseException.getStatusCode() == 401));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static boolean b(Throwable paramThrowable)
  {
    HttpResponseException localHttpResponseException = e(paramThrowable);
    if ((localHttpResponseException != null) && (localHttpResponseException.getStatusCode() >= 400) && (localHttpResponseException.getStatusCode() < 500));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static boolean c(Throwable paramThrowable)
  {
    HttpResponseException localHttpResponseException = e(paramThrowable);
    if ((localHttpResponseException != null) && (localHttpResponseException.getStatusCode() >= 500) && (localHttpResponseException.getStatusCode() < 600));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static boolean d(Throwable paramThrowable)
  {
    if (paramThrowable != null)
      if (!(paramThrowable instanceof IOException));
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      paramThrowable = paramThrowable.getCause();
      break;
    }
  }

  public static HttpResponseException e(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    if (localThrowable != null)
      if (!(localThrowable instanceof HttpResponseException));
    for (HttpResponseException localHttpResponseException = (HttpResponseException)localThrowable; ; localHttpResponseException = null)
    {
      return localHttpResponseException;
      localThrowable = localThrowable.getCause();
      break;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.ProtocolExceptions
 * JD-Core Version:    0.6.2
 */