package com.facebook.orca.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.users.FacebookUserIterator;
import com.facebook.orca.users.LastActive;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.PicCropInfo;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserBuilder;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Provider;

class DbFetchThreadUsersHandler
{
  private static final String[] e = { "user_key", "first_name", "last_name", "name", "pic_big", "pic_square", "pic_crop", "last_active" };
  private final ThreadsDatabaseSupplier a;
  private final UserSerialization b;
  private final Provider<FacebookUserIterator> c;
  private final ObjectMapper d;

  DbFetchThreadUsersHandler(ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, Provider<FacebookUserIterator> paramProvider, UserSerialization paramUserSerialization, ObjectMapper paramObjectMapper)
  {
    this.a = paramThreadsDatabaseSupplier;
    this.b = paramUserSerialization;
    this.c = paramProvider;
    this.d = paramObjectMapper;
  }

  private Map<UserKey, User> b(Collection<UserKey> paramCollection)
  {
    HashMap localHashMap = Maps.a();
    FacebookUserIterator localFacebookUserIterator = (FacebookUserIterator)this.c.b();
    localFacebookUserIterator.a(paramCollection);
    try
    {
      User localUser = localFacebookUserIterator.d();
      if (localUser != null)
        localHashMap.put(localUser.c(), localUser);
    }
    finally
    {
      localFacebookUserIterator.e();
    }
    return localHashMap;
  }

  ImmutableList<User> a(Collection<UserKey> paramCollection)
  {
    Tracer localTracer = Tracer.a("DbFetchThreadUsersHandler.doThreadUsersQuery");
    HashMap localHashMap = Maps.a();
    Map localMap = b(paramCollection);
    Collection localCollection;
    if (paramCollection != null)
      localCollection = UserKey.a(paramCollection);
    for (String str = "user_key IN " + SqlUtil.b(localCollection); ; str = null)
    {
      Cursor localCursor = this.a.b().query("thread_users", e, str, null, null, null, null);
      while (true)
      {
        try
        {
          if (localCursor.moveToNext())
          {
            UserKey localUserKey = UserKey.a(localCursor.getString(0));
            Name localName = new Name(localCursor.getString(1), localCursor.getString(2), localCursor.getString(3));
            if (localCursor.getString(6) == null)
              break label374;
            JsonNode localJsonNode2 = this.d.readTree(localCursor.getString(6));
            localPicCropInfo = this.b.a(localJsonNode2);
            if (localCursor.getString(7) == null)
              break label368;
            JsonNode localJsonNode1 = this.d.readTree(localCursor.getString(7));
            localLastActive = this.b.f(localJsonNode1);
            if (!localMap.containsKey(localUserKey))
              break label362;
            localImmutableList2 = ((User)localMap.get(localUserKey)).j();
            localHashMap.put(localUserKey, new UserBuilder().a(localUserKey.a(), localUserKey.b()).a(localName).e(localCursor.getString(4)).d(localCursor.getString(5)).a(localPicCropInfo).a(localLastActive).b(localImmutableList2).w());
            continue;
          }
        }
        finally
        {
          localCursor.close();
          localTracer.a();
        }
        ImmutableList localImmutableList1 = ImmutableList.a(localHashMap.values());
        localCursor.close();
        localTracer.a();
        return localImmutableList1;
        label362: ImmutableList localImmutableList2 = null;
        continue;
        label368: LastActive localLastActive = null;
        continue;
        label374: PicCropInfo localPicCropInfo = null;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbFetchThreadUsersHandler
 * JD-Core Version:    0.6.0
 */