package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.common.util.Log;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.Method;
import com.facebook.katana.util.URLQueryBuilder;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;

public class GraphApiMethod extends ApiMethod
{
  private static final Class<?> a = GraphApiMethod.class;
  private static final String f = a.getSimpleName();
  protected final List<FormBodyPart> b;
  private String g;
  private String h;

  public GraphApiMethod(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, null, paramString1, paramString2, paramString3, null);
    this.b = Lists.a();
  }

  public GraphApiMethod(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramContext, null, paramString2, paramString3, paramString4, null);
    this.e.put("access_token", paramString1);
    this.b = Lists.a();
  }

  protected String a(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    String str3;
    if (paramBoolean1)
    {
      localStringBuilder1 = new StringBuilder(this.d);
      if (this.c != null)
        localStringBuilder1.append(this.c);
      if (!paramBoolean2)
        break label161;
      localStringBuilder2 = e();
      if (localStringBuilder2.length() != 0)
        break label147;
      String str2 = getClass().getName();
      if (f == str2)
        break label139;
      StringBuffer localStringBuffer = new StringBuffer(f);
      localStringBuffer.append("(");
      localStringBuffer.append(str2);
      localStringBuffer.append(")");
      str3 = localStringBuffer.toString();
      label110: Log.a(str3, "We always should have something in the query (e.g., the signature)");
    }
    label139: label147: label161: for (String str1 = this.d; ; str1 = localStringBuilder1.toString())
    {
      return str1;
      localStringBuilder1 = new StringBuilder("/");
      break;
      str3 = f;
      break label110;
      localStringBuilder1.append("?");
      localStringBuilder1.append(localStringBuilder2);
    }
  }

  public void b()
  {
    try
    {
      if (this.k.equals("GET"));
      for (this.l = new HttpOperation(this.o, HttpOperation.Method.GET, a(true, true), this.m, true); ; this.l = new HttpOperation(this.o, a(true, true), this.b, this.m, true))
      {
        this.l.b();
        return;
        if (!this.k.equals("POST"))
          break;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        if (this.q == null)
          break;
        this.q.a_(this, 0, null, localException);
        break;
        if (this.k.equals("DELETE"))
        {
          this.e.put("method", "delete");
          this.l = new HttpOperation(this.o, a(true, false), e().toString(), "application/x-www-form-urlencoded", this.m, true);
          continue;
        }
        throw new IllegalArgumentException("Unknown HTTP method");
      }
    }
  }

  public void c(String paramString)
  {
    this.h = paramString;
  }

  public void d(String paramString)
  {
    this.g = paramString;
  }

  protected StringBuilder e()
  {
    return URLQueryBuilder.a(this.e);
  }

  public String g()
  {
    return this.h;
  }

  public String h()
  {
    return this.g;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphApiMethod
 * JD-Core Version:    0.6.0
 */