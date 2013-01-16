package com.facebook.orca.phonenumber.identification;

import android.os.Handler;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyPhoneNumberSmsConsumer
{
  private SettableFuture<String> a;
  private Handler b;
  private Runnable c;
  private boolean d = false;
  private String e;

  private void a(String paramString)
  {
    if (this.a != null)
    {
      this.a.a_(paramString);
      e();
      f();
    }
  }

  private String b(String paramString)
  {
    Matcher localMatcher1 = Pattern.compile(this.e + "\\s\\w+").matcher(paramString);
    boolean bool1 = localMatcher1.find();
    String str1 = null;
    if (!bool1);
    while (true)
    {
      return str1;
      String str2 = localMatcher1.group();
      Matcher localMatcher2 = Pattern.compile("\\w+$").matcher(str2);
      boolean bool2 = localMatcher2.find();
      str1 = null;
      if (!bool2)
        continue;
      str1 = localMatcher2.group();
    }
  }

  private void c()
  {
    if (this.a != null)
    {
      this.a.a_(new Exception("Cannot get the confirmation sms from Facebook"));
      f();
    }
  }

  private void d()
  {
    this.c = new VerifyPhoneNumberSmsConsumer.1(this);
    this.b.postDelayed(this.c, 30000L);
  }

  private void e()
  {
    if (this.c != null)
    {
      this.b.removeCallbacks(this.c);
      this.c = null;
    }
  }

  private void f()
  {
    this.e = null;
    this.b = null;
    this.d = false;
    this.a = null;
  }

  public ListenableFuture<String> a(Handler paramHandler, String paramString)
  {
    boolean bool1;
    if (paramHandler != null)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Null Handler!");
      if (paramString == null)
        break label101;
    }
    label101: for (boolean bool2 = true; ; bool2 = false)
    {
      Preconditions.checkArgument(bool2, "Null Marker!");
      int i = paramString.length();
      boolean bool3 = false;
      if (i > 0)
      {
        int j = paramString.length();
        bool3 = false;
        if (j <= 5)
          bool3 = true;
      }
      Preconditions.checkArgument(bool3, "Invalid marker length!");
      this.e = paramString;
      this.b = paramHandler;
      this.a = SettableFuture.c();
      d();
      this.d = true;
      return this.a;
      bool1 = false;
      break;
    }
  }

  public void a()
  {
    e();
    f();
  }

  public boolean a(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = b((String)localIterator.next());
      if (str == null)
        continue;
      VerifyPhoneNumberSmsConsumer.SmsConsumerRunnable localSmsConsumerRunnable = new VerifyPhoneNumberSmsConsumer.SmsConsumerRunnable(this, str);
      this.b.post(localSmsConsumerRunnable);
    }
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean b()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phonenumber.identification.VerifyPhoneNumberSmsConsumer
 * JD-Core Version:    0.6.0
 */