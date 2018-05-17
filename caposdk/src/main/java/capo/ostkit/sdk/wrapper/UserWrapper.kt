package capo.ostkit.sdk.wrapper;

import android.content.Context
import capo.ostkit.sdk.service.VolleyRequestCallback
import capo.ostkit.sdk.utils.Utilities
import java.time.temporal.TemporalAmount

/**
 * Created by TinhVC on 5/17/18.
 */

class UserWrapper(_context: Context, _apiKey: String, _secret: String, _baseUrl: String) : OpenWrapper() {

    init {
        this.context = _context
        this.apiKey = _apiKey
        this.secret = _secret
        this.baseUrl = _baseUrl
    }

    /*
    * Post to /users/create to register a new user and obtain a unique
    * identifier to interact with the created user within your application.
    * A user can own branded tokens within your branded token economy.
    * Users can exchange branded tokens within your application through transaction types.
    * Users also hold an airdrop token balance, which consists of tokens the company
    * awards to the user to spend within the economy.
    * */
    fun createUser(name: String, callBack: VolleyRequestCallback) {
        this.endPoint = OstWrapperSdk.USER_CREATE
        val mRequestTimestamp = Utilities.getTimestamp()
        params.put("name", name)
        params.put("request_timestamp", mRequestTimestamp)
        params.put("api_key", apiKey)

        var stringToSign = Utilities.generateQueryString(endPoint, params)
        var apiSignature = Utilities.generateApiSignature(stringToSign, secret)
        params.put("signature", apiSignature)
        this.execute(callBack)
    }

    /* Post to /users/edit to edit an existing user for
    * a given unique identifier within the application.
    * A user can own branded tokens within your branded token economy.
    * Users can exchange branded tokens within your application through transaction types.
    * Users also hold an airdrop token balance, which consists of tokens the company
    * awards to the user to spend within the economy.
    * */
    fun editUser(uuid: String, name: String, callBack: VolleyRequestCallback) {
        this.endPoint = OstWrapperSdk.USER_EDIT
        val mRequestTimestamp = Utilities.getTimestamp()
        params.put("name", name)
        params.put("uuid", uuid)
        params.put("request_timestamp", mRequestTimestamp)
        params.put("api_key", apiKey)

        var stringToSign = Utilities.generateQueryString(endPoint, params)
        var apiSignature = Utilities.generateApiSignature(stringToSign, secret)
        params.put("signature", apiSignature)
        this.execute(callBack)
    }

    /*
    * Send a GET request on /users/list to receive a paginated
    * - optionally filtered - ordered array of users within the economy.
    * A user can own branded tokens within your branded token economy.
    * Users can exchange branded tokens within your application through transaction types.
    * Users also hold an airdrop token balance, which consists of tokens the company
    * awards to the user to spend within the economy.
    * */
    @JvmOverloads
    fun getListUser(pageNumber: Int, callBack: VolleyRequestCallback, filter: String = "all", orderBy: String = "creation_time", order: String = "asc") {
        this.endPoint = OstWrapperSdk.USER_LIST
        val mRequestTimestamp = Utilities.getTimestamp()
        params.put("page_no", pageNumber.toString())
        params.put("filter", filter)
        params.put("order_by", orderBy)
        params.put("order", order)
        params.put("request_timestamp", mRequestTimestamp)
        params.put("api_key", apiKey)

        var stringToSign = Utilities.generateQueryString(endPoint, params)
        var apiSignature = Utilities.generateApiSignature(stringToSign, secret)
        params.put("signature", apiSignature)
        this.execute(callBack)
    }

    /*
    * Post to /users/airdrop/drop to request an airdrop of a
    * certain amount of branded tokens to a set of users.
    * This API allows end-users to receive or be awarded a selected amount
    * of branded tokens to be able participate in the branded token economy.
    * */
    @JvmOverloads
    fun drop(amount: String, callBack: VolleyRequestCallback, listType: String = "never_airdropped") {
        this.endPoint = OstWrapperSdk.USER_AIRDROP_DROP
        val mRequestTimestamp = Utilities.getTimestamp()
        params.put("amount", amount)
        params.put("list_type", listType) // optional: all/never_airdropped
        params.put("request_timestamp", mRequestTimestamp)
        params.put("api_key", apiKey)

        var stringToSign = Utilities.generateQueryString(endPoint, params)
        var apiSignature = Utilities.generateApiSignature(stringToSign, secret)
        params.put("signature", apiSignature)
        this.execute(callBack)
    }

    /*
    * Send a GET request to /users/airdrop/status to receive the airdrop status.
    * Get the status of the airdrop of branded tokens.
    * This API can be used to understand which stage the
    * processing of airdropping the tokens are going through.
    * */
    fun dropStatus(airDropUuid: String, callBack: VolleyRequestCallback) {
        this.endPoint = OstWrapperSdk.USER_AIRDROP_DROP
        val mRequestTimestamp = Utilities.getTimestamp()
        params.put("airdrop_uuid", airDropUuid)
        params.put("request_timestamp", mRequestTimestamp)
        params.put("api_key", apiKey)

        var stringToSign = Utilities.generateQueryString(endPoint, params)
        var apiSignature = Utilities.generateApiSignature(stringToSign, secret)
        params.put("signature", apiSignature)
        this.execute(callBack)
    }
}