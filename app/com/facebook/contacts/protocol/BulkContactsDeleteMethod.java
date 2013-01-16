package com.facebook.contacts.protocol;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class BulkContactsDeleteMethod
  implements ApiMethod<Void, Boolean>
{
  public ApiRequest a(Void paramVoid)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("method", "delete"));
    return new ApiRequest("bulkDeleteImportedContacts", "POST", "me/bulkcontacts", localArrayList, ApiResponseType.JSON);
  }

  public Boolean a(Void paramVoid, ApiResponse paramApiResponse)
  {
    return Boolean.valueOf(JSONUtil.f(paramApiResponse.c()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.protocol.BulkContactsDeleteMethod
 * JD-Core Version:    0.6.0
 */