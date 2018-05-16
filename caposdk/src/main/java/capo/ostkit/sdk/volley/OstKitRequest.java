package capo.ostkit.sdk.volley;

import android.content.Context;

import com.android.volley.Request;

import java.util.Map;
import java.util.TreeMap;

import capo.ostkit.sdk.OstWrapperSdk;
import capo.ostkit.sdk.service.VolleyRequestCallback;
import capo.ostkit.sdk.service.VolleyRequestQueue;
import capo.ostkit.sdk.utils.Logger;
import capo.ostkit.sdk.utils.Utilities;

/**
 * Created by TinhVC on 5/16/18.
 */

public class OstKitRequest {
    private Context mContext;
    private String mApiKey;
    private String mSecret;
    private String mRequestTimestamp = "0";
    private String mEndPoint = "";
    private String mBaseUrl = "";
    private String mStringToSign = "";
    private String mApiSignature = "";
    private Map<String, String> mParams;


    public OstKitRequest(Context context, String apiKey, String secret, String endPoint, Map<String, String> params, String baseUrl) {
        this.mContext = context;
        this.mApiKey = apiKey;
        this.mSecret = secret;
        this.mEndPoint = endPoint;
        this.mBaseUrl = baseUrl;
        this.mParams = params;
        this.mRequestTimestamp = Utilities.getTimestamp();
//        this.mRequestTimestamp = "1526459602";
        this.mParams.put("request_timestamp", mRequestTimestamp);
        this.mParams.put("api_key", mApiKey);
        this.generateQueryString();
        this.generateApiSignature();
    }

    public void generateQueryString() {
        // TreeMap to store values of HashMap
        TreeMap<String, String> sorted = new TreeMap<>(mParams);

        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            if (mStringToSign.equalsIgnoreCase("")) {
                mStringToSign = mEndPoint + "?" + entry.getKey().toLowerCase() + "=" + (entry.getValue().toString().replace(" ", "+"));
            } else {
                mStringToSign += "&" + entry.getKey().toLowerCase() + "=" + (entry.getValue().toString().replace(" ", "+"));
            }
        }
        Logger.log("QueryString: " + mStringToSign);
    }

    public void generateApiSignature() {
        mApiSignature = Utilities.hmacDigest(mStringToSign, mSecret, "HmacSHA256");
        Logger.log("ApiSignature: " + mApiSignature);
        mParams.put("signature", mApiSignature);
    }

    public int getMethod() {
        switch (mEndPoint) {
            case OstWrapperSdk.USER_CREATE:
                return Request.Method.POST;
            case OstWrapperSdk.USER_EDIT:
                return Request.Method.POST;
            case OstWrapperSdk.USER_LIST:
                return Request.Method.GET;
            case OstWrapperSdk.USER_AIRDROP_DROP:
                return Request.Method.POST;
            case OstWrapperSdk.USER_AIRDROP_STATUS:
                return Request.Method.GET;
            case OstWrapperSdk.TRANSACTION_TYPE_CREATE:
                return Request.Method.POST;
            case OstWrapperSdk.TRANSACTION_TYPE_EDIT:
                return Request.Method.POST;
            case OstWrapperSdk.TRANSACTION_TYPE_LIST:
                return Request.Method.GET;
            case OstWrapperSdk.TRANSACTION_TYPE_EXECUTE:
                return Request.Method.POST;
            case OstWrapperSdk.TRANSACTION_TYPE_STATUS:
                return Request.Method.POST;
            default:
                return -1;
        }
    }

    public void execute(VolleyRequestCallback callback) {
        Map<String, String> paramSorted = new TreeMap<>(mParams);
        int method = getMethod();
        String url = "";

        if (method == Request.Method.GET) {
            for (Map.Entry<String, String> entry : paramSorted.entrySet()) {
                if (url.equalsIgnoreCase("")) {
                    url = OstWrapperSdk.BASE_URL + mEndPoint + "?" + entry.getKey() + "=" + entry.getValue();
                } else {
                    url += "&" + entry.getKey() + "=" + entry.getValue();
                }
            }
        } else {
            url = OstWrapperSdk.BASE_URL + mEndPoint;
        }
        new VolleyRequestQueue(mContext, getMethod(), url, paramSorted, callback);
    }
}
