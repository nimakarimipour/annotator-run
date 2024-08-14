/*
 * Table Wrapper API
 * Copyright (C) 2020  Spacious Team <spacious-team@ya.ru>
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

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;

@ToString
@EqualsAndHashCode
public class TableColumnImpl implements TableColumn {
    private final String[] words;

    public static TableColumn of(String... words) {
        if (words.length == 0 || (words.length == 1 && (words[0] == null || words[0].isEmpty()))) {
            return LEFTMOST_COLUMN;
        }
        return new TableColumnImpl(words);
    }

    private TableColumnImpl(String... words) {
        this.words = Arrays.stream(words)
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }

    public int getColumnIndex(int firstColumnForSearch, ReportPageRow... headerRows) {
        for (ReportPageRow header : headerRows) {
            next_cell:
            for (TableCell cell : header) {
                Object value;
                if (cell != null && cell.getColumnIndex() >= firstColumnForSearch && ((value = cell.getValue()) instanceof String)) {
                    String colName = value.toString().toLowerCase();
                    for (String word : words) {
                        if (!containsWord(colName, word)) {
                            continue next_cell;
                        }
                    }
                    return cell.getColumnIndex();
                }
            }
        }
        throw new RuntimeException("Не обнаружен заголовок таблицы, включающий слова: " + String.join(", ", words));
    }

    private boolean containsWord(String text, String word) {
        return text.matches("(^|(.|\\n)*\\b|(.|\\n)*\\s)" + word + "(\\b(.|\\n)*|\\s(.|\\n)*|$)");
    }
}
