package com.facebook.orca.protocol.methods;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DeleteMessagesParams;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class DeleteMessagesMethod
  implements ApiMethod<DeleteMessagesParams, Void>
{
  public ApiRequest a(DeleteMessagesParams paramDeleteMessagesParams)
  {
    String str = Joiner.on(",").join(paramDeleteMessagesParams.b());
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("ids", str));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("deleteMessages", "DELETE", "", localArrayList, ApiResponseType.STRING);
  }

  public Void a(DeleteMessagesParams paramDeleteMessagesParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.DeleteMessagesMethod
 * JD-Core Version:    0.6.0
 */