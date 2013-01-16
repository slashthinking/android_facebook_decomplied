package com.facebook.orca.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NestedFragment;
import com.facebook.fragment.NavigableFragmentController.FragmentActionBuilder;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

public class WildfireUserLookupOperation
{
  private static final Class<?> a = WildfireUserLookupOperation.class;
  private WildfireUserLookupOperation.Listener b;
  private String c;
  private OrcaServiceFragment d;

  private void a(ServiceException paramServiceException)
  {
    BLog.e(a, "User lookup failed with error " + paramServiceException.getMessage());
    if (paramServiceException.a() == ErrorCode.API_ERROR)
    {
      int i = ((ApiErrorResult)paramServiceException.b().h()).a();
      BLog.e(a, "API error code: " + i);
    }
    a(null, null, null);
  }

  private void a(OperationResult paramOperationResult)
  {
    BLog.c(a, "User lookup succeeded. Redirecting to login screen...");
    User localUser = (User)paramOperationResult.h();
    a(this.c, localUser.g(), localUser.p());
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new NavigableFragmentController.FragmentActionBuilder(PasswordCredentialsFragment.class).a().c();
    if (paramString1 != null)
      localIntent.putExtras(PasswordCredentialsFragment.a(paramString1, paramString2, paramString3));
    this.b.c(localIntent);
  }

  public ImmutableList<OrcaServiceFragment> a()
  {
    return ImmutableList.a(this.d);
  }

  public void a(NestedFragment paramNestedFragment)
  {
    this.d = OrcaServiceFragment.a(paramNestedFragment, "userLookupOperation");
    this.d.a(new WildfireUserLookupOperation.1(this));
  }

  public void a(WildfireUserLookupOperation.Listener paramListener)
  {
    this.b = paramListener;
  }

  public void a(String paramString1, String paramString2)
  {
    BLog.d(a, "This number already belongs to a full Facebook account.");
    this.c = paramString2;
    Bundle localBundle = new Bundle();
    localBundle.putString("uid", paramString1);
    this.d.a("user_lookup", localBundle);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireUserLookupOperation
 * JD-Core Version:    0.6.0
 */