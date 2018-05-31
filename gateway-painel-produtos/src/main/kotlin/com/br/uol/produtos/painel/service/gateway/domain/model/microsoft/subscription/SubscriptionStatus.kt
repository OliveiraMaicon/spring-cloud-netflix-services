package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.subscription


/**
 * Enum para representar os status possiveis de uma assinatura no CSP
 * @author ggarcia
 * @see https://msdn.microsoft.com/en-us/library/partnercenter/microsoft.partner.sdk.models.subscriptions.subscriptionstatus.aspx
 */
enum class SubscriptionStatus(val subscriptionState: SubscriptionState?) {

    NONE(null),
    INACTIVE(SubscriptionState.DEPROVISIONED),
    ACTIVE(SubscriptionState.ACTIVE),
    SUSPENDED(SubscriptionState.DISABLED)

}
