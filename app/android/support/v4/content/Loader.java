package android.support.v4.content;

import android.content.Context;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D>
{
  int m;
  Loader.OnLoadCompleteListener<D> n;
  Context o;
  boolean p = false;
  boolean q = false;
  boolean r = true;
  boolean s = false;

  public Loader(Context paramContext)
  {
    this.o = paramContext.getApplicationContext();
  }

  protected void a()
  {
  }

  public void a(int paramInt, Loader.OnLoadCompleteListener<D> paramOnLoadCompleteListener)
  {
    if (this.n != null)
      throw new IllegalStateException("There is already a listener registered");
    this.n = paramOnLoadCompleteListener;
    this.m = paramInt;
  }

  public void a(Loader.OnLoadCompleteListener<D> paramOnLoadCompleteListener)
  {
    if (this.n == null)
      throw new IllegalStateException("No listener register");
    if (this.n != paramOnLoadCompleteListener)
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    this.n = null;
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.m);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.n);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mStarted=");
    paramPrintWriter.print(this.p);
    paramPrintWriter.print(" mContentChanged=");
    paramPrintWriter.print(this.s);
    paramPrintWriter.print(" mAbandoned=");
    paramPrintWriter.print(this.q);
    paramPrintWriter.print(" mReset=");
    paramPrintWriter.println(this.r);
  }

  public void b(D paramD)
  {
    if (this.n != null)
      this.n.a(this, paramD);
  }

  public String c(D paramD)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    DebugUtils.a(paramD, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  protected void g()
  {
  }

  protected void h()
  {
  }

  protected void i()
  {
  }

  public Context j()
  {
    return this.o;
  }

  public boolean k()
  {
    return this.p;
  }

  public boolean l()
  {
    return this.q;
  }

  public boolean m()
  {
    return this.r;
  }

  public final void n()
  {
    this.p = true;
    this.r = false;
    this.q = false;
    g();
  }

  public void o()
  {
    a();
  }

  public void p()
  {
    this.p = false;
    h();
  }

  public void q()
  {
    this.q = true;
    r();
  }

  protected void r()
  {
  }

  public void s()
  {
    i();
    this.r = true;
    this.p = false;
    this.q = false;
    this.s = false;
  }

  public boolean t()
  {
    boolean bool = this.s;
    this.s = false;
    return bool;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    DebugUtils.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.m);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public void u()
  {
    if (this.p)
      o();
    while (true)
    {
      return;
      this.s = true;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.content.Loader
 * JD-Core Version:    0.6.0
 */