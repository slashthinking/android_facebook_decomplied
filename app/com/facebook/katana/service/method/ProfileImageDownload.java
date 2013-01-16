package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.HttpOperationListener;
import com.facebook.katana.net.HttpOperation.Method;

public class ProfileImageDownload extends ApiMethod
  implements HttpOperation.HttpOperationListener
{
  public final long a;
  public final String b;
  private ProfileImage f;

  public ProfileImageDownload(Context paramContext, Intent paramIntent, long paramLong, String paramString1, String paramString2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", null, paramString1, paramServiceOperationListener);
    this.a = paramLong;
    this.b = paramString2;
  }

  // ERROR //
  public void a(HttpOperation paramHttpOperation, int paramInt, String paramString, com.facebook.katana.net.HttpOperation.ResponseInputStream paramResponseInputStream, Exception paramException)
  {
    // Byte code:
    //   0: iload_2
    //   1: sipush 200
    //   4: if_icmpne +66 -> 70
    //   7: new 30	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: getfield 23	com/facebook/katana/service/method/ProfileImageDownload:b	Ljava/lang/String;
    //   15: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload 4
    //   22: aload 6
    //   24: invokevirtual 38	com/facebook/katana/net/HttpOperation$ResponseInputStream:a	(Ljava/io/File;)V
    //   27: aload 6
    //   29: invokevirtual 42	java/io/File:length	()J
    //   32: pop2
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 46	com/facebook/katana/service/method/ProfileImageDownload:o	Landroid/content/Context;
    //   38: aload_0
    //   39: getfield 21	com/facebook/katana/service/method/ProfileImageDownload:a	J
    //   42: aload_0
    //   43: getfield 49	com/facebook/katana/service/method/ProfileImageDownload:d	Ljava/lang/String;
    //   46: aload_0
    //   47: getfield 23	com/facebook/katana/service/method/ProfileImageDownload:b	Ljava/lang/String;
    //   50: invokestatic 54	com/facebook/katana/provider/ConnectionsProvider:a	(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;)Lcom/facebook/katana/binding/ProfileImage;
    //   53: putfield 56	com/facebook/katana/service/method/ProfileImageDownload:f	Lcom/facebook/katana/binding/ProfileImage;
    //   56: aload 6
    //   58: invokevirtual 60	java/io/File:exists	()Z
    //   61: ifeq +9 -> 70
    //   64: aload 6
    //   66: invokevirtual 63	java/io/File:delete	()Z
    //   69: pop
    //   70: aload_0
    //   71: iload_2
    //   72: aload_3
    //   73: aload 5
    //   75: invokespecial 66	com/facebook/katana/service/method/ApiMethod:a	(ILjava/lang/String;Ljava/lang/Exception;)V
    //   78: return
    //   79: astore 5
    //   81: aload 6
    //   83: invokevirtual 60	java/io/File:exists	()Z
    //   86: ifeq +58 -> 144
    //   89: aload 6
    //   91: invokevirtual 63	java/io/File:delete	()Z
    //   94: pop
    //   95: iconst_0
    //   96: istore_2
    //   97: aconst_null
    //   98: astore_3
    //   99: goto -29 -> 70
    //   102: astore 5
    //   104: aload 6
    //   106: invokevirtual 60	java/io/File:exists	()Z
    //   109: ifeq +35 -> 144
    //   112: aload 6
    //   114: invokevirtual 63	java/io/File:delete	()Z
    //   117: pop
    //   118: iconst_0
    //   119: istore_2
    //   120: aconst_null
    //   121: astore_3
    //   122: goto -52 -> 70
    //   125: astore 7
    //   127: aload 6
    //   129: invokevirtual 60	java/io/File:exists	()Z
    //   132: ifeq +9 -> 141
    //   135: aload 6
    //   137: invokevirtual 63	java/io/File:delete	()Z
    //   140: pop
    //   141: aload 7
    //   143: athrow
    //   144: iconst_0
    //   145: istore_2
    //   146: aconst_null
    //   147: astore_3
    //   148: goto -78 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   20	56	79	java/io/IOException
    //   20	56	102	com/facebook/katana/util/ImageUtils$ImageException
    //   20	56	125	finally
  }

  public void a(HttpOperation paramHttpOperation, long paramLong1, long paramLong2)
  {
  }

  public void b()
  {
    try
    {
      this.l = new HttpOperation(this.o, HttpOperation.Method.GET, this.d, this, false);
      this.l.b();
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        this.q.a_(this, 0, null, localException);
      }
    }
  }

  public ProfileImage g()
  {
    return this.f;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ProfileImageDownload
 * JD-Core Version:    0.6.0
 */