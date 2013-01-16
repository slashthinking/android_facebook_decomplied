package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.model.FacebookPhotoTag;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhotosAddTag extends ApiMethod
{
  private final List<FacebookPhotoTag> a;

  public PhotosAddTag(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "photos.addTag", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("session_key", paramString1);
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("pid", paramString2);
    this.e.put("tags", paramString3);
    this.a = new ArrayList();
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonResponseVerifier.a(paramJsonParser);
    JsonParser localJsonParser = FBJsonFactory.a.createJsonParser((String)this.e.get("tags"));
    if (FbJsonChecker.a(localJsonParser) != JsonToken.START_ARRAY)
      throw new JsonParseException("Malformed JSON", localJsonParser.getCurrentLocation());
    for (JsonToken localJsonToken = FbJsonChecker.a(localJsonParser); localJsonToken != JsonToken.END_ARRAY; localJsonToken = FbJsonChecker.a(localJsonParser))
    {
      if (localJsonToken != JsonToken.START_OBJECT)
        continue;
      this.a.add(new FacebookPhotoTag(localJsonParser));
    }
  }

  public List<FacebookPhotoTag> g()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosAddTag
 * JD-Core Version:    0.6.0
 */