/*
package org.example.playtogether.interceptor;

import graphql.language.Document;
import graphql.language.OperationDefinition;
import graphql.parser.Parser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.playtogether.config.security.JwtTokenProvider;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class RequestHeaderInterceptor implements WebGraphQlInterceptor {

    JwtTokenProvider jwtTokenProvider;

    @Override
    public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {
        String operationName = request.getOperationName();
        String document = request.getDocument();

        Document parsedDocument = Parser.parse(document);

        Optional<OperationDefinition> operation = parsedDocument.getDefinitions().stream()
                .filter(def -> def instanceof OperationDefinition)
                .map(def -> (OperationDefinition) def)
                .filter(opDef -> {
                    // If operationName is null, use the first operation in the document
                    if (operationName == null) {
                        return true;
                    } else {
                        return opDef.getName() != null && opDef.getName().equals(operationName);
                    }
                })
                .findFirst();

        if (operation.isPresent()) {
            OperationDefinition opDef = operation.get();
            OperationDefinition.Operation operationType = opDef.getOperation();
            String operationDefName = opDef.getName();

            if (operationDefName == null) {
                return Mono.error(new RuntimeException("Operation name is required."));
            }

            if (operationType == OperationDefinition.Operation.MUTATION &&
                    (operationDefName.equals("Login") || operationDefName.equals("Register"))) {
                return chain.next(request);
            }
        } else {
            return Mono.error(new RuntimeException("Invalid operation."));
        }

        if (document.contains("__schema") || document.contains("__type")) {
            return chain.next(request);
        }

        String bearerToken = request.getHeaders().getFirst("Authorization");
        log.debug("Authorization Header: {}", bearerToken);

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            if (jwtTokenProvider.validateToken(bearerToken)) {
                return chain.next(request);
            } else {
                return Mono.error(new RuntimeException("Invalid credentials"));
            }
        } else {
            return Mono.error(new RuntimeException("Invalid credentials"));
        }
    }

    @Override
    public WebGraphQlInterceptor andThen(WebGraphQlInterceptor nextInterceptor) {
        return WebGraphQlInterceptor.super.andThen(nextInterceptor);
    }

    @Override
    public Chain apply(Chain chain) {
        return WebGraphQlInterceptor.super.apply(chain);
    }
}
*/
