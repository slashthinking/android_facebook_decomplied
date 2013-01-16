package com.facebook.graphql;

public class GraphQl$GetCouponActionLink
{
  public static final GraphQlQueryGetCouponActionLink.GetCouponActionLinkField a = new GraphQlQueryGetCouponActionLink.GetCouponActionLinkField("title");
  public static final GraphQlQueryGetCouponActionLink.GetCouponActionLinkField b = new GraphQlQueryGetCouponActionLink.GetCouponActionLinkField("url.site(mobile)");

  @Deprecated
  public static final GraphQlQueryGetCouponActionLink.GetCouponActionLinkField c = new GraphQlQueryGetCouponActionLink.GetCouponActionLinkField("type");

  public static GraphQlQueryGetCouponActionLink.GetCouponActionLinkField a(GraphQlQueryCoupon paramGraphQlQueryCoupon)
  {
    return new GraphQlQueryGetCouponActionLink.GetCouponActionLinkField("coupon", paramGraphQlQueryCoupon);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.GetCouponActionLink
 * JD-Core Version:    0.6.2
 */