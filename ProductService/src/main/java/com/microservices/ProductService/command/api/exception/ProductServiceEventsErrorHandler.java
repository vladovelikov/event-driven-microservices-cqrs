package com.microservices.ProductService.command.api.exception;

import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.EventMessageHandler;
import org.axonframework.eventhandling.ListenerInvocationErrorHandler;

import javax.annotation.Nonnull;

public class ProductServiceEventsErrorHandler implements ListenerInvocationErrorHandler {

    @Override
    public void onError(@Nonnull Exception exception, @Nonnull EventMessage<?> eventMessage, @Nonnull EventMessageHandler eventMessageHandler) throws Exception {
        throw exception;
    }
}
