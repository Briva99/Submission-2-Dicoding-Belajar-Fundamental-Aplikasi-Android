package example.com.submission2githubuser.retrofit;



import java.util.List;

import example.com.submission2githubuser.model.DetailUserModel;
import example.com.submission2githubuser.model.FollowerModel;
import example.com.submission2githubuser.model.FollowingModel;
import example.com.submission2githubuser.model.ResponseUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 94e8c43ebed968020e23a9eff39999fc8f08ab5f")
    Call<ResponseUser> getSearchUser(
            @Query("q") String username
    );

    @GET("users/{username}")
    @Headers("Authorization: token 94e8c43ebed968020e23a9eff39999fc8f08ab5f")
    Call<DetailUserModel> getDetailUser(
            @Path("username") String username
    );

    @GET("users/{username}/followers")
    @Headers("Authorization: token 94e8c43ebed968020e23a9eff39999fc8f08ab5f")
    //<list> soalnya modelnya dibungkus array karena data ne banyak
    Call<List<FollowerModel>> getFollowerUser(
            @Path("username") String username
    );

    @GET("users/{username}/following")
    @Headers("Authorization: token 94e8c43ebed968020e23a9eff39999fc8f08ab5f")
    Call<List<FollowingModel>> getFollowingUser(
            @Path("username") String username
    );
}
