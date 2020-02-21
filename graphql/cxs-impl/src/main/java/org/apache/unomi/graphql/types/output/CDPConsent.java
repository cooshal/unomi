/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.unomi.graphql.types.output;

import graphql.annotations.annotationTypes.GraphQLDataFetcher;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLID;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.annotations.annotationTypes.GraphQLNonNull;
import graphql.annotations.annotationTypes.GraphQLPrettify;
import org.apache.unomi.api.Consent;
import org.apache.unomi.graphql.fetchers.consent.ConsentEventConnectionDataFetcher;

import java.util.Date;

@GraphQLName("CDP_Consent")
public class CDPConsent {

    @GraphQLID
    @GraphQLField
    @GraphQLNonNull
    private String token;
    private CDPSource source;
    private CDPClient client = CDPClient.DEFAULT;
    private String type;
    private CDPConsentStatus status;
    private Date lastUpdate;
    private Date expiration;
    private CDPProfileInterface profile;

    public CDPConsent(String token, Consent consent) {
        this.token = token;
        source = new CDPSource(consent.getScope());
        type = consent.getTypeIdentifier();
        status = CDPConsentStatus.from(consent.getStatus());
        lastUpdate = consent.getStatusDate();
        expiration = consent.getRevokeDate();
//        TODO: CDPProfile contains list of CDPConsents, resulting a circular dependency
//        profile = builder.profile;
    }

    public String getToken() {
        return token;
    }

    public CDPSource getSource() {
        return source;
    }

    public CDPClient getClient() {
        return client;
    }

    public String getType() {
        return type;
    }

    public CDPConsentStatus getStatus() {
        return status;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Date getExpiration() {
        return expiration;
    }

    public CDPProfileInterface getProfile() {
        return profile;
    }

    @GraphQLField
    @GraphQLPrettify
    @GraphQLDataFetcher(ConsentEventConnectionDataFetcher.class)
    public CDPEventConnection getEvents() {
        return null;
    }
}
