package com.facebook.katana.platform;

import android.os.Bundle;
import android.os.Message;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.common.json.jsonmirror.JMException;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.TokenRefreshRequestResponse;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.HttpOperationListener;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import org.apache.http.ParseException;

class TokenRefreshService$TokenRefreshOperationListener
  implements HttpOperation.HttpOperationListener
{
  private Message b;

  public TokenRefreshService$TokenRefreshOperationListener(TokenRefreshService paramTokenRefreshService, Message paramMessage)
  {
    this.b = Message.obtain(paramMessage);
  }

  public void a(HttpOperation paramHttpOperation, int paramInt, String paramString, HttpOperation.ResponseInputStream paramResponseInputStream, Exception paramException)
  {
    if (paramException != null)
      TokenRefreshService.a(this.a, this.b, "internal error");
    while (true)
    {
      return;
      if (paramInt != 200)
      {
        TokenRefreshService.a(this.a, this.b, "http protocol error");
        continue;
      }
      Bundle localBundle = new Bundle();
      TokenRefreshRequestResponse localTokenRefreshRequestResponse;
      try
      {
        JsonParser localJsonParser = FBJsonFactory.a.createJsonParser(paramResponseInputStream);
        FbJsonChecker.a(localJsonParser);
        localTokenRefreshRequestResponse = (TokenRefreshRequestResponse)JMParser.a(localJsonParser, TokenRefreshRequestResponse.class);
        if (localTokenRefreshRequestResponse != null)
          break label229;
        FacebookApiException localFacebookApiException = (FacebookApiException)JMParser.a(localJsonParser, FacebookApiException.class);
        if (localFacebookApiException != null)
        {
          localBundle.putString("error", localFacebookApiException.b());
          localBundle.putInt("error_code", localFacebookApiException.a());
          TokenRefreshService.a(this.a, this.b, localBundle);
        }
      }
      catch (JsonParseException localJsonParseException)
      {
        TokenRefreshService.a(this.a, this.b, "unexpected response");
        continue;
        TokenRefreshService.a(this.a, this.b, "unexpected response");
      }
      catch (ParseException localParseException)
      {
        TokenRefreshService.a(this.a, this.b, "unexpected response");
      }
      catch (JMException localJMException)
      {
        TokenRefreshService.a(this.a, this.b, "unexpected response");
      }
      catch (IOException localIOException)
      {
        TokenRefreshService.a(this.a, this.b, "internal error");
      }
      continue;
      label229: localBundle.putString("access_token", localTokenRefreshRequestResponse.accessToken);
      localBundle.putLong("expires_in", localTokenRefreshRequestResponse.expiresAt);
      TokenRefreshService.a(this.a, this.b, localBundle);
    }
  }

  public void a(HttpOperation paramHttpOperation, long paramLong1, long paramLong2)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.TokenRefreshService.TokenRefreshOperationListener
 * JD-Core Version:    0.6.0
 */