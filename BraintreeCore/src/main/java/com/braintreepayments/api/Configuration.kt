package com.braintreepayments.api

import androidx.annotation.RestrictTo
import com.braintreepayments.api.sharedutils.Json
import org.json.JSONException
import org.json.JSONObject

/**
 * Contains the remote configuration for the Braintree Android SDK.
 *
 * @property assetsUrl The assets URL of the current environment.
 * @property cardinalAuthenticationJwt the JWT for Cardinal
 * @property clientApiUrl The url of the Braintree client API for the current environment.
 * @property environment The current environment.
 * @property isCvvChallengePresent `true` if cvv is required for card transactions, `false`
 * otherwise.
 * @property isGooglePayEnabled `true` if Google Payment is enabled and supported in the current
 * environment; `false` otherwise.
 * @property isLocalPaymentEnabled `true` if Local Payment is enabled for the merchant account;
 * `false` otherwise.
 * @property isPayPalEnabled `true` if PayPal is enabled and supported in the current environment,
 * `false` otherwise.
 * @property isPostalCodeChallengePresent `true` if postal code is required for card transactions,
 * `false` otherwise.
 * @property isThreeDSecureEnabled `true` if 3D Secure is enabled and supported for the current
 * merchant account, * `false` otherwise.
 * @property isVenmoEnabled `true` if Venmo is enabled for the merchant account; `false` otherwise.
 * @property isVisaCheckoutEnabled `true` if Visa Checkout is enabled for the merchant account;
 * `false` otherwise.
 * @property merchantAccountId the current Braintree merchant account id.
 * @property merchantId the current Braintree merchant id.
 * @property payPalDirectBaseUrl the url for custom PayPal environments.
 * @property payPalPrivacyUrl the PayPal app privacy url.
 * @property payPalUserAgreementUrl the PayPal app user agreement url.
 * @property supportedCardTypes a list of card types supported by the merchant.
 */
class Configuration internal constructor(configurationString: String) {

    /**
     * @suppress
     */
    companion object {
        private const val ASSETS_URL_KEY = "assetsUrl"
        private const val BRAINTREE_API_KEY = "braintreeApi"
        private const val CARDINAL_AUTHENTICATION_JWT = "cardinalAuthenticationJWT"
        private const val CARD_KEY = "creditCards"
        private const val CHALLENGES_KEY = "challenges"
        private const val CLIENT_API_URL_KEY = "clientApiUrl"
        private const val ENVIRONMENT_KEY = "environment"
        private const val GOOGLE_PAY_KEY = "androidPay"
        private const val GRAPHQL_KEY = "graphQL"
        private const val MERCHANT_ACCOUNT_ID_KEY = "merchantAccountId"
        private const val MERCHANT_ID_KEY = "merchantId"
        private const val PAYPAL_ENABLED_KEY = "paypalEnabled"
        private const val PAYPAL_KEY = "paypal"
        private const val PAY_WITH_VENMO_KEY = "payWithVenmo"
        private const val THREE_D_SECURE_ENABLED_KEY = "threeDSecureEnabled"
        private const val VISA_CHECKOUT_KEY = "visaCheckout"

        @JvmStatic
        @Throws(JSONException::class)
        @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
        fun fromJson(configurationString: String): Configuration {
            return Configuration(configurationString)
        }
    }

    // region Public Properties
    val assetsUrl: String
    val cardinalAuthenticationJwt: String?
    val clientApiUrl: String
    val environment: String
    val isCvvChallengePresent: Boolean
    val isGooglePayEnabled: Boolean
    val isLocalPaymentEnabled: Boolean
    val isPayPalEnabled: Boolean
    val isPostalCodeChallengePresent: Boolean
    val isThreeDSecureEnabled: Boolean
    val isVenmoEnabled: Boolean
    val isVisaCheckoutEnabled: Boolean
    val merchantAccountId: String?
    val merchantId: String
    val payPalDirectBaseUrl: String?
    val payPalPrivacyUrl: String?
    val payPalUserAgreementUrl: String?
    val supportedCardTypes: List<String>
    // endregion

    // region Internal Properties

    /**
     * @return The Access Token for Braintree API.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val braintreeApiAccessToken: String

    /**
     * @return the base url for accessing Braintree API.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val braintreeApiUrl: String

    /**
     * @return the authorization fingerprint to use for Google Payment, only allows tokenizing
     * Google Payment cards.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val googlePayAuthorizationFingerprint: String?

    /**
     * @return the Google Pay display name to show to the user.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val googlePayDisplayName: String

    /**
     * @return the current Google Pay environment.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val googlePayEnvironment: String?

    /**
     * @return the PayPal Client ID used by Google Pay.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val googlePayPayPalClientId: String

    /**
     * @return a list of supported card networks for Google Pay.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val googlePaySupportedNetworks: List<String>

    /**
     * @return the GraphQL url.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val graphQLUrl: String

    /**
     * @return a boolean indicating whether Braintree API is enabled for this merchant.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val isBraintreeApiEnabled: Boolean

    /**
     * @return `true` if fraud device data collection should occur; `false` otherwise.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val isFraudDataCollectionEnabled: Boolean

    /**
     * @return `true` if GraphQL is enabled for the merchant account; `false` otherwise.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val isGraphQLEnabled: Boolean

    /**
     * @return `true` if PayPal touch is currently disabled, `false` otherwise.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val isPayPalTouchDisabled: Boolean

    /**
     * @return the PayPal app client id.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val payPalClientId: String?

    /**
     * @return the PayPal currency code.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val payPalCurrencyIsoCode: String?

    /**
     * @return the PayPal app display name.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val payPalDisplayName: String?

    /**
     * @return the current environment for PayPal.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val payPalEnvironment: String?

    /**
     * @return the Access Token used by the Venmo app to tokenize on behalf of the merchant.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val venmoAccessToken: String

    /**
     * @return the Venmo environment used to handle this payment.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val venmoEnvironment: String

    /**
     * @return the Venmo merchant id used by the Venmo app to authorize payment.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val venmoMerchantId: String

    /**
     * @return a boolean indicating whether ECD is enabled for this Venmo merchant.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val venmoEnrichedCustomerDataEnabled: Boolean

    /**
     * @return the Visa Checkout API key configured in the Braintree Control Panel.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val visaCheckoutApiKey: String

    /**
     * @return the Visa Checkout External Client ID configured in the Braintree Control Panel.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val visaCheckoutExternalClientId: String

    /**
     * @return the Visa Checkout supported networks enabled for the merchant account.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP) val visaCheckoutSupportedNetworks: List<String>

    private val braintreeApiConfiguration: BraintreeApiConfiguration
    private val cardConfiguration: CardConfiguration
    private val challenges: MutableSet<String>
    private val configurationString: String
    private val googlePayConfiguration: GooglePayConfiguration
    private val graphQLConfiguration: GraphQLConfiguration
    private val payPalConfiguration: PayPalConfiguration
    private val venmoConfiguration: VenmoConfiguration
    private val visaCheckoutConfiguration: VisaCheckoutConfiguration
    // endregion

    init {
        this.configurationString = configurationString
        val json = JSONObject(configurationString)
        assetsUrl = Json.optString(json, ASSETS_URL_KEY, "")
        clientApiUrl = json.getString(CLIENT_API_URL_KEY)

        // parse json challenges
        challenges = mutableSetOf()
        json.optJSONArray(CHALLENGES_KEY)?.let { challengesArray ->
            for (i in 0 until challengesArray.length()) {
                challenges.add(challengesArray.optString(i, ""))
            }
        }

        braintreeApiConfiguration = BraintreeApiConfiguration(json.optJSONObject(BRAINTREE_API_KEY))
        cardConfiguration = CardConfiguration(json.optJSONObject(CARD_KEY))
        cardinalAuthenticationJwt = Json.optString(json, CARDINAL_AUTHENTICATION_JWT, null)
        environment = json.getString(ENVIRONMENT_KEY)
        googlePayConfiguration = GooglePayConfiguration(json.optJSONObject(GOOGLE_PAY_KEY))
        graphQLConfiguration = GraphQLConfiguration(json.optJSONObject(GRAPHQL_KEY))
        isPayPalEnabled = json.optBoolean(PAYPAL_ENABLED_KEY, false)
        isThreeDSecureEnabled = json.optBoolean(THREE_D_SECURE_ENABLED_KEY, false)
        merchantAccountId = Json.optString(json, MERCHANT_ACCOUNT_ID_KEY, null)
        merchantId = json.getString(MERCHANT_ID_KEY)
        payPalConfiguration = PayPalConfiguration(json.optJSONObject(PAYPAL_KEY))
        venmoConfiguration = VenmoConfiguration(json.optJSONObject(PAY_WITH_VENMO_KEY))
        visaCheckoutConfiguration = VisaCheckoutConfiguration(json.optJSONObject(VISA_CHECKOUT_KEY))

        isCvvChallengePresent = challenges.contains("cvv")
        isGooglePayEnabled = googlePayConfiguration.isEnabled
        isLocalPaymentEnabled = isPayPalEnabled // Local Payments are enabled when PayPal is enabled
        isPostalCodeChallengePresent = challenges.contains("postal_code")
        isVenmoEnabled = venmoConfiguration.isAccessTokenValid
        isVisaCheckoutEnabled = visaCheckoutConfiguration.isEnabled
        payPalDirectBaseUrl = payPalConfiguration.directBaseUrl
        payPalPrivacyUrl = payPalConfiguration.privacyUrl
        payPalUserAgreementUrl = payPalConfiguration.userAgreementUrl

        braintreeApiAccessToken = braintreeApiConfiguration.accessToken
        braintreeApiUrl = braintreeApiConfiguration.url
        googlePayAuthorizationFingerprint = googlePayConfiguration.googleAuthorizationFingerprint
        googlePayDisplayName = googlePayConfiguration.displayName
        googlePayEnvironment = googlePayConfiguration.environment
        googlePayPayPalClientId = googlePayConfiguration.paypalClientId
        googlePaySupportedNetworks = googlePayConfiguration.supportedNetworks
        graphQLUrl = graphQLConfiguration.url
        isBraintreeApiEnabled = braintreeApiConfiguration.isEnabled
        isFraudDataCollectionEnabled = cardConfiguration.isFraudDataCollectionEnabled
        isGraphQLEnabled = graphQLConfiguration.isEnabled
        isPayPalTouchDisabled = payPalConfiguration.isTouchDisabled
        payPalClientId = payPalConfiguration.clientId
        payPalCurrencyIsoCode = payPalConfiguration.currencyIsoCode
        payPalDisplayName = payPalConfiguration.displayName
        payPalEnvironment = payPalConfiguration.environment
        supportedCardTypes = cardConfiguration.supportedCardTypes
        venmoAccessToken = venmoConfiguration.accessToken
        venmoEnvironment = venmoConfiguration.environment
        venmoMerchantId = venmoConfiguration.merchantId
        venmoEnrichedCustomerDataEnabled = venmoConfiguration.enrichedCustomerDataEnabled
        visaCheckoutApiKey = visaCheckoutConfiguration.apiKey
        visaCheckoutExternalClientId = visaCheckoutConfiguration.externalClientId
        visaCheckoutSupportedNetworks = visaCheckoutConfiguration.acceptedCardBrands
    }

    // region Public Methods
    /**
     * @return Configuration as a json [String].
     */
    fun toJson(): String {
        return configurationString
    }
    // endregion

    // region Internal Methods
    /**
     * Check if a specific feature is enabled in the GraphQL API.
     *
     * @param feature The feature to check.
     * @return `true` if GraphQL is enabled and the feature is enabled, `false` otherwise.
     * @suppress
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
    fun isGraphQLFeatureEnabled(feature: String) = graphQLConfiguration.isFeatureEnabled(feature)
    // endregion
}
