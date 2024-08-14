/*
 * Table Wrapper API
 * Copyright (C) 2021  Spacious Team <spacious-team@ya.ru>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.spacious_team.table_wrapper.api;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class TableFactoryRegistry {

    private static final Collection<TableFactory> factories = new HashSet<>();

    public static void add(TableFactory tableFactory) {
        factories.add(tableFactory);
    }

    @SuppressWarnings("unused")
    public static Collection<TableFactory> getAll() {
        return Collections.unmodifiableCollection(factories);
    }

    public static TableFactory get(ReportPage reportPage) {
        for (TableFactory factory : factories) {
            if (factory.canHandle(reportPage)) {
                return factory;
            }
        }
        throw new IllegalArgumentException("Нет парсера для отчета формата " + reportPage.getClass().getSimpleName());
    }
}
