/*
 * Copyright 2014 - 2019 Blazebit.
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

package com.blazebit.persistence.view.impl.metamodel;

import com.blazebit.persistence.view.CTEProvider;
import com.blazebit.persistence.view.FlushMode;
import com.blazebit.persistence.view.FlushStrategy;
import com.blazebit.persistence.view.LockMode;
import com.blazebit.persistence.view.metamodel.ManagedViewType;
import com.blazebit.persistence.view.metamodel.MappingConstructor;
import com.blazebit.persistence.view.metamodel.MethodAttribute;
import com.blazebit.persistence.view.spi.type.TypeConverter;

import javax.persistence.metamodel.ManagedType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;

/**
 * @author Christian Beikov
 * @since 1.2.0
 */
public class ConvertedFlatViewType<X> implements FlatViewTypeImplementor<X> {

    private final FlatViewTypeImplementor<X> delegate;
    private final Type convertedType;
    private final TypeConverter<?, X> converter;

    public ConvertedFlatViewType(FlatViewTypeImplementor<X> delegate, Type convertedType, TypeConverter<?, X> converter) {
        this.delegate = delegate;
        this.convertedType = convertedType;
        this.converter = converter;
    }

    @Override
    public Type getConvertedType() {
        return convertedType;
    }

    @Override
    public TypeConverter<?, X> getConverter() {
        return converter;
    }

    @Override
    public FlatViewTypeImplementor<X> getRealType() {
        return delegate;
    }
    // Delegating methods

    @Override
    public MappingType getMappingType() {
        return delegate.getMappingType();
    }

    @Override
    public void checkAttributes(MetamodelBuildingContext context) {
        delegate.checkAttributes(context);
    }

    @Override
    public void checkNestedAttributes(List<AbstractAttribute<?, ?>> parents, MetamodelBuildingContext context) {
        delegate.checkNestedAttributes(parents, context);
    }

    @Override
    public LockMode getLockMode() {
        return delegate.getLockMode();
    }

    @Override
    public NavigableMap<String, AbstractMethodAttribute<? super X, ?>> getRecursiveAttributes() {
        return delegate.getRecursiveAttributes();
    }

    @Override
    public NavigableMap<String, AbstractMethodAttribute<? super X, ?>> getRecursiveSubviewAttributes() {
        return delegate.getRecursiveSubviewAttributes();
    }

    @Override
    public Set<AbstractMethodAttribute<? super X, ?>> getUpdateMappableAttributes() {
        return delegate.getUpdateMappableAttributes();
    }

    @Override
    public Map<ManagedViewTypeImplementor<? extends X>, String> getInheritanceSubtypeConfiguration() {
        return delegate.getInheritanceSubtypeConfiguration();
    }

    @Override
    public boolean hasEmptyConstructor() {
        return delegate.hasEmptyConstructor();
    }

    @Override
    public boolean hasJoinFetchedCollections() {
        return delegate.hasJoinFetchedCollections();
    }

    @Override
    public boolean hasSubtypes() {
        return delegate.hasSubtypes();
    }

    @Override
    public boolean supportsInterfaceEquals() {
        return delegate.supportsInterfaceEquals();
    }

    @Override
    public ManagedViewTypeImpl.InheritanceSubtypeConfiguration<X> getInheritanceSubtypeConfiguration(Map<ManagedViewTypeImplementor<? extends X>, String> inheritanceSubtypeMapping) {
        return delegate.getInheritanceSubtypeConfiguration(inheritanceSubtypeMapping);
    }

    @Override
    public ManagedViewTypeImpl.InheritanceSubtypeConfiguration<X> getOverallInheritanceSubtypeConfiguration() {
        return delegate.getOverallInheritanceSubtypeConfiguration();
    }

    @Override
    public ManagedViewTypeImpl.InheritanceSubtypeConfiguration<X> getDefaultInheritanceSubtypeConfiguration() {
        return delegate.getDefaultInheritanceSubtypeConfiguration();
    }

    @Override
    public Map<Map<ManagedViewTypeImplementor<? extends X>, String>, ManagedViewTypeImpl.InheritanceSubtypeConfiguration<X>> getInheritanceSubtypeConfigurations() {
        return delegate.getInheritanceSubtypeConfigurations();
    }

    @Override
    public AbstractMethodAttribute<?, ?> getMutableAttribute(int i) {
        return delegate.getMutableAttribute(i);
    }

    @Override
    public int getMutableAttributeCount() {
        return delegate.getMutableAttributeCount();
    }

    @Override
    public Class<?> getEntityClass() {
        return delegate.getEntityClass();
    }

    @Override
    public ManagedType<?> getJpaManagedType() {
        return delegate.getJpaManagedType();
    }

    @Override
    public int getDefaultBatchSize() {
        return delegate.getDefaultBatchSize();
    }

    @Override
    public Set<MethodAttribute<? super X, ?>> getAttributes() {
        return delegate.getAttributes();
    }

    @Override
    public MethodAttribute<? super X, ?> getAttribute(String name) {
        return delegate.getAttribute(name);
    }

    @Override
    public Set<MappingConstructor<X>> getConstructors() {
        return delegate.getConstructors();
    }

    @Override
    public MappingConstructor<X> getConstructor(Class<?>... parameterTypes) {
        return delegate.getConstructor(parameterTypes);
    }

    @Override
    public Set<String> getConstructorNames() {
        return delegate.getConstructorNames();
    }

    @Override
    public MappingConstructor<X> getConstructor(String name) {
        return delegate.getConstructor(name);
    }

    @Override
    public String getInheritanceMapping() {
        return delegate.getInheritanceMapping();
    }

    @Override
    public Set<ManagedViewType<? extends X>> getInheritanceSubtypes() {
        return delegate.getInheritanceSubtypes();
    }

    @Override
    public int getSubtypeIndex(ManagedViewTypeImplementor<? super X> inheritanceBase) {
        return delegate.getSubtypeIndex(inheritanceBase);
    }

    @Override
    public boolean isUpdatable() {
        return delegate.isUpdatable();
    }

    @Override
    public boolean isCreatable() {
        return delegate.isCreatable();
    }

    @Override
    public Method getPostCreateMethod() {
        return delegate.getPostCreateMethod();
    }

    @Override
    public List<Method> getSpecialMethods() {
        return delegate.getSpecialMethods();
    }

    @Override
    public Set<CTEProvider> getCteProviders() {
        return delegate.getCteProviders();
    }

    @Override
    public FlushMode getFlushMode() {
        return delegate.getFlushMode();
    }

    @Override
    public FlushStrategy getFlushStrategy() {
        return delegate.getFlushStrategy();
    }

    @Override
    public boolean isPersistabilityValidationEnabled() {
        return delegate.isPersistabilityValidationEnabled();
    }

    @Override
    public Set<String> getPersistabilityValidationExcludedEntityAttributes() {
        return delegate.getPersistabilityValidationExcludedEntityAttributes();
    }

    @Override
    public Class<X> getJavaType() {
        return delegate.getJavaType();
    }
}
