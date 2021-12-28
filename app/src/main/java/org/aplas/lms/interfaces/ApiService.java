package org.aplas.lms.interfaces;

import org.aplas.lms.configs.Constants;
import org.aplas.lms.requests.auths.LoginRequest;
import org.aplas.lms.requests.auths.RegisterRequest;
import org.aplas.lms.requests.courses.AddCourseRequest;
import org.aplas.lms.responses.auths.LoginResponse;
import org.aplas.lms.responses.auths.LogoutResponse;
import org.aplas.lms.responses.auths.RegisterResponse;
import org.aplas.lms.responses.courses.CourseResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    // Auth

    @POST(Constants.LOGIN_URL)
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST(Constants.LOGOUT_URL)
    Call<LogoutResponse> logout();

    @POST(Constants.REGISTER_URL)
    Call<RegisterResponse> register(@Body RegisterRequest request);

    // Course

    @POST(Constants.CREATE_COURSE_URL)
    Call<CourseResponse> create_course(@Body AddCourseRequest request);

    @GET(Constants.GET_ALL_COURSE_URL)
    Call<CourseResponse> get_all_course();

    @GET(Constants.GET_COURSE_BY_ID_USER_URL)
    Call<CourseResponse> get_course_by_id_user();

    // Attendance

//    @POST(Constants.CREATE_ATTENDANCE_URL)
//    Call<AddShopResponse> create_shop(@Body AddShopRequest request);
//
//    @GET(Constants.GET_SHOP_BY_USER_ID)
//    Call<GetShopByUserIdResponse> get_shop_by_user_id();
//
//    @POST(Constants.UPDATE_SHOP)
//    Call<UpdateShopResponse> update_shop(@Path("id") int id,
//                                         @Body UpdateShopRequest request);
//
//
//    // Attendances
//
//    @POST(Constants.CREATE_PRODUCT)
//    Call<AddProductResponse> create_product(@Body AddProductRequest request);
//
//    @GET(Constants.GET_PRODUCT_BY_SHOP_ID)
//    Call<List<GetProductByShopIdResponse>> get_product_by_shop_id();
//
//    @POST(Constants.UPDATE_PRODUCT)
//    Call<UpdateProductResponse> update_product(@Body UpdateProductRequest request);

}
