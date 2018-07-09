package henryfebryan.com.retrofit;

import henryfebryan.com.retrofit.pojo.MultipleResource;
import henryfebryan.com.retrofit.pojo.User;
import henryfebryan.com.retrofit.pojo.UserList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface APIInterface {

    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();
    /*
            - @GET("/api/unknown") calls doGetListResources();.
            - doGetListResources() is the method name.
              MultipleResource.java is a Model POJO class
              for our response object that’s used to map the response parameters to their respective variables.
              These POJO class act as the method return type.
    */

    @POST("/api/users")
    Call<User> createUser(@Body User user); //@Body – Sends Java objects as request body.

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);
    /*
        We can simply add a method parameter with @Query() and a query parameter name, describing the type.
        To URL encode a query use the form:
        @Query(value = "auth_token",encoded = true) String auth_token
     */

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
    /*
        ~ @Field – send data as form-urlencoded. This requires a @FormUrlEncoded annotation attached with the method.
        ~ *(The @Field parameter works only with a POST)*
     */

    /*
    Note:
        - @Field requires a mandatory parameter.
        - In cases when @Field is optional, we can use @Query instead and pass a null value.
     */
}
