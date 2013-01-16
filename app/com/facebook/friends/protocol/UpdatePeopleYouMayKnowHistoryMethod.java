package com.facebook.friends.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class UpdatePeopleYouMayKnowHistoryMethod
  implements ApiMethod<UpdatePeopleYouMayKnowHistoryMethod.Params, Boolean>
{
  public ApiRequest a(UpdatePeopleYouMayKnowHistoryMethod.Params paramParams)
  {
    NameValuePair[] arrayOfNameValuePair = new NameValuePair[4];
    arrayOfNameValuePair[0] = new BasicNameValuePair("event", paramParams.b.value);
    arrayOfNameValuePair[1] = new BasicNameValuePair("location", paramParams.c.value);
    arrayOfNameValuePair[2] = new BasicNameValuePair("suggestion_ids", paramParams.a);
    arrayOfNameValuePair[3] = new BasicNameValuePair("format", "json");
    ArrayList localArrayList = Lists.a(arrayOfNameValuePair);
    if (paramParams.b == UpdatePeopleYouMayKnowHistoryMethod.Event.CLICK)
      localArrayList.add(new BasicNameValuePair("click_type", "FRIENDED"));
    return new ApiRequest("updatePeopleYouMayKnowHistory", "POST", "method/user.updatepeopleyoumayknowhistory", localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(UpdatePeopleYouMayKnowHistoryMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    return Boolean.valueOf(paramApiResponse.c().asBoolean());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod
 * JD-Core Version:    0.6.0
 */