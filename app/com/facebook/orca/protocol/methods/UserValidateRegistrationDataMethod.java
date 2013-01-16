package com.facebook.orca.protocol.methods;

import com.facebook.orca.prefs.AuthPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.UserValidateRegistrationDataParams;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class UserValidateRegistrationDataMethod
  implements ApiMethod<UserValidateRegistrationDataParams, Void>
{
  private OrcaSharedPreferences a;

  public UserValidateRegistrationDataMethod(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramOrcaSharedPreferences;
  }

  public ApiRequest a(UserValidateRegistrationDataParams paramUserValidateRegistrationDataParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    if (paramUserValidateRegistrationDataParams.a() != null)
      localArrayList.add(new BasicNameValuePair("firstname", paramUserValidateRegistrationDataParams.a()));
    if (paramUserValidateRegistrationDataParams.b() != null)
      localArrayList.add(new BasicNameValuePair("lastname", paramUserValidateRegistrationDataParams.b()));
    if (paramUserValidateRegistrationDataParams.c() != null)
      localArrayList.add(new BasicNameValuePair("email", paramUserValidateRegistrationDataParams.c()));
    if (paramUserValidateRegistrationDataParams.d() != null)
      localArrayList.add(new BasicNameValuePair("phone", paramUserValidateRegistrationDataParams.d()));
    if (paramUserValidateRegistrationDataParams.e() != null)
      localArrayList.add(new BasicNameValuePair("country_code", paramUserValidateRegistrationDataParams.e()));
    if (paramUserValidateRegistrationDataParams.f() != null)
      localArrayList.add(new BasicNameValuePair("password", paramUserValidateRegistrationDataParams.f()));
    if (paramUserValidateRegistrationDataParams.g() != null)
      localArrayList.add(new BasicNameValuePair("gender", paramUserValidateRegistrationDataParams.g()));
    if (paramUserValidateRegistrationDataParams.h() != null)
      localArrayList.add(new BasicNameValuePair("birthday", paramUserValidateRegistrationDataParams.h()));
    localArrayList.add(new BasicNameValuePair("reg_instance", this.a.a(AuthPrefKeys.k, null)));
    return new ApiRequest("userValidateRegistrationData", "POST", "method/user.validateRegistrationData", localArrayList, ApiResponseType.JSON);
  }

  public Void a(UserValidateRegistrationDataParams paramUserValidateRegistrationDataParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.UserValidateRegistrationDataMethod
 * JD-Core Version:    0.6.0
 */