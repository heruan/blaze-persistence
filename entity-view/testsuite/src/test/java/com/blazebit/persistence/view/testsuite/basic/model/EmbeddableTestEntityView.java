/*
 * Copyright 2014 Blazebit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blazebit.persistence.view.testsuite.basic.model;

import java.util.Map;
import java.util.Set;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.Mapping;
import com.blazebit.persistence.view.testsuite.entity.EmbeddableTestEntity;
import com.blazebit.persistence.view.testsuite.entity.EmbeddableTestEntityId;
import com.blazebit.persistence.view.testsuite.entity.IntIdEntity;

/**
 *
 * @author Christian Beikov
 * @since 1.0
 */
@EntityView(EmbeddableTestEntity.class)
public interface EmbeddableTestEntityView extends IdHolderView<EmbeddableTestEntityId> {

    @Mapping("id.intIdEntity")
    public IntIdEntity getIdIntIdEntity();
    
    @Mapping("id.intIdEntity.id")
    public Integer getIdIntIdEntityId();
    
    @Mapping("id.intIdEntity.name")
    public String getIdIntIdEntityName();
    
    @Mapping("id.key")
    public String getIdKey();

    @Mapping("embeddable")
    public EmbeddableTestEntityEmbeddableSubView getEmbeddable();

    @Mapping("embeddableSet")
    public Set<EmbeddableTestEntitySimpleEmbeddableSubView> getEmbeddableSet();

    @Mapping("embeddableMap")
    public Map<String, EmbeddableTestEntitySimpleEmbeddableSubView> getEmbeddableMap();

    @Mapping("embeddable.manyToOne")
    public EmbeddableTestEntity getEmbeddableManyToOne();

    @Mapping("embeddable.oneToMany")
    public Set<EmbeddableTestEntity> getEmbeddableOneToMany();

    @Mapping("embeddable.elementCollection")
    public Map<String, IntIdEntity> getEmbeddableElementCollection();
}