package com.facebook.katana.platform;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class TokenRefreshService extends Service
{
  final Messenger a = new Messenger(new TokenRefreshService.1(this));

  private URI a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    AppSession localAppSession = AppSession.b(this, true);
    URI localURI = null;
    if (localAppSession == null);
    while (true)
    {
      return localURI;
      String str = localAppSession.b().oAuthToken;
      localURI = null;
      if (str == null)
        continue;
      localArrayList.add(new BasicNameValuePair("access_token", paramString));
      localArrayList.add(new BasicNameValuePair("fb_access_token", str));
      localArrayList.add(new BasicNameValuePair("format", "json"));
      localURI = new URI(Constants.URL.f(this) + "?" + URLEncodedUtils.format(localArrayList, "UTF-8"));
    }
  }

  private void a(Message paramMessage)
  {
    String str = paramMessage.getData().getString("access_token");
    if (str == null)
      a(paramMessage, "access_token parameter not found.");
    while (true)
    {
      return;
      try
      {
        URI localURI = a(str);
        if (localURI == null)
          continue;
        new HttpOperation(getApplicationContext(), HttpOperation.Method.GET, localURI.toString(), new TokenRefreshService.TokenRefreshOperationListener(this, paramMessage), false).b();
      }
      catch (URISyntaxException localURISyntaxException)
      {
        a(paramMessage, "internal error (invalid parameters?)");
      }
    }
  }

  private void a(Message paramMessage, Bundle paramBundle)
  {
    Message localMessage = Message.obtain();
    localMessage.setData(paramBundle);
    try
    {
      paramMessage.replyTo.send(localMessage);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        localRemoteException.printStackTrace();
    }
  }

  private void a(Message paramMessage, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("error", paramString);
    a(paramMessage, localBundle);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.a.getBinder();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.TokenRefreshService
 * JD-Core Version:    0.6.0
 */