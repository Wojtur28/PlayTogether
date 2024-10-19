/*
package org.example.playtogether.resolver;

import graphql.kickstart.annotations.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.example.playtogether.core.entities.user.UserEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class CustomGraphQLResolver implements GraphQLQueryResolver {


    public UserEntity yourQuery(DataFetchingEnvironment environment) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();

            return UserEntity.getDataForUser(username);
        } else {

            throw new AccessDeniedException("You are not authorized to access this resource.");
        }
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
*/
