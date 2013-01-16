package com.facebook.katana.activity.codegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.CodeGeneratorGetSecretResponse;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.KeyValueManager;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.view.FacebookProgressCircleView;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.lang.reflect.UndeclaredThrowableException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CodeGeneratorActivity extends BaseFacebookActivity
{
  private static final int[] o = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 };
  protected Runnable n = new CodeGeneratorActivity.2(this);
  private Handler p = new Handler();
  private String q;
  private AppSession r;
  private FacebookProgressCircleView s;
  private TextView t;

  public static String a(String paramString, Long paramLong)
  {
    byte[] arrayOfByte1 = ByteBuffer.allocate(8).putLong(paramLong.longValue()).array();
    byte[] arrayOfByte2 = a(b(paramString), arrayOfByte1);
    int i = 0xF & arrayOfByte2[(-1 + arrayOfByte2.length)];
    int j = ((0x7F & arrayOfByte2[i]) << 24 | (0xFF & arrayOfByte2[(i + 1)]) << 16 | (0xFF & arrayOfByte2[(i + 2)]) << 8 | 0xFF & arrayOfByte2[(i + 3)]) % o[6];
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(j);
    return StringLocaleUtil.a("%06d", arrayOfObject);
  }

  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init(new SecretKeySpec(paramArrayOfByte1, "RAW"));
      byte[] arrayOfByte = localMac.doFinal(paramArrayOfByte2);
      return arrayOfByte;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      ErrorReporting.a("hmac function failed", localGeneralSecurityException.getMessage(), localGeneralSecurityException);
    }
    throw new UndeclaredThrowableException(localGeneralSecurityException);
  }

  private static byte[] b(String paramString)
  {
    int i = 0;
    if (!CodeGeneratorGetSecretResponse.b(paramString))
      throw new IllegalStateException();
    byte[] arrayOfByte = new byte[5 * paramString.length() / 8];
    int j = 0;
    int k = 0;
    int m = 0;
    int i1;
    int i2;
    label73: int i3;
    if (i < paramString.length())
    {
      i1 = paramString.charAt(i);
      if ((65 <= i1) && (i1 <= 90))
      {
        i2 = i1 - 65;
        i3 = k + 5;
        m = m << 5 | i2 & 0x1F;
        if (i3 < 8)
          break label146;
        int i4 = j + 1;
        arrayOfByte[j] = (byte)(m >> i3 - 8);
        k = i3 - 8;
        j = i4;
      }
    }
    while (true)
    {
      i++;
      break;
      i2 = 26 + (i1 - 50);
      break label73;
      return arrayOfByte;
      label146: k = i3;
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.r = AppSession.a(this, true);
    this.q = i();
    if (StringUtils.c(this.q))
    {
      startActivity(new Intent(this, CodeGeneratorAutoProvisionSecretActivity.class));
      finish();
    }
    while (true)
    {
      return;
      setContentView(2130903096);
      this.t = ((TextView)findViewById(2131296686));
      this.t.setText(2131363456);
      findViewById(2131296497).setOnClickListener(new CodeGeneratorActivity.1(this));
      this.s = ((FacebookProgressCircleView)findViewById(2131296498));
    }
  }

  protected void a(String paramString)
  {
    ((TextView)findViewById(2131296496)).setText(paramString);
  }

  protected String i()
  {
    long l = this.r.b().userId;
    return KeyValueManager.a(this, "login_approvals_secret:" + Long.toString(l), "");
  }

  protected void onPause()
  {
    this.p.removeCallbacks(this.n);
    this.s.setVisibility(8);
    super.onPause();
  }

  protected void onResume()
  {
    super.onResume();
    this.r = AppSession.a(this, true);
    this.q = i();
    if (StringUtils.c(this.q))
    {
      startActivity(new Intent(this, CodeGeneratorAutoProvisionSecretActivity.class));
      finish();
    }
    while (true)
    {
      return;
      this.p.removeCallbacks(this.n);
      this.p.post(this.n);
      this.s.setVisibility(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.codegenerator.CodeGeneratorActivity
 * JD-Core Version:    0.6.0
 */