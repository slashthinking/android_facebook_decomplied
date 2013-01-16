package com.facebook.apache.http.entity.mime;

import com.facebook.apache.http.entity.mime.content.ContentBody;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

public class HttpMultipart
{
  private static final ByteArrayBuffer a = a(MIME.a, ": ");
  private static final ByteArrayBuffer b = a(MIME.a, "\r\n");
  private static final ByteArrayBuffer c = a(MIME.a, "--");
  private final String d;
  private final Charset e;
  private final String f;
  private final List<FormBodyPart> g;
  private final HttpMultipartMode h;

  public HttpMultipart(String paramString1, Charset paramCharset, String paramString2, HttpMultipartMode paramHttpMultipartMode)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("Multipart subtype may not be null");
    if (paramString2 == null)
      throw new IllegalArgumentException("Multipart boundary may not be null");
    this.d = paramString1;
    if (paramCharset != null);
    while (true)
    {
      this.e = paramCharset;
      this.f = paramString2;
      this.g = new ArrayList();
      this.h = paramHttpMultipartMode;
      return;
      paramCharset = MIME.a;
    }
  }

  private static ByteArrayBuffer a(Charset paramCharset, String paramString)
  {
    ByteBuffer localByteBuffer = paramCharset.encode(CharBuffer.wrap(paramString));
    ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(localByteBuffer.remaining());
    localByteArrayBuffer.append(localByteBuffer.array(), localByteBuffer.position(), localByteBuffer.remaining());
    return localByteArrayBuffer;
  }

  private void a(HttpMultipartMode paramHttpMultipartMode, OutputStream paramOutputStream, boolean paramBoolean)
  {
    ByteArrayBuffer localByteArrayBuffer = a(this.e, b());
    Iterator localIterator1 = this.g.iterator();
    if (localIterator1.hasNext())
    {
      FormBodyPart localFormBodyPart = (FormBodyPart)localIterator1.next();
      a(c, paramOutputStream);
      a(localByteArrayBuffer, paramOutputStream);
      a(b, paramOutputStream);
      Header localHeader = localFormBodyPart.c();
      switch (HttpMultipart.1.a[paramHttpMultipartMode.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
      while (true)
      {
        a(b, paramOutputStream);
        if (paramBoolean)
          localFormBodyPart.b().a(paramOutputStream);
        a(b, paramOutputStream);
        break;
        Iterator localIterator2 = localHeader.iterator();
        while (localIterator2.hasNext())
          a((MinimalField)localIterator2.next(), paramOutputStream);
        a(localFormBodyPart.c().a("Content-Disposition"), this.e, paramOutputStream);
        if (localFormBodyPart.b().b() != null)
          a(localFormBodyPart.c().a("Content-Type"), this.e, paramOutputStream);
      }
    }
    a(c, paramOutputStream);
    a(localByteArrayBuffer, paramOutputStream);
    a(c, paramOutputStream);
    a(b, paramOutputStream);
  }

  private static void a(MinimalField paramMinimalField, OutputStream paramOutputStream)
  {
    a(paramMinimalField.a(), paramOutputStream);
    a(a, paramOutputStream);
    a(paramMinimalField.b(), paramOutputStream);
    a(b, paramOutputStream);
  }

  private static void a(MinimalField paramMinimalField, Charset paramCharset, OutputStream paramOutputStream)
  {
    a(paramMinimalField.a(), paramCharset, paramOutputStream);
    a(a, paramOutputStream);
    a(paramMinimalField.b(), paramCharset, paramOutputStream);
    a(b, paramOutputStream);
  }

  private static void a(String paramString, OutputStream paramOutputStream)
  {
    a(a(MIME.a, paramString), paramOutputStream);
  }

  private static void a(String paramString, Charset paramCharset, OutputStream paramOutputStream)
  {
    a(a(paramCharset, paramString), paramOutputStream);
  }

  private static void a(ByteArrayBuffer paramByteArrayBuffer, OutputStream paramOutputStream)
  {
    paramOutputStream.write(paramByteArrayBuffer.buffer(), 0, paramByteArrayBuffer.length());
  }

  public List<FormBodyPart> a()
  {
    return this.g;
  }

  public void a(FormBodyPart paramFormBodyPart)
  {
    if (paramFormBodyPart == null);
    while (true)
    {
      return;
      this.g.add(paramFormBodyPart);
    }
  }

  public void a(OutputStream paramOutputStream)
  {
    a(this.h, paramOutputStream, true);
  }

  public String b()
  {
    return this.f;
  }

  public long c()
  {
    Iterator localIterator = this.g.iterator();
    long l1 = 0L;
    long l2;
    while (localIterator.hasNext())
    {
      long l3 = ((FormBodyPart)localIterator.next()).b().e();
      if (l3 >= 0L)
        l1 += l3;
      else
        l2 = -1L;
    }
    while (true)
    {
      return l2;
      HttpMultipart.ByteCountingOutputStream localByteCountingOutputStream = new HttpMultipart.ByteCountingOutputStream(null);
      try
      {
        a(this.h, localByteCountingOutputStream, false);
        int i = localByteCountingOutputStream.a;
        l2 = l1 + i;
      }
      catch (IOException localIOException)
      {
        l2 = -1L;
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.apache.http.entity.mime.HttpMultipart
 * JD-Core Version:    0.6.2
 */