package android_src.mms.transaction;

import android.os.Bundle;

public class TransactionBundle
{
  private final Bundle a;

  private TransactionBundle(int paramInt)
  {
    this.a = new Bundle();
    this.a.putInt("type", paramInt);
  }

  public TransactionBundle(int paramInt, String paramString)
  {
    this(paramInt);
    this.a.putString("uri", paramString);
  }

  public TransactionBundle(Bundle paramBundle)
  {
    this.a = paramBundle;
  }

  public int a()
  {
    return this.a.getInt("type");
  }

  public String b()
  {
    return this.a.getString("uri");
  }

  public byte[] c()
  {
    return this.a.getByteArray("mms-push-data");
  }

  public String d()
  {
    return this.a.getString("mmsc-url");
  }

  public String e()
  {
    return this.a.getString("proxy-address");
  }

  public int f()
  {
    return this.a.getInt("proxy-port");
  }

  public String toString()
  {
    return "transactionType: " + a() + " uri: " + b() + " pushData: " + c() + " mmscUrl: " + d() + " proxyAddress: " + e() + " proxyPort: " + f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.TransactionBundle
 * JD-Core Version:    0.6.0
 */