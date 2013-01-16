package android_src.mms.transaction;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android_src.mms.MmsException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class Transaction extends Observable
{
  private final int a;
  protected Context b;
  protected String c;
  protected TransactionState d;
  protected TransactionSettings e;

  public Transaction(Context paramContext, int paramInt, TransactionSettings paramTransactionSettings)
  {
    this.b = paramContext;
    this.d = new TransactionState();
    this.a = paramInt;
    this.e = paramTransactionSettings;
  }

  private void a(String paramString, TransactionSettings paramTransactionSettings)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)this.b.getSystemService("connectivity");
    if (paramTransactionSettings.d())
    {
      int j = b(paramTransactionSettings.b());
      if (j == -1)
        throw new IOException("Cannot establish route for " + paramString + ": Unknown host");
      if (!localConnectivityManager.requestRouteToHost(2, j))
        throw new IOException("Cannot establish route to proxy " + j);
    }
    else
    {
      int i = b(Uri.parse(paramString).getHost());
      if (i == -1)
        throw new IOException("Cannot establish route for " + paramString + ": Unknown host");
      if (!localConnectivityManager.requestRouteToHost(2, i))
        throw new IOException("Cannot establish route to " + i + " for " + paramString);
    }
  }

  public static int b(String paramString)
  {
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(paramString);
      byte[] arrayOfByte = localInetAddress.getAddress();
      i = (0xFF & arrayOfByte[3]) << 24 | (0xFF & arrayOfByte[2]) << 16 | (0xFF & arrayOfByte[1]) << 8 | 0xFF & arrayOfByte[0];
      return i;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      while (true)
        int i = -1;
    }
  }

  public abstract void a();

  public void a(TransactionSettings paramTransactionSettings)
  {
    this.e = paramTransactionSettings;
  }

  public boolean a(Transaction paramTransaction)
  {
    if ((getClass().equals(paramTransaction.getClass())) && (this.c.equals(paramTransaction.c)));
    for (int i = 1; ; i = 0)
      return i;
  }

  protected byte[] a(long paramLong, byte[] paramArrayOfByte)
  {
    return a(paramLong, paramArrayOfByte, this.e.a());
  }

  protected byte[] a(long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null)
      throw new MmsException();
    a(paramString, this.e);
    return HttpUtils.a(this.b, paramLong, paramString, paramArrayOfByte, 1, this.e.d(), this.e.b(), this.e.c());
  }

  protected byte[] a(String paramString)
  {
    a(paramString, this.e);
    return HttpUtils.a(this.b, -1L, paramString, null, 2, this.e.d(), this.e.b(), this.e.c());
  }

  protected byte[] a(byte[] paramArrayOfByte)
  {
    return a(-1L, paramArrayOfByte, this.e.a());
  }

  protected byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    return a(-1L, paramArrayOfByte, paramString);
  }

  public abstract int b();

  public TransactionState d()
  {
    return this.d;
  }

  public int e()
  {
    return this.a;
  }

  public TransactionSettings f()
  {
    return this.e;
  }

  public String toString()
  {
    return getClass().getName() + ": serviceId=" + this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.Transaction
 * JD-Core Version:    0.6.0
 */