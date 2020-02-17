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
package org.apache.unomi.graphql.propertytypes;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.annotations.annotationTypes.GraphQLPrettify;

import java.util.List;

@GraphQLName("CDP_PropertyInterface")
public class CDPPropertyType {

    private String id;
    private String name;
    private Integer minOccurrences;
    private Integer maxOccurrences;
    private List<String> tags;
    private List<String> systemTags;
    private Boolean personalData;

    public CDPPropertyType(@GraphQLName("id") String id,
                           @GraphQLName("name") String name,
                           @GraphQLName("minOccurrences") Integer minOccurrences,
                           @GraphQLName("maxOccurrences") Integer maxOccurrences,
                           @GraphQLName("tags") List<String> tags,
                           @GraphQLName("systemTags") List<String> systemTags,
                           @GraphQLName("personalData") Boolean personalData) {
        this.id = id;
        this.name = name;
        this.minOccurrences = minOccurrences;
        this.maxOccurrences = maxOccurrences;
        this.tags = tags;
        this.systemTags = systemTags;
        this.personalData = personalData;
    }

    public CDPPropertyType(CDPPropertyType input) {
        this.id = input.id;
        this.name = input.name;
        this.minOccurrences = input.minOccurrences;
        this.maxOccurrences = input.maxOccurrences;
        this.tags = input.tags;
        this.systemTags = input.systemTags;
        this.personalData = input.personalData;
    }

    @GraphQLField
    @GraphQLPrettify
    public String getId() {
        return id;
    }

    @GraphQLField
    @GraphQLPrettify
    public String getName() {
        return name;
    }

    @GraphQLField
    @GraphQLPrettify
    public Integer getMinOccurrences() {
        return minOccurrences;
    }

    @GraphQLField
    @GraphQLPrettify
    public Integer getMaxOccurrences() {
        return maxOccurrences;
    }

    @GraphQLField
    @GraphQLPrettify
    public List<String> getTags() {
        return tags;
    }

    @GraphQLField
    @GraphQLPrettify
    public List<String> getSystemTags() {
        return systemTags;
    }

    @GraphQLField
    @GraphQLPrettify
    public Boolean isPersonalData() {
        return personalData;
    }

    public String getCDPPropertyType() {
        return "string";
    }

}
