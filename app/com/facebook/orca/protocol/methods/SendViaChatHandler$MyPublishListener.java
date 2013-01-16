package com.facebook.orca.protocol.methods;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.orca.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

class SendViaChatHandler$MyPublishListener
{
  private final long b;
  private boolean c;
  private boolean d;
  private BroadcastReceiver e;

  public SendViaChatHandler$MyPublishListener(SendViaChatHandler paramSendViaChatHandler, long paramLong)
  {
    this.b = paramLong;
  }

  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.push.mqtt.PUBLISH");
    this.e = new SendViaChatHandler.MyPublishListener.1(this);
    LocalBroadcastManager.a(SendViaChatHandler.a(this.a)).a(this.e, localIntentFilter);
  }

  public void a(String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      boolean bool = "/send_message_response".equals(paramString1);
      if (!bool);
      while (true)
      {
        return;
        try
        {
          JsonNode localJsonNode = SendViaChatHandler.b(this.a).readTree(paramString2);
          if (JSONUtil.c(localJsonNode.get("msgid")) != this.b)
            continue;
          this.c = localJsonNode.get("succeeded").booleanValue();
          this.d = true;
          notifyAll();
        }
        catch (IOException localIOException)
        {
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean a(long paramLong)
  {
    monitorenter;
    try
    {
      long l1 = paramLong + System.currentTimeMillis();
      long l2 = l1 - System.currentTimeMillis();
      while ((l2 > 0L) && (!this.d))
      {
        wait(l2);
        l2 = l1 - System.currentTimeMillis();
      }
      boolean bool = this.d;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void b()
  {
    if (this.e != null)
      LocalBroadcastManager.a(SendViaChatHandler.a(this.a)).a(this.e);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.SendViaChatHandler.MyPublishListener
 * JD-Core Version:    0.6.0
 */