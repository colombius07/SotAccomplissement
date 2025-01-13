package nro.sot.accomplissement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.util.List;

// Interface pour l'API
public interface ApiService {

    // Récupérer la liste des promotions
    @GET("promotions")
    Call<List<String>> getPromotions();

    // Récupérer les détails d'une promotion spécifique
    @GET("promotions/{promotionName}/{detailName}")
    Call<PromotionDetail> getPromotionDetails(@Path("promotionName") String promotionName, @Path("detailName") String detailName);
}
