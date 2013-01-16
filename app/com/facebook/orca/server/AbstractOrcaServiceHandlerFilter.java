package com.facebook.orca.server;

import com.facebook.orca.debug.Tracer;

public class AbstractOrcaServiceHandlerFilter
  implements OrcaServiceHandler.Filter
{
  private final String a;

  protected AbstractOrcaServiceHandlerFilter(String paramString)
  {
    this.a = paramString;
  }

  protected OperationResult A(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult B(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult C(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult D(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult E(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult F(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Tracer localTracer = Tracer.a(this.a);
    try
    {
      String str = paramOperationParams.a();
      Object localObject2;
      if ("get_wildfire_reg_gk".equals(str))
      {
        OperationResult localOperationResult32 = b(paramOperationParams, paramOrcaServiceHandler);
        localObject2 = localOperationResult32;
      }
      while (true)
      {
        return localObject2;
        if ("verify_reg_data".equals(str))
        {
          OperationResult localOperationResult31 = x(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult31;
          localTracer.a(10L);
          continue;
        }
        if ("register_partial_acct".equals(str))
        {
          OperationResult localOperationResult30 = y(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult30;
          localTracer.a(10L);
          continue;
        }
        if ("user_lookup".equals(str))
        {
          OperationResult localOperationResult29 = z(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult29;
          localTracer.a(10L);
          continue;
        }
        if ("login".equals(str))
        {
          OperationResult localOperationResult28 = w(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult28;
          localTracer.a(10L);
          continue;
        }
        if ("fetch_thread_list".equals(str))
        {
          OperationResult localOperationResult27 = c(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult27;
          localTracer.a(10L);
          continue;
        }
        if ("fetch_more_threads".equals(str))
        {
          OperationResult localOperationResult26 = d(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult26;
          localTracer.a(10L);
          continue;
        }
        if ("fetch_thread".equals(str))
        {
          OperationResult localOperationResult25 = e(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult25;
          localTracer.a(10L);
          continue;
        }
        if ("fetch_multiple_threads".equals(str))
        {
          OperationResult localOperationResult24 = A(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult24;
          localTracer.a(10L);
          continue;
        }
        if ("queue_message".equals(str))
        {
          OperationResult localOperationResult23 = g(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult23;
          localTracer.a(10L);
          continue;
        }
        if ("add_members".equals(str))
        {
          OperationResult localOperationResult22 = h(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult22;
          localTracer.a(10L);
          continue;
        }
        if ("create_thread".equals(str))
        {
          OperationResult localOperationResult21 = f(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult21;
          localTracer.a(10L);
          continue;
        }
        if ("fetch_more_messages".equals(str))
        {
          OperationResult localOperationResult20 = v(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult20;
          localTracer.a(10L);
          continue;
        }
        if ("remove_member".equals(str))
        {
          OperationResult localOperationResult19 = i(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult19;
          localTracer.a(10L);
          continue;
        }
        if ("mark_thread".equals(str))
        {
          OperationResult localOperationResult18 = j(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult18;
          localTracer.a(10L);
          continue;
        }
        if ("delete_thread".equals(str))
        {
          OperationResult localOperationResult17 = m(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult17;
          localTracer.a(10L);
          continue;
        }
        if ("delete_messages".equals(str))
        {
          OperationResult localOperationResult16 = n(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult16;
          localTracer.a(10L);
          continue;
        }
        if ("modify_thread".equals(str))
        {
          OperationResult localOperationResult15 = o(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult15;
          localTracer.a(10L);
          continue;
        }
        if ("mark_folder_seen".equals(str))
        {
          OperationResult localOperationResult14 = q(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult14;
          localTracer.a(10L);
          continue;
        }
        if ("save_draft".equals(str))
        {
          OperationResult localOperationResult13 = p(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult13;
          localTracer.a(10L);
          continue;
        }
        if ("pushed_message".equals(str))
        {
          OperationResult localOperationResult12 = r(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult12;
          localTracer.a(10L);
          continue;
        }
        if ("request_sms_confirmation_code".equals(str))
        {
          OperationResult localOperationResult11 = B(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult11;
          localTracer.a(10L);
          continue;
        }
        if ("confirm_phone".equals(str))
        {
          OperationResult localOperationResult10 = C(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult10;
          localTracer.a(10L);
          continue;
        }
        if ("get_app_info".equals(str))
        {
          OperationResult localOperationResult9 = s(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult9;
          localTracer.a(10L);
          continue;
        }
        if ("update_user_settings".equals(str))
        {
          OperationResult localOperationResult8 = D(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult8;
          localTracer.a(10L);
          continue;
        }
        if ("analytics_upload".equals(str))
        {
          OperationResult localOperationResult7 = E(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult7;
          localTracer.a(10L);
          continue;
        }
        if ("read_receipt".equals(str))
        {
          OperationResult localOperationResult6 = k(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult6;
          localTracer.a(10L);
          continue;
        }
        if ("delivered_receipt".equals(str))
        {
          OperationResult localOperationResult5 = l(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult5;
          localTracer.a(10L);
          continue;
        }
        if ("chat_get_visibility".equals(str))
        {
          OperationResult localOperationResult4 = t(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult4;
          localTracer.a(10L);
          continue;
        }
        if ("chat_set_visiblity".equals(str))
        {
          OperationResult localOperationResult3 = u(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult3;
          localTracer.a(10L);
          continue;
        }
        if ("push_trace_confirmation".equals(str))
        {
          OperationResult localOperationResult2 = F(paramOperationParams, paramOrcaServiceHandler);
          localObject2 = localOperationResult2;
          localTracer.a(10L);
          continue;
        }
        OperationResult localOperationResult1 = paramOrcaServiceHandler.a(paramOperationParams);
        localObject2 = localOperationResult1;
        localTracer.a(10L);
      }
    }
    finally
    {
      localTracer.a(10L);
    }
    throw localObject1;
  }

  protected OperationResult b(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult c(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult d(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult e(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult f(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult g(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult h(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult i(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult j(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult k(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult l(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult m(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult n(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult o(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult p(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult q(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult r(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult s(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult t(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult u(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult v(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult w(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult x(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult y(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult z(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    return paramOrcaServiceHandler.a(paramOperationParams);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.AbstractOrcaServiceHandlerFilter
 * JD-Core Version:    0.6.0
 */