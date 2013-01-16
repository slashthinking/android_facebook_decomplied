package com.karmascience.gifts.controllers;

import android.net.Uri;
import com.facebook.graphql.model.GraphQLBirthdate;

public class OrderManager$UserInfo
{
  public String a;
  public String b;
  public Uri c;
  public GraphQLBirthdate d;

  public UserInfo a()
  {
    UserInfo localUserInfo = new UserInfo();
    localUserInfo.c = this.c;
    localUserInfo.b = this.b;
    localUserInfo.a = this.a;
    localUserInfo.d = this.d;
    return localUserInfo;
  }

  void a(String paramString1, String paramString2, Uri paramUri, GraphQLBirthdate paramGraphQLBirthdate)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramUri;
    this.d = paramGraphQLBirthdate;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.OrderManager.UserInfo
 * JD-Core Version:    0.6.0
 */