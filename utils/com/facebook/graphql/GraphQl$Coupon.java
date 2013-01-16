package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Coupon
{
  public static final GraphQlQueryCoupon.CouponField a = new GraphQlQueryCoupon.CouponField("id");
  public static final GraphQlQueryCoupon.CouponField b = new GraphQlQueryCoupon.CouponField("url.site(mobile)");
  public static final GraphQlQueryCoupon.CouponField c = new GraphQlQueryCoupon.CouponField("has_viewer_claimed");
  public static final GraphQlQueryCoupon.CouponField d = new GraphQlQueryCoupon.CouponField("is_active");
  public static final GraphQlQueryCoupon.CouponField e = new GraphQlQueryCoupon.CouponField("name");
  public static final GraphQlQueryCoupon.CouponField f = new GraphQlQueryCoupon.CouponField("is_expired");
  public static final GraphQlQueryCoupon.CouponField g = new GraphQlQueryCoupon.CouponField("expiration_date");
  public static final GraphQlQueryCoupon.CouponField h = new GraphQlQueryCoupon.CouponField("redemption_code");
  public static final GraphQlQueryCoupon.CouponField i = new GraphQlQueryCoupon.CouponField("terms");
  public static final GraphQlQueryCoupon.CouponField j = new GraphQlQueryCoupon.CouponField("claim_limit");
  public static final GraphQlQueryCoupon.CouponField k = new GraphQlQueryCoupon.CouponField("claim_count");
  public static final GraphQlQueryCoupon.CouponField l = new GraphQlQueryCoupon.CouponField("is_stopped");
  public static final GraphQlQueryCoupon.CouponField m = new GraphQlQueryCoupon.CouponField("mobile_post_claim_message");

  public static GraphQlQueryCoupon.CouponField a(GraphQlQueryPage paramGraphQlQueryPage)
  {
    return new GraphQlQueryCoupon.CouponField("owning_page", paramGraphQlQueryPage);
  }

  public static GraphQlQueryCoupon a(GraphQlQueryCoupon.CouponField[] paramArrayOfCouponField)
  {
    return new GraphQlQueryCoupon(ImmutableList.a(paramArrayOfCouponField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Coupon
 * JD-Core Version:    0.6.2
 */