package com.facebook.ipc.katana.model;

import com.facebook.common.json.FbJsonChecker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class FacebookStatus
{
  private final String a;
  private final long b;
  private FacebookUser c;
  private final long d;

  public FacebookStatus(FacebookUser paramFacebookUser, String paramString, long paramLong1, long paramLong2)
  {
    this.c = paramFacebookUser;
    this.a = paramString;
    this.b = paramLong1;
    this.d = paramLong2;
  }

  public FacebookStatus(JsonParser paramJsonParser)
  {
    Object localObject1 = null;
    long l1 = -1L;
    Object localObject2 = null;
    Object localObject3 = null;
    String str1 = null;
    String str2 = null;
    long l2 = 0L;
    Object localObject4 = null;
    long l3 = -1L;
    Object localObject5 = FbJsonChecker.a(paramJsonParser);
    String str5;
    long l17;
    Object localObject18;
    Object localObject19;
    if (localObject5 != JsonToken.END_OBJECT)
      if (localObject5 == JsonToken.VALUE_STRING)
      {
        str5 = paramJsonParser.getCurrentName();
        if (str5.equals("first_name"))
        {
          String str7 = paramJsonParser.getText();
          l17 = l3;
          localObject18 = localObject3;
          localObject19 = str7;
        }
      }
    while (true)
    {
      label89: Object localObject10 = localObject19;
      Object localObject9 = localObject18;
      long l18 = l2;
      Object localObject8 = localObject1;
      Object localObject20 = localObject4;
      long l8 = l1;
      long l7 = l17;
      Object localObject11 = localObject20;
      long l4 = l18;
      while (true)
      {
        JsonToken localJsonToken1 = FbJsonChecker.a(paramJsonParser);
        localObject2 = localObject10;
        localObject1 = localObject8;
        Object localObject12 = localObject11;
        Object localObject13 = localObject9;
        l3 = l7;
        localObject5 = localJsonToken1;
        l1 = l8;
        l2 = l4;
        localObject4 = localObject12;
        localObject3 = localObject13;
        break;
        if (str5.equals("last_name"))
        {
          String str6 = paramJsonParser.getText();
          l17 = l3;
          localObject18 = str6;
          localObject19 = localObject2;
          break label89;
        }
        if (str5.equals("name"))
        {
          str1 = paramJsonParser.getText();
          l17 = l3;
          localObject18 = localObject3;
          localObject19 = localObject2;
          break label89;
        }
        if (str5.equals("pic_square"))
        {
          str2 = paramJsonParser.getText();
          if (str2.length() != 0)
            break label799;
          l17 = l3;
          localObject18 = localObject3;
          localObject19 = localObject2;
          str2 = null;
          break label89;
        }
        if (!str5.equals("status_id"))
          break label799;
        l17 = Long.parseLong(paramJsonParser.getText());
        localObject18 = localObject3;
        localObject19 = localObject2;
        break label89;
        if (localObject5 == JsonToken.VALUE_NUMBER_INT)
        {
          if (paramJsonParser.getCurrentName().equals("uid"))
            l1 = paramJsonParser.getLongValue();
          l4 = l2;
          localObject8 = localObject1;
          long l15 = l3;
          localObject9 = localObject3;
          localObject10 = localObject2;
          long l16 = l1;
          l7 = l15;
          localObject11 = localObject4;
          l8 = l16;
          continue;
        }
        long l13;
        long l14;
        Object localObject15;
        Object localObject16;
        label407: Object localObject17;
        if (localObject5 == JsonToken.START_OBJECT)
        {
          if (localObject1 == null)
            break label726;
          if (localObject1.equals("status"))
          {
            l13 = l3;
            l14 = l2;
            Object localObject14 = localObject4;
            localObject15 = localObject5;
            localObject16 = localObject14;
            if (localObject15 == JsonToken.END_OBJECT)
              break label770;
            if (localObject15 == JsonToken.VALUE_STRING)
            {
              if (paramJsonParser.getCurrentName().equals("message"))
                localObject16 = paramJsonParser.getText();
              localObject17 = localObject16;
            }
          }
        }
        while (true)
        {
          JsonToken localJsonToken2 = FbJsonChecker.a(paramJsonParser);
          localObject16 = localObject17;
          localObject15 = localJsonToken2;
          break label407;
          if (localObject15 == JsonToken.VALUE_NUMBER_INT)
          {
            String str4 = paramJsonParser.getCurrentName();
            if (str4.equals("time"))
            {
              l14 = paramJsonParser.getLongValue();
              localObject17 = localObject16;
              continue;
            }
            if (str4.equals("status_id"))
            {
              l13 = paramJsonParser.getLongValue();
              localObject17 = localObject16;
              continue;
              paramJsonParser.skipChildren();
              l4 = l2;
              localObject8 = localObject1;
              long l11 = l3;
              localObject9 = localObject3;
              localObject10 = localObject2;
              long l12 = l1;
              l7 = l11;
              localObject11 = localObject4;
              l8 = l12;
              break;
              if (localObject5 == JsonToken.FIELD_NAME)
              {
                String str3 = paramJsonParser.getText();
                l4 = l2;
                localObject8 = str3;
                long l9 = l3;
                localObject9 = localObject3;
                localObject10 = localObject2;
                long l10 = l1;
                l7 = l9;
                localObject11 = localObject4;
                l8 = l10;
                break;
                if ((localObject2 != null) && (localObject2.equals("null")));
                for (Object localObject6 = null; ; localObject6 = localObject2)
                {
                  if ((localObject3 != null) && (localObject3.equals("null")));
                  for (Object localObject7 = null; ; localObject7 = localObject3)
                  {
                    this.c = new FacebookUser(l1, (String)localObject6, (String)localObject7, str1, str2);
                    if ((localObject4 != null) && (localObject4.length() > 0));
                    for (this.a = localObject4; ; this.a = null)
                    {
                      this.d = l3;
                      this.b = l2;
                      return;
                    }
                  }
                }
              }
              l4 = l2;
              localObject8 = localObject1;
              long l5 = l3;
              localObject9 = localObject3;
              localObject10 = localObject2;
              long l6 = l1;
              l7 = l5;
              localObject11 = localObject4;
              l8 = l6;
              break;
            }
          }
          label726: localObject17 = localObject16;
        }
        label770: l8 = l1;
        localObject8 = localObject1;
        localObject11 = localObject16;
        l7 = l13;
        l4 = l14;
        localObject9 = localObject3;
        localObject10 = localObject2;
      }
      label799: l17 = l3;
      localObject18 = localObject3;
      localObject19 = localObject2;
    }
  }

  public FacebookUser a()
  {
    return this.c;
  }

  public String b()
  {
    return this.a;
  }

  public long c()
  {
    return this.b;
  }

  public long d()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.katana.model.FacebookStatus
 * JD-Core Version:    0.6.0
 */