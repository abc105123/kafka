/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kafka.common;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The classic group state.
 */
public enum ClassicGroupState {
    UNKNOWN("Unknown"),
    PREPARING_REBALANCE("PreparingRebalance"),
    COMPLETING_REBALANCE("CompletingRebalance"),
    STABLE("Stable"),
    DEAD("Dead"),
    EMPTY("Empty");

    private static final Map<String, ClassicGroupState> NAME_TO_ENUM = Arrays.stream(values())
        .collect(Collectors.toMap(state -> state.name.toUpperCase(Locale.ROOT), Function.identity()));

    private final String name;

    ClassicGroupState(String name) {
        this.name = name;
    }

    /**
     * Case-insensitive classic group state lookup by string name.
     */
    public static ClassicGroupState parse(String name) {
        ClassicGroupState state = NAME_TO_ENUM.get(name.toUpperCase(Locale.ROOT));
        return state == null ? UNKNOWN : state;
    }

    @Override
    public String toString() {
        return name;
    }
}
