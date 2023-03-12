package com.Sharpest.sharpestapp;

public class Urls {

//    static String api_test="http://41.32.95.166:8080/sharp-backend/";
   public  static String api_test="https://zad-solutions.com/api/";
//   public  static String api_test="http://zad-solutions.com/sharp-backend/";
//   public  static String api_test="http://196.221.151.69:8085/sharp-backend/";

   public static String productMulti_list=api_test+"item-category-mobile/get-item-by-item-category-and-spare-part?page=";//0&size=10&sparePartsFlag=0

    public static String Product_Categry=api_test+"item-mobile/get-item-by-category?ItemCategory=";// 1&page=0&size=10

    public static String Details_Product=api_test+"item-mobile/find?id=";//
    public static String login=api_test+"auth/sign-in";//
    public static String siginUp=api_test+"auth/sign-up";//

    public static String Details_Coursess=api_test+"course-mobile/find?id=";//

    public static String Booking_Item=api_test+"request-item-mobile/new";//

    public static String favoriteHome=api_test+"item-mobile/get-favourite-items?favouriteFlag=1&page=";//

    public static String coursesHome=api_test+"course-mobile/get-course-by-active-flag?page=";//0&size=10&courseActiveFlag=1

    public static String OffersHome=api_test+"course-mobile/get-course-by-active-flag?page=";//0&size=10&courseActiveFlag=1

    public static String designAndPrograming_Request=api_test+"customer-request-mobile/create-design-programming-request";//

    public static String seanaRequest=api_test+"customer-request-mobile/create-maintenance-support-request";//

    public static String photo3dRequest=api_test+"customer-request-mobile/create-three-dimensional-imaging-request";//

    public static String course_favoret=api_test+"course-mobile/get-all-favourite-courses?courseFavouriteFlag=1";//


    public static String offers=api_test+"offers-mobile/list?page=";//

    public static String machen_myrequest=api_test+"request-item-mobile/get-customer-item-orders?sparePartsFlag=0&page=";//
    public static String pice_machen_myrequest=api_test+"request-item-mobile/get-customer-item-orders?sparePartsFlag=1&page=";//
    public static String cource_machen_myrequest=api_test+"course-mobile/get-user-courses?page=";//
//    public static String cource_machen_myrequest=api_test+"course-mobile/get-user-courses?page=0&size=10";//

    public static String service_machen_myrequest=api_test+"customer-request-mobile/get-customer-requests?page=";//

    public static String dataUser=api_test+"users/get-logged-in-info";//



    public static String changepassword=api_test+"auth/change-password";//


    public static String uplodeImageProfile=api_test+"users/upload-user-profile-image?securityId=";//


 public static String  send_reqestCours_promocde=api_test+"course-reservation-mobile/register-course";
 public static String  totalCouponValue=api_test+"request-item-mobile/get-total-coupon-value";


 public static String  sendConntactUs=api_test+"contact-us/new";

 public static String  sendUpdateprofile=api_test+"users/update";


 public static String  Seana_get_Offer=api_test+"customer-request-mobile/get-service-request-type-offer?serviceRequestTypeId=";




}
