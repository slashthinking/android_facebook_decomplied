package com.facebook.apache.http.entity.mime;

import com.facebook.apache.http.entity.mime.content.ContentBody;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public class MultipartEntity
  implements HttpEntity
{
  private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private final HttpMultipart b;
  private final Header c;
  private long d;
  private volatile boolean e;

  public MultipartEntity()
  {
    this(HttpMultipartMode.STRICT, null, null);
  }

  public MultipartEntity(HttpMultipartMode paramHttpMultipartMode, String paramString, Charset paramCharset)
  {
    if (paramString == null)
      paramString = a();
    if (paramHttpMultipartMode == null)
      paramHttpMultipartMode = HttpMultipartMode.STRICT;
    this.b = new HttpMultipart("form-data", paramCharset, paramString, paramHttpMultipartMode);
    this.c = new BasicHeader("Content-Type", a(paramString, paramCharset));
    this.e = true;
  }

  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    int i = 30 + localRandom.nextInt(11);
    for (int j = 0; j < i; j++)
      localStringBuilder.append(a[localRandom.nextInt(a.length)]);
    return localStringBuilder.toString();
  }

  protected String a(String paramString, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("multipart/form-data; boundary=");
    localStringBuilder.append(paramString);
    if (paramCharset != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramCharset.name());
    }
    return localStringBuilder.toString();
  }

  public void a(FormBodyPart paramFormBodyPart)
  {
    this.b.a(paramFormBodyPart);
    this.e = true;
  }

  public void a(String paramString, ContentBody paramContentBody)
  {
    a(new FormBodyPart(paramString, paramContentBody));
  }

  public void consumeContent()
  {
    if (isStreaming())
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
  }

  public InputStream getContent()
  {
    throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
  }

  public Header getContentEncoding()
  {
    return null;
  }

  public long getContentLength()
  {
    if (this.e)
    {
      this.d = this.b.c();
      this.e = false;
    }
    return this.d;
  }

  public Header getContentType()
  {
    return this.c;
  }

  public boolean isChunked()
  {
    if (!isRepeatable());
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean isRepeatable()
  {
    Iterator localIterator = this.b.a().iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((FormBodyPart)localIterator.next()).b().e() >= 0L);
    for (int i = 0; ; i = 1)
      return i;
  }

  public boolean isStreaming()
  {
    if (!isRepeatable());
    for (int i = 1; ; i = 0)
      return i;
  }

  public void writeTo(OutputStream paramOutputStream)
  {
    this.b.a(paramOutputStream);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.apache.http.entity.mime.MultipartEntity
 * JD-Core Version:    0.6.0
 */