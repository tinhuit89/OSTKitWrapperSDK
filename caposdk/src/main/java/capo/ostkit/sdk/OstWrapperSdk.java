package capo.ostkit.sdk;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import capo.ostkit.sdk.service.VolleyRequestCallback;
import capo.ostkit.sdk.volley.OstKitRequest;

/**
 * Created by TinhVC on 5/16/18.
 */

public class OstWrapperSdk {
    private Context mContext;
    private String mApiKey;
    private String mSecret;

    /*Define url request*/
    public static final String BASE_URL = "https://playgroundapi.ost.com";
    public static final String USER_CREATE = "/users/create";
    public static final String USER_EDIT = "/users/edit";
    public static final String USER_LIST = "/users/list";
    public static final String USER_AIRDROP_DROP = "/users/airdrop/drop";
    public static final String USER_AIRDROP_STATUS = "/users/airdrop/status";
    public static final String TRANSACTION_TYPE_CREATE = "/transaction-types/create";
    public static final String TRANSACTION_TYPE_EDIT = "/transaction-types/edit";
    public static final String TRANSACTION_TYPE_LIST = "/transaction-types/list";
    public static final String TRANSACTION_TYPE_EXECUTE = "/transaction-types/execute";
    public static final String TRANSACTION_TYPE_STATUS = "/transaction-types/status";

    public OstWrapperSdk(Context context, String apiKey, String secret) {
        this.mContext = context;
        this.mApiKey = apiKey;
        this.mSecret = secret;
    }

    public String getApiKey() {
        return mApiKey;
    }

    public String getSecret() {
        return mSecret;
    }

    public OstKitRequest createRequest(String endPoint, Map<String, String> params) {
        OstKitRequest ostKitRequest = new OstKitRequest(mContext, getApiKey(), getSecret(), endPoint, params, BASE_URL);
        return ostKitRequest;
    }

}
