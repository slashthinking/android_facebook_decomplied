package com.karmascience.gifts.content;

import com.facebook.common.util.Log;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.model.CardFront;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Sku;
import com.karmascience.gifts.controllers.OrderManager.CardInfo;
import com.karmascience.gifts.controllers.OrderManager.ProductInfo;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ShareOrderApiMethod<T> extends GraphPOJOApiMethod<T>
{
  private static final String a = ShareOrderApiMethod.class.getSimpleName();

  public ShareOrderApiMethod(OrderManager.ProductInfo paramProductInfo, OrderManager.UserInfo paramUserInfo, OrderManager.CardInfo paramCardInfo, boolean paramBoolean, ThreadingService paramThreadingService, Class<T> paramClass)
  {
    super("SubmitOrder", paramThreadingService, 0, paramClass, "POST", "me/gifts");
    try
    {
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("gift_product", Long.parseLong(paramProductInfo.a.e()));
      if (paramProductInfo.b != null)
        localJSONObject1.put("gift_product_sku", Long.parseLong(paramProductInfo.b.c()));
      localJSONArray.put(localJSONObject1);
      String str5 = localJSONArray.toString();
      str1 = str5;
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("message", paramCardInfo.c);
        localJSONObject2.put("to_name", paramCardInfo.d);
        localJSONObject2.put("closing", paramCardInfo.f);
        localJSONObject2.put("from_name", paramCardInfo.e);
        String str4 = localJSONObject2.toString();
        str2 = str4;
        if (paramProductInfo.a.c("itunes_has_recommended"))
          str3 = paramProductInfo.a.b("itunes_recommended_itunes_id");
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          while (true)
          {
            String str3;
            JSONObject localJSONObject3 = new JSONObject();
            localJSONObject3.put("itunes_id", str3);
            a("sender_recommendation", localJSONObject3.toString());
            if (paramProductInfo.a.q())
              a("sender_mailing_address", paramProductInfo.a.b("sender_mailing_address"));
            a("gift_items", str1);
            a("card_message", str2);
            a("to", paramUserInfo.a);
            a("card_template", paramCardInfo.a.b());
            a("post_to_timeline", Boolean.toString(paramBoolean));
            a("gift_card_template", paramCardInfo.a.b());
            a("message", a(paramCardInfo));
            return;
            localJSONException1 = localJSONException1;
            Log.a(a, "Error making product data", localJSONException1);
            String str1 = null;
          }
          localJSONException2 = localJSONException2;
          Log.a(a, "Error making card data", localJSONException2);
          String str2 = null;
        }
        catch (JSONException localJSONException3)
        {
          while (true)
            Log.b("Can't add recommendation", localJSONException3);
        }
      }
    }
  }

  private String a(OrderManager.CardInfo paramCardInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramCardInfo.d);
    localStringBuilder.append(",\n");
    localStringBuilder.append(paramCardInfo.c);
    localStringBuilder.append('\n');
    localStringBuilder.append(paramCardInfo.f);
    localStringBuilder.append(",\n");
    localStringBuilder.append(paramCardInfo.e);
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.ShareOrderApiMethod
 * JD-Core Version:    0.6.0
 */