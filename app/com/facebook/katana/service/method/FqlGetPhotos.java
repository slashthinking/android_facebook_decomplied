package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.Log;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.katana.util.StringUtils;
import com.facebook.notifications.model.FacebookPhoto;
import com.facebook.orca.inject.FbInjector;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FqlGetPhotos extends FqlGeneratedQuery
{
  private static final Class<?> a = FqlGetPhotos.class;
  private static final String b = a.getSimpleName();
  private NotificationsContract f = (NotificationsContract)FbInjector.a(this.o).a(NotificationsContract.class);

  public FqlGetPhotos(Context paramContext, Intent paramIntent, String paramString, Set<String> paramSet)
  {
    super(paramContext, paramIntent, paramString, null, "photo", a(paramSet), FacebookPhoto.class);
  }

  private String a(long paramLong)
  {
    return "join_data_string LIKE \"%" + paramLong + "%\"";
  }

  private static String a(Set<String> paramSet)
  {
    Preconditions.checkNotNull(paramSet);
    return "object_id IN (%1)".replaceFirst("%1", StringUtils.a(", ", new Object[] { paramSet }));
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FacebookPhoto.class);
    if (localList == null)
      Log.a(b, "Failed to fetch notification photos");
    while (true)
    {
      return;
      ContentResolver localContentResolver = this.o.getContentResolver();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FacebookPhoto localFacebookPhoto = (FacebookPhoto)localIterator.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("object_photo_url", localFacebookPhoto.objectPhoto);
        localContentResolver.update(this.f.c, localContentValues, a(localFacebookPhoto.objectId), null);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetPhotos
 * JD-Core Version:    0.6.0
 */