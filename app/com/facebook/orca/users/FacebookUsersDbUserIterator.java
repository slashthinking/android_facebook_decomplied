package com.facebook.orca.users;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.common.util.TriState;
import com.facebook.orca.common.names.NameNormalizer;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.database.UsersDatabaseSupplier;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FacebookUsersDbUserIterator
  implements FacebookUserIterator
{
  private static final String[] e = { "fbid", "first_name", "last_name", "name", "email_addresses", "phone_numbers", "pic_big", "pic_square", "pic_crop", "rank", "is_pushable", "birthday_month", "birthday_day", "birthday_year", "last_active", "mobile_app_data" };
  private final UsersDatabaseSupplier a;
  private final UserSerialization b;
  private final ObjectMapper c;
  private Cursor d;

  public FacebookUsersDbUserIterator(UsersDatabaseSupplier paramUsersDatabaseSupplier, UserSerialization paramUserSerialization, ObjectMapper paramObjectMapper)
  {
    this.a = paramUsersDatabaseSupplier;
    this.b = paramUserSerialization;
    this.c = paramObjectMapper;
  }

  public void a()
  {
    this.d = this.a.b().query("facebook_users", e, null, null, null, null, null);
  }

  public void a(int paramInt)
  {
    this.d = this.a.b().query("facebook_users", e, null, null, null, null, "rank DESC", Integer.toString(paramInt));
  }

  public void a(ImmutableCollection<UserKey> paramImmutableCollection)
  {
    Collection localCollection = UserKey.b(paramImmutableCollection);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fbid NOT IN ");
    localStringBuilder.append(SqlUtil.b(localCollection));
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("facebook_users");
    localSQLiteQueryBuilder.appendWhere(localStringBuilder.toString());
    this.d = localSQLiteQueryBuilder.query(this.a.b(), e, null, null, null, null, null);
  }

  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fbid IN (");
    localStringBuilder.append("SELECT DISTINCT fbid FROM facebook_users_name_lookup ");
    localStringBuilder.append("WHERE normalized_name GLOB ");
    localStringBuilder.append("'" + NameNormalizer.a(paramString) + "*') ");
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("facebook_users");
    localSQLiteQueryBuilder.appendWhere(localStringBuilder.toString());
    this.d = localSQLiteQueryBuilder.query(this.a.b(), e, null, null, null, null, "rank DESC", Integer.toString(paramInt));
  }

  public void a(Collection<UserKey> paramCollection)
  {
    Collection localCollection = UserKey.b(paramCollection);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fbid IN ");
    localStringBuilder.append(SqlUtil.b(localCollection));
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("facebook_users");
    localSQLiteQueryBuilder.appendWhere(localStringBuilder.toString());
    this.d = localSQLiteQueryBuilder.query(this.a.b(), e, null, null, null, null, null);
  }

  public void b()
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("facebook_users");
    localSQLiteQueryBuilder.appendWhere("mobile_app_data <> \"\"");
    this.d = localSQLiteQueryBuilder.query(this.a.b(), e, null, null, null, null, "rank DESC", null);
  }

  public void c()
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("favorite_contacts AS f INNER JOIN facebook_users AS u ON f.fbid = u.fbid");
    HashMap localHashMap = Maps.a();
    for (String str : e)
      localHashMap.put(str, "u." + str);
    localSQLiteQueryBuilder.setProjectionMap(localHashMap);
    this.d = localSQLiteQueryBuilder.query(this.a.b(), e, null, null, null, null, "f.display_order ASC");
  }

  public User d()
  {
    boolean bool = this.d.moveToNext();
    User localUser = null;
    JsonNode localJsonNode;
    if (bool)
    {
      if (this.d.getString(8) == null)
        break label444;
      localJsonNode = this.c.readTree(this.d.getString(8));
    }
    label438: label444: for (PicCropInfo localPicCropInfo = this.b.a(localJsonNode); ; localPicCropInfo = null)
    {
      ImmutableList localImmutableList1 = this.b.c(this.c.readTree(this.d.getString(4)));
      ImmutableList localImmutableList2 = this.b.d(this.c.readTree(this.d.getString(5)));
      TriState localTriState = TriState.UNSET;
      String str1;
      if (!this.d.isNull(10))
      {
        if (this.d.getInt(10) != 0)
          localTriState = TriState.YES;
      }
      else
      {
        str1 = this.d.getString(14);
        if ((str1 == null) || (str1.length() <= 0))
          break label438;
      }
      for (LastActive localLastActive = this.b.f(this.c.readTree(str1)); ; localLastActive = null)
      {
        String str2 = this.d.getString(15);
        MobileAppData localMobileAppData = null;
        if (str2 != null)
        {
          int i = str2.length();
          localMobileAppData = null;
          if (i > 0)
            localMobileAppData = this.b.g(this.c.readTree(str2));
        }
        localUser = new UserBuilder().a(User.Type.FACEBOOK, this.d.getString(0)).b(this.d.getString(1)).c(this.d.getString(2)).a(this.d.getString(3)).a(localImmutableList1).b(localImmutableList2).e(this.d.getString(6)).d(this.d.getString(7)).a(localPicCropInfo).a(this.d.getFloat(9)).a(new Birthday(this.d.getInt(10), this.d.getInt(11), this.d.getInt(12))).a(localTriState).a(localLastActive).a(localMobileAppData).w();
        return localUser;
        localTriState = TriState.NO;
        break;
      }
    }
  }

  public void e()
  {
    if (this.d != null)
    {
      this.d.close();
      this.d = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.FacebookUsersDbUserIterator
 * JD-Core Version:    0.6.0
 */