package com.br.uol.produtos.painel.service.gateway.domain.model.microsoft.subscription

enum class SubscriptionState {

    PROVISION_PENDING,
    ORDER_PENDING,
    ACTIVE,
    DISABLED,
    DEPROVISIONED,
    GRACE_PERIOD;

    fun value(): String {
        return this.name
    }
}